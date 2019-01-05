package com.ydws.game.bean;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class bishangBean {

    /**
     * code : 200
     * message : 成功
     * data : {"id":10343,"bankName":"阿萨德","cardNumber":"84564654","zhifubao":"8451562","wechat":"845","payee":"给对方","phone":"13845463333","photo":"http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png"}
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
         * id : 10343
         * bankName : 阿萨德
         * cardNumber : 84564654
         * zhifubao : 8451562
         * wechat : 845
         * payee : 给对方
         * phone : 13845463333
         * photo : http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/headpicture/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20181106142337.png
         */

        private int id;
        private String bankName;
        private String cardNumber;
        private String zhifubao;
        private String wechat;
        private String payee;
        private String phone;
        private String photo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
