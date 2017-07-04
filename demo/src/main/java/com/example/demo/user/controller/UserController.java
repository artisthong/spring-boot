package com.example.demo.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.service.UserService;
import com.example.demo.user.vo.User;

@RestController
@RequestMapping("/users")
public class UserController {
//	private Logger logger = LoggerFactory.getILoggerFactory()
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	public UserController(UserService userService){
		this.userService = userService;
	}
//1	
	@RequestMapping(path="",method=RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getUsers();
	}

	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable int id, HttpServletRequest request){
		User user = userService.getUserForId(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("user",user.getName());
		logger.info("Session = "+session.getAttribute("user").toString());
		return user;
	}
	
	@RequestMapping(path="",method=RequestMethod.POST)
	public int createUser(@Valid @RequestBody User user){
		return userService.insert(user);		
	}
	
	@RequestMapping(path="",method=RequestMethod.PUT)
	public int modifyUser(@Valid @RequestBody User user){
		return userService.update(user);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public int deleteUser(@Valid @PathVariable int id){
		return userService.delete(id);
	}
	
	@RequestMapping(path="exception",method=RequestMethod.PUT)
	public int occurServerError(User user) throws RuntimeException{
		return userService.updateForError(user);
//		throw new Exception();
	}
}
