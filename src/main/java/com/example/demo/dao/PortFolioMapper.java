package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.entity.PortFolio;;

@Mapper
public interface PortFolioMapper {
	
    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userRequest);

}
