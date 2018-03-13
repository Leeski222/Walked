package cn.nju.lee.walked.view;

/**
 * Created by 果宝 on 2018/ic_create/ic_multi_fab.
 */

public interface BaseView<T> {

    /**
     * 设置view的presenter
     *
     * @param presenter
     */
    void setPresenter(T presenter);

}
