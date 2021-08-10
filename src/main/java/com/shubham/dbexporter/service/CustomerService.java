package com.shubham.dbexporter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.dbexporter.model.Customer;
import com.shubham.dbexporter.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> listAll(){
		//Business logic should be here, not in controller
		return repo.findAll();
	}
	
}
