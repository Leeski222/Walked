package cn.nju.lee.walked.view.info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import cn.nju.lee.walked.R;
import cn.nju.lee.walked.view.info.fragment.AuthorFragment;
import cn.nju.lee.walked.view.info.fragment.MyTracksFragment;
import cn.nju.lee.walked.view.info.fragment.PersonalFragment;
import cn.nju.lee.walked.view.login.LoginActivity;

/**
 * Created by 果宝 on 2018/3/21.
 */

public class InfoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private FragmentManager mFragmentManager;

    public static void activityStart(Activity activity) {
        Intent intent = new Intent(activity, InfoActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mFragmentManager = this.getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.info_frame_content, new MyTracksFragment()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_navigation_list:
                mFragmentManager.beginTransaction().replace(R.id.info_frame_content, new MyTracksFragment()).commit();
                return true;
            case R.id.info_navigation_personal:
                mFragmentManager.beginTransaction().replace(R.id.info_frame_content, new PersonalFragment()).commit();
                return true;
            case R.id.info_navigation_author:
                mFragmentManager.beginTransaction().replace(R.id.info_frame_content, new AuthorFragment()).commit();
                return true;
        }
        return false;
    }
}
