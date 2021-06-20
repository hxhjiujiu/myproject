package com.hxh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxh.domin.User;
import com.hxh.service.UserService;
import com.hxh.util.Myutil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/golist{pagNum}")
	public String golist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {

		PageHelper.startPage(pageNum, 5);
		List<User> userList = userService.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<User>(userList, 5);
		model.addAttribute("pageInfo", pageInfo);
		Myutil.findAdmin(model);
		return "list";

	}

    //模糊查询
	@RequestMapping("/mohu")
	public String gomohu(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model, String name) {

		PageHelper.startPage(pageNum, 5);
		List<User> userList = userService.findByLike(name);
		PageInfo<User> pageInfo = new PageInfo<User>(userList, 5);
		model.addAttribute("pageInfo", pageInfo);
		Myutil.findAdmin(model);
		return "list";

	}

	@GetMapping("/user")
	public String toaddUser(Model model) {
		Myutil.findAdmin(model);
		return "addUser";

	}

	@PostMapping("/user")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/golist";

	}

	@GetMapping("/user{id}")
	public String toUpdate(@PathVariable("id") Integer id, Model model) {
		Myutil.findAdmin(model);
		User user = userService.findByIdUser(id);
		model.addAttribute("user", user);
		return "updateUser";

	}
	@PostMapping("/upadteUser")
	public String UpdateUser( Model model,User user) {
		Myutil.findAdmin(model);
		userService.updateUser(user);
		return "redirect:/golist";

	}
	

	@GetMapping("/deleteUser{id}")
	public String deleteByIdUser(@PathVariable("id") Integer id) {
		userService.deleteByIdUser(id);
		return "redirect:/golist";

	}
	@RequestMapping("/about")
	public String toAbout(Model model) {
		Myutil.findAdmin(model);
		return "about";
		
	}

}
