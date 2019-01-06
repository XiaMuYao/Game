package com.ydws.game.bean;

public class DaiLiCaoZuoJinBiBean {

    /**
     * id : 272
     * userId : 10006
     * createTime : 2018-12-27 10:02:40
     * tradingStatus : 1
     * goldNumber : 1000000
     */

    private int id;
    private int userId;
    private String createTime;
    private int tradingStatus;
    private int goldNumber;

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

    public int getGoldNumber() {
        return goldNumber;
    }

    public void setGoldNumber(int goldNumber) {
        this.goldNumber = goldNumber;
    }
}
