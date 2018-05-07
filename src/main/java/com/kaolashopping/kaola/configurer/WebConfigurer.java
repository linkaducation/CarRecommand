package com.kaolashopping.kaola.configurer;

import com.kaolashopping.kaola.intercepter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午2:16
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private IgnorePageInterceptier ignorePageInterceptier;

    @Autowired
    private HomepageIntercepter homepageIntercepter;

    @Autowired
    private AdmnIntercepter admnIntercepter;

    @Autowired
    private PersonalFeatureIntercepter personalFeatureIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(admnIntercepter).addPathPatterns("/admin/**");
        registry.addInterceptor(ignorePageInterceptier).addPathPatterns("/**");
        registry.addInterceptor(homepageIntercepter).addPathPatterns("/user/**");
        registry.addInterceptor(personalFeatureIntercepter).addPathPatterns("/detail/**", "/brand/**");
        super.addInterceptors(registry);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(error404Page);
        };
    }
}
