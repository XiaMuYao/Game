package com.ydws.game.bean;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/4
 * 描    述：个人用户信息
 * 修订历史：
 * ================================================
 */
public class PersonalMessageBean {

    /**
     * code : 200
     * message : 成功
     * data : {"id":10000,"photo":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541232109486&di=66a25f7b6db3ab33ec07e59bf2862bd9&imgtype=0&src=http%3A%2F%2Fimg.bitscn.com%2Fupimg%2Fallimg%2Fc151231%2F1451551R050-1340K.jpg","jinbi":4444,"yinbi":10000,"propsNumber":20,"userType":2,"agentType":2}
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
         * id : 10000
         * photo : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541232109486&di=66a25f7b6db3ab33ec07e59bf2862bd9&imgtype=0&src=http%3A%2F%2Fimg.bitscn.com%2Fupimg%2Fallimg%2Fc151231%2F1451551R050-1340K.jpg
         * jinbi : 4444
         * yinbi : 10000
         * propsNumber : 20
         * userType : 2
         * agentType : 2
         */

        private int id;
        private String photo;
        private int jinbi;
        private int yinbi;
        private int propsNumber;
        private int userType;
        private int agentType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getJinbi() {
            return jinbi;
        }

        public void setJinbi(int jinbi) {
            this.jinbi = jinbi;
        }

        public int getYinbi() {
            return yinbi;
        }

        public void setYinbi(int yinbi) {
            this.yinbi = yinbi;
        }

        public int getPropsNumber() {
            return propsNumber;
        }

        public void setPropsNumber(int propsNumber) {
            this.propsNumber = propsNumber;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getAgentType() {
            return agentType;
        }

        public void setAgentType(int agentType) {
            this.agentType = agentType;
        }
    }
}
