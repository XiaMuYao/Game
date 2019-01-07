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
public class tuiguangBean {

    /**
     * code : 200
     * message : 成功
     * data : {"zongZhituiPlayerNumber":20,"zongQudaoPlayerNumber":24,"zongZhituiPlayerYeji":5000,"zongQudaoPlayerYeji":5000,"leijiGold":0,"weekGold":0,"weiLingGold":0}
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
         * zongZhituiPlayerNumber : 20
         * zongQudaoPlayerNumber : 24
         * zongZhituiPlayerYeji : 5000
         * zongQudaoPlayerYeji : 5000
         * leijiGold : 0
         * weekGold : 0
         * weiLingGold : 0
         */

        private int zongZhituiPlayerNumber;
        private int zongQudaoPlayerNumber;
        private int zongZhituiPlayerYeji;
        private int zongQudaoPlayerYeji;
        private int leijiGold;
        private String weekGold;
        private int weiLingGold;

        public int getZongZhituiPlayerNumber() {
            return zongZhituiPlayerNumber;
        }

        public void setZongZhituiPlayerNumber(int zongZhituiPlayerNumber) {
            this.zongZhituiPlayerNumber = zongZhituiPlayerNumber;
        }

        public int getZongQudaoPlayerNumber() {
            return zongQudaoPlayerNumber;
        }

        public void setZongQudaoPlayerNumber(int zongQudaoPlayerNumber) {
            this.zongQudaoPlayerNumber = zongQudaoPlayerNumber;
        }

        public int getZongZhituiPlayerYeji() {
            return zongZhituiPlayerYeji;
        }

        public void setZongZhituiPlayerYeji(int zongZhituiPlayerYeji) {
            this.zongZhituiPlayerYeji = zongZhituiPlayerYeji;
        }

        public int getZongQudaoPlayerYeji() {
            return zongQudaoPlayerYeji;
        }

        public void setZongQudaoPlayerYeji(int zongQudaoPlayerYeji) {
            this.zongQudaoPlayerYeji = zongQudaoPlayerYeji;
        }

        public int getLeijiGold() {
            return leijiGold;
        }

        public void setLeijiGold(int leijiGold) {
            this.leijiGold = leijiGold;
        }

        public String getWeekGold() {
            return weekGold;
        }

        public void setWeekGold(String weekGold) {
            this.weekGold = weekGold;
        }

        public int getWeiLingGold() {
            return weiLingGold;
        }

        public void setWeiLingGold(int weiLingGold) {
            this.weiLingGold = weiLingGold;
        }
    }
}
