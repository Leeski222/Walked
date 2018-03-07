package cn.nju.lee.walked.model.modelinterface;

import cn.nju.lee.walked.model.response.LoginResponse;
import io.reactivex.Observer;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface LoginModel {
    void login(Observer<LoginResponse> observer,
               String username, String password);
}