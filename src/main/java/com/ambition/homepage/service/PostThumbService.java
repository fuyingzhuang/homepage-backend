package com.ambition.homepage.service;

import com.ambition.homepage.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ambition.homepage.model.entity.User;

/**
 * 帖子点赞服务
 *
 * @author ambition
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId    帖子 id
     * @param loginUser 登录用户
     * @return 点赞数
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId 用户 id
     * @param postId 帖子 id
     * @return 点赞数
     */
    int doPostThumbInner(long userId, long postId);
}
