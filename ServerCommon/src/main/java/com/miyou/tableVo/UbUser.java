package com.miyou.tableVo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class UbUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @NotEmpty(message = "登录账号不能为空")
    @Column(name = "name", length = 20)
    @Length(min = 2,max=20,message = "登录账号长度必须再2到20个字符之间")
    private String userName;

    @NotEmpty(message = "真实姓名不能为空")
    @Column(name = "relName", length = 20)
    @Length(min = 1,max=6,message = "真实姓名长度必须再1到6个字符之间")
    private String relName;

    @NotEmpty(message = "密码不能为空")
    @Column(name = "pwd", length = 20)
    private String pwd;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;
}
