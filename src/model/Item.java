package model;

import java.io.Serializable;

public class Item  implements Serializable {
	Integer id;
	String itemno;
	String itemname;
	Integer cost;
	Integer price;
	String factoryno;
	Integer qty;
	
	public Item(String itemno, String itemname, Integer cost, Integer price, String factoryno, Integer qty) {
		super();
		this.itemno = itemno;
		this.itemname = itemname;
		this.cost = cost;
		this.price = price;
		this.factoryno = factoryno;
		this.qty = qty;
	}

	public Item() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getFactoryno() {
		return factoryno;
	}

	public void setFactoryno(String factoryno) {
		this.factoryno = factoryno;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	

}
