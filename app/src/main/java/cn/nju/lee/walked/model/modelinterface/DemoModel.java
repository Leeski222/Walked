package cn.nju.lee.walked.model.modelinterface;

import cn.nju.lee.walked.model.response.DemoResponse;
import io.reactivex.Observer;

/**
 * Created by 果宝 on 2018/1/5.
 */

public interface DemoModel {
    void getDemo(Observer<DemoResponse> observer, String a);
}
