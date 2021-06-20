package com.hxh.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;


@Configuration
public class MyLocalResovel implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		// 获取页面手动切换传递的语言参数
		String l = request.getParameter("1");
		//获取请求头自动传递的语言参数Accept-Language
		String header = request.getHeader("Accept-Language");
		Locale locale=null;
		if (!StringUtils.isEmpty(l)) {
			String[] split = l.split("_");
			locale =new Locale(split[0],split[1]);
			
		}else {
			String[] splits = header.split(",");
			String[] split = splits[0].split("-");
			locale =new Locale(split[0],split[1]);
		}
		
		
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocalResovel();
	}

}
