package cn.nju.lee.walked.presenter;

import java.io.File;

import cn.nju.lee.walked.contract.CreateContract;
import cn.nju.lee.walked.model.ModelRepository;
import cn.nju.lee.walked.model.modelinterface.CreateModel;
import cn.nju.lee.walked.model.response.CreateResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * Created by 果宝 on 2018/3/13.
 */

public class CreatePresenter implements CreateContract.Presenter{

    private CreateContract.View createView;
    private CreateModel createModel;

    public CreatePresenter(CreateContract.View view) {
        this.createView = view;
        createModel = ModelRepository.getInstance().getCreateModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void createTrack(File file,
                            String title, String content,
                            String createTime, String updateTime,
                            double longitude, double latitude) {

        createModel.createTrack(new Observer<Response<CreateResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<CreateResponse> response) {
                if(response.code() == 201) {
                    createView.createSuccess();
                } else {
                    createView.createFailed();
                }
            }

            @Override
            public void onError(Throwable e) {
                createView.createFailed();
            }

            @Override
            public void onComplete() {

            }
        }, file, title, content, createTime, updateTime, latitude, longitude);
    }
}
