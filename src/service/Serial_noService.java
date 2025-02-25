package service;

import java.util.List;

import model.Serial_no;

public interface Serial_noService {
	
		//create
		void addSerial_no(Serial_no serial_no);
		
		//read
		String AllSerial_no();
		List<Serial_no> selectById(int id);
		List<Serial_no> findAllSerial_no();
		Serial_no findBySerial_Name(String serial_name);
		
		//update
		void updateSerial_no(Serial_no serial_no);
		
		
		//delete
		void deleteSerial_noById(int id);

}
