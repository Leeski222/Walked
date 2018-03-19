package cn.nju.lee.walked.view.widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;

import static android.app.Activity.RESULT_OK;


/**
 * Created by 果宝 on 2018/3/9.
 */

public class UploadPictureUtil {

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;

    private File tempFile;
    private Uri tempUri;

    private View parent;
    private View popupView;

    private Activity mActivity;
    private OnCropSuccess mOnCropSuccess;

    private PopupWindow popupWindow;

    public interface OnCropSuccess {
        void setPictureUri(Uri uri);
    }

    public UploadPictureUtil(Activity activity, OnCropSuccess onCropSuccess) {
        this.mActivity = activity;
        this.mOnCropSuccess = onCropSuccess;
        this.parent = ((ViewGroup) mActivity.findViewById(android.R.id.content)).getChildAt(0);
        this.popupView = View.inflate(mActivity, R.layout.view_select_photo, null);

        ButterKnife.bind(this, popupView);

        initPopupWindow();
    }

    private void initPopupWindow() {
        popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setAnimationStyle(R.style.upload_photo_anim);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x30000000));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
    }

    /**
     * 显示上传方式选择框
     */
    public void showPopupWindow() {
        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @OnClick(R.id.select_photo_tv_open_album)
    void openAlbum() {
        popupWindow.dismiss();
        getPictureFromAlbum();
    }

    @OnClick(R.id.select_photo_tv_take_photo)
    void takePhoto() {
        popupWindow.dismiss();
        getPictureFromCamera();
    }

    @OnClick(R.id.select_photo_tv_cancel)
    void cancel() {
        popupWindow.dismiss();
    }

    /**
     * 从相机获取图片
     */
    private void getPictureFromCamera() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //如果在Android7.0以上,使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(mActivity, "cn.nju.lee.walked.view", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        mActivity.startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    /**
     * 从相册获取图片
     */
    private void getPictureFromAlbum() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        mActivity.startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);
    }

    /**
     * 裁剪图片
     */
    private void cropPicture(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 240);
        intent.putExtra("outputY", 240);

        // 部分国产机型会因为return-data方式而程序崩溃，故应采用uri路径的方式来传递图片
        intent.putExtra("return-data", false);
        tempUri = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() +".jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        mActivity.startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    public void handleActivityResult(int requestCode, int resultCode, Intent intent) {

        switch (requestCode) {
            case CAMERA_REQUEST_CODE:   //调用相机后返回
                if (resultCode == RESULT_OK) {
                    //用相机返回的照片去调用剪裁也需要对Uri进行处理
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(mActivity, "cn.nju.lee.walked.view", tempFile);
                        cropPicture(contentUri);
                    } else {
                        cropPicture(Uri.fromFile(tempFile));
                    }
                }
                break;

            case ALBUM_REQUEST_CODE:    //调用相册后返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    cropPicture(uri);
                }
                break;

            case CROP_REQUEST_CODE:     //调用剪裁后返回
                if(resultCode == RESULT_OK) {
                    //在这里获得了剪裁后的uri对象
                    mOnCropSuccess.setPictureUri(tempUri);
                }
                break;
        }

    }
}
