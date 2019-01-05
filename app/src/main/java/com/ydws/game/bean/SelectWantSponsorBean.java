package com.ydws.game.bean;

import android.os.Parcel;
import android.os.Parcelable;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class SelectWantSponsorBean {


    /**
     * code : 200
     * message : 成功
     * data : {"id":10045,"city":"中国","wechat":"17531791101","phone":"13644554242","bankName":"大连甘井子农行","cardNumber":"154245254646","zhifubao":"1753179110","payee":"牟先生","becomeStatus":4,"tradingNumber":null}
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

    public static class DataBean implements Parcelable
    {


        /**
         * id : 10045
         * city : 中国
         * wechat : 17531791101
         * phone : 13644554242
         * bankName : 大连甘井子农行
         * cardNumber : 154245254646
         * zhifubao : 1753179110
         * payee : 牟先生
         * becomeStatus : 4
         * tradingNumber : null
         */

        private int id;
        private String city;
        private String wechat;
        private String phone;
        private String bankName;
        private String cardNumber;
        private String zhifubao;
        private String payee;
        private int becomeStatus;
        private String tradingNumber;

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

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
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

        public int getBecomeStatus() {
            return becomeStatus;
        }

        public void setBecomeStatus(int becomeStatus) {
            this.becomeStatus = becomeStatus;
        }

        public String getTradingNumber() {
            return tradingNumber;
        }

        public void setTradingNumber(String tradingNumber) {
            this.tradingNumber = tradingNumber;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.city);
            dest.writeString(this.wechat);
            dest.writeString(this.phone);
            dest.writeString(this.bankName);
            dest.writeString(this.cardNumber);
            dest.writeString(this.zhifubao);
            dest.writeString(this.payee);
            dest.writeInt(this.becomeStatus);
            dest.writeString(this.tradingNumber);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readInt();
            this.city = in.readString();
            this.wechat = in.readString();
            this.phone = in.readString();
            this.bankName = in.readString();
            this.cardNumber = in.readString();
            this.zhifubao = in.readString();
            this.payee = in.readString();
            this.becomeStatus = in.readInt();
            this.tradingNumber = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
