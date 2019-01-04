package com.ydws.game.base;


public interface IBaseView {

    /**
     * 加载动画
     *
     * @param b
     */
    void showHud(boolean b);

    /**
     * toast 提示
     *
     * @param msg
     */
    void showMessage(String msg);
}
