package service;

import java.util.List;

import model.Item;

public interface ItemService {
	
	//create
	void addItem(Item item);
	
	//read
	String AllItem();
	List<Item> selectById(int id);
	List<Item> findAllItem();
	Item findByItemno(String itemno);
	boolean isItemnoBeenUse(String itemno);
	String orderbyItemno();
	String[][] csvByItemno();
	
	//update
	void updateItem(Item item);
	
	
	//delete
	void deleteItemById(int id);

}
