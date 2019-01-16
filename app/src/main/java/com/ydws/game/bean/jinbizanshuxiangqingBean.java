package com.ydws.game.bean;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class jinbizanshuxiangqingBean {

    /**
     * code : 200
     * message : 成功.
     * data : {"tradingId":446,"city":"中国11123","payee":"我","phone":"12452514215","goldNumber":1234,"zhuanzhangPhoto":"http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/commodity/avatar-1547175722241.png","payType":2,"bankname":"456","cardNumber":"789","usdt":12.34,"wechat":"123","zhifubaoId":"963"}
     * pageCount : 0
     * pageNum : 0
     */

    private String code;
    private String message;
    private DataBean data;
    private int pageCount;
    private int pageNum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public static class DataBean {
        /**
         * tradingId : 446
         * city : 中国11123
         * payee : 我
         * phone : 12452514215
         * goldNumber : 1234.0
         * zhuanzhangPhoto : http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/commodity/avatar-1547175722241.png
         * payType : 2
         * bankname : 456
         * cardNumber : 789
         * usdt : 12.34
         * wechat : 123
         * zhifubaoId : 963
         */

        private int tradingId;
        private String city;
        private String payee;
        private String phone;
        private double goldNumber;
        private String zhuanzhangPhoto;
        private int payType;
        private String bankname;
        private String cardNumber;
        private double usdt;
        private String wechat;
        private String zhifubaoId;
        private String fiat;

        public String getFiat() {
            return fiat;
        }

        public void setFiat(String fiat) {
            this.fiat = fiat;
        }

        public int getTradingId() {
            return tradingId;
        }

        public void setTradingId(int tradingId) {
            this.tradingId = tradingId;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public double getGoldNumber() {
            return goldNumber;
        }

        public void setGoldNumber(double goldNumber) {
            this.goldNumber = goldNumber;
        }

        public String getZhuanzhangPhoto() {
            return zhuanzhangPhoto;
        }

        public void setZhuanzhangPhoto(String zhuanzhangPhoto) {
            this.zhuanzhangPhoto = zhuanzhangPhoto;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
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

        public double getUsdt() {
            return usdt;
        }

        public void setUsdt(double usdt) {
            this.usdt = usdt;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getZhifubaoId() {
            return zhifubaoId;
        }

        public void setZhifubaoId(String zhifubaoId) {
            this.zhifubaoId = zhifubaoId;
        }
    }
}
