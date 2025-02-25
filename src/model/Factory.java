package model;

import java.io.Serializable;

public class Factory   implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer id;
	String factoryno;
	String factoryname;
	String factorycontect;
	String factorytel;
	String factoryadds;
	
	
	public Factory() {
		super();
	}


	public Factory(String factoryno, String factoryname, String factorycontect, String factorytel, String factoryadds) {
		super();
		this.factoryno = factoryno;
		this.factoryname = factoryname;
		this.factorycontect = factorycontect;
		this.factorytel = factorytel;
		this.factoryadds = factoryadds;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFactoryno() {
		return factoryno;
	}


	public void setFactoryno(String factoryno) {
		this.factoryno = factoryno;
	}


	public String getFactoryname() {
		return factoryname;
	}


	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}


	public String getFactorycontect() {
		return factorycontect;
	}


	public void setFactorycontect(String factorycontect) {
		this.factorycontect = factorycontect;
	}


	public String getFactorytel() {
		return factorytel;
	}


	public void setFactorytel(String factorytel) {
		this.factorytel = factorytel;
	}


	public String getFactoryadds() {
		return factoryadds;
	}


	public void setFactoryadds(String factoryadds) {
		this.factoryadds = factoryadds;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

}
