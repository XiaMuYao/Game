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
public class GameListBean {

    /**
     * code : 200
     * message : 成功
     * data : [{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:37:33","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:37:52","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:46:38","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:46:57","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:47:09","gameName":"消消乐","status":2},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:47:32","gameName":"消消乐","status":2},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-26 18:47:40","gameName":"消消乐","status":2},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-27 14:06:20","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-27 14:10:50","gameName":"消消乐","status":1},{"gameLiushui":80,"userName":"454245","duijuTime":"2018-11-27 14:11:07","gameName":"消消乐","status":1}]
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
         * gameLiushui : 80
         * userName : 454245
         * duijuTime : 2018-11-26 18:37:33
         * gameName : 消消乐
         * status : 1
         */

        private int gameLiushui;
        private String userName;
        private String duijuTime;
        private String gameName;
        private int status;

        public int getGameLiushui() {
            return gameLiushui;
        }

        public void setGameLiushui(int gameLiushui) {
            this.gameLiushui = gameLiushui;
        }

        public String getUserName() {

            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDuijuTime() {
            return duijuTime;
        }

        public void setDuijuTime(String duijuTime) {
            this.duijuTime = duijuTime;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
