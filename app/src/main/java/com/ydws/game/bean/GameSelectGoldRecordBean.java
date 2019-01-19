package com.ydws.game.bean;

import java.util.List;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class GameSelectGoldRecordBean {


    /**
     * code : 200
     * message : 成功
     * data : [{"id":99,"userId":10045,"lastChangeTime":"2018-12-21 17:43:42","tradingStatus":2,"propsNumber":null,"buyOrSell":2,"goldNumber":10000}]
     * pageNum : 0
     * pageCount : 0
     */

    private String code;
    private String message;
    private int pageNum;
    private int pageCount;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 99
         * userId : 10045
         * lastChangeTime : 2018-12-21 17:43:42
         * tradingStatus : 2
         * propsNumber : null
         * buyOrSell : 2
         * goldNumber : 10000
         */

        private int id;
        private int userId;
        private String createTime;
        private int tradingStatus;
        private Object propsNumber;
        private int buyOrSell;
        private int goldNumber;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getTradingStatus() {
            return tradingStatus;
        }

        public void setTradingStatus(int tradingStatus) {
            this.tradingStatus = tradingStatus;
        }

        public Object getPropsNumber() {
            return propsNumber;
        }

        public void setPropsNumber(Object propsNumber) {
            this.propsNumber = propsNumber;
        }

        public int getBuyOrSell() {
            return buyOrSell;
        }

        public void setBuyOrSell(int buyOrSell) {
            this.buyOrSell = buyOrSell;
        }

        public int getGoldNumber() {
            return goldNumber;
        }

        public void setGoldNumber(int goldNumber) {
            this.goldNumber = goldNumber;
        }
    }
}