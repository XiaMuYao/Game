package com.ydws.game.bean;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class xiuxishijian {

    /**
     * code : 200
     * message : 成功.
     * data : {"biStatus":1,"restTimes":null,"haoTimes":null}
     * pageNum : 0
     * pageCount : 0
     */

    private String code;
    private String message;
    private DataBean data;
    private int pageNum;
    private int pageCount;

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

    public static class DataBean {
        /**
         * biStatus : 1
         * restTimes : null
         * haoTimes : null
         */

        private int biStatus;
        private String restTimes;
        private long haoTimes;

        public int getBiStatus() {
            return biStatus;
        }

        public void setBiStatus(int biStatus) {
            this.biStatus = biStatus;
        }

        public Object getRestTimes() {
            return restTimes;
        }

        public void setRestTimes(String restTimes) {
            this.restTimes = restTimes;
        }

        public long getHaoTimes() {
            return haoTimes;
        }

        public void setHaoTimes(long haoTimes) {
            this.haoTimes = haoTimes;
        }
    }
}
