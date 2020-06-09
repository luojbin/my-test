package com.loyofo.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * springMVC 配置类, 对应 config-web.xml
 *
 * @author luojbin
 * @version 1.0
 * @date 2019/7/5 10:53
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.loyofo.test.app", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class WebConfig extends WebMvcConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(WebConfig.class);

    /**
     * 配置视图解析器, 相当于在 spring-mvc.xml 中配置
     *
     * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * <property name="prefix" value="/WEB-INF/views/" />
     * <property name="suffix" value=".jsp" />
     * </bean>
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * 静态资源映射, 相当于在 spring-mvc.xml 中配置
     * <p>
     * <mvc:default-servlet-handler />
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /**
     * 添加文件上传支持, 具体文件大小限制等需要在 DispatcherServlet 的初始化类中配置,
     * <p>
     * 相当于在 spring-mvc.xml 中添加对应的 bean
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter resolver = new StringHttpMessageConverter();
        List<MediaType> contentType = new ArrayList<>();
        contentType.add(MediaType.TEXT_HTML);
        contentType.add(MediaType.APPLICATION_JSON);
        resolver.setDefaultCharset(StandardCharsets.UTF_8);
        resolver.setSupportedMediaTypes(contentType);
        converters.add(resolver);
        super.configureMessageConverters(converters);
    }
}
