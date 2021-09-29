package com.huan;

import com.huan.postconstructdemo.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author YueDong Huan
 * @Date 2021/9/24
 * @Email huanyued@163.com
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrmApplication.class)
public class ApplicationTest {

    @Test
    @Rollback(false)
    public void contextLoads() {
        System.out.println(Family.names);
    }
}
