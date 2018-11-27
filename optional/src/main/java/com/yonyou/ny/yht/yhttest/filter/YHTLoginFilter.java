package com.yonyou.ny.yht.yhttest.filter;

import com.yonyou.yht.sdk.ISessionStore;
import com.yonyou.yht.sdk.SessionStoreFactory;
import com.yonyou.yht.web.cas.ProxyReceivingTicketValidationFilter;
import lombok.extern.slf4j.Slf4j;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/11/8 11:20 AM
 * @since 1.0 Created by lipangeng on 2018/11/8 11:20 AM. Email:lipg@outlook.com.
 */
@Slf4j
public class YHTLoginFilter extends ProxyReceivingTicketValidationFilter {
    @Override
    public void saveLoginInfo(String ticket,
                                 Assertion assertion,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        super.saveLoginInfo(ticket, assertion, request, response);
        log.info("保存本地登陆信息，或执行本地登陆操作");
        // 记录sessionid,方便注销时进行注销
        ISessionStore sessionStore = SessionStoreFactory.getSessionStore();
        assertion.getPrincipal().getAttributes().put("_session_id", request.getSession().getId());
        sessionStore.setAssertion(ticket, assertion);
        log.info("存储SessionId:" + request.getSession().getId());
    }
}
