package com.hxh.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;
@Configuration
public class PageHelperConfig {
	 @Bean
	    public PageHelper getPageHelper(){
	        PageHelper pageHelper=new PageHelper();
	        Properties properties=new Properties();
	        properties.setProperty("helperDialect","mysql");
	        properties.setProperty("reasonable","true");
	        properties.setProperty("supportMethodsArguments","true");
	        properties.setProperty("params","count=countSql");
	        pageHelper.setProperties(properties);
	        return pageHelper;
	    }

}
