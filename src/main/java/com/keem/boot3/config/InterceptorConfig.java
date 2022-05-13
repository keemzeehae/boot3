package com.keem.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.keem.boot3.interceptor.AdminInterceptor;
import com.keem.boot3.interceptor.MemberInterceptor;
import com.keem.boot3.interceptor.SellerInterceptor;
import com.keem.boot3.interceptor.WriterCheckInterceptor;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private SellerInterceptor sellerInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
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
		
		registry.addInterceptor(adminInterceptor).
				addPathPatterns("/admin/manage");
		
		registry.addInterceptor(memberInterceptor)
				.addPathPatterns("/board/*")
				.excludePathPatterns("/board/list");
		
		registry.addInterceptor(writerCheckInterceptor)
				.addPathPatterns("/board/update")
				.addPathPatterns("/board/delete");
		
		
	}

}
