package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.SignUpPO;

import retrofit2.Response;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class SignUpResponse extends BaseResponse<SignUpPO> {
    public SignUpResponse(String condition, String message, SignUpPO data) {
        super(condition, message, data);
    }
}
