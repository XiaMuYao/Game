package com.ydws.game.bean

import android.content.Context
import android.content.Intent
import com.ydws.game.activity.GoldSearchActivity

class RecordByDaoOrGoldBean(private val context: Context, var id: Int = 0,var idStr :String ="", var userId: Int = 0, var lastChangeTime: String? = null, var tradingStatus: Int = 0, var propsNumber: Any? = null, var buyOrSell: Int = 0, var goldNumber: Int = 0) {
    var buyOrSellStr: String = ""
    var goldNumberStr:String = "0"
    var statusStr:String ="已完成"
    init {
        statusStr = if(tradingStatus == 1) "進行中" else "已完成"
        goldNumberStr = goldNumber.toString()
        if(buyOrSell ==1){
            buyOrSellStr = "赞助"
        }else{
            buyOrSellStr = "回购"
        }
    }
    fun lookup() {
        context.startActivity(Intent(context, GoldSearchActivity::class.java))
    }
}
