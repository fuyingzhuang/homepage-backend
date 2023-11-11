package com.ambition.homepage.code;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ambition
 * @date 2023/10/26 11:46
 */
@SpringBootTest
public class CrawlerTest {
    @Test
    void testFetchPassage() {
        System.out.println("testFetchPassage");
        String url = "https://www.baidu.com";
        String result1 = HttpUtil.get("https://www.baidu.com");
        System.out.println(result1);
    }
}
