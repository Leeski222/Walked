package cn.nju.lee.walked.presenter;

import java.io.File;
import java.util.regex.Pattern;

import cn.nju.lee.walked.contract.SignUpContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import cn.nju.lee.walked.model.vopo.VerificationPO;
import cn.nju.lee.walked.util.SignUpResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class SignUpPresenter implements SignUpContract.Presenter{

    private String verificationEmail;
    private String verificationCode;

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

        if(!isEmailFormatValid(email)) {
            signUpView.emailFormatInvalid();
            return;
        }

        if(verification.equals(null) || verification.equals("")) {
            signUpView.verificationEmpty();
            return;
        }

        if(!email.equals(verificationEmail) || !verification.equals(verificationCode)) {
            signUpView.verificationError();
            return;
        }

        signUpModel.signUp(new Observer< Response<SignUpResponse> >() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<SignUpResponse> response) {
                if(response.code() == 201) {
                    signUpView.signUpSuccess();
                } else {
                    signUpView.signUpFailed(SignUpResult.EMAIL_EXISTED);
                }
            }

            @Override
            public void onError(Throwable e) {
                signUpView.signUpFailed(SignUpResult.NETWORK_ERROR);
            }

            @Override
            public void onComplete() {

            }
        }, null, email, username, password);

    }

    @Override
    public void sendVerificationCode(String email) {
        if(!isEmailFormatValid(email)) {
            signUpView.emailFormatInvalid();
            return;
        }

        signUpModel.sendVerificationCode(new Observer< Response<VerificationResponse> >() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response< VerificationResponse> response) {
                if(response.code() == 201) {
                    signUpView.sendVerificationSuccess();

                    VerificationPO verification = response.body().getData();
                    verificationEmail = verification.getEmail();
                    verificationCode = verification.getCode();
                } else {
                    signUpView.sendVerificationFailed();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, email);
    }

    private boolean isEmailFormatValid(String email) {
        final String emailRegex = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        return Pattern.matches(emailRegex, email);
    }
}
