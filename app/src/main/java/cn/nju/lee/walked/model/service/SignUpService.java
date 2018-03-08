package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.BaseResponse;
import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.response.VerificationResponse;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
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

    @FormUrlEncoded
    @POST("/users")
    Observable<SignUpResponse> signUp(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/verification")
    Observable<VerificationResponse> sendVerificationResponse(
            @Field("emali") String email
    );
}
