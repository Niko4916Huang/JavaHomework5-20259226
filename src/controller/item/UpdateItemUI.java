package controller.item;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.employee.EmployUI;
import controller.factory.FactoryUI;
import controller.customer.CustomerUI;
import controller.orders.OrdersUI;
import model.Employee;
import model.Factory;
import model.Item;
import service.impl.FactoryServiceImpl;
import service.impl.ItemServiceImpl;
import util.ClockPanel;
import util.Tool;

public class UpdateItemUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Tname;
	private JTextField Tcost;
	private JTextField Tprice;
	private JTextField Tqty;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateItemUI frame = new UpdateItemUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateItemUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Item oneItem = (Item) Tool.read("item.txt");
		/*
		System.out.println(oneItem.getId()+"\t"+oneItem.getItemno()+
				"\t"+oneItem.getItemname()+"\t"+oneItem.getCost()+
				"\t"+oneItem.getPrice()+"\t"+oneItem.getFactoryno()+
				"\t"+oneItem.getQty()
				);
		*/
		JLabel lblNewLabel = new JLabel("商品基本資料 - 更新作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(283, 3, 301, 26);
		panel.add(lblNewLabel);
		
		JLabel employeeNameLb = new JLabel("使用員工："+employee.getName());
		employeeNameLb.setBounds(6, 11, 124, 16);
		panel.add(employeeNameLb);
		
	// 小時鐘介面
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.setBackground(new Color(205, 255, 239));
        clockPanel.setBounds(697, 3, 90, 32);
        panel.add(clockPanel);
     // 啟動時鐘更新
        new Timer(1000, e1 -> clockPanel.updateTime()).start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(18, 47, 125, 410);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnReceiving = new JButton("進貨作業");
		btnReceiving.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ReceivingUI frame;
					frame = new ReceivingUI();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReceiving.setBounds(2, 25, 117, 29);
		panel_1.add(btnReceiving);

		JButton btnOrders = new JButton("銷貨作業");
		btnOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					OrdersUI frame = new OrdersUI();
					frame.setVisible(true);
					dispose();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOrders.setBounds(2, 65, 117, 29);
		panel_1.add(btnOrders);
		
		JButton btnReport = new JButton("報表作業");
		btnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ReportUI frame = new ReportUI();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReport.setBounds(2, 105, 117, 29);
		panel_1.add(btnReport);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 155, 105, 190);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" 基本資料");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(22, 6, 77, 16);
		panel_3.add(lblNewLabel_1);
		
		JButton btnItem = new JButton("商 品");
		btnItem.setEnabled(false);
		btnItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnItem.setBounds(6, 34, 95, 29);
		panel_3.add(btnItem);
		
		JButton btnFactory = new JButton("廠 商");
		btnFactory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FactoryUI frame = new FactoryUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnFactory.setBounds(6, 68, 95, 29);
		panel_3.add(btnFactory);
		
		JButton btnEmployee = new JButton("員 工");
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployUI frame = new EmployUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnEmployee.setBounds(6, 102, 95, 29);
		panel_3.add(btnEmployee);
		
		JButton btncustomer = new JButton("客 戶");
		btncustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerUI frame = new CustomerUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btncustomer.setBounds(6, 136, 95, 29);
		panel_3.add(btncustomer);
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(4, 360, 117, 29);
		panel_1.add(btnExit);
		
		
/***************************************************************/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("商品編號：");
		lblNewLabel_2.setBounds(40, 20, 75, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("商品名稱：");
		lblNewLabel_2_1.setBounds(40, 55, 75, 16);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("進       價：");
		lblNewLabel_2_2.setBounds(40, 85, 75, 16);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("售       價：");
		lblNewLabel_2_3.setBounds(40, 120, 75, 16);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("廠商編號：");
		lblNewLabel_2_4.setBounds(40, 155, 75, 16);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("庫  存  量：");
		lblNewLabel_2_5.setBounds(40, 190, 75, 16);
		panel_2.add(lblNewLabel_2_5);
		
		JLabel lblItemno = new JLabel(oneItem.getItemno());
		lblItemno.setBounds(137, 20, 61, 16);
		panel_2.add(lblItemno);
		
		Tname = new JTextField(oneItem.getItemname());
		Tname.setColumns(10);
		Tname.setBounds(137, 50, 250, 24);
		panel_2.add(Tname);
		
		Tcost = new JTextField(String.valueOf(oneItem.getCost()));
		Tcost.setColumns(10);
		Tcost.setBounds(137, 80, 69, 24);
		panel_2.add(Tcost);
		
		Tprice = new JTextField(String.valueOf(oneItem.getPrice()));
		Tprice.setColumns(10);
		Tprice.setBounds(137, 115, 69, 24);
		panel_2.add(Tprice);
		
		JLabel lblfactoryno = new JLabel();
		lblfactoryno.setBounds(137, 152, 250, 24);
		panel_2.add(lblfactoryno);
		Factory Thisfactory = new FactoryServiceImpl().findByFactoryno(oneItem.getFactoryno());
		lblfactoryno.setText(Thisfactory.getFactoryno() + " - " + Thisfactory.getFactoryname());
		
/*
//		comboBox List data	
			List<String> itemlist = new ArrayList<String>();
			
			int selectedIndex = 0;
			
			int selectedcounter = 0;
			List<Factory> listdata=new FactoryServiceImpl().findAllFactory();	
			for(Factory oneData:listdata)
			{
				String selectItem = oneData.getFactoryno() + "-" + oneData.getFactoryname();
				itemlist.add(selectItem);
				if (oneItem.getFactoryno().equals(oneData.getFactoryno()))
						selectedIndex = selectedcounter;
				selectedcounter++;
					
			}
			String[] item = new String[itemlist.size()];
			itemlist.toArray(item);
*/		
/*
		Tfactoryno = new JTextField(oneItem.getFactoryno());
		Tfactoryno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sFactoryno = Tfactoryno.getText().trim();
				Factory Thisfactory = new FactoryServiceImpl().findByFactoryno(sFactoryno);
				// if(new FactoryServiceImpl().isFactorynoBeenUse(sFactoryno))
				if(Thisfactory != null)
				{
					lblFactoryName.setText(Thisfactory.getFactoryname());
				}
				else
				{
					Tool.alert(" 廠商編號不存在， 請重新輸入！");
				}
				
			}
		});
		Tfactoryno.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sFactoryno = Tfactoryno.getText().trim();
					Factory Thisfactory = new FactoryServiceImpl().findByFactoryno(sFactoryno);
					// if(new FactoryServiceImpl().isFactorynoBeenUse(sFactoryno))
					if(Thisfactory != null)
					{
						lblFactoryName.setText(Thisfactory.getFactoryname());
					}
					else
					{
						Tool.alert(" 廠商編號不存在， 請重新輸入！");
					}
				}			
			} );
	*/
		/*
		Tfactoryno.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				System.out.println("Factory no changed!");
			}
		});
		*/
/*
		Tfactoryno.setColumns(10);
		Tfactoryno.setBounds(137, 150, 69, 26);
		panel_2.add(Tfactoryno);
*/
		
		Tqty = new JTextField(String.valueOf(oneItem.getQty()));
		Tqty.setColumns(10);
		Tqty.setBounds(137, 185, 69, 24);
		panel_2.add(Tqty);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("元");
		lblNewLabel_2_5_1.setBounds(216, 85, 36, 16);
		panel_2.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("元");
		lblNewLabel_2_5_1_1.setBounds(218, 120, 36, 16);
		panel_2.add(lblNewLabel_2_5_1_1);
		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(49, 245, 117, 29);
		panel_2.add(bntQuery);
		
		JButton btnNewAdd = new JButton("更  新");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!Tname.getText().equals("") && !Tcost.getText().equals("") && 
					!Tprice.getText().equals("") && !Tqty.getText().equals("") )
				{
				/*
					String strSelected = searchingBox.getSelectedItem().toString();
					String[] words = strSelected.split("-");
					String Tfactoryno = words[0];
				*/	
					oneItem.setItemname(Tname.getText());
					oneItem.setCost(Integer.parseInt(Tcost.getText()));					
					oneItem.setPrice(Integer.parseInt(Tprice.getText()));
					oneItem.setQty(Integer.parseInt(Tqty.getText()));
					
					new ItemServiceImpl().updateItem(oneItem);
					
					Tool.alert(" 更 新 成 功！");
					ItemUI frame = new ItemUI();
					frame.setVisible(true);
					dispose();					
								
				}
				else
				{
					Tool.alert(" 輸入錯誤， 不可有空欄位，\n    請重新輸入！");
				}
			}
		});
		btnNewAdd.setBounds(216, 245, 117, 29);
		panel_2.add(btnNewAdd);




	}
}
