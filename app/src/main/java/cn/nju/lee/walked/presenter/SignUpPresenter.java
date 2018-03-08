package cn.nju.lee.walked.presenter;

import android.util.Log;

import cn.nju.lee.walked.contract.SignUpContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.response.SignUpResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 果宝 on 2018/3/7.
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
    public void signUp(String email, String username, String password) {
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
        }, email, username, password);
    }

    @Override
    public void sendVerificationCode(String email) {

    }
}
