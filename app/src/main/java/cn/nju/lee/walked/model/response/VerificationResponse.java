package cn.nju.lee.walked.model.response;

import okhttp3.ResponseBody;

/**
 * Created by 果宝 on 2018/3/8.
 */

public class VerificationResponse extends BaseResponse<ResponseBody> {
    public VerificationResponse(String condition, String message, ResponseBody data) {
        super(condition, message, data);
    }
}
