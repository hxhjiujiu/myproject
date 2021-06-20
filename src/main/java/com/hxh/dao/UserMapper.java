package com.hxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hxh.domin.User;
@Mapper
public interface UserMapper {
	//查询所有
	List<User> findAll();
	//添加用户
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
