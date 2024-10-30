package com.graphql.service;

import java.util.List;

import com.graphql.dtos.UserDTO;
import com.graphql.entity.User;

public interface IUserService {

	User createUser(User user);
	
	User createUserDTO(UserDTO userDTO);
	
	User findUserById(int id);
	
	List<User> finAllUsers();
	
	User upadateUserById(UserDTO userDTO, int id);
	
	String deleteUserByid(int id);
}
