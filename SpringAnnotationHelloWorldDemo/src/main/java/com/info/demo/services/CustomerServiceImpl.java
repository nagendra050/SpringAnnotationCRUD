package com.info.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.demo.dao.CustomerDao;
import com.info.demo.entity.Customer;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired(required=true)
	@Qualifier("dao")
	private CustomerDao dao;

	@Override
	@Transactional
	public Customer addCustomer(String customerName, String country) {
		System.out.println("creation invoked:"+customerName);
		Customer customer =new Customer();
		customer.setCustomerName(customerName);
		customer.setCountry(country);
		customer.setCreatedDate(new Date());
		customer.setUpdateDate(new Date());
		customer=dao.addCustomer(customer);
		return customer;
	}

	@Override
	@Transactional
	public Customer updateCustomer(long customerId, String customerName, String country) {
		System.out.println("Cusomer Service Update invoked:"+customerName);
	      Customer customer = new Customer();
	      customer.setCustomerId(customerId);
	      customer.setCountry(country);
	      customer.setCustomerName(customerName);
	     customer.setUpdateDate(new Date());
	      customer = dao.updateCustomer(customer);
	      return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(long customerId) {
		return dao.getCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return dao.getCustomers();
	}

}
