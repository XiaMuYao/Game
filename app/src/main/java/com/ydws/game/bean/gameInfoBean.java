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
     * data : {"id":1,"gameName":"斗地主","numberVote":54,"randomNumberVote":4382,"gameIntroduce":"吹牛流行于中国各个地方，游戏斗智斗勇，技巧多变，极具趣味\n性，而且规则简单易学，拥有广泛的游戏人群! ","endTime":"2019-01-10","numNumberVote":4436,"gameFeatures":"规则简单易学，技巧多变，极具趣味性，把握对手的心理很重要","gameRules":"由发牌的人拿出1到8(二副牌1至16)张牌，扣下，并宣布是几张\n某点牌，如\"两张7\"。下家可以选择以下几种应法。\n一 不相信:(游戏的玩法:除了自己以外，其他任何人都可以不相信)\n则翻开那几张底牌，如果是骗张，则将此轮所有的牌都归被翻的人\n所有;如果不是骗张，则归不相信的人所有。然后由赢的人继续出牌\n和喊牌。\n二 相信并跟牌:跟牌的人只能跟一张到四张牌，然后叫牌:一种是加\n叫，即在原来的基础上加牌，比如上家所\"两张7\"，可以所\"加跟1张\n7\"，也可以喊其他的个人帐户盖过去，比如\"2张8\"，但必须满足两\n个条件，要么牌张比先出的人多，要么同张数情况下点力要大。\n三 放弃:表示相信上一个喊牌人的牌，自己放弃跟牌或加牌的机会，\n轮到下一家处理。如果连续多家放弃又轮到自己出牌，则刚才的牌\n成为一圈，将不再翻开而作为淘汰牌。如果下家三次以上不相信上\n家，而且三次上家都为真，那么第三次不相信就自动被认为放弃。\n牌的大小:A,2,3,\u202610,J,Q,K(A为自由牌，即A可以作为其他任何点\n数的牌看待)\n胜负:第一个出完手中的所有牌为胜利者，其他人全部为输家。输家\n扣除手中的牌数乘以每张牌代表的分数，赢家赢得所有输家的分数。"}
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
         * gameName : 斗地主
         * numberVote : 54
         * randomNumberVote : 4382
         * gameIntroduce : 吹牛流行于中国各个地方，游戏斗智斗勇，技巧多变，极具趣味
         性，而且规则简单易学，拥有广泛的游戏人群!
         * endTime : 2019-01-10
         * numNumberVote : 4436
         * gameFeatures : 规则简单易学，技巧多变，极具趣味性，把握对手的心理很重要
         * gameRules : 由发牌的人拿出1到8(二副牌1至16)张牌，扣下，并宣布是几张
         某点牌，如"两张7"。下家可以选择以下几种应法。
         一 不相信:(游戏的玩法:除了自己以外，其他任何人都可以不相信)
         则翻开那几张底牌，如果是骗张，则将此轮所有的牌都归被翻的人
         所有;如果不是骗张，则归不相信的人所有。然后由赢的人继续出牌
         和喊牌。
         二 相信并跟牌:跟牌的人只能跟一张到四张牌，然后叫牌:一种是加
         叫，即在原来的基础上加牌，比如上家所"两张7"，可以所"加跟1张
         7"，也可以喊其他的个人帐户盖过去，比如"2张8"，但必须满足两
         个条件，要么牌张比先出的人多，要么同张数情况下点力要大。
         三 放弃:表示相信上一个喊牌人的牌，自己放弃跟牌或加牌的机会，
         轮到下一家处理。如果连续多家放弃又轮到自己出牌，则刚才的牌
         成为一圈，将不再翻开而作为淘汰牌。如果下家三次以上不相信上
         家，而且三次上家都为真，那么第三次不相信就自动被认为放弃。
         牌的大小:A,2,3,…10,J,Q,K(A为自由牌，即A可以作为其他任何点
         数的牌看待)
         胜负:第一个出完手中的所有牌为胜利者，其他人全部为输家。输家
         扣除手中的牌数乘以每张牌代表的分数，赢家赢得所有输家的分数。
         */

        private int id;
        private String gameName;
        private int numberVote;
        private int randomNumberVote;
        private String gameIntroduce;
        private String endTime;
        private int numNumberVote;
        private String gameFeatures;
        private String gameRules;

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

        public String getGameFeatures() {
            return gameFeatures;
        }

        public void setGameFeatures(String gameFeatures) {
            this.gameFeatures = gameFeatures;
        }

        public String getGameRules() {
            return gameRules;
        }

        public void setGameRules(String gameRules) {
            this.gameRules = gameRules;
        }
    }
}
