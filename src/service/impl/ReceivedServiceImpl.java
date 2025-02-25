package service.impl;

import java.util.List;

import dao.impl.ItemDaoImpl;
import dao.impl.ReceivedDaoImpl;
import model.Received;
import service.ReceivedService;

public class ReceivedServiceImpl implements ReceivedService {

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
	
	private static ReceivedDaoImpl receiveddaoimpl=new ReceivedDaoImpl();
	private static ItemDaoImpl itemdaoimpl=new ItemDaoImpl();

	@Override
	public void addItem(Received received) {
		// TODO Auto-generated method stub
		receiveddaoimpl.add(received);
	}

	@Override
	public String AllItem() {
		// TODO Auto-generated method stub
		
		List<Received> listItem=receiveddaoimpl.selectAll();
		String show="";
		
		for(Received oneitem:listItem)
		{		
			show=show+oneitem.getIndate()+
					"\t"+oneitem.getItemno()+
				/*
					"\t進  價:"+oneitem.getCost()+
					"\t售  價:"+oneitem.getPrice()+
				*/
					"\t"+oneitem.getFactoryno()+
					"\t"+oneitem.getInqty()+"\n";
		}			
		return show;
		
	}

	@Override
	public List<Received> selectById(int id) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.selectById(id);
	}

	@Override
	public List<Received> findAllItem() {
		// TODO Auto-generated method stub
		return receiveddaoimpl.selectAll();
	}

	@Override
	public List<Received> findByIndate(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.selectByIndate(indateFrom, indateTo);
	}

	@Override
	public String findByIndateOrderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.orderbyItemno(indateFrom, indateTo);
	}

	@Override
	public String findByIndateOrderbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.orderbyFactoryno(indateFrom, indateTo);
	}

	@Override
	public boolean isItemnoExist(String itemno) {
		// TODO Auto-generated method stub
		return !itemdaoimpl.selectByItemno(itemno).isEmpty();
	}

	@Override
	public void updateItem(Received received) {
		// TODO Auto-generated method stub
		receiveddaoimpl.update(received);
	}

	@Override
	public void deleteItemById(int id) {
		// TODO Auto-generated method stub
		receiveddaoimpl.delete(id);
	}

	@Override
	public String orderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.orderbyItemno(indateFrom, indateTo);
	}

	@Override
	public String orderbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.orderbyFactoryno(indateFrom, indateTo);
	}

	@Override
	public String groupbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.groupbyItemno(indateFrom, indateTo);
	}

	@Override
	public String groupbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.groupbyFactoryno(indateFrom, indateTo);
	}

	@Override
	public String[][] csvOrderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.csvOrderbyItemno(indateFrom, indateTo);
	}

	@Override
	public String[][] csvOrderbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.csvOrderbyFactoryno(indateFrom, indateTo);
	}

	@Override
	public String[][] csvGroupbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.csvGroupbyItemno(indateFrom, indateTo);
	}

	@Override
	public String[][] csvGroupbyFactoryno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return receiveddaoimpl.csvGroupbyFactoryno(indateFrom, indateTo);
	}


}
