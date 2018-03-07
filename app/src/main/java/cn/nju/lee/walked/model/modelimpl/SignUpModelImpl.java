package cn.nju.lee.walked.model.modelimpl;

import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.service.RetrofitServer;
import cn.nju.lee.walked.model.service.SignUpService;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class SignUpModelImpl implements SignUpModel {

    private SignUpService signUpService;

    public SignUpModelImpl() {
        signUpService = RetrofitServer.getInstance().create(SignUpService.class);
    }

    @Override
    public void signUp(Observer<SignUpResponse> observer, String email, String username, String password) {
        signUpService.signUp(email, username, password)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
