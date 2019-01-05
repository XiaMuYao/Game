package com.ydws.game.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PayTypeBean(val id:String ,val payType:String): Parcelable{

    /**
     * id : 1
     * payType : 支付宝支付
     */


    override fun toString(): String {
        return payType
    }
}
