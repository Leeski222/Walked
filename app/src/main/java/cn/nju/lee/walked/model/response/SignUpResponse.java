package cn.nju.lee.walked.model.response;

import okhttp3.ResponseBody;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class SignUpResponse extends BaseResponse<ResponseBody> {
    public SignUpResponse(String condition, String message, ResponseBody data) {
        super(condition, message, data);
    }
}
