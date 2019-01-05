package com.ydws.game.bean;

import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class jiaoyijiluBean {

    /**
     * code : 200
     * message : 成功
     * data : [{"goldNumber":"1000000.000","createTime":"2018-12-27 14:29:58","status":2,"type":1},{"goldNumber":"1000000.000","createTime":"2018-12-27 14:30:29","status":1,"type":1},{"goldNumber":"1000.000","createTime":"2018-12-27 14:31:50","status":2,"type":2},{"goldNumber":"1000.000","createTime":"2018-12-27 14:31:54","status":1,"type":2}]
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
         * goldNumber : 1000000.000
         * createTime : 2018-12-27 14:29:58
         * status : 2
         * type : 1
         */

        private String goldNumber;
        private String createTime;
        private int status;
        private int type;

        public String getGoldNumber() {
            return goldNumber;
        }

        public void setGoldNumber(String goldNumber) {
            this.goldNumber = goldNumber;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
