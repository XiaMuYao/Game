package com.ydws.game.bean;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class GameSelectEverydayTaskBean {


    /**
     * code : 200
     * message : 成功
     * data : {"completeGame":0,"unfinishedGame":3,"additionalGame":null,"validGame":9,"leaveGame":47,"weilingquJiangli":0}
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
         * completeGame : 0
         * unfinishedGame : 3
         * additionalGame : null
         * validGame : 9
         * leaveGame : 47
         * weilingquJiangli : 0
         */

        private int completeGame;
        private int unfinishedGame;
        private Object additionalGame;
        private int validGame;
        private int leaveGame;
        private String weilingquJiangli;

        public int getCompleteGame() {
            return completeGame;
        }

        public void setCompleteGame(int completeGame) {
            this.completeGame = completeGame;
        }

        public int getUnfinishedGame() {
            return unfinishedGame;
        }

        public void setUnfinishedGame(int unfinishedGame) {
            this.unfinishedGame = unfinishedGame;
        }

        public Object getAdditionalGame() {
            return additionalGame;
        }

        public void setAdditionalGame(Object additionalGame) {
            this.additionalGame = additionalGame;
        }

        public int getValidGame() {
            return validGame;
        }

        public void setValidGame(int validGame) {
            this.validGame = validGame;
        }

        public int getLeaveGame() {
            return leaveGame;
        }

        public void setLeaveGame(int leaveGame) {
            this.leaveGame = leaveGame;
        }

        public String getWeilingquJiangli() {
            return weilingquJiangli;
        }

        public void setWeilingquJiangli(String weilingquJiangli) {
            this.weilingquJiangli = weilingquJiangli;
        }
    }
}
