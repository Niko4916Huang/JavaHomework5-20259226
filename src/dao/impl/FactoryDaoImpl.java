package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FactoryDao;
import model.Factory;
import util.DbConnection;

public class FactoryDaoImpl implements FactoryDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		// add 
		Factory factory = new Factory("F002", "嘟嘟好食");
		new FactoryDaoImpl().add(factory);
		factory = new Factory("F003", "大潤發");
		new FactoryDaoImpl().add(factory);
		factory = new Factory("F004", "元金食品");
		new FactoryDaoImpl().add(factory);
	*/	
		/*
	//list all factory
	
		List<Factory> l=new FactoryDaoImpl().selectAll();
		for(Factory s:l)
		{
			System.out.println(s.getId()+"\t"+s.getFactoryno()+"\t"+s.getFactoryname());
		}
	*/
	/*
		// find factory by id
		System.out.println(new FactoryDaoImpl().selectById(1));
		// result:  [model.Factory@1a04f701]
	*/
	/*
		// find factory by factoryno		
		//	System.out.println(new FactoryDaoImpl().selectByfactoryno("F002"));
	*/
		
	/*
		// update name
				List<Factory> listFactory=new FactoryDaoImpl().selectById(10);
				Factory oneFactory=listFactory.get(0);
				oneFactory.setFactoryname("郭元益");
				
				new FactoryDaoImpl().update(oneFactory);
	*/
		
	}
	
// connect mysql database
	private static Connection conn= DbConnection.getDb();

	@Override
	public void add(Factory factory) {
		// TODO Auto-generated method stub
		String sql="insert into factory(factoryno, factoryname, factorycontect, factorytel, factoryadds) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,factory.getFactoryno());
			preparedstatement.setString(2,factory.getFactoryname());
			preparedstatement.setString(3,factory.getFactorycontect());
			preparedstatement.setString(4,factory.getFactorytel());
			preparedstatement.setString(5,factory.getFactoryadds());

			preparedstatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Factory> selectAll() {
		// TODO Auto-generated method stub
		String SQL="select * from factory";
		List<Factory> allFactory = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				Factory oneFactory=new Factory();
				oneFactory.setId(resultset.getInt("id"));
				oneFactory.setFactoryno(resultset.getString("factoryno"));
				oneFactory.setFactoryname(resultset.getString("factoryname"));
				oneFactory.setFactorycontect(resultset.getString("factorycontect"));
				oneFactory.setFactorytel(resultset.getString("factorytel"));
				oneFactory.setFactoryadds(resultset.getString("factoryadds"));
				
				allFactory.add(oneFactory);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFactory;
	}

	@Override
	public List<Factory> selectById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from factory where id = ?";
		List<Factory> oneFactory = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Factory factory=new Factory();
				factory.setId(resultset.getInt("id"));
				factory.setFactoryno(resultset.getString("factoryno"));
				factory.setFactoryname(resultset.getString("factoryname"));
				factory.setFactorycontect(resultset.getString("factorycontect"));
				factory.setFactorytel(resultset.getString("factorytel"));
				factory.setFactoryadds(resultset.getString("factoryadds"));
				
				oneFactory.add(factory);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneFactory;
	}

	@Override
	public List<Factory> selectByfactoryno(String factoryno) {
		// TODO Auto-generated method stub
		String sql = "select * from factory where factoryno = ?";
		List<Factory> onefactory = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,factoryno);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Factory factory=new Factory();
				factory.setId(resultset.getInt("id"));
				factory.setFactoryno(resultset.getString("factoryno"));
				factory.setFactoryname(resultset.getString("factoryname"));
				factory.setFactorycontect(resultset.getString("factorycontect"));
				factory.setFactorytel(resultset.getString("factorytel"));
				factory.setFactoryadds(resultset.getString("factoryadds"));
								
				onefactory.add(factory);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return onefactory;
	}

	@Override
	public void update(Factory factory) {
		// TODO Auto-generated method stub
		String sql="update factory set factoryno=?,factoryname=? ,factorycontect=? ,factorytel=? ,factoryadds=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,factory.getFactoryno());
			preparedstatement.setString(2,factory.getFactoryname());
			preparedstatement.setString(3,factory.getFactorycontect());
			preparedstatement.setString(4,factory.getFactorytel());
			preparedstatement.setString(5,factory.getFactoryadds());
			preparedstatement.setInt(6,factory.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from factory where id=?";
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
