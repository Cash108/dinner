package com.example.admin.test1;

import java.util.Date;

/**
 * Created by admin on 2017/4/28.
 */

public class infoData {
    private  int OrderId;
    private   int UserId;
    private  String OrderTime;
    private  String EatingTime;
    private  String OrderRestanurant;
    private  int Minnumber;
    private  int Maxnumber;
    private  String OrderAddress;
    private  String OrderStyle;
    private  String OrderCity;
    private  int OrderTelephone;
    private  int OrderNumber;
    private  int OrderStituation;

    //获取订单id
    public int getOrderId() {return OrderId;}
    //设置订单id
    public void setOrderId(int OrderId) { this.OrderId = OrderId; }
    //获取用户id
    public int getUserId() {                //获取用户密码
        return UserId;
    }
    //设置用户id
    public void setUserPwd(int userId) {     //输入用户密码
        this.UserId = userId;
    }
    //获取订单时间
    public String getOrderTime() {                   //获取用户ID号
        return OrderTime;
    }
    //设置订单时间
    public void setUserId(String OrderTime) {  this.OrderTime = OrderTime;}
    //获取约饭时间
    public String getEatingTime() {return EatingTime;}
    //设置约饭时间
    public void setEatingTime(String EatingTime) {  this.EatingTime = EatingTime;}
    //获取最小人数
    public int getMinNumber() {return Minnumber;}
    //设置最小人数
    public void setMinnNmber(int Minnumber) { this.Minnumber = Minnumber; }
    //获取最大人数
    public int getMaxNumber() {                //获取用户密码
        return Maxnumber;
    }
    //设置最大人数
    public void setMaxNumber(int Maxnumber) {     //输入用户密码
        this.Maxnumber = Maxnumber;
    }
    //获取饭馆名
    public String getOrderRestanurant() {return OrderRestanurant;}
    //设置饭馆名
    public void setOrderRestanurant(String OrderRestanurant) {  this.OrderRestanurant = OrderRestanurant; }
    //获取菜系
    public String getOrderStyle() {                //获取用户密码
        return OrderStyle;
    }
    //设置菜系
    public void setOrderStyle(String OrderStyle) {     //输入用户密码
        this.OrderStyle = OrderStyle;
    }
    //获取城市
    public String getOrderCity() {                   //获取用户ID号
        return OrderCity;
    }
    //设置城市
    public void setOrderCity(String OrderCity) {  this.OrderCity = OrderCity;}
    //获取地址
    public String getOrderAddress() {return OrderAddress;}
    //设置地址
    public void setOrderAddress(String OrderAddress) {  //输入用户名
        this.OrderAddress = OrderAddress;
    }
    //获取联系人电话
    public int getOrderTelephone() {return OrderTelephone;}
    //设置联系人电话
    public void setOrderTelephone(int OrderTelephone) { this.OrderTelephone = OrderTelephone; }
    //获取订单人数
    public int getOrderNumber() {                //获取用户密码
        return OrderNumber;
    }
    //设置订单人数
    public void setOrderNumber(int OrderNumber) {     //输入用户密码
        this.OrderNumber = OrderNumber;
    }
    //获取订单状态
    public int  getOrderStituation() { return OrderStituation;}
    //设置订单状态
    public void setOrderStituation(int OrderStituation) {  this.OrderStituation = OrderStituation;}

    public infoData(  int OrderId,int UserId,
          String OrderTime,
              String EatingTime,
            String OrderRestanurant,
            int Minnumber,
             int Maxnumber,
          String OrderAddress,
             String OrderStyle,
            String OrderCity,
             int OrderTelephone,
              int OrderNumber,
            int OrderStituation) {  //这里只采用用户名和密码
        super();
        this.OrderId = OrderId;
        this.UserId = UserId;
        this.OrderTime = OrderTime;
        this.EatingTime = EatingTime;
        this.Minnumber = Minnumber;
        this.Maxnumber = Maxnumber;
        this.OrderRestanurant = OrderRestanurant;
        this.OrderStyle = OrderStyle;
        this.OrderCity = OrderCity;
        this.OrderAddress = OrderAddress;
        this.OrderTelephone = OrderTelephone;
        this.OrderNumber = OrderNumber;
        this.OrderStituation = OrderStituation;

    }

}
