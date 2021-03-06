package com.ydws.game.bean;

import java.io.Serializable;

public class GoldTradingBean implements Serializable {

    /**
     * id : 10017
     * city : 大连
     * payee : 刘先生
     * bankName : 大连甘井子
     * cardNumber : 210299199606068585
     * zhifubao : 13644554245
     * wechatCode : 1753179110
     * jinbi : 22
     * phone : null
     * usdt : 0.22
     */

    private int id;
    private String city;
    private String payee;
    private String bankName;
    private String cardNumber;
    private String zhifubao;
    private String wechatCode;
    private String jinbi;
    private String phone;
    private String trandindId;
    private double usdt;

    public String getTrandindId() {
        return trandindId;
    }

    public void setTrandindId(String trandindId) {
        this.trandindId = trandindId;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao;
    }

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
    }

    public String getJinbi() {
        return jinbi;
    }

    public void setJinbi(String jinbi) {
        this.jinbi = jinbi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getUsdt() {
        return usdt;
    }

    public void setUsdt(double usdt) {
        this.usdt = usdt;
    }
}
