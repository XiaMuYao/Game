package com.ydws.game.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by 任飞宇
 * on 2018/11/12.
 */

public class GameAPP extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);

//        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//                LogUtils.d("onActivityCreated: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//                LogUtils.d("onActivityStarted: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//                LogUtils.d("onActivityResumed: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//                LogUtils.d("onActivityPaused: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//                LogUtils.d("onActivityStopped: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//                LogUtils.d("onActivitySaveInstanceState: " + activity.getLocalClassName());
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//                LogUtils.d("onActivityDestroyed: " + activity.getLocalClassName());
//            }
//        });

    }
}
