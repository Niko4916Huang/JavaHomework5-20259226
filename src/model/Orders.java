package model;

import java.io.Serializable;

public class Orders  implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer id;
	String ordersemployeeno;
	String ordersdate;
	String orderscustomerno;
	Integer ordersserial_number;
	String ordersitemno;
	Integer ordersqty;
	
	public Orders() {
		super();
	}

	public Orders(String ordersemployeeno, String ordersdate, String orderscustomerno, Integer ordersserial_number,
			String ordersitemno, Integer ordersqty) {
		super();
		this.ordersemployeeno = ordersemployeeno;
		this.ordersdate = ordersdate;
		this.orderscustomerno = orderscustomerno;
		this.ordersserial_number = ordersserial_number;
		this.ordersitemno = ordersitemno;
		this.ordersqty = ordersqty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdersemployeeno() {
		return ordersemployeeno;
	}

	public void setOrdersemployeeno(String ordersemployeeno) {
		this.ordersemployeeno = ordersemployeeno;
	}

	public String getOrdersdate() {
		return ordersdate;
	}

	public void setOrdersdate(String ordersdate) {
		this.ordersdate = ordersdate;
	}

	public String getOrderscustomerno() {
		return orderscustomerno;
	}

	public void setOrderscustomerno(String orderscustomerno) {
		this.orderscustomerno = orderscustomerno;
	}

	public Integer getOrdersserial_number() {
		return ordersserial_number;
	}

	public void setOrdersserial_number(Integer ordersserial_number) {
		this.ordersserial_number = ordersserial_number;
	}

	public String getOrdersitemno() {
		return ordersitemno;
	}

	public void setOrdersitemno(String ordersitemno) {
		this.ordersitemno = ordersitemno;
	}

	public Integer getOrdersqty() {
		return ordersqty;
	}

	public void setOrdersqty(Integer ordersqty) {
		this.ordersqty = ordersqty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
