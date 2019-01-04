package com.ydws.game.base;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * Created by 任飞宇
 * on 2018/11/9.
 */
public class ProgressUtils {

    public static KProgressHUD loading(Context context) {
        KProgressHUD kProgressHUD = KProgressHUD
                .create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
        return kProgressHUD;
    }

}
