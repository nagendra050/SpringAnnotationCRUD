package com.info.demo.services;

import java.util.List;

import com.info.demo.entity.Customer;

public interface CustomerService {

	 public Customer addCustomer(String customerName, String country);
	 public Customer updateCustomer(long customerId,String customerName, String country);
	 public Customer getCustomer(long customerId);
	 public List<Customer> getAllCustomers();
}
