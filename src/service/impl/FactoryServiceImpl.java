package service.impl;

import java.util.List;

import dao.impl.FactoryDaoImpl;
import model.Factory;
import service.FactoryService;

public class FactoryServiceImpl implements FactoryService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// new add
		Factory factory = new Factory("F006", " 義美");
		new FactoryServiceImpl().addFactory(factory);
	
		*/
	
	/*
		System.out.println(new FactoryServiceImpl().findAllFactory());
		// result:
		//[model.Factory@1a04f701, model.Factory@4e91d63f, model.Factory@d4342c2, model.Factory@2bbf180e, model.Factory@163e4e87, model.Factory@56de5251]
	*/
	
		
	//	 System.out.println(new FactoryServiceImpl().AllFactory());
		/* result:
		 * 	 
			 廠商編號:F001	廠商名稱:Cosco
			 廠商編號:F002	廠商名稱:嘟嘟好食
			 廠商編號:F003	廠商名稱:大潤發
			 廠商編號:F004	廠商名稱:元金食品
			 廠商編號:F005	廠商名稱:福義軒
			 廠商編號:F006	廠商名稱: 義美
		 */
	/*
		System.out.println(new FactoryServiceImpl().selectById(1));
		// result: [model.Factory@d4342c2]
	*/
	/*
		System.out.println(new FactoryServiceImpl().selectById(9));
		// result: null
	 * 
	 */
	//	new FactoryServiceImpl().deleteFactoryById(6);
	}
	
	private static FactoryDaoImpl factorydaoimpl=new FactoryDaoImpl();

	@Override
	public void addFactory(Factory factory) {
		// TODO Auto-generated method stub
		factorydaoimpl.add(factory);
	}

	@Override
	public String AllFactory() {
		// TODO Auto-generated method stub

	 	List<Factory> listFactory=factorydaoimpl.selectAll();
		String show="";
		
		for(Factory onefactory:listFactory)
		{		
			show=show+" 廠商編號:"+onefactory.getFactoryno()+
					"\t廠商名稱:"+onefactory.getFactoryname()+
					"\t聯絡人:"+onefactory.getFactorycontect()+
					"\t電話:"+onefactory.getFactorytel()+
					"\t地址:"+onefactory.getFactoryadds()+
					"\n";
		}			
		return show;

	}

	@Override
	public List<Factory> findAllFactory() {
		// TODO Auto-generated method stub
		return factorydaoimpl.selectAll();
	}

	@Override
	public List<Factory> selectById(int id) {
		// TODO Auto-generated method stub
		return factorydaoimpl.selectById(id);
	}

	@Override
	public Factory findByFactoryno(String factoryno) {
		// TODO Auto-generated method stub
		Factory factory = null;
		
		List<Factory> listFactory = factorydaoimpl.selectByfactoryno(factoryno);
		if (listFactory.size() > 0)
		{
			factory = listFactory.get(0);
		}
		
		return factory;
	}

	@Override
	public boolean isFactorynoBeenUse(String factoryno) {
		// TODO Auto-generated method stub
		return !factorydaoimpl.selectByfactoryno(factoryno).isEmpty();
	}

	@Override
	public void updateFactory(Factory factory) {
		// TODO Auto-generated method stub
		factorydaoimpl.update(factory);
	}

	@Override
	public void deletefactoryById(int id) {
		// TODO Auto-generated method stub
		factorydaoimpl.delete(id);
	}


}
