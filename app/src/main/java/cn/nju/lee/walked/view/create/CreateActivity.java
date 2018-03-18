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
import butterknife.OnFocusChange;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.view.widget.SoftKeyboardListener;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by 果宝 on 2018/3/13.
 */

public class CreateActivity extends AppCompatActivity {

    private boolean isLockFunctionBar;

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

    private void initInputRichEditor() {
        inputRichEditor.setVerticalScrollBarEnabled(true);
        inputRichEditor.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);

        inputRichEditor.focusEditor();
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
        final String fitScreen = "\" style=\"max-width:100%";
        if(!isLockFunctionBar) {
            inputRichEditor.insertImage("https://raw.githubusercontent.com/wasabeef/art/master/twitter.png", "demo" + fitScreen);
        }
    }

    @OnClick(R.id.print)
    void print() {
        String str = inputRichEditor.getHtml();
        if(str != null) {
            Log.e("content", str);
        }
    }
}
