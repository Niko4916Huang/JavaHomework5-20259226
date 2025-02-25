package model;

public class Serial_no {
	
	Integer id;
	String serial_name;
	Integer serial_number;
	
	public Serial_no() {
		super();
	}

	public Serial_no(String serial_name, Integer serial_number) {
		super();
		
		this.serial_name = serial_name;
		this.serial_number = serial_number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial_name() {
		return serial_name;
	}

	public void setSerial_name(String serial_name) {
		this.serial_name = serial_name;
	}

	public Integer getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(Integer serial_number) {
		this.serial_number = serial_number;
	}
	
	

}
