package dao;

import java.util.List;

import model.Orders;

public interface OrdersDao {
	// create
	void add(Orders orders);
	
	// read
	//select * from received
	List <Orders> selectAll();
	
	List <Orders> selectById(int id);
	List <Orders> selectByIndate(String indateFrom, String indateTo);
	String orderbyItemno(String indateFrom, String indateTo);
	String orderbyCustomerno(String indateFrom, String indateTo);
	String orderbyOneCustomerno(String indateFrom, String indateTo, String customerno);
	String groupbyItemno(String indateFrom, String indateTo);
	String groupbyCustomerno(String indateFrom, String indateTo);
	
	String[][] csvbyItemnono(String indateFrom, String indateTo);
	String[][] csvbyCustomerno(String indateFrom, String indateTo);
	
	
	// update
	void update(Orders orders);
	
	// delete
	void delete(int id);

}
