package com.ambition.homepage.controller;


import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.PageRequest;
import com.ambition.homepage.model.entity.Projects;
import com.ambition.homepage.model.vo.ProjectVO;
import com.ambition.homepage.service.ProjectsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;

/**
 * <p>
 * 个人项目表 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/homepage/projects")
public class ProjectsController {

    @Resource
    private ProjectsService projectsService;

    /**
     * 获取项目列表
     *
     * @param pageRequest 分页请求
     * @return 项目列表
     */
    @PostMapping("/list")
    public BaseResponse<Page<ProjectVO>> list(@RequestBody PageRequest pageRequest) {
        // 当前页数
        long current = pageRequest.getCurrent();
        // 每页条数
        long size = pageRequest.getPageSize();
        // 类型
        String type = pageRequest.getSearchType();
        // 搜索内容
        String search = pageRequest.getSearchText();

        return projectsService.getSearchList(current, size, type, search);
    }

    @GetMapping("/get")
    public BaseResponse<Projects> get(@RequestParam("id") Long id) {
        return projectsService.getProjectById(id);
    }

}

