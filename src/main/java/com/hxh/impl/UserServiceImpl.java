package com.hxh.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxh.dao.UserMapper;
import com.hxh.domin.User;
import com.hxh.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
//	@Cacheable(cacheNames = "user")
	public Integer addUser(User user) {
		
		return userMapper.addUser(user);
	}

	@Override
//	@Cacheable(cacheNames = "user")
	public User findByIdUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.findByIdUser(id);
	}

	@Override
//	@Cacheable(cacheNames = "user")
	public Integer deleteByIdUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByIdUser(id);
	}

	@Override
//	@Cacheable(cacheNames = "user")
	public List<User> findByLike(String name) {
		// TODO Auto-generated method stub
		return userMapper.findByLike(name);
	}

	@Override
//	@Cacheable(cacheNames = "user")
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}


	

}
