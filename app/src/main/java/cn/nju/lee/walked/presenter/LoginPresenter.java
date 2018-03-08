package cn.nju.lee.walked.presenter;

import android.util.Log;

import cn.nju.lee.walked.contract.LoginContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.LoginModel;
import cn.nju.lee.walked.model.response.LoginResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginContract.View view) {
        this.loginView = view;
        this.loginModel = ModelRepository.getInstance().getLoginModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void login(String username, String password) {
        loginModel.login(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginResponse loginResponse) {
                Log.e("LoginPresenter", loginResponse.getCondition());
                Log.e("LoginPresenter", loginResponse.getMessage());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("LoginPresenter", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        }, username, password);
    }
}
