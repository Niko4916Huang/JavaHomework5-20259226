package model;

import java.io.Serializable;

public class Received  implements Serializable {
	Integer id;
	String indate;
	String itemno;
	String factoryno;
	Integer inqty;
	
	public Received(String indate, String itemno, String factoryno, Integer inqty) {
		super();
		this.indate = indate;
		this.itemno = itemno;
		this.factoryno = factoryno;
		this.inqty = inqty;
	}

	public Received() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getFactoryno() {
		return factoryno;
	}

	public void setFactoryno(String factoryno) {
		this.factoryno = factoryno;
	}

	public Integer getInqty() {
		return inqty;
	}

	public void setInqty(Integer inqty) {
		this.inqty = inqty;
	}
	


}
