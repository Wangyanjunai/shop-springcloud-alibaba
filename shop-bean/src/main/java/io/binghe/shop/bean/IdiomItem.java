package io.binghe.shop.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.binghe.shop.utils.id.SnowFlakeFactory;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_idiom_item")
public class IdiomItem implements Serializable {

    private static final long serialVersionUID = -2107409980909070073L;

    /**
     * 数据id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    /**
     * 成语id
     */
    @TableField(value = "t_idiom_id")
    private Long idiomId;

    /**
     * 排序
     */
    @TableField(value = "t_sort")
    private int sort;

    /**
     * 解说文字
     */
    @TableField("t_idiom_words")
    private String idiomWords;

    /**
     * 图片文件url
     */
    @TableField("t_image_url")
    private String imageUrl;

    /**
     * 语音文件url
     */
    @TableField("t_audio_url")
    private String audioUrl;

    /**
     * 歌词文件url
     */
    @TableField("t_lrc_url")
    private String lrcUrl;
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

    public IdiomItem() {
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
    }
}
