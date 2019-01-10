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
public class gameInfoBean {


    /**
     * code : 200
     * message : 成功
     * data : {"id":1,"gameName":"暴擊土撥鼠","numberVote":65,"randomNumberVote":4576,"gameIntroduce":"對戰開始后會有土撥鼠和障礙物隨機出現在坑洞中，玩家敲擊土撥鼠得分，連續正確敲擊將會提高連擊次數，使當次得分享受加層獎勵。如果敲擊到障礙物，則會中斷連擊并重新累計。土撥鼠和障礙物會有不同分值，敲中土撥鼠得分，敲中障礙物失分。當對戰玩家有達到獲勝分值的則遊戲結束，根據失敗方所獲分數計算得失。 ","endTime":"2019-01-09","numNumberVote":4641,"gameCount":"雙人對戰","gameProps":"使用後可消除屏幕中所有障礙并持續6秒。 一局對戰只可使用一次。"}
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
         * id : 1
         * gameName : 暴擊土撥鼠
         * numberVote : 65
         * randomNumberVote : 4576
         * gameIntroduce : 對戰開始后會有土撥鼠和障礙物隨機出現在坑洞中，玩家敲擊土撥鼠得分，連續正確敲擊將會提高連擊次數，使當次得分享受加層獎勵。如果敲擊到障礙物，則會中斷連擊并重新累計。土撥鼠和障礙物會有不同分值，敲中土撥鼠得分，敲中障礙物失分。當對戰玩家有達到獲勝分值的則遊戲結束，根據失敗方所獲分數計算得失。
         * endTime : 2019-01-09
         * numNumberVote : 4641
         * gameCount : 雙人對戰
         * gameProps : 使用後可消除屏幕中所有障礙并持續6秒。 一局對戰只可使用一次。
         */

        private int id;
        private String gameName;
        private int numberVote;
        private int randomNumberVote;
        private String gameIntroduce;
        private String endTime;
        private int numNumberVote;
        private String gameCount;
        private String gameProps;

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

        public int getNumberVote() {
            return numberVote;
        }

        public void setNumberVote(int numberVote) {
            this.numberVote = numberVote;
        }

        public int getRandomNumberVote() {
            return randomNumberVote;
        }

        public void setRandomNumberVote(int randomNumberVote) {
            this.randomNumberVote = randomNumberVote;
        }

        public String getGameIntroduce() {
            return gameIntroduce;
        }

        public void setGameIntroduce(String gameIntroduce) {
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

        public String getGameCount() {
            return gameCount;
        }

        public void setGameCount(String gameCount) {
            this.gameCount = gameCount;
        }

        public String getGameProps() {
            return gameProps;
        }

        public void setGameProps(String gameProps) {
            this.gameProps = gameProps;
        }
    }
}
