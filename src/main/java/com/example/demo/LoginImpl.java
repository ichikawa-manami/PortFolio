package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PortFolioMapper;
import com.example.demo.entity.PortFolio;

@Service
public class LoginImpl implements UserDetailsService{

    //DBからユーザ情報を検索するメソッドを実装したクラス
    @Autowired
    private PortFolioMapper portFolioMapper;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {


    
      SiteUser user =  portFolioMapper.findByEmail(email);
      if(user == null) {
        //ユーザーが見つからなければ、SpringSecurityの以下の例外をthrowする。
        throw new UsernameNotFoundException(email + " not found");
      }
      return createUserDetails(user);
    }
  	
    public User createUserDetails(SiteUser user) {
      Set<GrantedAuthority> grantedAuthories = new HashSet<>();
      grantedAuthories.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

      return new User(user.getUsername(), user.getPassword(), grantedAuthories);
    }
}

