package com.ambition.homepage.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ambition
 * @date 2023/10/26 15:32
 */
@Data
public class SearchVo implements Serializable {
    List<UserVO> userVOList;
    List<PostVO> postVOList;
}
