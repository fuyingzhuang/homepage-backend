package com.ambition.homepage.controller;


import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.model.entity.Work;
import com.ambition.homepage.service.WorkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/homepage/work")
public class WorkController {


    @Resource
    private WorkService workService;


    @GetMapping("/list")
    public BaseResponse<List<Work>> get() {
        return workService.getWorkList();
    }


}

