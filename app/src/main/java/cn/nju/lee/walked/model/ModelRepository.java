package cn.nju.lee.walked.model;

import cn.nju.lee.walked.model.modelimpl.CreateModelImpl;
import cn.nju.lee.walked.model.modelimpl.LoginModelImpl;
import cn.nju.lee.walked.model.modelimpl.SignUpModelImpl;
import cn.nju.lee.walked.model.modelinterface.CreateModel;
import cn.nju.lee.walked.model.modelinterface.LoginModel;
import cn.nju.lee.walked.model.modelinterface.SignUpModel;

/**
 * Created by 果宝 on 2018/ic_create/8.
 */

public class ModelRepository{
    private static ModelRepository modelRepository;

    private ModelRepository() {
    }

    public static synchronized ModelRepository getInstance() {
        if(modelRepository == null) {
            modelRepository = new ModelRepository();
        }

        return modelRepository;
    }

    public SignUpModel getSignUpModel() {
        return new SignUpModelImpl();
    }

    public LoginModel getLoginModel() {
        return new LoginModelImpl();
    }

    public CreateModel getCreateModel() {
        return new CreateModelImpl();
    }
}
