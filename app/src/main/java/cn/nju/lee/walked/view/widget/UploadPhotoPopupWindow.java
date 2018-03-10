package cn.nju.lee.walked.view.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;

/**
 * Created by 果宝 on 2018/3/9.
 */

public class UploadPhotoPopupWindow {

    private View parent;
    private View popupView;
    private Context context;
    private PopupWindow popupWindow;

    public UploadPhotoPopupWindow(Activity activity) {
        this.context = activity;
        this.parent = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        this.popupView = View.inflate(activity, R.layout.popup_select_photo, null);

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
    public void openAlbum() {
        Toast.makeText(context, "打开相册", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.select_photo_tv_take_photo)
    public void takePhoto() {
        Toast.makeText(context, "照相", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.select_photo_tv_cancel)
    public void cancel() {
        popupWindow.dismiss();
    }
}
