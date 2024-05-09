package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PortFolioMapper;
import com.example.demo.dto.UserAddRequest;

/**
 * ユーザー情報 Service
 */
@Service
public class PortFolioService {

	/**
     * ユーザー情報 Mapper
     */
    @Autowired
    private PortFolioMapper portFolioMapper;
   
    /**
     * ユーザ情報登録
     * @param userAddRequest リクエストデータ
     */
    public void save(UserAddRequest userAddRequest) {
    	portFolioMapper.save(userAddRequest);
    }
  
    /**
     * ユーザー情報論理削除
     * @param id
     */
    public void delete(Long id) {
        portFolioMapper.delete(id);
    }


}