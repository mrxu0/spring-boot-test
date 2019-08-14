package springboot.demo.test.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("真实姓名")
    private String userName;
    @ApiModelProperty("密码")
    private String passWord;
    @ApiModelProperty("网名")
    private String nickName;
    public User() {
        super();
    }

    public User(String userName, String passWord) {
        super();
        this.passWord = passWord;
        this.userName = userName;
    }
}
