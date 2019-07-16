package com.payroll.PayrollCalculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.PayrollCalculator.Repositories.UserRepository;
import com.payroll.PayrollCalculator.entities.PayrollResponse;
import com.payroll.PayrollCalculator.entities.User;

@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepository;

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value="/login")
	public PayrollResponse login(@RequestBody User user) {
		
		String email = user.getEmail();
		String password  = user.getPassword();		
		User dbUser  = userRepository.findByEmail(email);
		
		PayrollResponse payrollResponse = new PayrollResponse();
		
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword())) {		
			payrollResponse.setStatus("success");
			payrollResponse.setStatusCode(200);
			payrollResponse.setMessage("user retrived succesfully");
			payrollResponse.setPayload(dbUser);			
			return payrollResponse;
		}
		
		payrollResponse.setStatus("fail");
		payrollResponse.setStatusCode(404);
		payrollResponse.setMessage("user not found");
		payrollResponse.setPayload(null);	

		return payrollResponse;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/adduser")
	public PayrollResponse addUser(@RequestBody User user) {
		PayrollResponse payrollResponse = new PayrollResponse();
		
		User dbUser = userRepository.findByEmail(user.getEmail());
		if(dbUser==null) {
			User savedUser = userRepository.save(user);
			payrollResponse.setStatus("success");
			payrollResponse.setStatusCode(200);
			payrollResponse.setMessage("user addedd successfully");
			payrollResponse.setPayload(savedUser);
			return payrollResponse;	
		}
		
		payrollResponse.setStatus("fail");
		payrollResponse.setStatusCode(402);
		payrollResponse.setMessage("user already present");
		payrollResponse.setPayload(null);
		
		return payrollResponse;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/getAllUsers")
	public List<User> getAllUsers(){		
		return userRepository.findAll();		
	}
	
	
	
}