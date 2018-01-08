package cn.nju.lee.walked.contract;

import cn.nju.lee.walked.model.vopo.DemoVO;
import cn.nju.lee.walked.presenter.BasePresenter;
import cn.nju.lee.walked.view.widget.BaseView;

/**
 * Created by 果宝 on 2018/1/5.
 */

public interface DemoContract {
    interface View extends BaseView<Presenter> {
        void setDemoData(DemoVO demoVO);
    }

    interface Presenter extends BasePresenter {
        void getDemoData(String a);
    }
}
