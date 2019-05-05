package com.weng.framework.sample.consumer.config;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 重要：为了解决服务提供方使用类级别的@RequestMapping时,feign调用404的问题
 * @author wengzhonghui
 * @date 2019/3/25 6:51
 */
@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignMappingDefaultConfiguration {


    private static class FeignFilterRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && !beanType.isInterface();
        }
    }
}
