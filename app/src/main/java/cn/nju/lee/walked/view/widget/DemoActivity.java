package cn.nju.lee.walked.view.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.DemoVO;

/**
 * Created by 果宝 on 2018/1/5.
 */

public class DemoActivity extends AppCompatActivity implements DemoContract.View{

    private static String ARG_A = "a";

    private String a;

    private DemoContract.Presenter demoPresenter;

    public static void activityStart(Activity activity, String a) {
        Intent intent = new Intent(activity, DemoActivity.class);
        intent.putExtra(ARG_A, a);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = getIntent().getStringExtra(ARG_A);
        demoPresenter = new DemoPresenter(this, a);
        setContentView(R.layout.activity_demo);
        demoPresenter.start();
    }

    @Override
    public void setPresenter(DemoContract.Presenter presenter) {
        this.demoPresenter = presenter;
    }

    @Override
    public void setDemoData(DemoVO demoVO) {
        Log.e("Tag", demoVO.getA());
    }
}
