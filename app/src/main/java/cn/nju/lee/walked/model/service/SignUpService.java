package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by 果宝 on 2018/3/7.
 */

public interface SignUpService {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/users")
    Observable<SignUpResponse> signUp(
            @Body RequestBody body
    );

    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/verification")
    Observable<VerificationResponse> sendVerificationResponse(
            @Field("email") String email
    );
}
