package com.info.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.demo.entity.Customer;

@Repository("dao")
@Transactional
public class CustomerDAOImpl implements CustomerDao{

	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(long customerId) {
		
		
	}

	@Override
	public Customer getCustomer(long customerId) {
		 String sql = "select customer from Customer customer where customer.customerId="+customerId;
	      try{
	          return (Customer) entityManager.createQuery(sql).getSingleResult();
	      }catch(Exception e){
	     }
	      return null;
	}

	@Override
	public List<Customer> getCustomers() {
		return entityManager.createQuery("select customer from Customer customer").getResultList();
	}

}
