package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 可配置值字典项目
 * </p>
 *
 * @author lisha
 * @since 2023-06-14
 */
@Data
//@TableName("shop_dict")
public class ShopDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 字典编号值 10供应引导等待时间  11采购引导等待时间  20企业认证等待时间
     */
    private Integer code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 删除标记 0未删除 1已删除
     */
    private Integer delFlag;


}
