package com.ydws.game.bean;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class jiaquanBean {


    /**
     * code : 200
     * message : 成功
     * data : {"status":1,"time":"2019-01-01T08:03:10.000+0000","level":2,"chengfaLevel":0,"timeStr":"00:00:00","taskLevel":3,"yesNo":1}
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
         * status : 1
         * time : 2019-01-01T08:03:10.000+0000
         * level : 2
         * chengfaLevel : 0
         * timeStr : 00:00:00
         * taskLevel : 3
         * yesNo : 1
         */

        private int status;
        private String time;
        private int level;
        private String timestamp;
        private int chengfaLevel;
        private String timeStr;
        private int taskLevel;
        private int yesNo;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getChengfaLevel() {
            return chengfaLevel;
        }

        public void setChengfaLevel(int chengfaLevel) {
            this.chengfaLevel = chengfaLevel;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public void setTimeStr(String timeStr) {
            this.timeStr = timeStr;
        }

        public int getTaskLevel() {
            return taskLevel;
        }

        public void setTaskLevel(int taskLevel) {
            this.taskLevel = taskLevel;
        }

        public int getYesNo() {
            return yesNo;
        }

        public void setYesNo(int yesNo) {
            this.yesNo = yesNo;
        }
    }
}
