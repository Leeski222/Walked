package cn.nju.lee.walked.view.track;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import jp.wasabeef.richeditor.RichEditor;


/**
 * Created by 果宝 on 2018/1/20.
 */

public class TrackActivity extends AppCompatActivity {

    @BindView(R.id.track_re_content)
    RichEditor contentRichEditor;

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, TrackActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        ButterKnife.bind(this);

        initContentRichEditor();
    }

    private void initContentRichEditor() {
        contentRichEditor.setInputEnabled(false);
        contentRichEditor.setHtml(" 1他姐姐<img src=\"https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg\" alt=\"https://raw.githubusercontent.com/wasabeef/art/master/twitter.png\" style=\"max-width:100%\"><br><div style=\"text-align: center;\">他安环</div><div style=\"text-align: center;\">谈谈</div>");
    }

}
