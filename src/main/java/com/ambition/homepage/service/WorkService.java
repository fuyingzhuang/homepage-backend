package com.ambition.homepage.service;

import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.model.entity.Work;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
public interface WorkService extends IService<Work> {


    BaseResponse<List<Work>> getWorkList();

}
