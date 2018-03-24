package cn.nju.lee.walked.model.modelinterface;

import java.io.File;

import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import io.reactivex.Observer;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface SignUpModel {
    void signUp(Observer< Response<SignUpResponse> > observer,
                File file, String email, String username, String password);

    void sendVerificationCode(Observer< Response<VerificationResponse> > observer,
                              String email);
}
