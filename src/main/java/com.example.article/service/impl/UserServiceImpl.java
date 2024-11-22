package com.example.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.article.entity.User;
import com.example.article.mapper.UserMapper;
import com.example.article.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Late-en
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper UserMapper;

	@Override
	public boolean addUser(User User) {
		return UserMapper.insert(User) == 1;
	}

	@Override
	public boolean existUser(String username) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username",username);
		return UserMapper.selectCount(wrapper) != 0;
	}

	@Override
	public boolean deleteUser(Serializable id) {
		return UserMapper.deleteById(id) == 1;
	}

	@Override
	public boolean updateUserInfo(User user) {
		return UserMapper.updateById(user) == 1;
	}

	@Override
	public boolean updatePassword(User user) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", user.getUsername());
		return UserMapper.update(user,wrapper) == 1;
	}

	@Override
	public boolean verityPasswd(String username, String password) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", username);
		wrapper.eq("password", password);
		return UserMapper.selectCount(wrapper) == 1;
	}

	@Override
	public List<User> allUsers() {
		return UserMapper.selectList(null).stream().peek(user -> user.setPassword(null)).collect(Collectors.toList());
	}

	@Override
	public User getUserInfo(String username) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username", username);
		return UserMapper.selectOne(wrapper);
	}
}
