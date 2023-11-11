package com.ambition.homepage.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Ambition
 * @date 2023/11/1 21:48
 */
public interface DataSource<T> {

   Page<T> getDataSource(String textSearch, long current, long pageSize);


}
