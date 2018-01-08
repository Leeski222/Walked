package cn.nju.lee.walked.model.modelimpl;

import android.util.Log;

import cn.nju.lee.walked.model.modelinterface.DemoModel;
import cn.nju.lee.walked.model.response.DemoResponse;
import cn.nju.lee.walked.model.service.DemoService;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 果宝 on 2018/1/8.
 */

public class DemoModelImpl extends BaseModelImpl implements DemoModel {
    @Override
    public void getDemo(Observer<DemoResponse> observer, String a) {
        DemoService demoService = retrofit.create(DemoService.class);

        Log.e("Tag", "getDemo");

        demoService.getDemo("b")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
