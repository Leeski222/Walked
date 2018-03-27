package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.TokenPO;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class LoginResponse extends BaseResponse<TokenPO> {
    public LoginResponse(String condition, String message, TokenPO data) {
        super(condition, message, data);
    }
}
