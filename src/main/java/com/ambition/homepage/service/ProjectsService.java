package com.ambition.homepage.service;

import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.model.entity.Projects;
import com.ambition.homepage.model.vo.ProjectVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 个人项目表 服务类
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
public interface ProjectsService extends IService<Projects> {

    BaseResponse<Page<ProjectVO>> getSearchList(long current, long size, String type, String search);

    BaseResponse<Projects> getProjectById(Long id);
}
