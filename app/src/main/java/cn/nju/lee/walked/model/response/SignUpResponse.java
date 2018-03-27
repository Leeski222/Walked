package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.UserInfoPO;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class SignUpResponse extends BaseResponse<UserInfoPO> {
    public SignUpResponse(String condition, String message, UserInfoPO data) {
        super(condition, message, data);
    }
}
