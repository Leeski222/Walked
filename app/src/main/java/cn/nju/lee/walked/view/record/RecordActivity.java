package cn.nju.lee.walked.view.record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.nju.lee.walked.R;


/**
 * Created by 果宝 on 2018/1/20.
 */

public class RecordActivity extends AppCompatActivity {

    public static void activityStart(Activity activity) {
        Intent intent = new Intent(activity, RecordActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
    }

}