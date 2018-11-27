package com.yonyou.ny.yht.yhttest.configuration;

import com.yonyou.yht.sdk.ISessionStore;
import com.yonyou.yht.sdk.SessionStoreFactory;
import com.yonyou.yht.web.cas.sso.SingleSignOutHandler;
import lombok.extern.slf4j.Slf4j;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/11/8 11:04 AM
 * @since 1.0 Created by lipangeng on 2018/11/8 11:04 AM. Email:lipg@outlook.com.
 */
@Slf4j
public class YHTSingleSignOutHandler extends SingleSignOutHandler {
    /**
     * 前台退出逻辑
     *
     * @since 1.0 Created by lipangeng on 2018/11/8 11:11 AM. Email:lipg@outlook.com
     */
    public void frontLogout(HttpServletRequest request, HttpServletResponse response) {
        log.info("front logout {} , {}", request, response);
        log.info("clean all cookies");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie[] arr$ = cookies;
            int len$ = cookies.length;

            for (int i$ = 0; i$ < len$; ++ i$) {
                Cookie c = arr$[i$];
                c.setValue((String) null);
                c.setMaxAge(- 1);
                c.setHttpOnly(true);
                c.setPath("/");
                response.addCookie(c);
            }
        }

    }

    /**
     * 后台退出逻辑
     *
     * @since 1.0 Created by lipangeng on 2018/11/8 11:11 AM. Email:lipg@outlook.com
     */
    public void backLogout(String ticket) {
        log.info("backLogout with ticket {} ", ticket);
        ISessionStore sessionStore = SessionStoreFactory.getSessionStore();
        Assertion assertion = sessionStore.getAssertion(ticket);
        // 后台session注销
        Object session_id = assertion.getPrincipal().getAttributes().get("_session_id");
        log.info("注销SessionId:{}",session_id);
        // 清理登陆状态
        sessionStore.setAssertion(ticket, (Assertion) null);
    }
}
