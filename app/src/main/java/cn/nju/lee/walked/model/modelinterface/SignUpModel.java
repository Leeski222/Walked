package cn.nju.lee.walked.model.modelinterface;

import java.io.File;

import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import io.reactivex.Observer;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public interface SignUpModel {
    void signUp(Observer<SignUpResponse> observer,
                File file, String email, String username, String password);

    void sendVerificationCode(Observer<VerificationResponse> observer,
                              String email);
}
