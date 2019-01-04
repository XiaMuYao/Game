package com.ydws.game.utils;

import android.view.View;

/**
 * 防止重复点击
 * @author lijing
 */
public class ClickProxy implements View.OnClickListener {
    private View.OnClickListener origin;
    private long lastclick = 0;
    private long timems = 1000;

    public ClickProxy(View.OnClickListener origin) {
        this.origin = origin;
    }

    @Override
    public void onClick(View view) {
        if (System.currentTimeMillis() - lastclick >= timems) {
            origin.onClick(view);
            lastclick = System.currentTimeMillis();
        }
    }
}
