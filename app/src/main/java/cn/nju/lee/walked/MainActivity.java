package cn.nju.lee.walked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.nju.lee.walked.view.widget.DemoActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoActivity.activityStart(this, "a");
    }

}
