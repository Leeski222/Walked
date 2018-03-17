package cn.nju.lee.walked.view.create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.view.widget.SoftKeyboardListener;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by 果宝 on 2018/ic_info/13.
 */

public class CreateActivity extends AppCompatActivity {

    @BindView(R.id.create_re_input)
    RichEditor inputRichEditor;
    @BindView(R.id.create_ll_function_bar)
    LinearLayout functionBar;

    public static void activityStart(Activity activity) {
        Intent intent = new Intent(activity, CreateActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

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

        this.getInputRichEditorFocus();
    }

    private void getInputRichEditorFocus() {
        inputRichEditor.setFocusable(true);
        inputRichEditor.setFocusableInTouchMode(true);
        inputRichEditor.requestFocus();
        inputRichEditor.requestFocusFromTouch();
    }

    @OnClick(R.id.create_iv_justify_left)
    void justifyLeft() {
        inputRichEditor.setAlignLeft();
        this.getInputRichEditorFocus();
    }

    @OnClick(R.id.create_iv_justify_center)
    void justifyCenter() {
        inputRichEditor.setAlignCenter();
        this.getInputRichEditorFocus();
    }

    @OnClick(R.id.create_iv_justify_right)
    void justifyRight() {
        inputRichEditor.setAlignRight();
        this.getInputRichEditorFocus();
    }

    @OnClick(R.id.create_iv_insert_picture)
    void insertPicture() {
        inputRichEditor.insertImage("https://raw.githubusercontent.com/wasabeef/art/master/twitter.png","demo");
    }

}
