package com.hxh.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public class Myutil {
	
	public  static void findAdmin(Model model) {
		SecurityContext context = SecurityContextHolder.getContext();
    	//获取用户相关信息
    	org.springframework.security.core.Authentication authentication= context.getAuthentication();
    	UserDetails principal = (UserDetails) authentication.getPrincipal();
    	String username = principal.getUsername();
    	model.addAttribute("username",username);
	}

}
