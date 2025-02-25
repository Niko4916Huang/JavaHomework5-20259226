package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	// create
	void add(Item item);
	
	// read
	//select * from item
	List <Item> selectAll();
	String orderbyItemno();
	String[][] csvByItemno();
	
	List <Item> selectById(int id);
	List <Item> selectByItemno(String itemno);
	
	// update
	void update(Item item);
	
	// delete
	void delete(int id);

}
