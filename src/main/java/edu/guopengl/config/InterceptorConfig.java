package edu.guopengl.config;

import edu.guopengl.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/pages/**","/user/**","/book/**","/lend/**","/collect/**","/class/**","/test/**")
                .excludePathPatterns("/user/login","/user/register",
                        "/js/**", "/css/**","/img/**","/assets/**",
                        "/**/index.html", "/**/register.html", "/**/fonts/*", "/**/*.svg","/**/upload.html","LoginByQQ");

    }
}
