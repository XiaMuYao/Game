package com.ydws.game.bean;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class SelectBuyBack {

    /**
     * code : 200
     * message : 成功
     * data : {"id":10045,"propsNumber":9800,"userName":"454245","bankName":"大连甘井子农行","cardNumber":"0.","zhifubao":"13644554245","city":"中国","payee":"牟先生","tradingPassword":"e10adc3949ba59abbe56e057f20f883e","times":0,"changeTime":"2018-12-24T02:38:50.000+0000","wechat":"1753179110","dongjieProps":0,"phone":"13644554242"}
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
         * id : 10045
         * propsNumber : 9800
         * userName : 454245
         * bankName : 大连甘井子农行
         * cardNumber : 0.
         * zhifubao : 13644554245
         * city : 中国
         * payee : 牟先生
         * tradingPassword : e10adc3949ba59abbe56e057f20f883e
         * times : 0
         * changeTime : 2018-12-24T02:38:50.000+0000
         * wechat : 1753179110
         * dongjieProps : 0
         * phone : 13644554242
         */

        private int id;
        private int propsNumber;
        private String userName;
        private String bankName;
        private String cardNumber;
        private String zhifubao;
        private String city;
        private String payee;
        private String tradingPassword;
        private int times;
        private String changeTime;
        private String wechat;
        private int dongjieProps;
        private String phone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPropsNumber() {
            return propsNumber;
        }

        public void setPropsNumber(int propsNumber) {
            this.propsNumber = propsNumber;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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

        public String getTradingPassword() {
            return tradingPassword;
        }

        public void setTradingPassword(String tradingPassword) {
            this.tradingPassword = tradingPassword;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public String getChangeTime() {
            return changeTime;
        }

        public void setChangeTime(String changeTime) {
            this.changeTime = changeTime;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public int getDongjieProps() {
            return dongjieProps;
        }

        public void setDongjieProps(int dongjieProps) {
            this.dongjieProps = dongjieProps;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
