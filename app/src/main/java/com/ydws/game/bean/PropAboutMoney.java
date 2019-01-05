package com.ydws.game.bean;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class PropAboutMoney {


    /**
     * code : 200
     * message : 成功
     * data : {"a":2,"divide2":0.25}
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

    public int getdoublePageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public static class DataBean {
        /**
         * a : 2
         * divide2 : 0.25
         */

        private String a;
        private String divide2;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getDivide2() {
            return divide2;
        }

        public void setDivide2(String divide2) {
            this.divide2 = divide2;
        }
    }
}
