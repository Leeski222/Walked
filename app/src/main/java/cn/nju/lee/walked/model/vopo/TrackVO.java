package cn.nju.lee.walked.model.vopo;

/**
 * Created by 果宝 on 2018/ic_create/20.
 */

public class TrackVO {

    private String username;

    private String createDate;

    private String content;

    private String thumbUpNum;

    public TrackVO(String username, String createDate, String content, String thumbUpNum) {
        this.username = username;
        this.createDate = createDate;
        this.content = content;
        this.thumbUpNum = thumbUpNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbUpNum() {
        return thumbUpNum;
    }

    public void setThumbUpNum(String thumbUpNum) {
        this.thumbUpNum = thumbUpNum;
    }
}
