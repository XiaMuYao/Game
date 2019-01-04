package com.ydws.game.base;


public interface IBaseActivity extends IBaseView {

    /**
     * 获取内容视图
     *
     * @return
     */
    int getContentLayoutID();
    /**
     * 初始化控件
     */
    void initViews();
    /**
     * 初始化数据
     */
    void initData();

}
