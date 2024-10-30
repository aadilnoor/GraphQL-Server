package com.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.dtos.UserDTO;
import com.graphql.entity.User;
import com.graphql.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public User createUserDTO(UserDTO userDTO) {

		User user = new User();
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		return userRepository.save(user);

		/*
		 * User save = userRepository.save(user); UserDTO dto =
		 * mapper.convertValue(save, UserDTO.class);
		 * 
		 * return dto;
		 */
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id :" + id));
	}

	@Override
	public List<User> finAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User upadateUserById(UserDTO userDTO, int id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id :" + id));
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		// User user2 = mapper.convertValue(userDTO, User.class);
		return userRepository.save(user);
	}

	@Override
	public String deleteUserByid(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id :" + id));
		 userRepository.delete(user);
		 return "User deleted successfully...";
	}
}
