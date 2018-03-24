package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.SignUpResponse;
import cn.nju.lee.walked.model.vopo.Post;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by 果宝 on 2018/ic_info/13.
 */

public interface CreateService {
    @Headers({
            "Content-Type: application/json",
    })
    @POST("/posts")
    Observable<SignUpResponse> createTrack(
            @Header("Authorization") String token,
            @Body Post post
    );
}
