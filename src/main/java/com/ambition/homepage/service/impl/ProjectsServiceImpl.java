package com.ambition.homepage.service.impl;

import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.ResultUtils;
import com.ambition.homepage.model.entity.Projects;
import com.ambition.homepage.mapper.ProjectsMapper;
import com.ambition.homepage.model.vo.ProjectVO;
import com.ambition.homepage.service.ProjectsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 个人项目表 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements ProjectsService {

    @Resource
    private ProjectsMapper projectsMapper;

    @Override
    public BaseResponse<Page<ProjectVO>> getSearchList(long current, long size, String type, String search) {
        QueryWrapper<Projects> projectsQueryWrapper = new QueryWrapper<>();
        projectsQueryWrapper.like("project_name", search);
//        查询总数
        int count = this.count(projectsQueryWrapper);
        System.out.println("count = " + count);
//        查询列表
        Page<Projects> projectsPage = new Page<>(current, size);
        projectsPage = this.page(projectsPage, projectsQueryWrapper);
        List<Projects> projectsList = projectsPage.getRecords();
        for (Projects projects : projectsList) {
            System.out.println("projects = " + projects);
        }
//        转换为VO
        List<ProjectVO> projectVOList = new ArrayList<>();
        for (Projects projects : projectsList) {
            ProjectVO projectVO = new ProjectVO();
            BeanUtils.copyProperties(projects, projectVO);
            projectVOList.add(projectVO);
        }
//        返回结果
        Page<ProjectVO> projectVOPage = new Page<>(current, size, count);
        projectVOPage.setRecords(projectVOList);
        projectVOPage.setTotal(count);
        return ResultUtils.success(projectVOPage);



    }

    @Override
    public BaseResponse<Projects> getProjectById(Long id) {
        return ResultUtils.success(this.getById(id));
    }
}
