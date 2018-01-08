package cn.nju.lee.walked.model.response;


import cn.nju.lee.walked.model.vopo.DemoPO;

/**
 * Created by 果宝 on 2018/1/5.
 */

public class DemoResponse extends BaseResponse<DemoPO>{
    public DemoResponse(String condition, String message, DemoPO data) {
        super(condition, message, data);
    }
}
