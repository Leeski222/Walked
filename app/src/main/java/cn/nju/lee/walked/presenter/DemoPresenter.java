package cn.nju.lee.walked.presenter;

import android.util.Log;

import cn.nju.lee.walked.contract.DemoContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.DemoModel;
import cn.nju.lee.walked.model.response.DemoResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 果宝 on 2018/1/5.
 */

public class DemoPresenter implements DemoContract.Presenter {
    DemoModel demoModel;
    DemoContract.View demoView;
    String a;

    public DemoPresenter(DemoContract.View demoView, String a) {
        this.demoModel = ModelRepository.getInstance().getDemoModel();
        this.demoView = demoView;
        this.a = a;
        demoView.setPresenter(this);
    }

    @Override
    public void getDemoData(String a) {
        demoModel.getDemo(new Observer<DemoResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DemoResponse demoResponse) {
                Log.e("Tag", "DemoPresenter onNext");

//                demoView.setDemoData(demoResponse.getData().toVO());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Tag", "DemoPresenter onError " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        }, a);
    }

    @Override
    public void start() {
        getDemoData(a);
    }
}
