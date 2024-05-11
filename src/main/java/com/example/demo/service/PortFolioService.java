package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PortFolioMapper;
import com.example.demo.dto.UserAddRequest;
import com.example.demo.entity.PortFolio;

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