package rto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginRTO {
    @NotEmpty(message = "用户名不能为空")
    private String nickname;
    @NotEmpty(message = "密码不能为空")
    @Length(max = 20, message = "密码长度不能超过20个字符")
    private String password;
}