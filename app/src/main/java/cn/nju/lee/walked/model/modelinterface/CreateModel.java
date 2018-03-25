package cn.nju.lee.walked.model.modelinterface;

import java.io.File;

import cn.nju.lee.walked.model.response.CreateResponse;
import io.reactivex.Observer;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/13.
 */

public interface CreateModel {
    void createTrack(Observer< Response<CreateResponse> > observer,
                     File file, String title, String content,
                     String createTime, String updateTime,
                     double latitude, double longitude);
}
