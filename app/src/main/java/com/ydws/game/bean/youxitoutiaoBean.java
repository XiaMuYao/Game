package com.ydws.game.bean;

import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class youxitoutiaoBean {

    /**
     * code : 200
     * message : 成功
     * data : [{"id":1,"gameName":"斗地主","numberVote":null,"randomNumberVote":null,"gameIntroduce":null,"endTime":"2018-12-13 ","numNumberVote":74,"gamePhoto":"https://www.baidu.com/img/dong_829616a42df497c9ef9afe2fbf24a913.png"},{"id":2,"gameName":"吹牛","numberVote":null,"randomNumberVote":null,"gameIntroduce":null,"endTime":"2018-12-13 ","numNumberVote":228,"gamePhoto":"https://www.baidu.com/img/dong_829616a42df497c9ef9afe2fbf24a913.png"},{"id":3,"gameName":"扫雷","numberVote":null,"randomNumberVote":null,"gameIntroduce":null,"endTime":"2018-12-10 ","numNumberVote":525,"gamePhoto":"https://www.baidu.com/img/dong_829616a42df497c9ef9afe2fbf24a913.png"}]
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
         * id : 1
         * gameName : 斗地主
         * numberVote : null
         * randomNumberVote : null
         * gameIntroduce : null
         * endTime : 2018-12-13
         * numNumberVote : 74
         * gamePhoto : https://www.baidu.com/img/dong_829616a42df497c9ef9afe2fbf24a913.png
         */

        private int id;
        private String gameName;
        private Object numberVote;
        private Object randomNumberVote;
        private Object gameIntroduce;
        private String endTime;
        private int numNumberVote;
        private String gamePhoto;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public Object getNumberVote() {
            return numberVote;
        }

        public void setNumberVote(Object numberVote) {
            this.numberVote = numberVote;
        }

        public Object getRandomNumberVote() {
            return randomNumberVote;
        }

        public void setRandomNumberVote(Object randomNumberVote) {
            this.randomNumberVote = randomNumberVote;
        }

        public Object getGameIntroduce() {
            return gameIntroduce;
        }

        public void setGameIntroduce(Object gameIntroduce) {
            this.gameIntroduce = gameIntroduce;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getNumNumberVote() {
            return numNumberVote;
        }

        public void setNumNumberVote(int numNumberVote) {
            this.numNumberVote = numNumberVote;
        }

        public String getGamePhoto() {
            return gamePhoto;
        }

        public void setGamePhoto(String gamePhoto) {
            this.gamePhoto = gamePhoto;
        }
    }
}
