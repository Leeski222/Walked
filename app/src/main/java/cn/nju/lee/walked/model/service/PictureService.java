package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.LoginResponse;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by 果宝 on 2018/ic_info/12.
 */

public interface PictureService {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/picture")
    Observable<LoginResponse> savePicture(
            @Header("Authorization") String token,
            @Field("picture") String picture
    );

    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("/picture")
    Observable<LoginResponse> getPicture(
            @Header("Authorization") String token,
            @Field("pic_id") String picID
    );

}
