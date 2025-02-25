package service;

import java.util.List;

import model.Orders;

public interface OrdersService {
	//create
		void addItem(Orders orders);
		
		//read
		String AllItem();
		List<Orders> selectById(int id);
		List<Orders> findAllItem();
		List<Orders> findByIndate(String indateFrom, String indateTo);
		String findByIndateOrderbyItemno(String indateFrom, String indateTo);
		String findByIndateOrderbyCustomerno(String indateFrom, String indateTo);
		String groupbyItemno(String indateFrom, String indateTo);
		String groupbyCustomerno(String indateFrom, String indateTo);
		String orderbyCustomerno(String indateFrom, String indateTo);
		String orderbyOneCustomerno(String indateFrom, String indateTo, String customerno);

		
		//update
		void updateOrders(Orders orders);
		
		
		//delete
		void deleteOrdersById(int id);

}
