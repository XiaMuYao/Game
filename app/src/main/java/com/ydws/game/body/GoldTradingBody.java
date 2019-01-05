package com.ydws.game.body;

public class GoldTradingBody {
    public String userId	;	//	用户ID
    public String	city	;	//	国家地区等详细地址
    public String	payee	;	//	收款人名
    public String	payType	;	//	支付方式(支付的ID)
    public String	bankname	;	//	开户行名字
    public String	cardNumber	;	//	收款账号(卡号)
    public String	zhifubaoId	;	//	支付宝账号
    public String	wechat	;	//	微信账号
    public String	goldNumber	;	//	金币数量
    public String	zhuanzhangPhoto	;	//	转账成功的截图
    public String	bishangId	;	//	币商ID
    public String	phone	;	//	电话号码

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getZhifubaoId() {
        return zhifubaoId;
    }

    public void setZhifubaoId(String zhifubaoId) {
        this.zhifubaoId = zhifubaoId;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getGoldNumber() {
        return goldNumber;
    }

    public void setGoldNumber(String goldNumber) {
        this.goldNumber = goldNumber;
    }

    public String getZhuanzhangPhoto() {
        return zhuanzhangPhoto;
    }

    public void setZhuanzhangPhoto(String zhuanzhangPhoto) {
        this.zhuanzhangPhoto = zhuanzhangPhoto;
    }

    public String getBishangId() {
        return bishangId;
    }

    public void setBishangId(String bishangId) {
        this.bishangId = bishangId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
