package com.kaolashopping.kaola.configurer;

import com.kaolashopping.kaola.intercepter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ming.zhong
 * @date 2018/2/14 下午2:16
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private CheckLoginIntercepter checkLoginIntercepter;

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
        registry.addInterceptor(checkLoginIntercepter).addPathPatterns("/account/**");
        registry.addInterceptor(personalFeatureIntercepter).addPathPatterns("/detail/**", "/brand/**");
        super.addInterceptors(registry);
    }
}
