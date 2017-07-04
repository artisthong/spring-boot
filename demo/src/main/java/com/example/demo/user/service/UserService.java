package com.example.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.vo.User;

@Service
@Transactional //트랜잭션
public class UserService {
	private UserMapper userMapper;
	
	public UserService(UserMapper  userMapper){
		this.userMapper = userMapper;
	}
	
	public List<User> getUsers(){
		return userMapper.selectUsers();
	} 
	
	public User getUserForId(int id){
		return userMapper.selectUserForId(id);
	}
	
	
	public int insert(User user){
		return userMapper.insert(user);
	}
	
	public int update(User user){
		return userMapper.update(user);		
	}
	
	public int delete(int id){
		return userMapper.delete(id);
	}
	
	public int updateForError(User user){
		userMapper.update(user);
		throw new RuntimeException();
	}
		
}
