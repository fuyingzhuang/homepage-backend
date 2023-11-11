package com.ambition.homepage.controller;

import com.ambition.homepage.common.BaseResponse;
import com.ambition.homepage.common.PageRequest;
import com.ambition.homepage.common.ResultUtils;
import com.ambition.homepage.datasource.CompanyProjectDataSource;
import com.ambition.homepage.datasource.PersonProjectDataSource;
import com.ambition.homepage.datasource.SkillDataSource;
import com.ambition.homepage.model.enums.AggregationSearchEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ambition
 * @date 2023/11/1 21:39
 */
@RestController
@RequestMapping("/homepage/search")
public class SearchController {


    @Resource
    private PersonProjectDataSource personProjectDataSource;

    @Resource
    private SkillDataSource skillDataSource;

    @Resource
    private CompanyProjectDataSource companyProjectDataSource;

    @PostMapping("/all")
    public BaseResponse<Page<?>> searchAll(@RequestBody PageRequest pageRequest) {

        System.out.println("pageRequest = " + pageRequest);
        String searchType = pageRequest.getSearchType();
        AggregationSearchEnum skillEnum = AggregationSearchEnum.SKILL;
        AggregationSearchEnum company = AggregationSearchEnum.COMPANY;
        AggregationSearchEnum personal = AggregationSearchEnum.PERSONAL;
        String skillEnumValue = skillEnum.getValue();
        String companyEnumValue = company.getValue();
        String personalEnumValue = personal.getValue();
        if (skillEnumValue.equals(searchType)) {
            return ResultUtils.success(skillDataSource.getDataSource(pageRequest.getSearchText(), pageRequest.getCurrent(), pageRequest.getPageSize()));
        } else if (companyEnumValue.equals(searchType)) {
            return  ResultUtils.success(companyProjectDataSource.getDataSource(pageRequest.getSearchText(), pageRequest.getCurrent(), pageRequest.getPageSize()));
        } else if (personalEnumValue.equals(searchType)) {
            return  ResultUtils.success(personProjectDataSource.getDataSource(pageRequest.getSearchText(), pageRequest.getCurrent(), pageRequest.getPageSize()));
        } else {
            return null;
        }

    }


}
