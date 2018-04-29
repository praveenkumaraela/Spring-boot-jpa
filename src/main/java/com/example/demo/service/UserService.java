package com.example.demo.service;

import com.example.demo.UserRepository;
import com.example.demo.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Value("${welcome.message}")
	private String mymessage;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String getWelcomeMessage() {
		return mymessage;
	}
	
	public List<UserRecord> getAllUsers(){
		List<UserRecord> records = new ArrayList();
		
		userRepository.findAll().forEach(records::add);
		
		return records;
	}
	
	public UserRecord getUser(String id) {
		return userRepository.findOne(id);
	}
	
	public void addUser(UserRecord userRecord) {
		userRepository.save(userRecord);
	}
	
	public void deleteUser(String id) {
		userRepository.delete(id);
	}
}
