package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * ユーザー情報登録 リクエストデータ
 */
@Data
public class UserAddRequest implements Serializable {
    /**
     * 名前
     */
    @NotEmpty(message = "名前は必ず入力してください")
    @Size(max = 255, message = "名前は255文字以内で入力してください")
    private String name;
    /**
     * パスワード
     */
    @NotEmpty(message = "パスワードは必ず入力してください")
    @Size(min = 8)
    @Pattern(regexp = "/\\A(?=.*?[a-z])(?=.*?[\\d])[a-z\\d]+\\z/i",
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

