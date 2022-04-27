package com.keem.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.keem.boot3.interceptor.SellerInterceptor;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private SellerInterceptor sellerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//  적용할 Interceptor를 등록
		registry.addInterceptor(sellerInterceptor)
		//Interceptor를 사용할 URL
				.addPathPatterns("/product/manage");
				//.addPathPatterns("")
		
				//제외할 URL 주소
				//.excludePathPatterns("")  이렇게 쓰면 됨
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		
		
	}

}
