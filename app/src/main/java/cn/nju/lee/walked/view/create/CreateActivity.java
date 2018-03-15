package cn.nju.lee.walked.view.create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by 果宝 on 2018/ic_info/13.
 */

public class CreateActivity extends AppCompatActivity {

    @BindView(R.id.create_re_input)
    RichEditor inputRichEditor;

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
    }

    private void initInputRichEditor() {
        inputRichEditor.setVerticalScrollBarEnabled(true);
        inputRichEditor.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);

    }

    @OnClick(R.id.button)
    void onClick() {
        inputRichEditor.setItalic();
    }

}
