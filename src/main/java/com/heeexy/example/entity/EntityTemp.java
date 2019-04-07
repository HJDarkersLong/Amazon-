package com.heeexy.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created By HJ on 2019-04-03 11:50:27
 *
 * 说明 : 测试实体类生成数据库表，注解在下面，配置在yml中
 */
@Entity
@Table(name="EntityTemp")
public class EntityTemp {

    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column(length = 128)
    private String id;

    /**
     * 渠 道 鉴 权token
     */
    @Column(length = 128)
    private String channelToken;

    /**
     * 彩之云用户 openid
     */
    @Column(length = 128)
    private String openId;

    /**
     * 彩之云用户 id
     */
    @Column(length = 128)
    private String czyId;

    /**
     * 用户手机号
     */
    @Column(length = 128)
    private String mobile;

    /**
     * 昵称
     */
    @Column(length = 128)
    private String nickName;

    /**
     * 用户性别，0：保密，1：男，2：女
     */
    @Column(length = 128)
    private String sex;

    /**
     * 头像链接
     */
    @Column(length = 128)
    private String headImgUrl;

    /**
     * 更新时间
     */
    @Column(length = 128)
    private Timestamp updateTime;

    /**
     * 创建时间
     */
    @Column(length = 128)
    private Timestamp createTime;


    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getChannelToken() {
        return channelToken;
    }

    public void setChannelToken(String channelToken) {
        this.channelToken = channelToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCzyId() {
        return czyId;
    }

    public void setCzyId(String czyId) {
        this.czyId = czyId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", channelToken=" + channelToken + ", openId=" + openId + ", czyId=" + czyId
                + ", mobile=" + mobile + ", nickName=" + nickName + ", sex=" + sex + ", headImgUrl=" + headImgUrl
                + ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
    }
}
