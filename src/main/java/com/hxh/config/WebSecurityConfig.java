package com.hxh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/fonts/**", "/img/**", 
				"/js/**", "/adminuser?error")
				.permitAll().anyRequest() // 任何其它请求
				.authenticated();// 都需要身份认证
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/toIndex", true)
				.failureUrl("/login?error").permitAll().and().logout().permitAll();
		;
		http.logout().logoutUrl("/mylogout").logoutSuccessUrl("/login").permitAll()
		.and().rememberMe()
		.and()
		.csrf().disable();// 跨站请求伪造,该令牌用于验证授权用户和发起请求者是否是同一个人

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 2、使用JDBC进行身份认证
        String userSQL ="select username,password,valid from t_customer " +
                "where username = ?";
        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
                "t_customer_authority ca where ca.customer_id=c.id " +
                "and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);
	}

}
