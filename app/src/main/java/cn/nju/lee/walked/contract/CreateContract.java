package cn.nju.lee.walked.contract;

import java.io.File;

import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.view.BaseView;

/**
 * Created by 果宝 on 2018/3/13.
 */

public interface CreateContract {
    interface View extends BaseView<CreateContract.Presenter> {
        void createSuccess();

        void createFailed();
    }

    interface Presenter extends BasePresenter {
        void createTrack(File file, String title, String content,
                         String createTime, String updateTime,
                         double longitude, double latitude);
    }
}
