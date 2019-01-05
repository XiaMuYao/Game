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
public class UserRegisterBean {
    private String userName;
    private String password;
    private int refereesId;
    private String question;
    private String answer;

    public UserRegisterBean(String userName, String password, int refereesId, String question, String answer) {
        this.userName = userName;
        this.password = password;
        this.refereesId = refereesId;
        this.question = question;
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRefereesId() {
        return refereesId;
    }

    public void setRefereesId(int refereesId) {
        this.refereesId = refereesId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
