package cn.nju.lee.walked.model.vopo;

/**
 * Created by 果宝 on 2018/1/5.
 */

public class DemoPO {

    private String a;

    public DemoPO(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public String setA() {
        return a;
    }

    public DemoVO toVO() {
        return new DemoVO(a);
    }
}
