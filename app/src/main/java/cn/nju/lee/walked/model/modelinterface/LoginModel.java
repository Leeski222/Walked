package cn.nju.lee.walked.model.modelinterface;

import cn.nju.lee.walked.model.response.LoginResponse;
import io.reactivex.Observer;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface LoginModel {
    void login(Observer< Response<LoginResponse> > observer,
               String email, String password);
}
