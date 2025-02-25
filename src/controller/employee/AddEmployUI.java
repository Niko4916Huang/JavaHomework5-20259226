package controller.employee;

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
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.ClockPanel;
import util.Tool;
import controller.item.ItemUI;
import controller.orders.OrdersUI;
import controller.factory.FactoryUI;
import controller.ReceivingUI;
import controller.ReportUI;
import controller.customer.CustomerUI;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;


public class AddEmployUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField temployno;
	private JTextField tname;
	private JTextField tusername;
	private JTextField tpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployUI frame = new AddEmployUI();
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
	public AddEmployUI() {
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
		
		
		
		JLabel lblNewLabel = new JLabel("員工基本資料 - 新增作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(272, 3, 279, 26);
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
		btnEmployee.setEnabled(false);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	
/*******************************************************************/
		
		
		
		JLabel lblNewLabel_2 = new JLabel("員工編號：");
		lblNewLabel_2.setBounds(130, 39, 74, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("員工姓名：");
		lblNewLabel_2_1.setBounds(130, 87, 74, 16);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("員工帳號：");
		lblNewLabel_3.setBounds(130, 141, 74, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("登入密碼：");
		lblNewLabel_4.setBounds(130, 185, 74, 16);
		panel_2.add(lblNewLabel_4);
		
		temployno = new JTextField();
		temployno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sEmployno = temployno.getText().trim();
				if (new EmployeeServiceImpl().isEmployeenoBeenUse(sEmployno))
				{
					Tool.alert(" 員工編號重複， 請重新輸入！");
				}
			}
		});
		temployno.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sEmployno = temployno.getText().trim();
					if (new EmployeeServiceImpl().isEmployeenoBeenUse(sEmployno))
					{
						Tool.alert(" 員工編號重複， 請重新輸入！");
					}
				}			
			} );
		temployno.setColumns(10);
		temployno.setBounds(258, 34, 196, 26);
		panel_2.add(temployno);
		
		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(258, 82, 196, 26);
		panel_2.add(tname);
		
		tusername = new JTextField();
		tusername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sUsername = tusername.getText().trim();
				if (new EmployeeServiceImpl().isUsernameBeenUse(sUsername))
				{
					Tool.alert(" 員工帳號已被使用， 請重新輸入！");
				}				
			}
		});
		tusername.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sUsername = tusername.getText().trim();
					if (new EmployeeServiceImpl().isUsernameBeenUse(sUsername))
					{
						Tool.alert(" 員工帳號已被使用， 請重新輸入！");
					}
				}			
			} );
		tusername.setColumns(10);
		tusername.setBounds(258, 136, 196, 26);
		panel_2.add(tusername);
		
		tpassword = new JTextField();
		tpassword.setColumns(10);
		tpassword.setBounds(258, 180, 196, 26);
		panel_2.add(tpassword);
		
		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployUI frame = new EmployUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(96, 275, 117, 29);
		panel_2.add(bntQuery);
		
		JButton btnNewAdd = new JButton("新  增");
		btnNewAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!temployno.getText().equals("") && !tname.getText().equals("") && !tusername.getText().equals("") 
						&& !tpassword.getText().equals("") )
				{
					// check employee no
					String Employno=temployno.getText();
					if(new EmployeeServiceImpl().isEmployeenoBeenUse(Employno))
					{
						Tool.alert(" 員工編號重複， 請重新輸入！");
					}
					else
					{
						String Username=tusername.getText();
						if(new EmployeeServiceImpl().isUsernameBeenUse(Username))
						{
							Tool.alert(" 員工帳號已被使用， 請重新輸入！");
						}
						else
						{
							String Employeeno=temployno.getText();
							String Employeename=tname.getText();
							String EmployeeUsername=tusername.getText();
							String EmployeePassword=tpassword.getText();
							
							Employee employee = new Employee(Employeeno, Employeename, EmployeeUsername, EmployeePassword);
							new EmployeeServiceImpl().addEmployee(employee);
							
							Tool.alert(" 新員工註冊成功， 請重新登入！");
							
							// TODO Auto-generated method stub
							EmployUI frame = new EmployUI();
							frame.setVisible(true);
							dispose();
													
						}
					}					
				}
				
			}
		
		});
		btnNewAdd.setBounds(337, 275, 117, 29);
		panel_2.add(btnNewAdd);

		
	}
}
