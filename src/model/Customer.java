package model;

import java.io.Serializable;

public class Customer   implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer id;
	String customerno;
	String customername;
	String customertel;
	String customeradds;
	String customernote;
	
	public Customer() {
		super();
	}

	public Customer(String customerno, String customername, String customertel, String customeradds,
			String customernote) {
		super();
		this.customerno = customerno;
		this.customername = customername;
		this.customertel = customertel;
		this.customeradds = customeradds;
		this.customernote = customernote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerno() {
		return customerno;
	}

	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomertel() {
		return customertel;
	}

	public void setCustomertel(String customertel) {
		this.customertel = customertel;
	}

	public String getCustomeradds() {
		return customeradds;
	}

	public void setCustomeradds(String customeradds) {
		this.customeradds = customeradds;
	}

	public String getCustomernote() {
		return customernote;
	}

	public void setCustomernote(String customernote) {
		this.customernote = customernote;
	}
	
	
	

}
