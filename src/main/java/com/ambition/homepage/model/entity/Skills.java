package com.ambition.homepage.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 技能专长表
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Skills对象", description="技能专长表")
public class Skills implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "技能ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "技能名称")
    private String name;

    @ApiModelProperty(value = "熟练程度")
    private Integer proficiency;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "技能分类")
    private Integer category;

    @ApiModelProperty(value = "排序字段")
    private Integer sortOrder;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    @ApiModelProperty(value = "更新日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;


}
