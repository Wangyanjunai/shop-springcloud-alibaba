package io.binghe.shop.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.binghe.shop.utils.id.SnowFlakeFactory;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_idiom")
public class Idiom implements Serializable {

    private static final long serialVersionUID = -2307409980909070073L;

    /**
     * 数据id
     */
    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    /**
     * 成语名称
     */
    @TableField("t_idiom_name")
    private String idiomName;

    /**
     * 搜索关键字母，成语的每个字拼音首字母组合
     */
    @TableField("t_search_keywords")
    private String searchKeywords;

    /**
     * 创建时间
     */
    @TableField("t_create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("t_update_time")
    private Date updateTime;

    /**
     * 预留字段01
     */
    @TableField("t_reserve_column01")
    private String ReserveColumn01;

    /**
     * 预留字段02
     */
    @TableField("t_reserve_column02")
    private String ReserveColumn02;

    /**
     * 预留字段03
     */
    @TableField("t_reserve_column03")
    private String ReserveColumn03;

    /**
     * 预留字段04
     */
    @TableField("t_reserve_column04")
    private String ReserveColumn04;

    public Idiom() {
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
    }
}
