package com.ambition.homepage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ambition.homepage.model.dto.post.PostQueryRequest;
import com.ambition.homepage.model.entity.Post;
import com.ambition.homepage.model.vo.PostVO;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子服务
 *
 * @author ambition
 *
 */
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post 帖子
     * @param add 是否新增
     */
    void validPost(Post post, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest 查询参数
     * @return 查询条件
     */
    QueryWrapper<Post> getQueryWrapper(PostQueryRequest postQueryRequest);

    /**
     * 从 ES 查询
     *
     * @param postQueryRequest 查询参数
     * @return 帖子分页数据
     */
    Page<Post> searchFromEs(PostQueryRequest postQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param post    帖子
     * @param request 请求
     * @return 帖子封装
     */
    PostVO getPostVO(Post post, HttpServletRequest request);

    /**
     * 分页获取帖子封装
     *
     * @param postPage 分页参数
     * @param request 请求
     * @return 帖子封装分页数据
     */
    Page<PostVO> getPostVOPage(Page<Post> postPage, HttpServletRequest request);
}
