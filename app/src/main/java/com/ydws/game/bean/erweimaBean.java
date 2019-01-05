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
public class erweimaBean {

    /**
     * code : 200
     * message : 成功
     * data : {"id":10045,"tuiguangErweima":"http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/erweima/1542368751983.png","tuiguanglianjie":"hangzhou.aliyuncs.com/erweima/1542161613997.png"}
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
         * id : 10045
         * tuiguangErweima : http://ydwsgame.oss-cn-hangzhou.aliyuncs.com/erweima/1542368751983.png
         * tuiguanglianjie : hangzhou.aliyuncs.com/erweima/1542161613997.png
         */

        private int id;
        private String tuiguangErweima;
        private String tuiguanglianjie;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTuiguangErweima() {
            return tuiguangErweima;
        }

        public void setTuiguangErweima(String tuiguangErweima) {
            this.tuiguangErweima = tuiguangErweima;
        }

        public String getTuiguanglianjie() {
            return tuiguanglianjie;
        }

        public void setTuiguanglianjie(String tuiguanglianjie) {
            this.tuiguanglianjie = tuiguanglianjie;
        }
    }
}
