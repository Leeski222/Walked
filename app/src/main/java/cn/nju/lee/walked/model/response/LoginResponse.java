package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.SignUpPO;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class LoginResponse extends BaseResponse<SignUpPO> {
    public LoginResponse(String condition, String message, SignUpPO data) {
        super(condition, message, data);
    }
}
