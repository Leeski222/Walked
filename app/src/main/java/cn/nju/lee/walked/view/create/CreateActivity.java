package cn.nju.lee.walked.view.create;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.baidu.mapapi.map.MyLocationData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.view.widget.SoftKeyboardListener;
import cn.nju.lee.walked.view.widget.UploadPictureUtil;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by 果宝 on 2018/3/13.
 */

public class CreateActivity extends AppCompatActivity implements UploadPictureUtil.OnCropSuccess{

    private static final String ARG_LOCATION_LATITUDE = "latitude";
    private double locationLatitude;

    private static final String ARG_LOCATION_LONGITUDE = "longitude";
    private double locationLongitude;

    private boolean isLockFunctionBar;

    private UploadPictureUtil mUploadPictureUtil;

    @BindView(R.id.create_re_input)
    RichEditor inputRichEditor;
    @BindView(R.id.create_ll_function_bar)
    LinearLayout functionBar;

    public static void activityStart(Activity activity, double latitude, double longitude) {
        Intent intent = new Intent(activity, CreateActivity.class);
        intent.putExtra(ARG_LOCATION_LATITUDE, latitude);
        intent.putExtra(ARG_LOCATION_LONGITUDE, longitude);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

        this.locationLatitude = getIntent().getDoubleExtra(ARG_LOCATION_LATITUDE, 0.00);
        this.locationLongitude = getIntent().getDoubleExtra(ARG_LOCATION_LONGITUDE, 0.00);
        this.mUploadPictureUtil = new UploadPictureUtil(this, this);

        initInputRichEditor();
        SoftKeyboardListener.setListener(this, new SoftKeyboardListener.OnSoftKeyboardChangeListener() {
            @Override
            public void keyBoardShow() {
                functionBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void keyBoardHide() {
                functionBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void initInputRichEditor() {
        inputRichEditor.setVerticalScrollBarEnabled(true);
        inputRichEditor.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        inputRichEditor.setPadding(10, 10, 10, 10);
        inputRichEditor.focusEditor();
    }

    /**
     * 如果选择的输入框是题目，则锁定功能栏
     */
    @OnFocusChange(R.id.create_et_title)
    void lockFunctionBar(View v, boolean hasFocus) {
        if(hasFocus) {
            isLockFunctionBar = true;
        } else {
            isLockFunctionBar = false;
        }
    }

    @OnClick(R.id.create_iv_bold)
    public void setBold() {
        if(!isLockFunctionBar) {
            inputRichEditor.setBold();
        }
    }

    @OnClick(R.id.create_iv_italic)
    public void setItalic() {
        if(!isLockFunctionBar) {
            inputRichEditor.setItalic();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_underline)
    public void setUnderline() {
        if(!isLockFunctionBar) {
            inputRichEditor.setUnderline();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_redo)
    public void redo() {
        if(!isLockFunctionBar) {
            inputRichEditor.redo();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_undo)
    public void undo() {
        if(!isLockFunctionBar) {
            inputRichEditor.undo();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_justify_left)
    void justifyLeft() {
        if(!isLockFunctionBar) {
            inputRichEditor.setAlignLeft();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_justify_center)
    void justifyCenter() {
        if(!isLockFunctionBar) {
            inputRichEditor.setAlignCenter();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_justify_right)
    void justifyRight() {
        if(!isLockFunctionBar) {
            inputRichEditor.setAlignRight();
            inputRichEditor.focusEditor();
        }
    }

    @OnClick(R.id.create_iv_insert_picture)
    void insertPicture() {
        if(!isLockFunctionBar) {
            // 隐藏软键盘
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(inputRichEditor.getApplicationWindowToken(), 0);

            mUploadPictureUtil.showPopupWindow();
        }
    }

    @Override
    public void setPictureUri(Uri uri) {
        // 适应屏幕大小的参数
        final String fitScreen = "\" style=\"max-width:100%";

        inputRichEditor.insertImage(uri.toString(), uri.toString() + fitScreen);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mUploadPictureUtil.handleActivityResult(requestCode, resultCode, data);
    }
}
