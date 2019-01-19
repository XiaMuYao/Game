package com.ydws.game.bean;

public class DetailsOfPropRepurchaseBean {

    /**
     * biShangId : 10006
     * id : 17
     * city : 反倒是
     * payee : 刘先生
     * createTime : 2018-11-14 16:05:56.0
     * tradingStatus : 1
     * zhuanzhangPhoto : 截图啊啊啊
     * propsNumber : 100
     * phone : 13644554242
     * payType : null
     * payTypeName : 支付宝支付
     */

    private int biShangId;
    private int id;
    private String city;
    private String payee;
    private String lastChangeTime;
    private int tradingStatus;
    private String zhuanzhangPhoto;
    private int propsNumber;
    private String phone;
    private Object payType;
    private String payTypeName;

    public int getBiShangId() {
        return biShangId;
    }

    public void setBiShangId(int biShangId) {
        this.biShangId = biShangId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(String lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
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

    public int getPropsNumber() {
        return propsNumber;
    }

    public void setPropsNumber(int propsNumber) {
        this.propsNumber = propsNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getPayType() {
        return payType;
    }

    public void setPayType(Object payType) {
        this.payType = payType;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
