package dao;


import java.util.List;

import model.Factory;

public interface FactoryDao {
	// create
	void add(Factory factory);
	
	// read
	//select * from Factory
	List <Factory> selectAll();
	
	List <Factory> selectById(int id);
	List <Factory> selectByfactoryno(String factorynono);
	
	// update
	void update(Factory factory);
	
	// delete
	void delete(int id);

}
