package cn.nju.lee.walked.presenter;

import cn.nju.lee.walked.contract.LoginContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.LoginModel;
import cn.nju.lee.walked.model.response.LoginResponse;
import cn.nju.lee.walked.model.vopo.TokenPO;
import cn.nju.lee.walked.util.AppData;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginContract.View view) {
        this.loginView = view;
        this.loginModel = ModelRepository.getInstance().getLoginModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void login(String email, String password) {
        loginModel.login(new Observer< Response<LoginResponse> >() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<LoginResponse> response) {
                if(response.code() == 201) {
                    // 登录成功后，保存用户登录状态及相关信息
                    TokenPO tokenPO = response.body().getData();
                    AppData.saveLoginState(true);
                    AppData.saveToken(tokenPO.getToken_string());
                    AppData.saveExpires(tokenPO.getExpires());

                    loginView.loginSuccess();
                } else {
                    loginView.loginFailed();
                }
            }

            @Override
            public void onError(Throwable e) {
                loginView.loginFailed();
            }

            @Override
            public void onComplete() {

            }
        }, email, password);
    }
}
