package controller.factory;

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
import javax.swing.text.MaskFormatter;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.employee.EmployUI;
import controller.item.ItemUI;
import controller.customer.CustomerUI;
import controller.orders.OrdersUI;
import model.Employee;
import model.Factory;
import service.impl.FactoryServiceImpl;
import util.ClockPanel;
import util.Tool;
import javax.swing.JFormattedTextField;

public class UpdateFactoryUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField factoryName;
	private JTextField factorycontect;
	private JTextField factoryadds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFactoryUI frame = new UpdateFactoryUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public UpdateFactoryUI() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Factory oneFactory = (Factory) Tool.read("factory.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("廠商基本資料 - 更新作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(274, 3, 274, 26);
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
		
		JButton btncustomer = new JButton("客 戶");
		btncustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerUI frame = new CustomerUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btncustomer.setBounds(4, 136, 95, 29);
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
				
		JLabel lblFactoryno = new JLabel(oneFactory.getFactoryno());
		lblFactoryno.setBounds(234, 51, 130, 30);
		panel_2.add(lblFactoryno);
		
		JLabel lblNewLabel_2 = new JLabel("廠商編號：");
		lblNewLabel_2.setBounds(129, 56, 75, 16);
		panel_2.add(lblNewLabel_2);
				
		JLabel lblNewLabel_2_1 = new JLabel("廠商名稱：");
		lblNewLabel_2_1.setBounds(129, 105, 75, 16);
		panel_2.add(lblNewLabel_2_1);
		
		factoryName = new JTextField(oneFactory.getFactoryname());
		factoryName.setColumns(10);
		factoryName.setBounds(234, 100, 234, 30);
		panel_2.add(factoryName);
		

		JLabel lblNewLabel_2_1_1 = new JLabel("聯 絡 人：");
		lblNewLabel_2_1_1.setBounds(129, 156, 75, 16);
		panel_2.add(lblNewLabel_2_1_1);
		
		factorycontect = new JTextField(oneFactory.getFactorycontect());
		factorycontect.setColumns(10);
		factorycontect.setBounds(234, 151, 234, 30);
		panel_2.add(factorycontect);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("廠商電話：");
		lblNewLabel_2_1_2.setBounds(129, 201, 75, 16);
		panel_2.add(lblNewLabel_2_1_2);
		
	// tel formatter	

		MaskFormatter mf2 = new MaskFormatter("##-*###-###*");
		JFormattedTextField formattedTextField = new JFormattedTextField(mf2);
		formattedTextField.setBounds(234, 196, 234, 30);
		panel_2.add(formattedTextField);
		formattedTextField.setText(oneFactory.getFactorytel());
	// for 	JFormattedTextField
		
		JLabel lblNewLabel_2_1_3 = new JLabel("廠商地址：");
		lblNewLabel_2_1_3.setBounds(129, 248, 75, 16);
		panel_2.add(lblNewLabel_2_1_3);
		
		factoryadds = new JTextField(oneFactory.getFactoryadds());
		factoryadds.setColumns(10);
		factoryadds.setBounds(234, 243, 234, 30);
		panel_2.add(factoryadds);

		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FactoryUI frame = new FactoryUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(129, 326, 117, 29);
		panel_2.add(bntQuery);
		
		JButton btnNewAdd = new JButton("更  新");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!factoryName.getText().equals("") )
				{
					{
						oneFactory.setFactoryname(factoryName.getText());
						oneFactory.setFactorycontect(factorycontect.getText());
						oneFactory.setFactorytel(formattedTextField.getText());
						oneFactory.setFactoryadds(factoryadds.getText());
						new FactoryServiceImpl().updateFactory(oneFactory);
						
						Tool.alert(" 更 新 成 功！");
						FactoryUI frame = new FactoryUI();
						frame.setVisible(true);
						dispose();
					}
				}
				else
				{
					Tool.alert(" 輸入錯誤， 請重新輸入！");
				}
				
			}
		});
		btnNewAdd.setBounds(357, 326, 117, 29);
		panel_2.add(btnNewAdd);
		

	}
}
