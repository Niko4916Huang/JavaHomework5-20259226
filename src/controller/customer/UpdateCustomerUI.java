package controller.customer;

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
import controller.factory.FactoryUI;
import controller.item.ItemUI;
import controller.orders.OrdersUI;
import model.Employee;
import model.Customer;
import service.impl.CustomerServiceImpl;
import util.ClockPanel;
import util.Tool;
import javax.swing.JFormattedTextField;

public class UpdateCustomerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					UpdateCustomerUI frame = new UpdateCustomerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public UpdateCustomerUI() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Customer oneCustomer = (Customer) Tool.read("customerUI.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("客戶基本資料 - 更新作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(287, 3, 241, 26);
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
		btncustomer.setEnabled(false);
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
		
	
		JLabel lblItemno = new JLabel(oneCustomer.getCustomerno());
		lblItemno.setBounds(235, 62, 231, 27);
		panel_2.add(lblItemno);
		
		tcustomername = new JTextField(oneCustomer.getCustomername());
		tcustomername.setBounds(230, 104, 261, 39);
		panel_2.add(tcustomername);
		tcustomername.setColumns(10);
		
		
// tel formatter	
		MaskFormatter mf2 = new MaskFormatter("##-*###-###*");
// for 	JFormattedTextField
		
		JFormattedTextField formattedTextField = new JFormattedTextField(mf2);
		formattedTextField.setText(oneCustomer.getCustomertel());
		formattedTextField.setBounds(230, 160, 261, 39);
		panel_2.add(formattedTextField);
		
		
		tcustomeradds = new JTextField(oneCustomer.getCustomeradds());
		tcustomeradds.setColumns(10);
		tcustomeradds.setBounds(230, 210, 261, 39);
		panel_2.add(tcustomeradds);
		
		tcustomernote = new JTextField(oneCustomer.getCustomernote());
		tcustomernote.setColumns(10);
		tcustomernote.setBounds(230, 260, 261, 39);
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
		
		JButton btnNewAdd = new JButton("更  新");
		btnNewAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if (!tcustomername.getText().equals("") )
				{
					
					oneCustomer.setCustomername(tcustomername.getText());
					oneCustomer.setCustomertel(formattedTextField.getText());
					oneCustomer.setCustomeradds(tcustomeradds.getText());
					oneCustomer.setCustomernote(tcustomernote.getText());
					
					new CustomerServiceImpl().updateCustomer(oneCustomer);
					
					Tool.alert(" 更 新 成 功！");
					CustomerUI frame = new CustomerUI();
					frame.setVisible(true);
					dispose();
										
				}
				else
				{
					Tool.alert(" 輸入錯誤，\n '客戶名稱' 不可有空欄位，\n    請重新輸入！");
				}
				
			}
		});
		btnNewAdd.setBounds(341, 345, 117, 29);
		panel_2.add(btnNewAdd);

		
		
	}
}
