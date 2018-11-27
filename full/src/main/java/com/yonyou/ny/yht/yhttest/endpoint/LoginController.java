package com.yonyou.ny.yht.yhttest.endpoint;

import com.yonyou.yht.sdkutils.StringUtils;
import com.yonyou.yht.sdkutils.YhtClientPropertyUtil;
import com.yonyou.yht.web.cas.util.CasClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.jasig.cas.client.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/11/6 11:05 AM
 * @since 1.0 Created by lipangeng on 2018/11/6 11:05 AM. Email:lipg@outlook.com.
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @RequestMapping
    public String login() {
        String url = null;
        String casLoginUrl = YhtClientPropertyUtil.getPropertyByKey("yht.login.url");
        if (StringUtils.isBlank(casLoginUrl)) {
            casLoginUrl = YhtClientPropertyUtil.getPropertyByKey("cas.url");
        }
        url = CommonUtils.constructRedirectUrl(CasClientUtils.computeLoginRedirection(casLoginUrl),
                                               "service",
                                               "http://local.lipg.cn:8080",
                                               false,
                                               false);
        return "redirect:" + url;
    }
}
