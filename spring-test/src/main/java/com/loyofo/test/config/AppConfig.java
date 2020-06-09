package com.loyofo.test.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;

/**
 * webapp 初始化类, 取代 web.xml
 */
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定应用上下文的配置文件路径, 相当于在 web.xml 中配置
     *
     *<context-param>
     * 		<param-name>contextConfigLocation</param-name>
     * 		<param-value>classpath:config-context.xml</param-value>
     * 	</context-param>
     * 	<listener>
     * 		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     * 	</listener>
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 指定 DispatcherServlet 上下文的配置文件路径, 相当于在 web.xml 中配置
     *
     * <servlet>
     * 		<servlet-name>dispatcher</servlet-name>
     * 		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     * 		<init-param>
     * 			<param-name>contextConfigLocation</param-name>
     * 			<param-value>classpath*:/config-web.xml</param-value>
     * 		</init-param>
     * 		<load-on-startup>1</load-on-startup>
     * 	</servlet>
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 指定 DispatcherServlet 映射路径, 相当于在 web.xml 配置
     *
     *	<servlet-mapping>
     * 		<servlet-name>dispatcher</servlet-name>
     * 		<url-pattern>/</url-pattern>
     * 	</servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addFilter("encoding", new CharacterEncodingFilter(StandardCharsets.UTF_8.name()))
                .addMappingForUrlPatterns(null, true, "/*" );
    }

}
