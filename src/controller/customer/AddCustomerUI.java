package controller.customer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import controller.factory.FactoryUI;
import controller.item.ItemUI;
import controller.orders.OrdersUI;
import model.Customer;
import model.Employee;
import service.impl.CustomerServiceImpl;
import util.ClockPanel;
import util.Tool;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddCustomerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tcustomerno;
	private JTextField tcustomername;
	private JTextField tcustomeradds;
	private JTextField tcustomernote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerUI frame = new AddCustomerUI();
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
	public AddCustomerUI() throws ParseException {
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
		
		
		
		JLabel lblNewLabel = new JLabel("客戶基本資料 - 新增作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(302, 3, 241, 26);
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
		
		JButton btnReport = new JButton("報表作業");
		btnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ReportUI frame;
					frame = new ReportUI();
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
		

		JLabel lblNewLabel_2 = new JLabel("客戶編號：");
		lblNewLabel_2.setBounds(110, 60, 75, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("客戶名稱：");
		lblNewLabel_2_1.setBounds(110, 120, 75, 16);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("電      話：");
		lblNewLabel_2_2.setBounds(110, 170, 75, 16);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("地       址：");
		lblNewLabel_2_3.setBounds(110, 220, 75, 16);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("備       註：");
		lblNewLabel_2_4.setBounds(110, 270, 75, 16);
		panel_2.add(lblNewLabel_2_4);
		
		tcustomerno = new JTextField();
		tcustomerno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String scustomerno = tcustomerno.getText().trim();
				Customer thisCustomer = new CustomerServiceImpl().findByCustomerno(scustomerno);
				if(thisCustomer != null)
				{
					Tool.alert(" 客戶編號已存在， 請重新輸入！");
				}
			}
		});
		tcustomerno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String scustomerno = tcustomerno.getText().trim();
				Customer thisCustomer = new CustomerServiceImpl().findByCustomerno(scustomerno);
				if(thisCustomer != null)
				{
					Tool.alert(" 客戶編號已存在， 請重新輸入！");
				}
			}
		});
		tcustomerno.setBounds(216, 57, 104, 35);
		panel_2.add(tcustomerno);
		tcustomerno.setColumns(10);
		
		tcustomername = new JTextField();
		tcustomername.setColumns(10);
		tcustomername.setBounds(216, 107, 211, 35);
		panel_2.add(tcustomername);

		
		
// tel formatter	
		MaskFormatter mf2 = new MaskFormatter("##-*###-###*");
// for 	JFormattedTextField
		JFormattedTextField formattedTextField = new JFormattedTextField(mf2);
		formattedTextField.setBounds(216, 157, 211, 35);
		panel_2.add(formattedTextField);
		
		tcustomeradds = new JTextField();
		tcustomeradds.setColumns(10);
		tcustomeradds.setBounds(216, 215, 211, 35);
		panel_2.add(tcustomeradds);
		
		tcustomernote = new JTextField();
		tcustomernote.setColumns(10);
		tcustomernote.setBounds(216, 265, 211, 35);
		panel_2.add(tcustomernote);
		
		JButton bntQuery = new JButton("回上頁");
		bntQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerUI frame = new CustomerUI();
				frame.setVisible(true);
				dispose();
			}
		});
		bntQuery.setBounds(98, 345, 117, 29);
		panel_2.add(bntQuery);

		JButton btnNewAdd = new JButton("新  增");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if (!tcustomerno.getText().equals("") && !tcustomername.getText().equals("") )
					{
					// check customer
						String Customerno=tcustomerno.getText();
						if(new CustomerServiceImpl().isCustomernoBeenUse(Customerno))
						{
							Tool.alert(" 客戶編號 已被使用， 請重新輸入！");
						}
						else
						{
							String Customer_no=tcustomerno.getText();
							String Customer_name=tcustomername.getText();
							String Customer_tel=formattedTextField.getText();
							String Customer_adds=tcustomeradds.getText();
							String Customer_note=tcustomernote.getText();
							
							Customer onecustomer = new Customer(Customer_no, Customer_name, Customer_tel, Customer_adds, Customer_note);
							new CustomerServiceImpl().addCustomer(onecustomer);
							
							Tool.alert(" 客 戶， 新增成功！");
							tcustomerno.setText("");
							tcustomername.setText("");
							formattedTextField.setText("");
							tcustomeradds.setText("");
							tcustomernote.setText("");
						}
					}
					else
					{
						Tool.alert("  輸入錯誤，\\n  編號及名稱  不可有空欄位，\n    請重新輸入！");
					}	
				
			}
		});
		btnNewAdd.setBounds(341, 345, 117, 29);
		panel_2.add(btnNewAdd);

		
		
	}
}
