package com.equipment.sys.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * @Author: bzu
 * @Date: 2020/11/23 19:16
 */
@Configuration
@ConditionalOnClass(value= {PaginationInterceptor.class})
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor  paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
