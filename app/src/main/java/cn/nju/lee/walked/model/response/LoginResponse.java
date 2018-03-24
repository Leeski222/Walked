package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.LoginPO;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class LoginResponse extends BaseResponse<LoginPO> {
    public LoginResponse(String condition, String message, LoginPO data) {
        super(condition, message, data);
    }
}
