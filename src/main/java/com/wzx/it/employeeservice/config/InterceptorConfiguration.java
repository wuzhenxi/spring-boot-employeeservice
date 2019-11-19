package com.wzx.it.employeeservice.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(authenticationInterceptor())
                // 配置拦截的路径
         .addPathPatterns("/**")
                // 配置不拦截的路径
                .excludePathPatterns("/**")
        .excludePathPatterns("/**.html","/error","/uploadFile");
        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
//    	 registry.addInterceptor(appCheckLoginInterceptor()).addPathPatterns("/rest/plm/v2/**");
// 		http.sessionManagement().
//         maximumSessions(1).
//         /**
//          * 自定义session过期策略，替代默认的{@link ConcurrentSessionFilter.ResponseBodySessionInformationExpiredStrategy}，
//          * 复写onExpiredSessionDetected方法，默认方法只输出异常，没业务逻辑。这里需要返回json
//          */
//         expiredSessionStrategy(ajaxSessionInformationExpiredStrategy);
    }

    @Bean
    public CheckLoginInterceptor authenticationInterceptor() {
        return new CheckLoginInterceptor();
    }
}
