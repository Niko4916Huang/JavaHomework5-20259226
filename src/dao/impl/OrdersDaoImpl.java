package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrdersDao;
import model.Orders;
import util.DbConnection;

public class OrdersDaoImpl implements OrdersDao {

	String Sline = "=============================================================================================\n";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  // add 
			Orders orders = new Orders( "A009", "2025/02/11", "C003", 1,  "I008", 50);
			new OrdersDaoImpl().add(orders);
			orders = new Orders( "A009", "2025/02/11", "C003", 1,  "I006", 24);
			new OrdersDaoImpl().add(orders);
			orders = new Orders( "A009", "2025/02/11", "C003", 1,  "I004", 12);
			new OrdersDaoImpl().add(orders);
			orders = new Orders( "A009", "2025/02/11", "C003", 1,  "I009", 48);
			new OrdersDaoImpl().add(orders);
			orders = new Orders( "A009", "2025/02/11", "C003", 1,  "I003", 20);
			new OrdersDaoImpl().add(orders);
			
		*/
		
		/*
		//list all item	
			List<Orders> listorders=new OrdersDaoImpl().selectAll();
			for(Orders oneorders:listorders)
			{
				System.out.println(oneorders.getId()+"\t"+oneorders.getOrdersemployeeno()+"\t"+oneorders.getOrdersdate()+"\t"+oneorders.getOrderscustomerno()+
							"\t"+oneorders.getOrdersserial_number()+"\t"+oneorders.getOrdersitemno()+"\t"+oneorders.getOrdersqty());
			}
			*/
		
			// result
			/*
			 * 	1	A009	2025/02/11	C003	1	I008	50
				2	A009	2025/02/11	C003	1	I006	24
				3	A009	2025/02/11	C003	1	I004	12
				4	A009	2025/02/11	C003	1	I009	48
				5	A009	2025/02/11	C003	1	I003	20
			 * 
			 */
		
			// find orders by id
			//		System.out.println(new OrdersDaoImpl().selectById(1));
			// result:  [model.Orders@1a04f701]
		 
		
		System.out.println(new OrdersDaoImpl().orderbyItemno("2025/02/11", "2025/02/12"));
		//new OrdersDaoImpl().orderbyItemno("2025/02/12", "2025/02/12");
		/*
		 * result:
		 * 	I003	可樂果原味	2025/02/11	C003	35	20
			I004	可樂果酷辣	2025/02/11	C003	35	12
			I006	無籽冰心話梅	2025/02/11	C003	40	24
			I008	旺旺仙貝 		2025/02/11	C003	65	50
			I009	旺仔雪餅		2025/02/11	C003	69	48
			=================================================================================
			 總計金額： 8642
		 * 
		 * 
		 */
		
		//System.out.println(new OrdersDaoImpl().orderbyCustomerno("2025/02/11", "2025/02/12"));
		//new OrdersDaoImpl().orderbyCustomerno("2025/02/11", "2025/02/12");
		/*
		 * result:
		 * 	C003	台北光復南店	I002	福義軒檸檬薄片	2025/02/11	20	48	960
			C003	台北光復南店	I003	可樂果原味	2025/02/11	35	20	700
			C003	台北光復南店	I004	可樂果酷辣	2025/02/11	35	12	420
			C003	台北光復南店	I006	無籽冰心話梅	2025/02/11	40	24	960
			C003	台北光復南店	I008	旺旺仙貝 		2025/02/11	65	50	3250
			=================================================================================
			 總計金額： 6290
		 */

			
		/*
			// update Orders:  4 	A009	2025/02/11	C003	1	I009	48
					List<Orders> listorders=new OrdersDaoImpl().selectById(4);
					Orders oneorders=listorders.get(0);
					oneorders.setOrdersitemno("I002");

					
					new OrdersDaoImpl().update(oneorders);
		*/
	}
	
	// connect mysql database
		private static Connection conn= DbConnection.getDb();

	@Override
	public void add(Orders orders) {
		// TODO Auto-generated method stub
		String sql="insert into orders(ordersemployeeno, ordersdate, orderscustomerno, ordersserial_number, ordersitemno, ordersqty) "
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,orders.getOrdersemployeeno());
			preparedstatement.setString(2,orders.getOrdersdate());	
			preparedstatement.setString(3,orders.getOrderscustomerno());
			preparedstatement.setInt(4,orders.getOrdersserial_number());
			preparedstatement.setString(5,orders.getOrdersitemno());
			preparedstatement.setInt(6,orders.getOrdersqty());

			preparedstatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> selectAll() {
		// TODO Auto-generated method stub
		String SQL="select * from orders";
		List<Orders> allorders = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				Orders oneorders=new Orders();
				oneorders.setId(resultset.getInt("id"));
				oneorders.setOrdersemployeeno(resultset.getString("ordersemployeeno"));
				oneorders.setOrdersdate(resultset.getString("ordersdate"));
				oneorders.setOrderscustomerno(resultset.getString("orderscustomerno"));
				oneorders.setOrdersserial_number(resultset.getInt("ordersserial_number"));
				oneorders.setOrdersitemno(resultset.getString("ordersitemno"));
				oneorders.setOrdersqty(resultset.getInt("ordersqty"));
				
				
				allorders.add(oneorders);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allorders;
	}

	@Override
	public List<Orders> selectById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from orders where id = ?";
		List<Orders> oneorders = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Orders orders=new Orders();
				orders.setId(resultset.getInt("id"));
				orders.setOrdersemployeeno(resultset.getString("ordersemployeeno"));
				orders.setOrdersdate(resultset.getString("ordersdate"));
				orders.setOrderscustomerno(resultset.getString("orderscustomerno"));
				orders.setOrdersserial_number(resultset.getInt("ordersserial_number"));
				orders.setOrdersitemno(resultset.getString("ordersitemno"));
				orders.setOrdersqty(resultset.getInt("ordersqty"));
				
				oneorders.add(orders);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneorders;
	}

	@Override
	public List<Orders> selectByIndate(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String SQL="select * from orders where ordersdate >= ? and ordersdate <= ? ";
		List<Orders> allorders = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				
				Orders orders=new Orders();
				orders.setId(resultset.getInt("id"));
				orders.setOrdersemployeeno(resultset.getString("ordersemployeeno"));
				orders.setOrdersdate(resultset.getString("ordersdate"));
				orders.setOrderscustomerno(resultset.getString("orderscustomerno"));
				orders.setOrdersserial_number(resultset.getInt("ordersserial_number"));
				orders.setOrdersitemno(resultset.getString("ordersitemno"));
				orders.setOrdersqty(resultset.getInt("ordersqty"));
				
				allorders.add(orders);
				
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allorders;
	}

	@Override
	public String orderbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";

		String 	SQL="select ";
		SQL += "orders.ordersitemno,";
		SQL += "item.itemname, ";
		SQL += "orders.ordersdate, ";				
		SQL += "orders.orderscustomerno, ";
		SQL += "customer.customername, ";
		SQL += "item.price, ";
		SQL += "orders.ordersqty ";
		
		SQL += "FROM orders ";
		SQL += "INNER JOIN customer ON  customer.customerno =orders.orderscustomerno ";
		SQL += "INNER JOIN item  ON  item.itemno =orders.ordersitemno ";		
		
		SQL += "WHERE ordersdate >= ? and ordersdate <= ? ";
		SQL += "ORDER BY ordersitemno, ordersdate ";
		
		
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			int totalsum = 0;
			while(resultset.next())
			{
				sQuery += resultset.getString("ordersitemno") + "\t";			
				sQuery += resultset.getString("itemname") + "\t";	
				sQuery += resultset.getString("ordersdate") + "\t";	
				sQuery += resultset.getString("orderscustomerno") + "\t";	
				
				sQuery += resultset.getString("customername") + "\t";	
				
				sQuery += Integer.toString(resultset.getInt("price")) + "\t";
				sQuery += Integer.toString(resultset.getInt("ordersqty")) + "\t";
				sum = resultset.getInt("price") * resultset.getInt("ordersqty");
				totalsum += sum;
				sQuery += Integer.toString(sum) + "\r\n";
			}	
			if (totalsum > 0)
			{
				sQuery += Sline;
				sQuery += " 總計金額： "+Integer.toString(totalsum)+ "\r\n";				
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String orderbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";
		
		String 	SQL="select ";
		
		SQL += "orders.orderscustomerno, ";
		SQL += "customer.customername, ";		
		SQL += "orders.ordersitemno, ";
		SQL += "item.itemname, ";
		SQL += "orders.ordersdate,";
		SQL += "item.price, ";
		SQL += "orders.ordersqty ";
		
		SQL += "FROM orders ";
		SQL += "INNER JOIN customer ON  customer.customerno =orders.orderscustomerno ";
		SQL += "INNER JOIN item  ON  item.itemno =orders.ordersitemno ";		
		
		SQL += "WHERE ordersdate >= ? and ordersdate <= ? ";
		SQL += "ORDER BY orderscustomerno, ordersitemno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			int totalsum = 0;
			while(resultset.next())
			{
				sQuery += resultset.getString("orderscustomerno") + "\t";			
				sQuery += resultset.getString("customername") + "\t";	
				sQuery += resultset.getString("ordersitemno") + "\t";	
				sQuery += resultset.getString("itemname") + "\t";	
				sQuery += resultset.getString("ordersdate") + "\t";	
				sQuery += Integer.toString(resultset.getInt("price")) + "\t";
				sQuery += Integer.toString(resultset.getInt("ordersqty")) + "\t";
				sum = resultset.getInt("price") * resultset.getInt("ordersqty");
				sQuery += Integer.toString(sum) + "\r\n";
				totalsum += sum;
			}	
			if (totalsum > 0)
			{
				sQuery +=  Sline;
				sQuery += " 總計金額： "+Integer.toString(totalsum)+ "\r\n";				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String orderbyOneCustomerno(String indateFrom, String indateTo, String customerno) {
		// TODO Auto-generated method stub
		String sQuery = "";
		
		String 	SQL="select ";
		
		SQL += "orders.orderscustomerno, ";
		SQL += "orders.ordersdate,";		
		SQL += "orders.ordersitemno, ";
		SQL += "item.itemname, ";
		SQL += "item.factoryno, ";
		SQL += "item.price, ";
		SQL += "orders.ordersqty ";
		
		SQL += "FROM orders ";
		SQL += "INNER JOIN item  ON  item.itemno =orders.ordersitemno ";		
		
		SQL += " WHERE ordersdate >= ? and ordersdate <= ? and orderscustomerno = ? ";
		SQL += " ORDER BY orderscustomerno, ordersitemno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			preparedstatement.setString(3,customerno);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			int totalsum = 0;
			while(resultset.next())
			{	
				// "銷貨日期\t商品編號\t商品名稱\t廠商編號\t售 價\t訂購量\t \n";
				sQuery += resultset.getString("ordersdate") + "\t";	
				sQuery += resultset.getString("ordersitemno") + "\t";	
				sQuery += resultset.getString("itemname") + "\t";	
				sQuery += resultset.getString("factoryno") + "\t";
				sQuery += Integer.toString(resultset.getInt("price")) + "\t";
				sQuery += Integer.toString(resultset.getInt("ordersqty")) + "\t";
				sum = resultset.getInt("price") * resultset.getInt("ordersqty");
				sQuery += Integer.toString(sum) + "\r\n";
				totalsum += sum;
			}	
			if (totalsum > 0)
			{
				sQuery +=  Sline;
				sQuery += " 總計金額： "+Integer.toString(totalsum)+ "\r\n";				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String groupbyItemno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";
		
		String 	SQL="select ";
		SQL += "orders.ordersitemno,";
		SQL += "item.itemname, ";
		SQL += "item.factoryno, ";
		SQL += "orders.ordersdate, ";				
		SQL += "orders.orderscustomerno, ";
		SQL += "customer.customername, ";
		SQL += "item.price, ";
		SQL += "orders.ordersqty ";
		
		SQL += "FROM orders ";
		SQL += "INNER JOIN customer ON  customer.customerno =orders.orderscustomerno ";
		SQL += "INNER JOIN item  ON  item.itemno =orders.ordersitemno ";		
		
		SQL += "WHERE ordersdate >= ? and ordersdate <= ? ";
		SQL += "ORDER BY ordersitemno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			String currentItemno = "";
			int currentqty = 0;
			int currentprice = 0;
			int totalprice = 0;
			while(resultset.next())
			{
				// same item no
				if (currentItemno.length() > 0)
				{
					if (currentItemno.equals(resultset.getString("ordersitemno")))
					{
						// add qty
						currentqty += resultset.getInt("ordersqty");
					}
					else
					{
						// sum and amount
						sum = currentprice * currentqty;	
						sQuery += Integer.toString(currentqty) + "\t";
						sQuery += Integer.toString(sum) + "\r\n";
						totalprice += sum;
						
						// keep data
						currentItemno = resultset.getString("ordersitemno");
						currentqty = resultset.getInt("ordersqty");
						currentprice = resultset.getInt("price");
						
						// display next
						sQuery += resultset.getString("ordersitemno") + "\t";	
						sQuery += resultset.getString("itemname") + "\t";	
						sQuery += resultset.getString("factoryno") + "\t";					
						sQuery += Integer.toString(resultset.getInt("price")) + "\t";
					}				
				}
				else
				{
					// keep data
					currentItemno = resultset.getString("ordersitemno");
					currentqty = resultset.getInt("ordersqty");
					currentprice = resultset.getInt("price");	

					// display
					sQuery += resultset.getString("ordersitemno") + "\t";
					sQuery += resultset.getString("itemname") + "\t";	
					sQuery += resultset.getString("factoryno") + "\t";
					sQuery += Integer.toString(resultset.getInt("price")) + "\t";
					
				}
				
			}	
			// sum and amount
			sum = currentprice * currentqty;	
			sQuery += Integer.toString(currentqty) + "\t";
			sQuery += Integer.toString(sum) + "\r\n";
			totalprice += sum;
			
			sQuery +=  Sline;
			sQuery += " 總計金額： "+Integer.toString(totalprice)+ "\r\n";				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String groupbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		String sQuery = "";
		
		String 	SQL="select ";
		
		SQL += "orders.orderscustomerno, ";
		SQL += "customer.customername, ";		
		SQL += "orders.ordersitemno, ";
		SQL += "item.itemname, ";
		SQL += "item.price, ";
		SQL += "orders.ordersqty ";
		
		SQL += "FROM orders ";
		SQL += "INNER JOIN customer ON  customer.customerno =orders.orderscustomerno ";
		SQL += "INNER JOIN item  ON  item.itemno =orders.ordersitemno ";		
		
		SQL += "WHERE ordersdate >= ? and ordersdate <= ? ";
		SQL += "ORDER BY orderscustomerno, ordersitemno ";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			preparedstatement.setString(1,indateFrom);
			preparedstatement.setString(2,indateTo);
			ResultSet resultset=preparedstatement.executeQuery();
			
			int sum = 0;
			String currentCustomerno = "";
			String currentItemno = "";
			int currentqty = 0;
			int currentprice = 0;
			int totalprice = 0;
			while(resultset.next())
			{
				
				if (currentCustomerno.length() > 0)
				{
					// same factory no
					if (currentCustomerno.equals(resultset.getString("orderscustomerno")))
					{		// same item no
						if (currentItemno.equals(resultset.getString("ordersitemno")))
						{
							// add qty
							currentqty += resultset.getInt("ordersqty");
						}
						else
						{	
							// sum and amount
							sum = currentprice * currentqty;	
							sQuery += Integer.toString(currentqty) + "\t";
							sQuery += Integer.toString(sum) + "\r\n";
							totalprice += sum;
							
							// keep data
							currentItemno = resultset.getString("ordersitemno");
							currentqty = resultset.getInt("ordersqty");
							currentprice = resultset.getInt("price");
							
							// display next
							sQuery += resultset.getString("orderscustomerno") + "\t";
							sQuery += resultset.getString("customername") + "\t";
							sQuery += resultset.getString("ordersitemno") + "\t";	
							sQuery += resultset.getString("itemname") + "\t";	
							sQuery += Integer.toString(resultset.getInt("price")) + "\t";
							
						}
					}
					else
					{
						// sum & display
						sum = currentprice * currentqty;	
						sQuery += Integer.toString(currentqty) + "\t";
						sQuery += Integer.toString(sum) + "\r\n";
						totalprice += sum;
						sQuery +=  Sline;
						sQuery += " 總計金額： "+Integer.toString(totalprice)+ "\r\n";
						sQuery +=  Sline;
						totalprice = 0;
						
						// keep data
						currentCustomerno = resultset.getString("orderscustomerno");
						currentItemno = resultset.getString("ordersitemno");
						currentqty = resultset.getInt("ordersqty");
						currentprice = resultset.getInt("price");
						
						// display
						sQuery += resultset.getString("orderscustomerno") + "\t";	
						sQuery += resultset.getString("customername") + "\t";
						sQuery += resultset.getString("ordersitemno") + "\t";	
						sQuery += resultset.getString("itemname") + "\t";	
						sQuery += Integer.toString(resultset.getInt("price")) + "\t";
					}
				}
				else
				{
					// keep data
					currentCustomerno = resultset.getString("orderscustomerno");
					currentItemno = resultset.getString("ordersitemno");
					currentqty = resultset.getInt("ordersqty");
					currentprice = resultset.getInt("price");	

					// display
					sQuery += resultset.getString("orderscustomerno") + "\t";	
					sQuery += resultset.getString("customername") + "\t";	
					sQuery += resultset.getString("ordersitemno") + "\t";	
					sQuery += resultset.getString("itemname") + "\t";	
					sQuery += Integer.toString(resultset.getInt("price")) + "\t";
					
				}

			}	

			// sum & display
			sum = currentprice * currentqty;	
			sQuery += Integer.toString(currentqty) + "\t";
			sQuery += Integer.toString(sum) + "\r\n";
			totalprice += sum;
			
			sQuery +=  Sline;
			sQuery += " 總計金額： "+Integer.toString(totalprice)+ "\r\n";				

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuery;
	}

	@Override
	public String[][] csvbyItemnono(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[][] csvbyCustomerno(String indateFrom, String indateTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Orders orders) {
		// TODO Auto-generated method stub
		String sql="update orders set ordersemployeeno=?, ordersdate=?, orderscustomerno=?, ordersserial_number=?, ordersitemno=?, ordersqty=?  where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,orders.getOrdersemployeeno());
			preparedstatement.setString(2,orders.getOrdersdate());	
			preparedstatement.setString(3,orders.getOrderscustomerno());
			preparedstatement.setInt(4,orders.getOrdersserial_number());
			preparedstatement.setString(5,orders.getOrdersitemno());
			preparedstatement.setInt(6,orders.getOrdersqty());
			preparedstatement.setInt(7,orders.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from orders where id=?";
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
