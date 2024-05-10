package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PortFolioMapper;
import com.example.demo.dto.UserAddRequest;

@Service
public class PortFolioService {
	
    @Autowired
    private PortFolioMapper portFolioMapper;
	
    /**
     * ユーザ情報登録
     * @param userAddRequest リクエストデータ
     */
    public void save(UserAddRequest userAddRequest) {
        portFolioMapper.save(userAddRequest);
    }
	

}