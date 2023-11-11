package com.ambition.homepage.datasource;

import com.ambition.homepage.model.entity.Projects;
import com.ambition.homepage.service.ProjectsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ambition
 * @date 2023/11/1 21:52
 */
@Service
public class PersonProjectDataSource implements DataSource<Projects> {

    @Resource
    private ProjectsService projectsService;

    @Override
    public Page<Projects> getDataSource(String textSearch, long current, long pageSize) {
        Page<Projects> objectPage = new Page<>(current, pageSize);
        QueryWrapper<Projects> projectsQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Projects> queryWrapper = projectsQueryWrapper.like("project_name", textSearch).eq("project_type", 0);

        Page<Projects> page = projectsService.page(objectPage, queryWrapper);
        return page;
    }
}
