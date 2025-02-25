package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import model.Customer;
import util.DbConnection;

public class CustomerDaoImpl implements CustomerDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  // add 
			Customer customer = new Customer("C001", "台北中山北店", "02-2536-1350", "台北市中山區中山北路二段33號2樓", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C002", "台北南京東店", "02-8770-7989", "台北市松山區南京東路四段169號2樓", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C003", "台北光復南店", "02-2325-3478", "台北市大安區光復南路612號2樓", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C004", "台北和平東店", "02-2393-4689", "台北市大安和平東路一段177號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C005", "板橋文化店", "02-2272-2016", "新北市板橋區文化路一段71號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C006", "台北永和店", "02-8660-6006", "新北市永和區永和路一段228號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C007", "新竹北大店", "03-525-3236", "新竹市北區北大路346號2樓", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C008", "中壢延平店", "03-425-9009", "中壢市延平路552號2樓", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C009", "桃園中山店", "03-339-1650", "桃園市中山路546號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C010", "台中五權店", "04-2201-2012", "台中市西區五權路131號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C011", "台中文心店", "04-2313-6430", "台中市西屯區寧夏路233號", "備註");
			new CustomerDaoImpl().add(customer);
			customer = new Customer("C012", "台中台灣大道店", "04-2355-3155", "台中市西屯區台灣大道四段771號2樓", "備註");
			new CustomerDaoImpl().add(customer);
		*/
			
		/*		
		//list all customer	
			List<Customer> listCustomer=new CustomerDaoImpl().selectAll();
			for(Customer oneCustomer:listCustomer)
			{
				System.out.println(oneCustomer.getId()+"\t"+oneCustomer.getCustomerno()+
									"\t"+oneCustomer.getCustomername()+"\t"+oneCustomer.getCustomertel()+
									"\t"+oneCustomer.getCustomeradds()+"\t"+oneCustomer.getCustomernote()
									);
			}
			*/
		
			// result
			/*
			 * 	1	C001	Peter	台北市中山區中山北路二段33號2樓			02-2536-1350	貨物送3樓
				2	C002	台北南京東店	台北市松山區南京東路四段169號2樓		02-8770-7989	備註
				3	C003	台北光復南店	台北市大安區光復南路612號2樓			02-2325-3478	備註
				4	C004	台北和平東店	台北市大安和平東路一段177號			02-2393-4689	備註
				5	C005	板橋文化店	新北市板橋區文化路一段71號			02-2272-2016	備註
				6	C006	台北永和店	新北市永和區永和路一段228號			02-8660-6006	備註
				7	C007	新竹北大店	新竹市北區北大路346號2樓			03-525-3236		備註
				8	C008	中壢延平店	中壢市延平路552號2樓				03-425-9009		備註
				9	C009	桃園中山店	桃園市中山路546號					03-339-1650		備註
				10	C010	台中五權店	台中市西區五權路131號				04-2201-2012	備註
				11	C011	台中文心店	台中市西屯區寧夏路233號				04-2313-6430	備註
				12	C012	台中台灣大道店	台中市西屯區台灣大道四段771號2樓		04-2355-3155	備註

			 * 
			 */
		
		/*
			// find customer by id
					System.out.println(new CustomerDaoImpl().selectById(1));
			// result:  [model.Customer@1a04f701]
		 */

		/*
			// find customer by customerno		
				System.out.println(new CustomerDaoImpl().selectByCustomerno("C002"));
				// result: [model.Customer@1a04f701]
		*/
			
		/*
			// update customer
					List<Customer> listCustomer=new CustomerDaoImpl().selectById(1);
					Customer oneCustomer=listCustomer.get(0);
					oneCustomer.setCustomername("台北中山北店");
					
					new CustomerDaoImpl().update(oneCustomer);
		*/

	}
	// connect mysql database
			private static Connection conn= DbConnection.getDb();
			
			
	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		 String sql="insert into customer(customerno, customername, customertel, customeradds, customernote) "
					+ "values(?,?,?,?,?)";
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,customer.getCustomerno());
				preparedstatement.setString(2,customer.getCustomername());
				preparedstatement.setString(3,customer.getCustomertel());
				preparedstatement.setString(4,customer.getCustomeradds());
				preparedstatement.setString(5,customer.getCustomernote());				

				preparedstatement.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	@Override
	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		 String SQL="select * from customer";
			List<Customer> allCustomer = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(SQL);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{
					Customer oneCustomer=new Customer();
					oneCustomer.setId(resultset.getInt("id"));
					oneCustomer.setCustomerno(resultset.getString("customerno"));
					oneCustomer.setCustomername(resultset.getString("customername"));
					oneCustomer.setCustomertel(resultset.getString("customertel"));
					oneCustomer.setCustomeradds(resultset.getString("customeradds"));
					oneCustomer.setCustomernote(resultset.getString("customernote"));
							
					allCustomer.add(oneCustomer);
					
				}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return allCustomer;
		
	}
	
	
	@Override
	public List<Customer> selectById(int id) {
		// TODO Auto-generated method stub
		 String sql = "select * from customer where id = ?";
			List<Customer> oneCustomer = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setInt(1,id);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{

					Customer customer=new Customer();
					customer.setId(resultset.getInt("id"));
					customer.setCustomerno(resultset.getString("customerno"));
					customer.setCustomername(resultset.getString("customername"));
					customer.setCustomertel(resultset.getString("customertel"));
					customer.setCustomeradds(resultset.getString("customeradds"));
					customer.setCustomernote(resultset.getString("customernote"));

					oneCustomer.add(customer);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oneCustomer;
		 
	}
	
	
	@Override
	public List<Customer> selectByCustomerno(String customerno) {
		// TODO Auto-generated method stub
		 String sql = "select * from customer where customerno = ?";
			List<Customer> oneCustomer = new ArrayList();
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,customerno);
				ResultSet resultset=preparedstatement.executeQuery();
				
				while(resultset.next())
				{

					Customer customer=new Customer();
					customer.setId(resultset.getInt("id"));
					customer.setCustomerno(resultset.getString("customerno"));
					customer.setCustomername(resultset.getString("customername"));
					customer.setCustomertel(resultset.getString("customertel"));
					customer.setCustomeradds(resultset.getString("customeradds"));
					customer.setCustomernote(resultset.getString("customernote"));
					
					oneCustomer.add(customer);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oneCustomer;

	}
	
	
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		 String sql="update customer set customerno=?,customername=?, customertel=?, customeradds=?, customernote=? where id=?";
			
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setString(1,customer.getCustomerno());
				preparedstatement.setString(2,customer.getCustomername());
				preparedstatement.setString(3,customer.getCustomertel());
				preparedstatement.setString(4,customer.getCustomeradds());	
				preparedstatement.setString(5,customer.getCustomernote());
				preparedstatement.setInt(6,customer.getId());
				
				preparedstatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 String sql="delete from customer where id=?";
			try {
				PreparedStatement preparedstatement=conn.prepareStatement(sql);
				preparedstatement.setInt(1,id);
				
				preparedstatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}	
	

}
