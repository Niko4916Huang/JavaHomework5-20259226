package service;

import java.util.List;

import model.Factory;

public interface FactoryService {
	
	//create
		void addFactory(Factory factory);
		
		//read
		String AllFactory();
		List<Factory> selectById(int id);
		List<Factory> findAllFactory();
		Factory findByFactoryno(String factoryno);
		boolean isFactorynoBeenUse(String factoryno);
		
		//update
		void updateFactory( Factory factory);
		
		
		//delete
		void deletefactoryById(int id);

}
