package dao;

import java.util.List;

import model.Serial_no;

public interface Serial_noDao {
	
	// create
		void add(Serial_no serial_no);
		
		// read
		//select * from item
		List <Serial_no> selectAll();
		
		List <Serial_no> selectById(int id);
		List <Serial_no> selectBySerial_name(String serial_name);
		
		// update
		void update(Serial_no serial_no);
		
		// delete
		void delete(int id);

}
