package service.impl;

import java.util.List;

import dao.impl.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// new add
		Customer customer = new Customer("C013", "台南南門店", "06-213-7966", "台南市中西區南門路121號", "備註");
		new CustomerServiceImpl().addCustomer(customer);
	
		*/
	
		//System.out.println(new CustomerServiceImpl().findAllCustomer());
		// result:		[model.Customer@1a04f701, model.Customer@4e91d63f, model.Customer@d4342c2, model.Customer@2bbf180e, 
		//				model.Customer@163e4e87, model.Customer@56de5251, model.Customer@419c5f1a, model.Customer@12b0404f, 
		//				model.Customer@769e7ee8, model.Customer@5276e6b0, model.Customer@71b1176b, model.Customer@6193932a, 
		//				model.Customer@647fd8ce]

	
		
		 //System.out.println(new CustomerServiceImpl().AllCustomer());
		/* result:
		 * 	 客戶編號:C001	客戶名稱:台北中山北店		電   話:02-2536-1350		地   址:台北市中山區中山北路二段33號2樓		備   註:備註
			 客戶編號:C002	客戶名稱:台北南京東店		電   話:02-8770-7989		地   址:台北市松山區南京東路四段169號2樓		備   註:備註
			 客戶編號:C003	客戶名稱:台北光復南店		電   話:02-2325-3478		地   址:台北市大安區光復南路612號2樓			備   註:備註
			 客戶編號:C004	客戶名稱:台北和平東店		電   話:02-2393-4689		地   址:台北市大安和平東路一段177號			備   註:備註
			 客戶編號:C005	客戶名稱:板橋文化店			電   話:02-2272-2016		地   址:新北市板橋區文化路一段71號			備   註:備註
			 客戶編號:C006	客戶名稱:台北永和店			電   話:02-8660-6006		地   址:新北市永和區永和路一段228號			備   註:備註
			 客戶編號:C007	客戶名稱:新竹北大店			電   話:03-525-3236		地   址:新竹市北區北大路346號2樓				備   註:備註
			 客戶編號:C008	客戶名稱:中壢延平店			電   話:03-425-9009		地   址:中壢市延平路552號2樓				備   註:備註
			 客戶編號:C009	客戶名稱:桃園中山店			電   話:03-339-1650		地   址:桃園市中山路546號					備   註:備註
			 客戶編號:C010	客戶名稱:台中五權店			電   話:04-2201-2012		地   址:台中市西區五權路131號				備   註:備註
			 客戶編號:C011	客戶名稱:台中文心店			電   話:04-2313-6430		地   址:台中市西屯區寧夏路233號				備   註:備註
			 客戶編號:C012	客戶名稱:台中台灣大道店		電   話:04-2355-3155		地   址:台中市西屯區台灣大道四段771號2樓		備   註:備註



		 */
	
		//System.out.println(new CustomerServiceImpl().selectById(1));
		// result: model.Item@d4342c2
		
		/*
			// update
				Customer customer= new CustomerServiceImpl().findByCustomerno("C001");
				customer.setCustomernote("送上3樓");
				new CustomerServiceImpl().updateCustomer(customer);
		*/
		
	// delete
	//	new ItemServiceImpl().deleteItemById(6);

	}
	
	private static CustomerDaoImpl customerdaoimpl=new CustomerDaoImpl();
	

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerdaoimpl.add(customer);
	}

	@Override
	public String AllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> listCustomer=customerdaoimpl.selectAll();
		String show="";
		
		for(Customer onecustomer:listCustomer)
		{		
			show=show+" 客戶編號:"+onecustomer.getCustomerno()+
					"\t客戶名稱:"+onecustomer.getCustomername()+
					"\t\t電   話:"+onecustomer.getCustomertel()+
					"\t\t地   址:"+onecustomer.getCustomeradds()+
					"\t\t備   註:"+onecustomer.getCustomernote() + "\n";
		}			
		return show;
	}

	@Override
	public List<Customer> selectById(int id) {
		// TODO Auto-generated method stub
		return customerdaoimpl.selectById(id);
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return  customerdaoimpl.selectAll();
	}

	@Override
	public Customer findByCustomerno(String customerno) {
		// TODO Auto-generated method stub
		Customer onecustomer = null;
		
		List<Customer> listCustomer = customerdaoimpl.selectByCustomerno(customerno);
		if (listCustomer.size() > 0)
		{
			onecustomer = listCustomer.get(0);
		}
		
		return onecustomer;
	}

	@Override
	public boolean isCustomernoBeenUse(String customerno) {
		// TODO Auto-generated method stub
		return  !customerdaoimpl.selectByCustomerno(customerno).isEmpty();
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerdaoimpl.update(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		customerdaoimpl.delete(id);
	}

}
