package com.snsoft.ElectricHeating.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.snsoft.ElectricHeating.filter.JWTProcessingFilter;
import com.snsoft.ElectricHeating.filter.MoCharacterEncodingFilter;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年1月30日上午11:14:43
 * 
 * @Description TODO Server 配置
 */
@Configuration
public class ServerConfig {

	// web 三大件 servlet filter listen
	// 注册 CharacterEncodingFilter
	@Bean
	public FilterRegistrationBean<MoCharacterEncodingFilter> myFilter() {
		FilterRegistrationBean<MoCharacterEncodingFilter> registrationBean = new FilterRegistrationBean<MoCharacterEncodingFilter>();
		registrationBean.setFilter(new MoCharacterEncodingFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		return registrationBean;
	}

	// 注册 JWTProcessingFilter
	@Bean
	public FilterRegistrationBean<JWTProcessingFilter> myFilter1() {
		FilterRegistrationBean<JWTProcessingFilter> registrationBean = new FilterRegistrationBean<JWTProcessingFilter>();
		registrationBean.setFilter(new JWTProcessingFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		return registrationBean;
	}

}
