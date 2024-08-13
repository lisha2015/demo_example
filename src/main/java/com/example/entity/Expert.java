package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lisha
 * @since 2024-07-23
 */
@Getter
@Setter
public class Expert implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 头像
     */
    private String headImage;

    private String name;

    /**
     * 电话号码
     */
    private String mobile;

    /**
     * 人物标签
     */
    private String label;

    /**
     * 人物简介
     */
    private String profile;

    /**
     * 人物详细介绍
     */
    private String introduction;

    /**
     * 人物视频介绍，多个用逗号隔开
     */
    private String video;

    /**
     * 创建日期
     */
    private LocalDateTime createDate;

    /**
     * 更新日期
     */
    private LocalDateTime updateDate;

    /**
     * 启用状态0否 1是
     */
    private Integer enabledStatus;

    /**
     * 删除状态0否 1是
     */
    private Integer delFlag;


}
