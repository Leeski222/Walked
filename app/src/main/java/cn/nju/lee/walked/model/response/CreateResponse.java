package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.TrackPO;

/**
 * Created by 果宝 on 2018/3/26.
 */

public class CreateResponse extends BaseResponse<TrackPO> {
    public CreateResponse(String condition, String message, TrackPO data) {
        super(condition, message, data);
    }
}
