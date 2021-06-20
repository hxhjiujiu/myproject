package com.hxh.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxh.util.Myutil;

@Controller
public class LoginController {
	@RequestMapping("/toIndex")
	public String toIndex(Model model) {
		Myutil.findAdmin(model);
		return "index";
	}
	@GetMapping("/login")
	public String adminUser() {
		return "login";
	}
	 @RequestMapping("/main")
	    public String toMain(Authentication authentication){ // 会自动注入Authentication
	        System.out.println("登录用户：");
	        return "index.html";
	    }

	    @PreAuthorize("hasRole('ROLE_admin')")
	    @RequestMapping("/admin")
	    @ResponseBody
	    public String admin(){
	        return "你是管理员角色";
	    }

	    @PreAuthorize("hasRole('ROLE_customer')")
	    @RequestMapping("/customer")
	    @ResponseBody
	    public String customer(){
	        return "你是普通用户角色";
	    }
	//获取用户信息
	    @GetMapping("/getUserByContext")
	    @ResponseBody
	    public void getUser(Model model) {
	    	SecurityContext context = SecurityContextHolder.getContext();
	    	//获取用户相关信息
	    	org.springframework.security.core.Authentication authentication= context.getAuthentication();
	    	UserDetails principal = (UserDetails) authentication.getPrincipal();
	    	
	    	String username = principal.getUsername();
	    	model.addAttribute("username",username);
	    }
	

}
