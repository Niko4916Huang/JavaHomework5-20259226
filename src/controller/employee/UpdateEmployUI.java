package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import controller.customer.CustomerUI;
import controller.factory.FactoryUI;
import controller.item.ItemUI;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.ClockPanel;
import util.Tool;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class UpdateEmployUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_Name;
	private JTextField t_Username;
	private JTextField t_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployUI frame = new UpdateEmployUI();
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
	public UpdateEmployUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Employee oneEmployUI = (Employee) Tool.read("employUI.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("員工基本資料 - 更新作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(280, 3, 283, 26);
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
		
		JButton btnOrders = new JButton("銷貨作業");
		btnOrders.setBounds(2, 65, 117, 29);
		panel_1.add(btnOrders);
		
/*******************************************************************/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("員工編號：");
		lblNewLabel_2.setBounds(140, 57, 75, 16);
		panel_2.add(lblNewLabel_2);
				
		JLabel lblemployno = new JLabel(oneEmployUI.getEmployeeno());
		lblemployno.setBounds(260, 57, 130, 16);
		panel_2.add(lblemployno);
				
		JLabel lblNewLabel_2_1 = new JLabel("員工姓名：");
		lblNewLabel_2_1.setBounds(140, 97, 75, 16);
		panel_2.add(lblNewLabel_2_1);
				
		JLabel lblNewLabel_3 = new JLabel("員工帳號：");
		lblNewLabel_3.setBounds(140, 137, 74, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("登入密碼：");
		lblNewLabel_4.setBounds(140, 177, 74, 16);
		panel_2.add(lblNewLabel_4);
		
		t_Name = new JTextField(oneEmployUI.getName());
		t_Name.setBounds(260, 92, 207, 26);
		panel_2.add(t_Name);
		t_Name.setColumns(10);
		
		t_Username = new JTextField(oneEmployUI.getUsername());
		t_Username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sUsername = t_Username.getText().trim();
				if (new EmployeeServiceImpl().isUsernameBeenUse(sUsername))
				{
					Tool.alert(" 員工帳號已被使用， 請重新輸入！");
				}				
			}
		});
		t_Username.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sUsername = t_Username.getText().trim();
					if (new EmployeeServiceImpl().isUsernameBeenUse(sUsername))
					{
						Tool.alert(" 員工帳號已被使用， 請重新輸入！");
					}
				}			
			} );
		t_Username.setColumns(10);
		t_Username.setBounds(260, 132, 207, 26);
		panel_2.add(t_Username);
		
		t_Password = new JTextField(oneEmployUI.getPassword());
		t_Password.setColumns(10);
		t_Password.setBounds(260, 172, 207, 26);
		panel_2.add(t_Password);
		
		JButton bntDelete = new JButton("刪 除");
		bntDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeServiceImpl().deleteEmployeeById(oneEmployUI.getId());
				String msg = "員工: " + t_Name.getText() + " 已被刪除!";
				Tool.alert(msg);
				
				EmployUI frame = new EmployUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntDelete.setBounds(113, 244, 117, 29);
		panel_2.add(bntDelete);
		
		JButton btnNewAdd = new JButton("更  新");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!t_Name.getText().equals("") && !t_Username.getText().equals("") && !t_Password.getText().equals("") )
				{
					String TUsername=t_Username.getText();
					if(new EmployeeServiceImpl().isUsernameBeenUse(TUsername))
					{
						Tool.alert(" 員工帳號已被使用， 請重新輸入！");
					}
					else
					{
						oneEmployUI.setName(t_Name.getText());
						oneEmployUI.setUsername(t_Username.getText());
						oneEmployUI.setPassword(t_Password.getText());
						new EmployeeServiceImpl().updateEmployee(oneEmployUI);
						
						Tool.alert(" 更 新 成 功！");
						EmployUI frame = new EmployUI();
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
		btnNewAdd.setBounds(371, 244, 117, 29);
		panel_2.add(btnNewAdd);
		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployUI frame = new EmployUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(242, 244, 117, 29);
		panel_2.add(bntQuery);


	}
}
