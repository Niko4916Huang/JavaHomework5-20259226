package service.impl;

import java.util.List;

import dao.impl.ItemDaoImpl;
import model.Item;
import service.ItemService;

public class ItemServiceImpl implements ItemService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		// new add
		Item item = new Item("I002", "福義軒-檸檬薄片", 12, 20, "F005", 14);
		new ItemServiceImpl().addItem(item);
	
		*/
	
		//System.out.println(new ItemServiceImpl().findAllItem());
		// result:
	
		
		 //System.out.println(new ItemServiceImpl().AllItem());
		/* result:
		 * 	 貨品編號:I001	貨品名稱:奶油椰子餅			進  價:12	售  價:20	供應廠商:F001		現有數量:20
 			 貨品編號:I002	貨品名稱:福義軒-檸檬薄片	進  價:12	售  價:20	供應廠商:F005		現有數量:14

		 */
	
		//System.out.println(new ItemServiceImpl().selectById(1));
		// result: model.Item@d4342c2
	
	/*
		System.out.println(new ItemServiceImpl().selectById(9));
		// result: null
	 * 
	 */
	//	new ItemServiceImpl().deleteItemById(6);

	}
	
	private static ItemDaoImpl itemdaoimpl=new ItemDaoImpl();

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemdaoimpl.add(item);
	}

	@Override
	public String AllItem() {
		// TODO Auto-generated method stub
		List<Item> listItem=itemdaoimpl.selectAll();
		String show="";
		
		for(Item oneitem:listItem)
		{		
			show=show+" 貨品編號:"+oneitem.getItemno()+
					"\t貨品名稱:"+oneitem.getItemname()+
					"\t進  價:"+oneitem.getCost()+
					"\t售  價:"+oneitem.getPrice()+
					"\t供應廠商:"+oneitem.getFactoryno()+
					"\t現有數量:"+oneitem.getQty()+"\n";
		}			
		return show;
	}

	@Override
	public List<Item> findAllItem() {
		// TODO Auto-generated method stub
		return itemdaoimpl.selectAll();
	}
	
	@Override
	public List<Item> selectById(int id) {
		// TODO Auto-generated method stub
		return itemdaoimpl.selectById(id);
	}

	@Override
	public Item findByItemno(String itemno) {
		// TODO Auto-generated method stub
		Item item = null;
		
		List<Item> listItem = itemdaoimpl.selectByItemno(itemno);
		if (listItem.size() > 0)
		{
			item = listItem.get(0);
		}
		
		return item;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub			
		itemdaoimpl.update(item);
	}

	@Override
	public void deleteItemById(int id) {
		// TODO Auto-generated method stub
		itemdaoimpl.delete(id);
	}

	@Override
	public boolean isItemnoBeenUse(String itemno) {
		// TODO Auto-generated method stub
		return !itemdaoimpl.selectByItemno(itemno).isEmpty();
	}

	@Override
	public String orderbyItemno() {
		// TODO Auto-generated method stub
		return itemdaoimpl.orderbyItemno();
	}

	@Override
	public String[][] csvByItemno() {
		// TODO Auto-generated method stub
		return itemdaoimpl.csvByItemno();
	}

}
