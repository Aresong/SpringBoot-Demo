package com.s5.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Aresong
 * @Date: 2019/5/16 0:03
 * @Version 1.0
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
            return new ConfigurationCustomizer(){
                @Override
                public void customize(Configuration configuration) {
                    configuration.setMapUnderscoreToCamelCase(true);
                }
         };
    }
}