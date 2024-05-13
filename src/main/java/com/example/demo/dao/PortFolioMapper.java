package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.example.demo.dto.UserAddRequest;
import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.PortFolio;;

@Mapper
public interface PortFolioMapper {
	
    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userRequest);
    
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<PortFolio> search(UserSearchRequest name);
    
    PortFolio findByEmail(String email);
    

}
