package service.impl;

import java.util.List;

import dao.impl.Serial_noDaoImpl;
import model.Customer;
import model.Serial_no;
import service.Serial_noService;

public class Serial_noServiceImpl implements Serial_noService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// new add
		Serial_no serialno = new Serial_no("C013", 1);
		new Serial_noServiceImpl().addSerial_no(serialno);
	
		*/
	
		//System.out.println(new Serial_noServiceImpl().findAllSerial_no());
		// result:	
		// [model.Serial_no@1a04f701, model.Serial_no@4e91d63f, model.Serial_no@d4342c2, 
		// model.Serial_no@2bbf180e, model.Serial_no@163e4e87, model.Serial_no@56de5251]


	
		
		 //System.out.println(new Serial_noServiceImpl().AllSerial_no());
		/* result:
		 *  	序號名稱:orders	目前編號:2
			 序號名稱:customer	目前編號:13
			 序號名稱:employee	目前編號:10
			 序號名稱:factory	目前編號:13
			 序號名稱:item	目前編號:9
			 序號名稱:C013	目前編號:1


		 */
	
		//System.out.println(new Serial_noServiceImpl().selectById(6));
		// result: [model.Serial_no@d4342c2]
		
		/*
			// update
			Serial_no serial_no= new Serial_noServiceImpl().findBySerial_Name("C013");
			serial_no.setSerial_number(10);
			new Serial_noServiceImpl().updateSerial_no(serial_no);
		*/
		
	// delete
	//	new Serial_noServiceImpl().deleteSerial_noById(6);
	}
	
	private static Serial_noDaoImpl serial_nodaoimpl=new Serial_noDaoImpl();

	@Override
	public void addSerial_no(Serial_no serial_no) {
		// TODO Auto-generated method stub
		serial_nodaoimpl.add(serial_no);
	}

	@Override
	public String AllSerial_no() {
		// TODO Auto-generated method stub
		List<Serial_no> listSerial_no=serial_nodaoimpl.selectAll();
		String show="";
		
		for(Serial_no oneserial_no:listSerial_no)
		{		
			show=show+" 序號名稱:"+oneserial_no.getSerial_name()+
					"\t目前編號:"+oneserial_no.getSerial_number() + "\n";
		}			
		return show;
	}

	@Override
	public List<Serial_no> selectById(int id) {
		// TODO Auto-generated method stub
		return serial_nodaoimpl.selectById(id);
	}

	@Override
	public List<Serial_no> findAllSerial_no() {
		// TODO Auto-generated method stub
		return  serial_nodaoimpl.selectAll();
	}

	@Override
	public Serial_no findBySerial_Name(String serial_name) {
		// TODO Auto-generated method stub
		Serial_no oneSerial_no = null;
		
		List<Serial_no> listSerial_no = serial_nodaoimpl.selectBySerial_name(serial_name);
		if (listSerial_no.size() > 0)
		{
			oneSerial_no = listSerial_no.get(0);
		}
		
		return oneSerial_no;
	}

	@Override
	public void updateSerial_no(Serial_no serial_no) {
		// TODO Auto-generated method stub
		serial_nodaoimpl.update(serial_no);
	}

	@Override
	public void deleteSerial_noById(int id) {
		// TODO Auto-generated method stub
		serial_nodaoimpl.delete(id);
	}

}
