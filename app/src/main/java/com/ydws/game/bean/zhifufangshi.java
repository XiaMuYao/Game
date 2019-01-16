package com.ydws.game.bean;

import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class zhifufangshi {


    /**
     * code : 200
     * message : 成功
     * data : [{"id":1,"payType":"支付宝支付"},{"id":2,"payType":"微信支付"},{"id":3,"payType":"银行卡"}]
     * pageCount : 0
     * pageNum : 0
     */

    private String code;
    private String message;
    private int pageCount;
    private int pageNum;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * payType : 支付宝支付
         */

        private int id;
        private String payType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }
    }
}
