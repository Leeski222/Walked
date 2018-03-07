package cn.nju.lee.walked.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.view.signup.SignUpActivity;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class LoginActivity extends AppCompatActivity{

    @BindView(R.id.login_btn_signin)
    Button signinButton;
    @OnClick(R.id.login_btn_signin)
    void login() {

    }

    @BindView(R.id.login_lv_jump_to_signup)
    LinearLayout signUpLayout;
    @OnClick(R.id.login_lv_jump_to_signup)
    void jumpToSignupView() {
        SignUpActivity.activityStart(this);
    }

    @BindView(R.id.login_tv_jump_to_forget_password)
    TextView forgetPasswordTextView;
    @OnClick(R.id.login_tv_jump_to_forget_password)
    void jumpToForgetPasswordView() {
        Toast.makeText(this, "跳转到找回密码界面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
