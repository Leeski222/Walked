package cn.nju.lee.walked.model;

import cn.nju.lee.walked.model.modelimpl.DemoModelImpl;
import cn.nju.lee.walked.model.modelinterface.DemoModel;

/**
 * Created by 果宝 on 2018/1/8.
 */

public class ModelRepository{
    private static ModelRepository modelRepository;

    private ModelRepository() {
    }

    public static ModelRepository getInstance() {
        if(modelRepository == null) {
            modelRepository = new ModelRepository();
        }

        return modelRepository;
    }

    public DemoModel getDemoModel() {
        return new DemoModelImpl();
    }
}
