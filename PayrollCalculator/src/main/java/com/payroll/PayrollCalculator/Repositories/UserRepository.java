package com.payroll.PayrollCalculator.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.payroll.PayrollCalculator.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
	User findById(Integer id);
	
	User findByEmail(String email);
	
	List<User> findAll();
	
}
