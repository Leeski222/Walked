package cn.nju.lee.walked.contract;

import java.io.File;

import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.util.SignUpResult;
import cn.nju.lee.walked.view.BaseView;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface SignUpContract {
    interface View extends BaseView<SignUpContract.Presenter> {
        void signUpSuccess();

        void signUpFailed(SignUpResult result);

        void emailFormatInvalid();
    }

    interface Presenter extends BasePresenter {
        void signUp(File profile, String email, String username, String password, String verification);

        void sendVerificationCode(String email);
    }
}
