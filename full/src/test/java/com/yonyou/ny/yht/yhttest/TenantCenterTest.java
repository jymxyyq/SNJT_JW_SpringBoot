package com.yonyou.ny.yht.yhttest;

import com.yonyou.iuap.tenant.sdk.TenantCenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 租户测试
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/10/30 3:10 PM
 * @since 1.0 Created by lipangeng on 2018/10/30 3:10 PM. Email:lipg@outlook.com.
 */
@RunWith(JUnit4.class)
public class TenantCenterTest {
    private static final Logger log = LoggerFactory.getLogger(TenantCenterTest.class);

    @Test
    public void getTenantById(){
        String tenant = TenantCenter.getTenantById("tenant");
        log.info("tenant:{}",tenant);
    }
}
