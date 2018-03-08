package cn.nju.lee.walked.contract;

import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.util.SignResult;
import cn.nju.lee.walked.view.BaseView;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface SignUpContract {
    interface View extends BaseView<SignUpContract.Presenter> {
        void signUpSuccess();

        void signUpFailed(SignResult result);
    }

    interface Presenter extends BasePresenter {
        void signUp(String email, String username, String password);

        void sendVerificationCode(String email);
    }
}
