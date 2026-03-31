package com.cms.service;

import org.springframework.stereotype.Service;
import com.cms.entity.Customer;
import com.cms.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation 
implements CustomerService{

	CustomerRepository cusRepo;
	
	public CustomerServiceImplementation(CustomerRepository cusRepo) {
		this.cusRepo = cusRepo;
	}

	@Override
	public boolean validate(Customer cus) {
		String dbPass = cusRepo.findById(cus.getId()).get().getPassword();
		return cus.getPassword().equals(dbPass);
	}

}
