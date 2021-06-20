package com.hxh.service;

import java.util.List;


import com.hxh.domin.User;

public interface UserService {
	//查询所有
		List<User> findAllUser();
		Integer addUser(User user);
		//查询出来需要修改的信息
		User findByIdUser(Integer id);
		//删除数据
		Integer deleteByIdUser(Integer id);
		//模糊查寻
		List<User> findByLike(String name);
		//修改用户
		Integer updateUser(User user);
		

}
