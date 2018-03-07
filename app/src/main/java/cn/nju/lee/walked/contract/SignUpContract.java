package cn.nju.lee.walked.contract;

import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.util.SignResult;
import cn.nju.lee.walked.view.widget.BaseView;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class SignUpContract {
    interface View extends BaseView<SignUpContract.Presenter> {
        void signSuccess();

        void signFailed(SignResult result);
    }

    interface Presenter extends BasePresenter {
        void sign(String email, String username, String password);
    }
}
