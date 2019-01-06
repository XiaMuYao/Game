package com.ydws.game.bean;

public class DaiLiCaoZuoGoldDetailBean {

    /**
     * id : 273
     * userId : 10006
     * goldNumber : 1000000
     * createTime : 2018-12-27 10:04:33
     * tradingStatus : 1
     * zhuanzhangPhoto : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545889292588&di=e57ebe190643a6ca4665d6b9dc7f5111&imgtype=0&src=http%3A%2F%2Fi4.hexunimg.cn%2F2016-09-06%2F185896417.jpg
     * phone : 13644554242
     * pay : 支付宝支付
     */

    private int id;
    private int userId;
    private int goldNumber;
    private String createTime;
    private int tradingStatus;
    private String zhuanzhangPhoto;
    private String phone;
    private String pay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoldNumber() {
        return goldNumber;
    }

    public void setGoldNumber(int goldNumber) {
        this.goldNumber = goldNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getTradingStatus() {
        return tradingStatus;
    }

    public void setTradingStatus(int tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

    public String getZhuanzhangPhoto() {
        return zhuanzhangPhoto;
    }

    public void setZhuanzhangPhoto(String zhuanzhangPhoto) {
        this.zhuanzhangPhoto = zhuanzhangPhoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
