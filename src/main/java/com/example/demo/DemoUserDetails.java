package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.PortFolio;


public class DemoUserDetails implements UserDetails {

  // 先ほど作成したentity.Userをフィールドに持ってくる
  private PortFolio portFolio;
	
	public DemoUserDetails(PortFolio user) {
		super();
		this.portFolio = user;
	}
	
	public PortFolio getAccount() {
		return portFolio;
	}


	// passwordを返す
	@Override
	public String getPassword() {
		return portFolio.getPassword();
	}

	// nameを返す
	@Override
	public String getUsername() {
		return portFolio.getName();
	}

	// ユーザーのアカウントの有効期限が切れているかどうかを示す。今回は有効期限は設定しないので、デフォルトでtrueに設定。
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// ユーザーのアカウントがロックされているかかどうかを示す。今回はロックは設定しないので、デフォルトでtrueに設定。
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// ユーザーの資格情報（パスワード）の有効期限が切れているかどうかを示す。今回は資格情報の有効期限は設定しないので、デフォルトでtrueに設定。
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// ユーザーが有効か無効かを示す。今回は有効か無効かは設定しないので、デフォルトでtrueに設定。
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "CustomUserDetails [user=" + portFolio + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}

