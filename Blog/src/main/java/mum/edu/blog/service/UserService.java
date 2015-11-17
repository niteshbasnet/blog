package mum.edu.blog.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.User;
import mum.edu.blog.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final static Logger LOGGER = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user)
	{
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		LOGGER.info("User Saved with username= " + user.getUsername());
		return userRepository.save(user);
	}
	
	public User findByUsername(String username)
	{
		System.out.println(username);
		User newuser = userRepository.findFirstUserByUsername(username);
		System.out.println(newuser);
		return newuser;
	}
	
	public User findById(long id)
	{
		return userRepository.findUserById(id);
	}
	
}
