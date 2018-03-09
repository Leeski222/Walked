package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.LoginResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface LoginService {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/users/token")
    Observable<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
