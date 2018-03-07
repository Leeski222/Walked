package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.UserPO;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class LoginResponse extends BaseResponse<UserPO> {
    public LoginResponse(String condition, String message, UserPO data) {
        super(condition, message, data);
    }
}
