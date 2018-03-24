package cn.nju.lee.walked.model.vopo;

/**
 * Created by 果宝 on 2018/3/22.
 */

public class LoginPO {
//    Authorization ;

    final String a = "Bearer ";

    long expires;

    String token_string;

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getToken_string() {
        return token_string;
    }

    public void setToken_string(String token_string) {
        this.token_string = token_string;
    }
}
