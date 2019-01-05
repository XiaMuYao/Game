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
public class buyingPropsBean {

    /**
     * code : 200
     * message : 成功
     * data : {"id":10027,"jinbi":50000,"niName":"昵称"}
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
         * id : 10027
         * jinbi : 50000
         * niName : 昵称
         */

        private int id;
        private int jinbi;
        private String niName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getJinbi() {
            return jinbi;
        }

        public void setJinbi(int jinbi) {
            this.jinbi = jinbi;
        }

        public String getNiName() {
            return niName;
        }

        public void setNiName(String niName) {
            this.niName = niName;
        }
    }
}
