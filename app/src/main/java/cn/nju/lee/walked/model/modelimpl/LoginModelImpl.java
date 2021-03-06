package cn.nju.lee.walked.model.modelimpl;

import cn.nju.lee.walked.model.modelinterface.LoginModel;
import cn.nju.lee.walked.model.response.LoginResponse;
import cn.nju.lee.walked.model.service.LoginService;
import cn.nju.lee.walked.model.service.RetrofitServer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class LoginModelImpl implements LoginModel {

    private LoginService loginService;

    public LoginModelImpl() {
        loginService = RetrofitServer.getInstance().create(LoginService.class);
    }

    @Override
    public void login(Observer< Response<LoginResponse> > observer, String email, String password) {
        loginService.login(email, password)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
