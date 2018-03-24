package cn.nju.lee.walked.model.response;

import cn.nju.lee.walked.model.vopo.VerificationPO;
import okhttp3.ResponseBody;

/**
 * Created by 果宝 on 2018/ic_info/8.
 */

public class VerificationResponse extends BaseResponse<VerificationPO> {
    public VerificationResponse(String condition, String message, VerificationPO data) {
        super(condition, message, data);
    }
}
