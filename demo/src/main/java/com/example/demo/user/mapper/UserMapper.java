package com.example.demo.user.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.user.vo.User;

@Mapper
public interface UserMapper{
	@Select("select * from users")
	public List<User> selectUsers();
	
	@Select("select * from users where id=#{id}")
	public User selectUserForId(int id);
	
	@Insert("insert into users(id,name,age) values(#{id},#{name},#{age})")
	public int insert(User user);
	
	@Update("update users set name =#{name}, age=#{age} where id = #{id}")
	public int update(User user);
	
	@Delete("delete from users where id = #{id}")
	public int delete(int id);	
}

