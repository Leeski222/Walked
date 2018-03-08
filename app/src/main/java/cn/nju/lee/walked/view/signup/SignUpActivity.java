package cn.nju.lee.walked.view.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.contract.SignUpContract;
import cn.nju.lee.walked.presenter.SignUpPresenter;
import cn.nju.lee.walked.util.SignResult;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    private SignUpContract.Presenter signUpPresenter;

    @BindView(R.id.signup_et_email)
    EditText emailEditText;
    @BindView(R.id.signup_et_account)
    EditText accountEditText;
    @BindView(R.id.signup_et_password)
    EditText passwordEditText;
    @BindView(R.id.signup_et_verification)
    EditText verificationEditText;

    @BindView(R.id.signup_cb_accept_protocol)
    CheckBox acceptProtocolCheckBox;

    public static void activityStart(Activity activity) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        this.signUpPresenter = new SignUpPresenter(this);
        this.signUpPresenter.start();
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        this.signUpPresenter = presenter;
    }

    @Override
    public void signUpSuccess() {

    }

    @Override
    public void signUpFailed(SignUpResult result) {

    }

    @OnClick(R.id.signup_btn_signup)
    void signUp() {
        boolean isAcceptProtocol = acceptProtocolCheckBox.isChecked();
        String email = "";
        String username = "";
        String password = "";
        String verificationCode = "";
        if(isAcceptProtocol) {
            signUpPresenter.signUp(email, username, password);
        } else {
            Toast.makeText(this, "请先同意用户协议", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.signup_btn_send)
    void sendVerificationCode() {

    }
}
