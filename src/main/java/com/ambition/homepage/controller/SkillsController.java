package com.ambition.homepage.controller;


import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.ResultUtils;
import com.ambition.homepage.model.entity.Skills;
import com.ambition.homepage.service.SkillsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 技能专长表 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/homepage/skills")
public class SkillsController {

    @Resource
    private SkillsService skillsService;

    @GetMapping("/list")
    public BaseResponse<List<Skills>> getSkills() {
        List<Skills> skills = skillsService.list();
        return ResultUtils.success(skills);
    }

}

