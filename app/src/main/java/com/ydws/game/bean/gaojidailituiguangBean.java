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
public class gaojidailituiguangBean {

    /**
     * code : 200
     * message : 成功.
     * data : {"level":0,"loseJinbi":10000,"jiaquanMax":0,"leijiJiangli":666,"weekLeijiJiangli":200}
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
         * level : 0
         * loseJinbi : 10000
         * jiaquanMax : 0
         * leijiJiangli : 666
         * weekLeijiJiangli : 200
         */

        private int level;
        private int loseJinbi;
        private int jiaquanMax;
        private int leijiJiangli;
        private int weekLeijiJiangli;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getLoseJinbi() {
            return loseJinbi;
        }

        public void setLoseJinbi(int loseJinbi) {
            this.loseJinbi = loseJinbi;
        }

        public int getJiaquanMax() {
            return jiaquanMax;
        }

        public void setJiaquanMax(int jiaquanMax) {
            this.jiaquanMax = jiaquanMax;
        }

        public int getLeijiJiangli() {
            return leijiJiangli;
        }

        public void setLeijiJiangli(int leijiJiangli) {
            this.leijiJiangli = leijiJiangli;
        }

        public int getWeekLeijiJiangli() {
            return weekLeijiJiangli;
        }

        public void setWeekLeijiJiangli(int weekLeijiJiangli) {
            this.weekLeijiJiangli = weekLeijiJiangli;
        }
    }
}
