package com.hxh;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxh.dao.UserMapper;
import com.hxh.domin.User;

@SpringBootTest
class Springbootword1ApplicationTests {
	@Autowired
	private UserMapper userListMapper;

	@Test
	void contextLoads() {
		List<User> list = userListMapper.findAll();
		for (User user : list) {
			System.out.println(user);
		}

	}

	@Test
	void contextLoads1() {
		User user=new User();
		user.setId(1);
		user.setSex('女');
		user.setName("张四");
		user.setMember("vip1");
		user.setEmail("172791530@.com");
		user.setPhonenumber("14785236912");
		Integer user2 = userListMapper.updateUser(user);
		System.out.println(user2);
		

	}

	@Test
	void contextLoads2() {
		Integer integer = userListMapper.deleteByIdUser(5);
		System.out.println(integer);

	}

	@Test
	void contextLoads3() {
		int page = 2;
		int size = 5;
		PageHelper.startPage(page, size);
		List<User> list = userListMapper.findAll();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		for (User user : pageInfo.getList()) {
			System.out.println(user);
		}

	}
	@Test
	void contextLoads4() {
	

	}
	

}
