package controller.orders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.item.ItemUI;
import model.Customer;
import model.Employee;
import model.Orders;
import service.impl.CustomerServiceImpl;
import util.ClockPanel;
import util.DatePicker;
import util.Tool;


public class OrdersUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersUI frame = new OrdersUI();
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
	public OrdersUI() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		//Received received  = (Received) Tool.read("received.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("銷 貨 作 業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(334, 3, 118, 26);
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
		

		JButton btnReceiving_1 = new JButton("銷貨作業");
		btnReceiving_1.setEnabled(false);
		btnReceiving_1.addMouseListener(new MouseAdapter() {
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
		btnReceiving_1.setBounds(2, 65, 117, 29);
		panel_1.add(btnReceiving_1);
		
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
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(2, 356, 117, 29);
		panel_1.add(btnExit);
		
		JButton btnbase = new JButton(" 基本資料");
		btnbase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnbase.setBounds(2, 145, 117, 29);
		panel_1.add(btnbase);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(167, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
/*******************************************************************/
	
		JLabel lblNewLabel_2 = new JLabel("銷貨日期：");
		lblNewLabel_2.setBounds(155, 86, 81, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("客戶編號：");
		lblNewLabel_2_1.setBounds(155, 144, 81, 16);
		panel_2.add(lblNewLabel_2_1);
		
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date current = new Date();
	// date formatter	
			MaskFormatter mf2 = new MaskFormatter("####/##/##");
	// for 	JFormattedTextField
			
		JFormattedTextField ordersDate = new JFormattedTextField(mf2);
		ordersDate.setText(sdFormat.format(current));
		ordersDate.setBounds(248, 81, 107, 26);
		panel_2.add(ordersDate);		
		
		JButton btnPickDate = new JButton("日曆");
		btnPickDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 				
				ordersDate.setText(new DatePicker(f).setPickedDate());
			}
		});
		btnPickDate.setBounds(364, 81, 69, 29);
		panel_2.add(btnPickDate);
		
		
//		comboBox List data	
			List<String> itemlist = new ArrayList<String>();
			
			List<Customer> listdata=new CustomerServiceImpl().findAllCustomer();	
			for(Customer oneData:listdata)
			{
				String selectItem = oneData.getCustomerno() + "-" + oneData.getCustomername();
				itemlist.add(selectItem);
			}
			String[] item = new String[itemlist.size()];
			itemlist.toArray(item);
//	end of	comboBox List data			
			JComboBox searchingBox = new JComboBox(item);
			searchingBox.setBounds(248, 140, 176, 26);
			panel_2.add(searchingBox);	
		
		JButton btnNewadd = new JButton("新  增");
		btnNewadd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Querydate = ordersDate.getText();
				String strSelected = searchingBox.getSelectedItem().toString();
				String[] words = strSelected.split("-");
				String sCustomerno = words[0];
				
				Orders orders = new Orders(employee.getEmployeeno(), Querydate, sCustomerno, 0, " ", 0);				
				Tool.save(orders, "orders.txt");
				
				AddOrdersUI frame = new AddOrdersUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewadd.setBounds(316, 218, 117, 29);
		panel_2.add(btnNewadd);
		
		JButton btnQuery = new JButton("查  詢");
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Querydate = ordersDate.getText();
				String strSelected = searchingBox.getSelectedItem().toString();
				String[] words = strSelected.split("-");
				String sCustomerno = words[0];
				
				Orders orders = new Orders(employee.getEmployeeno(), Querydate, sCustomerno, 0, " ", 0);				
				Tool.save(orders, "orders.txt");
				
				QueryOrdersUI frame = new QueryOrdersUI();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnQuery.setBounds(155, 218, 117, 29);
		panel_2.add(btnQuery);


		
	}
}
