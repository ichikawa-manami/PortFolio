package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class PortFolio implements Serializable {

    /**
     * ID
     */
    private Long id;
    
    /**
     * メールアドレス
     */
    private String email;

    /**
     * 名前
     */
    private String name;

    /**
     * 自己紹介文
     */
   private String self_introduction;
   
   /**
    * パスワード
    */
   private String password;
    
    /**
     * 更新日
     */
    private Date updated_at;

    /**
     * 作成日
     */
    private Date created_at;
    
    /**
     * 削除日時
     */
    private Date deleteDate;
}