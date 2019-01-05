package com.ydws.game.utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class Entry2MapUtil {
    public static Map<String,String> toMap(@NonNull Object o){
        Gson gson = new Gson();

        String jsonString = gson.toJson(o);
        return gson.fromJson(jsonString, new TypeToken<Map<String,String>>(){}.getType());
    }
}
