package cn.nju.lee.walked.model.modelimpl;

import java.io.File;

import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import cn.nju.lee.walked.model.service.RetrofitServer;
import cn.nju.lee.walked.model.service.SignUpService;
import cn.nju.lee.walked.model.vopo.SignUpVO;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by 果宝 on 2018/ic_info/7.
 */

public class SignUpModelImpl implements SignUpModel {

    private SignUpService signUpService;

    public SignUpModelImpl() {
        signUpService = RetrofitServer.getInstance().create(SignUpService.class);
    }

    @Override
    public void signUp(Observer<SignUpResponse> observer,
                       File profile, String email, String username, String password) {

        SignUpVO signUpVO = new SignUpVO();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), signUpVO.toString());

        signUpService.signUp(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void sendVerificationCode(Observer<VerificationResponse> observer,
                                     String email) {

        signUpService.sendVerificationResponse(email)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
