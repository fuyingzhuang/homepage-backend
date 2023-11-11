package com.ambition.homepage.model.vo;

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
 * 个人项目表
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Projects对象", description = "个人项目表")
public class ProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "个人项目ID")
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "项目所用技术")
    private String technologies;

    @ApiModelProperty(value = "项目介绍")
    private String projectDescription;

    @ApiModelProperty(value = "项目类型")
    private Integer projectType;

    @ApiModelProperty(value = "项目线上地址")
    private String onlineUrl;

    @ApiModelProperty(value = "项目仓库地址")
    private String githubUrl;


}
