package com.ydws.game.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.ydws.game.App;
import com.ydws.game.BuildConfig;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/1/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class StringUtli {
    /**
     * 去你妈
     *
     * @return
     */
    public static String getBlueTooth() {
        Context context = App.Companion.getInstance();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        System.out.println("imei========" + imei);
        return imei;
    }
}
