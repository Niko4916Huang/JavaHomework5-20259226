package controller.factory;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.customer.CustomerUI;
import controller.employee.EmployUI;
import controller.item.ItemUI;
import controller.orders.OrdersUI;
import model.Employee;
import model.Factory;
import service.impl.FactoryServiceImpl;
import util.ClockPanel;
import util.Tool;
import javax.swing.JComboBox;

public class FactoryUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactoryUI frame = new FactoryUI();
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
	public FactoryUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);			
		
		JLabel lblNewLabel = new JLabel("廠 商 - 基本資料作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(319, 3, 241, 26);
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
		btnFactory.setEnabled(false);
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
		
		JButton btnOrders = new JButton("客 戶");
		btnOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerUI frame = new CustomerUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnOrders.setBounds(6, 136, 95, 29);
		panel_3.add(btnOrders);
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(4, 360, 117, 29);
		panel_1.add(btnExit);
		
		JButton btnReport_1 = new JButton("銷貨作業");
		btnReport_1.addMouseListener(new MouseAdapter() {
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
		btnReport_1.setBounds(2, 65, 117, 29);
		panel_1.add(btnReport_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("廠商編號：");
		lblNewLabel_2.setBounds(146, 93, 75, 16);
		panel_2.add(lblNewLabel_2);
		
//		comboBox List data	
			List<String> itemlist = new ArrayList<String>();
			
			// int selectedIndex = 0;
			// searchingBox.setSelectedIndex(selectedIndex);
			
			List<Factory> listdata=new FactoryServiceImpl().findAllFactory();	
			for(Factory oneData:listdata)
			{
				String selectItem = oneData.getFactoryno() + "-" + oneData.getFactoryname();
				itemlist.add(selectItem);
			}
			String[] item = new String[itemlist.size()];
			itemlist.toArray(item);
		// end of
		
		JComboBox searchingBox = new JComboBox(item);
		searchingBox.setBounds(233, 85, 209, 34);
		panel_2.add(searchingBox);
		
		JButton bntQuery = new JButton("查  詢");
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strSelected = searchingBox.getSelectedItem().toString();
				String[] words = strSelected.split("-");
				String Factoryno = words[0];
				
				Factory oneFactory = new FactoryServiceImpl().findByFactoryno(Factoryno);
				if (oneFactory != null)
				{
					Tool.save(oneFactory, "factory.txt");
					
					
					try {
						UpdateFactoryUI frame = new UpdateFactoryUI();
						frame.setVisible(true);
						dispose();
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					Tool.alert(" 查 詢 失 敗!");
				}
			}
		});
		bntQuery.setBounds(146, 196, 117, 29);
		panel_2.add(bntQuery);
		
		JButton btnNewAdd = new JButton("新  增");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					AddFactoryUI frame = new AddFactoryUI();
					frame.setVisible(true);
					dispose();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewAdd.setBounds(325, 196, 117, 29);
		panel_2.add(btnNewAdd);

	}
}
