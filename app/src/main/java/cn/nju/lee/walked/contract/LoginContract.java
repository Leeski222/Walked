package cn.nju.lee.walked.contract;

import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.util.LoginResult;
import cn.nju.lee.walked.view.BaseView;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSuccess();

        void loginFailed(LoginResult result);
    }

    interface Presenter extends BasePresenter {
        void login(String username, String password);
    }
}
