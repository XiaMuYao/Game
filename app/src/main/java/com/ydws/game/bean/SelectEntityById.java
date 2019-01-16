package com.ydws.game.bean;

/***
 * Created by mo on 2019/1/6
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class SelectEntityById {


    /**
     * code : 200
     * message : 成功
     * data : {"id":10045,"photo":"http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png","jinbi":619.31,"yinbi":1000,"wechat":"1753179110","payee":"牟先生","propsNumber":9800,"sex":1,"phone":"13644554242","bankName":"大连甘井子农行","cardNumber":"0.","zhifubao":"13644554245","niName":"小枣子z","city":"中国","tradingWord":1,"usdtbalance":1}
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
         * photo : http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png
         * jinbi : 619.31
         * yinbi : 1000
         * wechat : 1753179110
         * payee : 牟先生
         * propsNumber : 9800
         * sex : 1
         * phone : 13644554242
         * bankName : 大连甘井子农行
         * cardNumber : 0.
         * zhifubao : 13644554245
         * niName : 小枣子z
         * city : 中国
         * tradingWord : 1
         * usdtbalance : 1
         */

        private int id;
        private String photo;
        private double jinbi;
        private int yinbi;
        private String wechat;
        private String payee;
        private int propsNumber;
        private int sex;
        private String phone;
        private String bankName;
        private String cardNumber;
        private String zhifubao;
        private String niName="";
        private String city;
        private int tradingWord;
        private int usdtbalance;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public double getJinbi() {
            return jinbi;
        }

        public void setJinbi(double jinbi) {
            this.jinbi = jinbi;
        }

        public int getYinbi() {
            return yinbi;
        }

        public void setYinbi(int yinbi) {
            this.yinbi = yinbi;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getPayee() {
            return payee;
        }

        public void setPayee(String payee) {
            this.payee = payee;
        }

        public int getPropsNumber() {
            return propsNumber;
        }

        public void setPropsNumber(int propsNumber) {
            this.propsNumber = propsNumber;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getNiName() {
            return niName;
        }

        public void setNiName(String niName) {
            this.niName = niName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getTradingWord() {
            return tradingWord;
        }

        public void setTradingWord(int tradingWord) {
            this.tradingWord = tradingWord;
        }

        public int getUsdtbalance() {
            return usdtbalance;
        }

        public void setUsdtbalance(int usdtbalance) {
            this.usdtbalance = usdtbalance;
        }
    }
}
