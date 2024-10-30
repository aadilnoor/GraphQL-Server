package com.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.graphql.dtos.UserDTO;
import com.graphql.entity.User;
import com.graphql.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@MutationMapping
	public User createUser(@Argument String name, @Argument String phone, @Argument String email,
			@Argument String password) {

		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		return userService.createUser(user);

	}

	@MutationMapping
	public User createUserBYUserDTO(@Argument UserDTO userDTO) {
		return userService.createUserDTO(userDTO);
	}

	@QueryMapping
	public User getUserById(@Argument int id) {
		return userService.findUserById(id);
	}

	@QueryMapping
	public List<User> getAllUsers() {
		return userService.finAllUsers();
	}

	@MutationMapping
	public User updateUser(@Argument UserDTO userDTO, @Argument int id) {
		return userService.upadateUserById(userDTO, id);
	}

	@MutationMapping
	public String deleteUser(@Argument int id) {
		return userService.deleteUserByid(id);

	}

}
