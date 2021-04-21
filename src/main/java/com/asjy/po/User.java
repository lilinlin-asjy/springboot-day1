package com.asjy.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auther: lilinlin
 * @Date: 2021/4/14
 * @Description: po
 * @version: 1.0
 */
/*@Data 注解编译时自动生成get、set、toString、hashCode、equals方法
@AllArgsConstructor 生成全部参数的构造方法
@NoArgsConstructor 生成无参构造方法
以上注解定义在类上
可以通过 javap -c 字节码文件 查看编译后的类*/
@Data
@NoArgsConstructor

public class User {
    private Integer uId;
    private Integer state;
    @Email
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "密码不能为空")
    private String username;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Pattern(regexp="13[0-9]{9}",message = "电话号码不符合规范")
    private String phone;
    private String addr;
    private String code;

    //自定义构造方法后，将不在生成无参构造方法，因此需要使用@NoArgsConstructor生成无参构造方法，也可以自己定义
    //因为mybatis要通过扫描mapper.xml，利用无参构造方法生成po类的对象，resultType="User"
    public User(String username, Integer state) {
        this.username = username;
        this.state = state;
    }


}