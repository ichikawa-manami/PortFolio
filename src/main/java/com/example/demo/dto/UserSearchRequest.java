package com.example.demo.dto;

import java.io.Serializable;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



/**
 * ユーザー リクエストデータ
 */
@Data
public class UserSearchRequest implements Serializable {
    /**
     * パスワード
     */
    @NotEmpty(message = "パスワードは必ず入力してください")
    @Size(min = 8, message = "8文字以上で入力してください")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{6,30}",
    message = "英数字8文字以上で入力してください")
    private String password;
    /**
     * メールアドレス
     */
    @NotEmpty(message = "メールアドレスは必ず入力してください")
    @Pattern(regexp = "^(([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+)*$", 
    message = "メールアドレスが正しい形式ではありません")
    private String email;
}