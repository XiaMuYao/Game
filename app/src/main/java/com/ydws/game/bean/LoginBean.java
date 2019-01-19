package com.ydws.game.bean;

/**
 * Created by 任飞宇
 * on 2018/11/27.
 */

public class LoginBean {


    /**
     * code : 200
     * message : 登陸成功
     * data : {"id":10043,"photo":"http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png","jinbi":110,"yinbi":1000,"propsNumber":0,"wechat":"1753179110","refereesId":10017,"userName":"77777","sex":1,"phone":"13644554242","bankName":"","cardNumber":"210299199606068585","zhifubao":"13644554245","payee":"","userType":2,"agentType":2,"usdtbalance":null}
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
         * id : 10043
         * photo : http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png
         * jinbi : 110
         * yinbi : 1000
         * propsNumber : 0
         * wechat : 1753179110
         * refereesId : 10017
         * userName : 77777
         * sex : 1
         * phone : 13644554242
         * bankName :
         * cardNumber : 210299199606068585
         * zhifubao : 13644554245
         * payee :
         * userType : 2
         * agentType : 2
         * usdtbalance : null
         */

        private int id;
        private String photo;
        private String jinbi;
        private String yinbi;
        private int propsNumber;
        private String wechat;
        private int refereesId;
        private String userName;
        private int sex;
        private String phone;
        private String bankName;
        private String cardNumber;
        private String zhifubao;
        private String payee;
        private int userType;
        private int agentType;
        private Object usdtbalance;

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


        public String getJinbi() {
            return jinbi;
        }

        public void setJinbi(String jinbi) {
            this.jinbi = jinbi;
        }

        public String getYinbi() {
            return yinbi;
        }

        public void setYinbi(String yinbi) {
            this.yinbi = yinbi;
        }

        public int getPropsNumber() {
            return propsNumber;
        }

        public void setPropsNumber(int propsNumber) {
            this.propsNumber = propsNumber;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public int getRefereesId() {
            return refereesId;
        }

        public void setRefereesId(int refereesId) {
            this.refereesId = refereesId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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

        public String getPayee() {
            return payee;
        }

        public void setPayee(String payee) {
            this.payee = payee;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getAgentType() {
            return agentType;
        }

        public void setAgentType(int agentType) {
            this.agentType = agentType;
        }

        public Object getUsdtbalance() {
            return usdtbalance;
        }

        public void setUsdtbalance(Object usdtbalance) {
            this.usdtbalance = usdtbalance;
        }
    }
}
