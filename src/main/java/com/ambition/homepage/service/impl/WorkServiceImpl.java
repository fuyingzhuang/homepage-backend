package com.ambition.homepage.service.impl;

import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.ResultUtils;
import com.ambition.homepage.model.entity.Work;
import com.ambition.homepage.mapper.WorkMapper;
import com.ambition.homepage.service.WorkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-10-31
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {

    @Resource
    private WorkMapper workMapper;


    @Override
    public BaseResponse<List<Work>> getWorkList() {
        List<Work> works = workMapper.selectList(null);
        return ResultUtils.success(works);
    }
}
