package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;
import controller.employee.AddEmployeeUI;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工帳號：");
		lblNewLabel.setBounds(87, 104, 79, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("登入密碼：");
		lblPassword.setBounds(87, 148, 79, 16);
		contentPane.add(lblPassword);
		

// error message
		JLabel errorMsg = new JLabel(" 輸入錯誤， 請重新輸入！");
		errorMsg.setForeground(new Color(255, 31, 32));
		errorMsg.setBounds(150, 183, 226, 25);
		errorMsg.setVisible(false);
		getContentPane().add(errorMsg);		

// username
		username = new JTextField();
		username.setText("admin");
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		username.setBounds(178, 99, 178, 26);
		contentPane.add(username);
		username.setColumns(10);
		
// password
		password = new JTextField();
		password.setText("admin");
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMsg.setVisible(false);
			}
		});
		password.setBounds(178, 143, 178, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		
// page title		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));
		panel.setBounds(32, 6, 388, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("進銷存貨作業 - 登入");
		lblNewLabel_1.setForeground(new Color(12, 35, 255));
		lblNewLabel_1.setBounds(70, 10, 294, 40);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
// exit button
		JButton exitButton = new JButton("離 開");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(32, 226, 117, 29);
		getContentPane().add(exitButton);
		
//  confirm button
		JButton loginButton = new JButton("確 認");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username = username.getText();
				String Password = password.getText();
				
				Employee employee = new EmployeeServiceImpl().Login(Username, Password);
				
				if(employee!=null)
				{
					
					Tool.save(employee, "employee.txt");
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
				else
				{
					errorMsg.setVisible(true);
				}
				
				
			}
		});
		loginButton.setBounds(168, 226, 117, 29);
		contentPane.add(loginButton);

// 註 冊
		JButton btnRegister = new JButton("新員工註冊");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddEmployeeUI addemployee=new AddEmployeeUI();
				addemployee.setVisible(true);
				dispose();

			}
		});
		btnRegister.setBounds(303, 226, 117, 29);
		contentPane.add(btnRegister);

	}
}
