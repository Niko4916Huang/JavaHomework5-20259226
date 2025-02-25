package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import service.impl.EmployeeServiceImpl;
import model.Employee;
import controller.LoginUI;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddEmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField employNo;
	private JTextField employName;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeUI frame = new AddEmployeeUI();
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
	public AddEmployeeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
// page title		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));
		panel.setBounds(32, 6, 388, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("新員工註冊作業");
		lblNewLabel_1.setForeground(new Color(12, 35, 255));
		lblNewLabel_1.setBounds(98, 10, 192, 40);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblNewLabel = new JLabel("員工編號：");
		lblNewLabel.setBounds(75, 93, 74, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("員工姓名：");
		lblNewLabel_2.setBounds(75, 121, 74, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("員工帳號：");
		lblNewLabel_3.setBounds(75, 149, 74, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("登入密碼：");
		lblNewLabel_4.setBounds(75, 177, 74, 16);
		contentPane.add(lblNewLabel_4);
		
// error message
		JLabel errorMsg = new JLabel(" 輸入錯誤， 請重新輸入！");
		errorMsg.setForeground(new Color(255, 31, 32));
		errorMsg.setBounds(146, 205, 234, 25);
		errorMsg.setVisible(false);
		getContentPane().add(errorMsg);	
		
		employNo = new JTextField();
		employNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		employNo.setBounds(184, 88, 196, 26);
		contentPane.add(employNo);
		employNo.setColumns(10);
		
		employName = new JTextField();
		employName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		employName.setColumns(10);
		employName.setBounds(184, 116, 196, 26);
		contentPane.add(employName);
		
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		username.setColumns(10);
		username.setBounds(184, 144, 196, 26);
		contentPane.add(username);
		
		password = new JTextField();
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		password.setColumns(10);
		password.setBounds(184, 172, 196, 26);
		contentPane.add(password);
		
		JButton btnReturn = new JButton("回到登入頁面");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginui = new LoginUI();
				loginui.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(62, 231, 117, 29);
		contentPane.add(btnReturn);
		
		JButton btnRegister = new JButton("註 冊");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			if (!employNo.getText().equals("") && !employName.getText().equals("") && !username.getText().equals("") 
					&& !password.getText().equals("") )
			{
				// check employee no
				String Employno=employNo.getText();
				if(new EmployeeServiceImpl().isEmployeenoBeenUse(Employno))
				{
					errorMsg.setText(" 員工編號重複， 請重新輸入！");
					errorMsg.setVisible(true);
				}
				else
				{
					String Username=username.getText();
					if(new EmployeeServiceImpl().isUsernameBeenUse(Username))
					{
						errorMsg.setText(" 員工帳號已被使用， 請重新輸入！");
						errorMsg.setVisible(true);
					}
					else
					{
						String Employeeno=employNo.getText();
						String Employeename=employName.getText();
						String EmployeeUsername=username.getText();
						String EmployeePassword=password.getText();
						
						Employee employee = new Employee(Employeeno, Employeename, EmployeeUsername, EmployeePassword);
						new EmployeeServiceImpl().addEmployee(employee);
						
						errorMsg.setForeground(Color.blue);
						errorMsg.setBackground(Color.gray);
						errorMsg.setText(" 新員工註冊成功， 請重新登入！");
						errorMsg.setVisible(true);
						
						
						int delay = 2000;
						Timer timer = new Timer( delay, new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							LoginUI loginui = new LoginUI();
							loginui.setVisible(true);
							dispose();
						}
						});
						timer.setRepeats(false);
						timer.start();
												
					}
				}
				
			}
		  }
		});
		btnRegister.setBounds(287, 231, 117, 29);
		contentPane.add(btnRegister);
	}
}
