package cn.nju.lee.walked.view.signup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.contract.SignUpContract;
import cn.nju.lee.walked.presenter.SignUpPresenter;
import cn.nju.lee.walked.util.SignUpResult;
import cn.nju.lee.walked.view.widget.UploadPictureUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View, UploadPictureUtil.OnCropSuccess{

    private SignUpContract.Presenter signUpPresenter;

    private UploadPictureUtil mUploadPictureUtil;

    @BindView(R.id.signup_civ_profile)
    CircleImageView profileCircleImageView;
    @BindView(R.id.signup_et_email)
    EditText emailEditText;
    @BindView(R.id.signup_et_username)
    EditText usernameEditText;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        this.mUploadPictureUtil = new UploadPictureUtil(this, this);
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
        switch (result) {
            case EMAIL_EXISTED:
                Toast.makeText(this, "邮箱已注册", Toast.LENGTH_SHORT).show();
                break;
            case NETWORK_ERROR:
                Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void verificationEmpty() {
        Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void verificationError() {
        Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emailFormatInvalid() {
        Toast.makeText(this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.signup_btn_signup)
    void signUp() {
        boolean isAcceptProtocol = acceptProtocolCheckBox.isChecked();

        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String verification = verificationEditText.getText().toString();
        if(isAcceptProtocol) {
            signUpPresenter.signUp(null, email, username, password, verification);
        } else {
            Toast.makeText(this, "请先同意用户协议", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.signup_btn_send)
    void sendVerificationCode() {
        String email = emailEditText.getText().toString();
        signUpPresenter.sendVerificationCode(email);
    }

    @OnClick(R.id.signup_civ_profile)
    void uploadProfile() {
        mUploadPictureUtil.showPopupWindow();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mUploadPictureUtil. handleActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setPictureUri(Uri uri) {

        Bitmap bitmap = null;

        try {
            bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "上传图片异常，请重试", Toast.LENGTH_SHORT).show();
        }

        if(bitmap == null) {
            Toast.makeText(this, "上传图片异常，请重试", Toast.LENGTH_SHORT).show();
        } else {
            profileCircleImageView.setImageBitmap(bitmap);
        }

    }
}
