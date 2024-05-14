package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.example.demo.entity.PortFolio;
import com.example.demo.dao.PortFolioMapper;


public class UserDetailsAuthenticationProvider 
extends AbstractUserDetailsAuthenticationProvider // AbstractUserDetailsAuthenticationProviderを継承する
{
	
	@Autowired
	private PortFolioMapper portFolioMapper;
	
    // @EnableWebSecurityをつけたconfigクラスにてBCryptPasswordEncoderをBean登録しているので、ここで注入する。
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    // UserDetails に何かしらの追加チェックを行いたい場合はここに実装。今回は要件にないので実装なし。
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {}

	@Override
	protected UserDetails retrieveUser(String name, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String password = (String) authentication.getCredentials(); // authenticationからpasswordを取得
		PortFolio user = portFolioMapper.findByName(name); // usernameでDBの検索を行う。
		if(bCryptPasswordEncoder.matches(password, user.getPassword())) { // 入力されたパスワードとDBにあったパスワードが一致するか判定
			return new DemoUserDetails(user); // 一致したらUserDetailsをnewしてreturn
		}else {
			throw new UsernameNotFoundException("user not found"); // 一致しなかったらUsernameNotFoundExceptionをスロー
		}
		
	}

}
