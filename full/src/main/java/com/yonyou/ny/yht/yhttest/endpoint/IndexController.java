package com.yonyou.ny.yht.yhttest.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.yht.sdk.UserCenter;
import com.yonyou.yht.web.cas.util.CasClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/11/5 3:26 PM
 * @since 1.0 Created by lipangeng on 2018/11/5 3:26 PM. Email:lipg@outlook.com.
 */
@RestController
@RequestMapping
@Slf4j
public class IndexController {

    @RequestMapping({"/", "index"})
    public Object index() throws IOException {
        return new LinkedHashMap<String, Object>() {{
            put("Logined", Boolean.TRUE);
            put("user", CasClientUtils.getLoginedUserAttributes());
            put("userCenter",
                new ObjectMapper().readValue(UserCenter.getUserById(CasClientUtils.getLoginedUserId()), Object.class));
        }};
    }
}
