package com.ydws.game.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
//
//private String id;
//private String countries;
//private String bili;
@Parcelize
data class Countries(val id:String ,val countries:String,val bili:String) :Parcelable