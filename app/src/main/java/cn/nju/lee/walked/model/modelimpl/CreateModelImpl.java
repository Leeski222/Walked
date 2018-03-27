package cn.nju.lee.walked.model.modelimpl;

import java.io.File;

import cn.nju.lee.walked.model.modelinterface.CreateModel;
import cn.nju.lee.walked.model.postbean.TrackBean;
import cn.nju.lee.walked.model.response.CreateResponse;
import cn.nju.lee.walked.model.service.CreateService;
import cn.nju.lee.walked.model.service.RetrofitServer;
import cn.nju.lee.walked.util.AppData;
import cn.nju.lee.walked.util.GsonUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/26.
 */

public class CreateModelImpl implements CreateModel{

    private CreateService createService;

    public CreateModelImpl() {
        createService = RetrofitServer.getInstance().create(CreateService.class);
    }

    @Override
    public void createTrack(Observer< Response<CreateResponse> > observer,
                            File file, String title, String content,
                            String createTime, String updateTime,
                            double latitude, double longitude) {

        String token = AppData.getToken();

        TrackBean trackBean = new TrackBean();
        trackBean.setTitle(title);
        trackBean.setContent(content);
        trackBean.setCreateTime(createTime);
        trackBean.setUpdateTime(updateTime);
        trackBean.setLatitude(latitude);
        trackBean.setLongitude(longitude);

        RequestBody body = new GsonUtil<TrackBean>().createRequestBody(trackBean);
        createService.createTrack(token, body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
