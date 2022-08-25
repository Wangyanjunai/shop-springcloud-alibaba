package io.binghe.shop.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.binghe.shop.utils.id.SnowFlakeFactory;
import io.binghe.shop.utils.passwd.PasswordUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author binghe(冰河技术)
 * @version 1.0.0
 * @description 用户实体类
 */

@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -7032479567987350240L;

    /**
     * 数据id
     */
    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String username;

    /**
     * 密码
     */
    @TableField("t_password")
    private String password;

    /**
     * 手机号
     */
    @TableField("t_phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("t_address")
    private String address;

    public User() {
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
        //默认密码
        this.password = PasswordUtils.getPassword("123456");
    }
}
