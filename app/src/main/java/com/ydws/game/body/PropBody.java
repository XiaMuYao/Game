package com.ydws.game.body;

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

    public  String userId;
    public String city;
    public String payee;
    public String bankname;
    public String cardNumber;
    public String zhifubaoId;
    public String wechat;
    public String propsNumber;
    public String traPassword;
    public String phone;
    public int language = 0;
    public String sessionId;
    public int fiat;
    public String fiatStr;
    public String countries;
}
