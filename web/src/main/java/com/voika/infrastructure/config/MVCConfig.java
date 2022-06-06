package com.voika.infrastructure.config;

import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;

@Configuration
@DependsOn({"shiroRealm", "crossFilter","shiroSessionManager"})
public class MVCConfig {

    @Resource
    private ShiroRealm realm;

    @Resource
    private CrossFilter crossFilter;

    @Resource
    private ShiroSessionManager shiroSessionManager;

//    @Bean
//    public FilterRegistrationBean filter() {
//        FilterRegistrationBean<CrossFilter> filter = new FilterRegistrationBean<>();
//        filter.setFilter(crossFilter);
//        filter.setOrder(1);
//        filter.addUrlPatterns("/**");
//        return filter;
//    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(defaultWebSecurityManager());
//        Map<String, String> url = new LinkedHashMap<String, String>() {{
//            put("/login/**", "anon");
//        }};
//        filter.setUnauthorizedUrl("/login/**");
//        filter.setFilterChainDefinitionMap(url);
        filter.setFilters(new HashMap<String, Filter>() {{
            put("crossFilter", crossFilter);
        }});
        return filter;
    }

    @Bean("sessionManager")
    public SessionManager sessionManager() {
        // 使用shiro的缓存
        shiroSessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return shiroSessionManager;
    }

    /**
     * 开启shiro 的AOP注解支持
     * @param securityManager
     * @return
     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }

//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        //自定义session管理
//        securityManager.setSessionManager(sessionManager());
//        return securityManager;
//    }

}
