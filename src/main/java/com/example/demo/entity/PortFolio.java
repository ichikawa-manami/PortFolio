package com.example.demo.entity;

import java.io.Serializable;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//ユーザー情報 Entity
@Data
@AllArgsConstructor
public class PortFolio implements Serializable{
	
	
	//ID
    private Long id;

    //メールアドレス
    private String email;
    
    //名前
    private String name;

    //自己紹介
    private String self_introduction;

    //パスワード
    private String password;

     //登録日時
    private Date created_at;

    //更新日時
    private Date updated_at;
    

}

