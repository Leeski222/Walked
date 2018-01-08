package cn.nju.lee.walked.model.service;

import cn.nju.lee.walked.model.response.DemoResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 果宝 on 2018/1/5.
 */

public interface DemoService {
    @GET("hello")
    Observable<DemoResponse> getDemo(@Query("a") String a);
}
