package service.impl;

import java.util.List;

import dao.OrdersDao;
import dao.impl.OrdersDaoImpl;
import model.Orders;
import service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// new add
		Received item = new Received("2025/02/10", "I009", "F008", 50);
		new ReceivedServiceImpl().addItem(item);
	*/
	
	
		//System.out.println(new ReceivedServiceImpl().findAllItem());
		// result:
		// [model.Received@2bbf180e, model.Received@163e4e87, model.Received@56de5251, 
		// model.Received@419c5f1a, model.Received@12b0404f, model.Received@769e7ee8, 
		// model.Received@5276e6b0]
		
		// System.out.println(new ReceivedServiceImpl().AllItem());
		/* result:
		 * 	 	2025/02/12	I003	F003	50
				2025/02/12	I004	F003	50
				2025/02/12	I005	F004	35
				2025/02/11	I009	F008	50
				2025/02/11	I008	F008	50
				2025/02/11	I007	F006	35
				2025/02/10	I009	F008	50

		 */
		
		
		//new ReceivedServiceImpl().findByIndateOrderbyItemno("2025/02/12", "2025/02/12");
	/*
		// result:
			2025/02/12	I003	可樂果原味	F003	20	35	50
			2025/02/12	I004	可樂果酷辣	F003	20	35	50
			2025/02/12	I005	甘草芭樂乾50g	F004	25	40	35
		
	 */
	
		//System.out.println(new ReceivedServiceImpl().selectById(1));
		// result: [model.Received@56de5251]
	
	
		//System.out.println(new ReceivedServiceImpl().selectById(9));
		// result: null

		//new ReceivedServiceImpl().deleteItemById(6);

	}
	
	private static OrdersDaoImpl ordersdaoimpl=new OrdersDaoImpl();

	@Override
	public void addItem(Orders orders) {
		// TODO Auto-generated method stub
		ordersdaoimpl.add(orders);
	}

	@Override
	public String AllItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> selectById(int id) {
		// TODO Auto-generated method stub
		return ordersdaoimpl.selectById(id);
	}

	@Override
	public List<Orders> findAllItem() {
		// TODO Auto-generated method stub
		List<Orders> listItem=ordersdaoimpl.selectAll();
		return listItem;
	}

	@Override
	public List<Orders> findByIndate(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return ordersdaoimpl.selectByIndate(indateFrom, indateTo);
	}

	@Override
	public String findByIndateOrderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return  ordersdaoimpl.orderbyItemno(indateFrom, indateTo);
	}

	@Override
	public String findByIndateOrderbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return  ordersdaoimpl.orderbyCustomerno(indateFrom, indateTo);
	}
	
	@Override
	public String orderbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return  ordersdaoimpl.orderbyItemno(indateFrom, indateTo);
	}

	@Override
	public String orderbyOneCustomerno(String indateFrom, String indateTo, String customerno) {
		// TODO Auto-generated method stub
		return ordersdaoimpl.orderbyOneCustomerno(indateFrom, indateTo, customerno);
	}

	@Override
	public String groupbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return ordersdaoimpl.groupbyItemno(indateFrom, indateTo);
	}

	@Override
	public String groupbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return ordersdaoimpl.groupbyCustomerno(indateFrom, indateTo);
	}

	@Override
	public void updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrdersById(int id) {
		// TODO Auto-generated method stub
		
	}

}
