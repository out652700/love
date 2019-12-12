package com.word.wm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author hzc65
 * @Date 2019/11/20 21 25
 * @Describe  web通用配置 替代xml
 */
@Configuration
public class webConfig implements WebMvcConfigurer {
    /**
     * 功能描述  添加跨域配置项： 允许http or https 部分请求方法支持跨域请求action
     *
     * @param:
     * @return:
     * @auther: hzc65
     * @date: 2019/5/1 15:54
     */
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("允许跨域请求");

        //允许被请求的Http
        final String HTTP_GET = "GET";
        final String HTTP_POST = "POST";
        final String HTTP_PUT = "PUT";
        final String HTTP_DELETE = "DELETE";

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(HTTP_GET, HTTP_POST, HTTP_PUT,HTTP_DELETE)
                .allowCredentials(true).maxAge(3600);

    }

    /**
     * 设置默认页面 index
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("默认页面");
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 访问静态资源static
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
