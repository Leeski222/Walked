package cn.nju.lee.walked.model.response;

/**
 * Created by 果宝 on 2018/1/5.
 */

public class BaseResponse<T> {
    String condition;
    String message;
    T data;

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
