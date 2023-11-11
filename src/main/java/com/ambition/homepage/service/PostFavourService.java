package com.ambition.homepage.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ambition.homepage.model.entity.Post;
import com.ambition.homepage.model.entity.PostFavour;
import com.ambition.homepage.model.entity.User;

/**
 * 帖子收藏服务
 *
 * @author ambition
 */
public interface PostFavourService extends IService<PostFavour> {

    /**
     * 帖子收藏
     *
     * @param postId    帖子 id
     * @param loginUser 登录用户
     * @return 收藏数
     */
    int doPostFavour(long postId, User loginUser);

    /**
     * 分页获取用户收藏的帖子列表
     *
     * @param page         分页参数
     * @param queryWrapper 查询条件
     * @param favourUserId 收藏用户 id
     * @return 帖子列表
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, Wrapper<Post> queryWrapper,
                                    long favourUserId);

    /**
     * 帖子收藏（内部服务）
     *
     * @param userId 用户 id
     * @param postId 帖子 id
     * @return 收藏数
     */
    int doPostFavourInner(long userId, long postId);
}
