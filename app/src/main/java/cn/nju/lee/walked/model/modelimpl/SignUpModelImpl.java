package cn.nju.lee.walked.model.modelimpl;

import java.io.File;

import cn.nju.lee.walked.model.modelinterface.SignUpModel;
import cn.nju.lee.walked.model.postbean.SignUpBean;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import cn.nju.lee.walked.model.service.RetrofitServer;
import cn.nju.lee.walked.model.service.SignUpService;
import cn.nju.lee.walked.util.GsonUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/7.
 */

public class SignUpModelImpl implements SignUpModel {

    private SignUpService signUpService;

    public SignUpModelImpl() {
        signUpService = RetrofitServer.getInstance().create(SignUpService.class);
    }

    @Override
    public void signUp(Observer< Response<SignUpResponse> > observer,
                       File profile, String email, String username, String password) {

        //上传图片文件，获得图片的pic_id
        String pic_id = "";

        SignUpBean signUpBean = new SignUpBean();
        signUpBean.setPic_id(pic_id);
        signUpBean.setEmail(email);
        signUpBean.setPassword(password);
        signUpBean.setUsername(username);

        RequestBody body = new GsonUtil<SignUpBean>().createRequestBody(signUpBean);

        signUpService.signUp(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void sendVerificationCode(Observer< Response<VerificationResponse> > observer,
                                     String email) {

        signUpService.sendVerificationCode(email)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
