package com.ssafy.happyhouse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.interceptor.JwtInterceptor;

@SpringBootApplication
public class HappyHouseSpringBootApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseSpringBootApplication.class, args);
	}

	@Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/member/**") // 기본 적용 경로
                .excludePathPatterns(
                		Arrays.asList("/member/login", "/member/insert")
                ); // 적용 제외 경로
    }

//    Interceptor를 이용해서 처리하므로 전역의 Corss Origin 처리
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("auth-token");
    }
}
