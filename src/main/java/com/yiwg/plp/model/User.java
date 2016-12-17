package com.yiwg.plp.model;

import javax.persistence.*;
import java.io.Serializable;

/*
*@date:2016/12/9
*@className:User
*@author：yiweiguo
*@description:用户类
*/
@Entity
@Table(name = "USER")
public class User implements Serializable {

    private int id;
    private String openId;
    private String nickName;
    private String city;
    private int gender; //男---->1   女----->2  未知------>0
    private int weight;//获取瓶子的权重，权重越低代表获得瓶子的可能性越低
    private String token;

    @Id
    @Column(name = "ID",nullable=false,length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "OPEN_ID",nullable = false ,length = 128)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "NICK_NAME",nullable = false,length = 36)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column(name = "CITY",nullable = true,length = 36)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "GENDER",nullable = true,length = 36)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Column(name = "WEIGHT",nullable = true,length = 36)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(name = "TOKEN",nullable = true,length = 128)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", token='" + token + '\'' +
                '}';
    }
}
