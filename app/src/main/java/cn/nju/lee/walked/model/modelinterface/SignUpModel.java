package cn.nju.lee.walked.model.modelinterface;

import cn.nju.lee.walked.model.response.SignUpResponse;
import io.reactivex.Observer;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface SignUpModel {
    void signUp(Observer<SignUpResponse> observer,
                String email, String username, String password);
}
