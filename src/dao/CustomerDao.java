package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	// create
	void add(Customer customer);
	
	// read
	//select * from item
	List <Customer> selectAll();
	
	List <Customer> selectById(int id);
	List <Customer> selectByCustomerno(String customerno);
	
	// update
	void update(Customer customer);
	
	// delete
	void delete(int id);


}
