package com.codingdojo.loginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginRegistration.models.LoginUser;
import com.codingdojo.loginRegistration.models.User;
import com.codingdojo.loginRegistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
        Optional<User> possUser = userRepo.findByEmail(newUser.getEmail());
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Confirm password must match password!");
        }
        if(possUser.isPresent()) {
        	result.rejectValue("email", "Matches", "Email in use!");
        }
		if(result.hasErrors()) {
			return null;
		}
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	public User login(LoginUser newLoginObj, BindingResult result) {
        Optional<User> possUser = userRepo.findByEmail(newLoginObj.getEmail());
    	if(!possUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Invalid Email");
    		return null;
    	}
    	User user = possUser.get();
        if(!BCrypt.checkpw(newLoginObj.getPassword(), user.getPassword())){
        	
        }
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	public User getUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) {
			return null;
		}
		return user.get();
	}
}
