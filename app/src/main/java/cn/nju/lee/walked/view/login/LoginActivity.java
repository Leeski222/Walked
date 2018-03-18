package cn.nju.lee.walked.view.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.contract.LoginContract;
import cn.nju.lee.walked.presenter.LoginPresenter;
import cn.nju.lee.walked.util.LoginResult;
import cn.nju.lee.walked.view.signup.SignUpActivity;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter loginPresenter;

    @BindView(R.id.login_et_username)
    EditText usernameEditText;
    @BindView(R.id.login_et_password)
    EditText passwordEditText;

    public static void activityStart(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        this.loginPresenter = new LoginPresenter(this);
        this.loginPresenter.start();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.loginPresenter = presenter;
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(LoginResult result) {
        Toast.makeText( this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login_btn_signin)
    void login() {
        String username = usernameEditText.getText().toString();
        String password = usernameEditText.getText().toString();
        loginPresenter.login(username, password);
    }

    @OnClick(R.id.login_lv_jump_to_signup)
    void jumpToSignUpView() {
        SignUpActivity.activityStart(this);
    }

    @OnClick(R.id.login_tv_jump_to_forget_password)
    void jumpToForgetPasswordView() {
        Toast.makeText(this, "跳转到找回密码界面", Toast.LENGTH_SHORT).show();
    }
}
