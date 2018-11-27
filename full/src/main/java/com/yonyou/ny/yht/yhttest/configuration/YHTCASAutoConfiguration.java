package com.yonyou.ny.yht.yhttest.configuration;

import com.yonyou.yht.web.cas.AuthenticationFilter2;
import com.yonyou.yht.web.cas.ProxyReceivingTicketValidationFilter;
import com.yonyou.yht.web.cas.sso.SingleSignOutFilter;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 友互通的自动配置
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2018/11/5 2:42 PM
 * @since 1.0 Created by lipangeng on 2018/11/5 2:42 PM. Email:lipg@outlook.com.
 */
@Configuration
public class YHTCASAutoConfiguration {

    /**
     * 单点登出拦截器
     *
     * @since 1.0 Created by lipangeng on 2018/11/5 2:52 PM. Email:lipg@outlook.com
     */
    @Bean
    public FilterRegistrationBean casSingleSignOutFilter() {
        FilterRegistrationBean<SingleSignOutFilter> singleSignOutFilter = new FilterRegistrationBean<>();
        singleSignOutFilter.setFilter(new SingleSignOutFilter());
        singleSignOutFilter.addUrlPatterns("/*");
        return singleSignOutFilter;
    }

    /**
     * CAS认证拦截器
     *
     * @since 1.0 Created by lipangeng on 2018/11/5 2:57 PM. Email:lipg@outlook.com
     */
    @Bean
    public FilterRegistrationBean casAuthenticationFilter2() {
        FilterRegistrationBean<AuthenticationFilter2> authenticationFilter2Filter = new FilterRegistrationBean<>();
        authenticationFilter2Filter.setFilter(new AuthenticationFilter2());
        authenticationFilter2Filter.addUrlPatterns("/*");
        return authenticationFilter2Filter;
    }

    /**
     * Ticket Validation Filter
     *
     * @since 1.0 Created by lipangeng on 2018/11/5 3:09 PM. Email:lipg@outlook.com
     */
    @Bean
    public FilterRegistrationBean casProxyReceivingTicketValidationFilter() {
        FilterRegistrationBean<ProxyReceivingTicketValidationFilter> proxyReceivingTicketValidationFilterFilter =
                new FilterRegistrationBean<>();
        proxyReceivingTicketValidationFilterFilter.setFilter(new ProxyReceivingTicketValidationFilter());
        proxyReceivingTicketValidationFilterFilter.addInitParameter("encoding", "UTF-8");
        proxyReceivingTicketValidationFilterFilter.addUrlPatterns("/*");
        return proxyReceivingTicketValidationFilterFilter;
    }

    /**
     * CAS HttpServletRequestWrapperFilter
     *
     * @since 1.0 Created by lipangeng on 2018/11/5 3:11 PM. Email:lipg@outlook.com
     */
    @Bean
    public FilterRegistrationBean casHttpServletRequestWrapperFilter() {
        FilterRegistrationBean<HttpServletRequestWrapperFilter> httpServletRequestWrapperFilterFilter =
                new FilterRegistrationBean<>();
        httpServletRequestWrapperFilterFilter.setFilter(new HttpServletRequestWrapperFilter());
        httpServletRequestWrapperFilterFilter.addUrlPatterns("/*");
        return httpServletRequestWrapperFilterFilter;
    }

    /**
     * AssertionThreadLocalFilter
     *
     * @since 1.0 Created by lipangeng on 2018/11/5 3:16 PM. Email:lipg@outlook.com
     */
    @Bean
    public FilterRegistrationBean casAssertionThreadLocalFilter() {
        FilterRegistrationBean<AssertionThreadLocalFilter> assertionThreadLocalFilterFilter =
                new FilterRegistrationBean<>();
        assertionThreadLocalFilterFilter.setFilter(new AssertionThreadLocalFilter());
        assertionThreadLocalFilterFilter.addUrlPatterns("/*");
        return assertionThreadLocalFilterFilter;
    }
}
