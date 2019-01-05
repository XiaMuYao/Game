package com.ydws.game.body;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
public class PropBody {
//    userId	是	Integer	用户id
//    city	是	string	国家和城市和详细地址
//    payee	是	string	收款人姓名
//    bankname	是	string	开户行名
//    cardNumber	是	string	收款账号(卡号)
//    zhifubaoId	是	string	支付宝账号
//    wechat	是	string	微信号
//    propsNumber	是	string	交易道具数量
//    traPassword	是	String	交易密码
//    phone	是	String	电话号
//    language	是	int	语言，0汉语，其他英文
//    sessionId	是	String	session校验
//    fiat	是	Bigdecimal	约个法币价值
//    countries

    public ObservableField<String> userId = new ObservableField<>("");
    public  ObservableField<String> city= new ObservableField<>("");
    public  ObservableField<String> payee= new ObservableField<>("");
    public  ObservableField<String> bankname= new ObservableField<>("");
    public  ObservableField<String> cardNumber= new ObservableField<>("");
    public  ObservableField<String> zhifubaoId= new ObservableField<>("");
    public  ObservableField<String> wechat= new ObservableField<>("");
    public  ObservableField<String> propsNumber= new ObservableField<>("");
    public  ObservableField<String> traPassword= new ObservableField<>("");
    public  ObservableField<String> phone= new ObservableField<>("");
    public ObservableInt language = new ObservableInt();
    public ObservableInt fiat= new ObservableInt(0);
    public  ObservableField<String> fiatStr= new ObservableField<>("");
    public  ObservableField<String> countries= new ObservableField<>("");

    public  ObservableField<String> buyValue= new ObservableField<>("");
}
