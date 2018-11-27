package com.yonyou.ny.yht.yhttest;

import com.yonyou.yht.sdk.UserCenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试用户中心
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/10/30 10:32 AM
 * @since 1.0 Created by lipangeng on 2018/10/30 10:32 AM. Email:lipg@outlook.com.
 */
@RunWith(JUnit4.class)
public class UserCenterTest {
    private static final Logger log = LoggerFactory.getLogger(UserCenterTest.class);

    @Test
    public void getUserById() {
        String abc = UserCenter.getUserById("ec4326d0-d490-4d5a-9105-260b51fd16d0");
        log.info(abc);
    }
}
