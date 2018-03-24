package cn.nju.lee.walked.model.response;

import okhttp3.Response;

/**
 * Created by 果宝 on 2018/ic_create/ic_multifab.
 */

public class BaseResponse<T> {
    String condition;   // 请求结果
    String message;     // 返回信息
    T data;             // 返回数据

    public BaseResponse(String condition, String message, T data) {
        this.condition = condition;
        this.message = message;
        this.data = data;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
