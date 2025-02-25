package service;

import java.util.List;

import model.Customer;

public interface CustomerService {
	
	//create
	void addCustomer(Customer customer);
	
	//read
	String AllCustomer();
	List<Customer> selectById(int id);
	List<Customer> findAllCustomer();
	Customer findByCustomerno(String customerno);
	boolean isCustomernoBeenUse(String customerno);
	
	//update
	void updateCustomer(Customer customer);
	
	
	//delete
	void deleteCustomerById(int id);
	 

}
