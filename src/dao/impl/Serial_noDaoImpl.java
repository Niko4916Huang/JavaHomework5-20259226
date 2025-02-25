package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Serial_noDao;
import model.Serial_no;
import util.DbConnection;

public class Serial_noDaoImpl implements Serial_noDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  // add 
			Serial_no serial_no = new Serial_no("orders", 1);
			new Serial_noDaoImpl().add(serial_no);
			serial_no = new Serial_no("customer", 13);
			new Serial_noDaoImpl().add(serial_no);
			serial_no = new Serial_no("employee", 10);
			new Serial_noDaoImpl().add(serial_no);
			serial_no = new Serial_no("factory", 13);
			new Serial_noDaoImpl().add(serial_no);
			serial_no = new Serial_no("item", 9);
			new Serial_noDaoImpl().add(serial_no);
		*/	
			
		
			
		/*	
		//list all serial_no	
			List<Serial_no> listSerial_no=new Serial_noDaoImpl().selectAll();
			for(Serial_no oneSerial_no:listSerial_no)
			{
				System.out.println(oneSerial_no.getId()+"\t"+oneSerial_no.getSerial_name()+
									"\t"+oneSerial_no.getSerial_number());
			}			
		*/
			// result
			/*
			 * 1	orders			1	
				2	customer		13
				3	employee		10
				4	factory			13
				5	item			9

			 * 
			 */
		
		/*
			// find serial_no by id
					System.out.println(new Serial_noDaoImpl().selectById(1));
			// result:  [model.Serial_no@1a04f701]
		 */

		/*
			// find serial_no by serial_name		
				System.out.println(new Serial_noDaoImpl().selectBySerial_name("orders"));
				// result: [model.Serial_no@1a04f701]
		*/
			
		
			// update serial_no
					List<Serial_no> listSerial_no=new Serial_noDaoImpl().selectById(1);
					Serial_no oneSerial_no=listSerial_no.get(0);
					oneSerial_no.setSerial_number( oneSerial_no.getSerial_number() + 1);
					
					new Serial_noDaoImpl().update(oneSerial_no);
		

	}
	// connect mysql database
				private static Connection conn= DbConnection.getDb();
				
				@Override
				public void add(Serial_no serial_no) {
					// TODO Auto-generated method stub
					String sql="insert into serial_no(serial_name, serial_number) "
							+ "values(?,?)";
					
					try {
						PreparedStatement preparedstatement=conn.prepareStatement(sql);
						preparedstatement.setString(1,serial_no.getSerial_name());
						preparedstatement.setInt(2,serial_no.getSerial_number());				

						preparedstatement.executeUpdate();
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				@Override
				public List<Serial_no> selectAll() {
					// TODO Auto-generated method stub
					String sql="select * from serial_no";
					List<Serial_no> allSerial_no = new ArrayList();
					
					try {
						PreparedStatement preparedstatement=conn.prepareStatement(sql);
						ResultSet resultset=preparedstatement.executeQuery();
						
						while(resultset.next())
						{

							Serial_no oneSerial_no=new Serial_no();
							oneSerial_no.setId(resultset.getInt("id"));
							oneSerial_no.setSerial_name(resultset.getString("serial_name"));
							oneSerial_no.setSerial_number(resultset.getInt("serial_number"));
							
							allSerial_no.add(oneSerial_no);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return allSerial_no;
				}
				@Override
				public List<Serial_no> selectById(int id) {
					// TODO Auto-generated method stub
					String sql = "select * from serial_no where id = ?";
					List<Serial_no> allSerial_no = new ArrayList();
					
					try {
						PreparedStatement preparedstatement=conn.prepareStatement(sql);
						preparedstatement.setInt(1,id);
						ResultSet resultset=preparedstatement.executeQuery();
						
						while(resultset.next())
						{

							Serial_no oneSerial_no=new Serial_no();
							oneSerial_no.setId(resultset.getInt("id"));
							oneSerial_no.setSerial_name(resultset.getString("serial_name"));
							oneSerial_no.setSerial_number(resultset.getInt("serial_number"));
							
							allSerial_no.add(oneSerial_no);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return allSerial_no;
				}
				@Override
				public List<Serial_no> selectBySerial_name(String serial_name) {
					// TODO Auto-generated method stub
					String sql = "select * from serial_no where serial_name = ?";
					List<Serial_no> allSerial_no = new ArrayList();
					
					try {
						PreparedStatement preparedstatement=conn.prepareStatement(sql);
						preparedstatement.setString(1,serial_name);
						ResultSet resultset=preparedstatement.executeQuery();
						
						while(resultset.next())
						{

							Serial_no oneSerial_no=new Serial_no();
							oneSerial_no.setId(resultset.getInt("id"));
							oneSerial_no.setSerial_name(resultset.getString("serial_name"));
							oneSerial_no.setSerial_number(resultset.getInt("serial_number"));
							
							allSerial_no.add(oneSerial_no);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return allSerial_no;
				}
				@Override
				public void update(Serial_no serial_no) {
					// TODO Auto-generated method stub
					String sql="update serial_no set serial_number=? where id=?";
					
					try {
						PreparedStatement preparedstatement=conn.prepareStatement(sql);
					
						preparedstatement.setInt(1,serial_no.getSerial_number());
						preparedstatement.setInt(2,serial_no.getId());
						
						preparedstatement.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				@Override
				public void delete(int id) {
					// TODO Auto-generated method stub
					String sql="delete from serial_no where id=?";
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
