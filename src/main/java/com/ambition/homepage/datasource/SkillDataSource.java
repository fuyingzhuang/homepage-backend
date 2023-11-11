package com.ambition.homepage.datasource;

import com.ambition.homepage.model.entity.Skills;
import com.ambition.homepage.service.SkillsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ambition
 * @date 2023/11/1 21:51
 */
@Service
public class SkillDataSource implements DataSource<Skills> {

    @Resource
    private SkillsService skillsService;

    @Override
    public Page<Skills> getDataSource(String textSearch, long current, long pageSize) {
        Page<Skills> skillsPage = new Page<>(current, pageSize);
        System.out.println("skillsPage = " + skillsPage);
        QueryWrapper<Skills> skillsQueryWrapper = new QueryWrapper<>();
        skillsQueryWrapper.like("name", textSearch);

        Page<Skills> page = skillsService.page(skillsPage, skillsQueryWrapper);
        return page;
    }
}
