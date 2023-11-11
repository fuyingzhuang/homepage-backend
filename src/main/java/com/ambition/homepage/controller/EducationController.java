package com.ambition.homepage.controller;


import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.ResultUtils;
import com.ambition.homepage.model.entity.Education;
import com.ambition.homepage.service.EducationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 教育背景表 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/homepage/education")
public class EducationController {

    @Resource
    private EducationService educationService;


    @GetMapping("/info")
    public BaseResponse<Education> getEducation() {
        Education education = educationService.getById(1L);
        return ResultUtils.success(education);
    }
}

