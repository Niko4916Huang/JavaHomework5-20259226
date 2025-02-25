package controller.orders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.item.ItemUI;
import model.Customer;
import model.Employee;
import model.Orders;
import service.impl.CustomerServiceImpl;
import service.impl.OrdersServiceImpl;
import util.ClockPanel;
import util.Tool;

public class QueryOrdersUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryOrdersUI frame = new QueryOrdersUI();
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
	public QueryOrdersUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	// read parameters
			Employee employee = (Employee) Tool.read("employee.txt");
			Orders orders  = (Orders) Tool.read("orders.txt");
			
			String OrdersEmployeeno = orders.getOrdersemployeeno();
			// employee.getName()
			String OrdersDate = orders.getOrdersdate();
			String OrdersCustomerno = orders.getOrderscustomerno();
			Customer oneCustomer = new CustomerServiceImpl().findByCustomerno(OrdersCustomerno);
			String OrdersCustomername = oneCustomer.getCustomername();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("銷貨作業 - 查詢");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(320, 3, 205, 26);
		panel.add(lblNewLabel);
		
		JLabel employeeNameLb = new JLabel("使用員工："+employee.getName());
		employeeNameLb.setBounds(6, 11, 124, 16);
		panel.add(employeeNameLb);
		
	// 小時鐘介面
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.setBackground(new Color(205, 255, 239));
        clockPanel.setBounds(667, 3, 90, 32);
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
		btnReport.setBounds(0, 105, 117, 29);
		panel_1.add(btnReport);
		
/*******************************************************************/
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(4, 356, 117, 29);
		panel_1.add(btnExit);
		
		JButton btnOrders = new JButton("銷貨作業");
		btnOrders.setEnabled(false);
		btnOrders.setBounds(2, 65, 117, 29);
		panel_1.add(btnOrders);
		
		JButton btnReceiving_1_1 = new JButton(" 基本資料");
		btnReceiving_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnReceiving_1_1.setBounds(0, 150, 117, 29);
		panel_1.add(btnReceiving_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 10, 630, 350);
		panel_2.add(scrollPane);
		
		JTextArea output = new JTextArea();
		output.setEditable(false);
		scrollPane.setViewportView(output);	
		
		String show = new OrdersServiceImpl().orderbyOneCustomerno(OrdersDate, OrdersDate, OrdersCustomerno);
		//System.out.println(show);
		String 	showout = "";
		if (show.length() > 0)
		{
			 		showout  = "客戶名稱："+OrdersCustomerno+" - "+OrdersCustomername+" \n";
					showout += "銷貨日期\t商品編號\t商品名稱\t廠商編號\t售 價\t訂購量\t小 計 \n";
					showout += "=============================================================================================\n";		
		}
		else
		{
			showout = " >>>>> 查無本日: " + OrdersDate + " <<<<<   客戶："+OrdersCustomerno+" - "+OrdersCustomername + " 的銷貨資料! \n\n";
			show = new OrdersServiceImpl().orderbyCustomerno(OrdersDate, OrdersDate);
			if (show.length() > 0)
			{
				showout += "商品編號\t商品名稱\t銷貨日期\t客戶編號\t客戶名稱\t售 價\t訂購量\t小 計 \n";
				showout += "=============================================================================================\n";
			}		
		}
		output.setText(showout + show);
		
		JButton btnNewButton = new JButton("回上頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					OrdersUI frame = new OrdersUI();
					frame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setBounds(269, 375, 117, 29);
		panel_2.add(btnNewButton);
	}

}
