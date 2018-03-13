package cn.nju.lee.walked.presenter;

import android.util.Log;

import java.io.File;
import java.util.regex.Pattern;

import cn.nju.lee.walked.contract.SignUpContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class SignUpPresenter implements SignUpContract.Presenter{

    private SignUpContract.View signUpView;
    private SignUpModel signUpModel;

    public SignUpPresenter(SignUpContract.View view) {
        this.signUpView = view;
        this.signUpModel = ModelRepository.getInstance().getSignUpModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void signUp(File file, String email, String username, String password, String verification) {
        if(isEmailFormatValid(email)) {
            signUpModel.signUp(new Observer<SignUpResponse>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(SignUpResponse signUpResponse) {
                    Log.e("SignUpPresenter", signUpResponse.getCondition());
                    Log.e("SignUpPresenter", signUpResponse.getMessage());
                }

                @Override
                public void onError(Throwable e) {
                    Log.e("SignUpPresenter", e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            }, null, email, username, password);
        } else {
            signUpView.emailFormatInvalid();
        }
    }

    @Override
    public void sendVerificationCode(String email) {
        if(isEmailFormatValid(email)) {
            signUpModel.sendVerificationCode(new Observer<VerificationResponse>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(VerificationResponse verificationResponse) {
                    String verification = verificationResponse.getData().toString();
                    Log.e("sendVerificationCode", verification);
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            }, email);
        } else {
            signUpView.emailFormatInvalid();
        }
    }

    private boolean isEmailFormatValid(String email) {
        final String emailRegex = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        return Pattern.matches(emailRegex, email);
    }
}
