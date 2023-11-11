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
 * 工作经历表
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Work对象", description="工作经历表")
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工作经历ID")
    @TableId(value = "experience_id", type = IdType.AUTO)
    private Integer experienceId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "职位名称")
    private String positionName;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "工作描述")
    private String jobDescription;

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
