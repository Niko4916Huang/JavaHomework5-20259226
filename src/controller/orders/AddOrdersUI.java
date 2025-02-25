package controller.orders;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.item.ItemUI;
import dao.impl.CustomerDaoImpl;
import dao.impl.ItemDaoImpl;
import dao.impl.OrdersDaoImpl;
import dao.impl.Serial_noDaoImpl;
import model.Customer;
import model.Employee;
import model.Item;
import model.Serial_no;
import model.Orders;
import service.impl.ItemServiceImpl;
import util.ClockPanel;
import util.Tool;

public class AddOrdersUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tordersqty;
	private boolean overWriteSerial_number = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrdersUI frame = new AddOrdersUI();
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
	public AddOrdersUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Orders orders  = (Orders) Tool.read("orders.txt");
		//String show = new ReceivedDaoImpl().orderbyItemno(received.getIndate(), received.getIndate());
		String OrdersEmployeeno = orders.getOrdersemployeeno();
		// employee.getName()
		String OrdersDate = orders.getOrdersdate();
		String Orderscustomerno = orders.getOrderscustomerno();
		List<Customer> listCustomer = new CustomerDaoImpl().selectByCustomerno(Orderscustomerno);
		Customer oneCustomer=listCustomer.get(0);
		String Orderscustomername = oneCustomer.getCustomername();
		
		// get the next serial number to use
		List<Serial_no> listSerial_no=new Serial_noDaoImpl().selectBySerial_name("orders");
		Serial_no oneSerial_no=listSerial_no.get(0);
		int Ordersserial_number = oneSerial_no.getSerial_number()+1;
		overWriteSerial_number = false;
		
		JLabel lblNewLabel = new JLabel("銷貨作業 - 商品訂購作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(304, 3, 305, 26);
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
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		btnExit.setBounds(4, 356, 117, 29);
		panel_1.add(btnExit);
		
		JButton btnorders = new JButton("銷貨作業");
		btnorders.setBounds(2, 65, 117, 29);
		panel_1.add(btnorders);
		
		JButton btnNewButton_2 = new JButton(" 基本資料");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(2, 145, 117, 29);
		panel_1.add(btnNewButton_2);

/*******************************************************************/			
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		String outputMsg  = "商品編號\t商品名稱\t  廠商編號\t售 價\t訂購量\n";
			   outputMsg += "========================================================\n";

				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 10, 637, 290);
		panel_2.add(scrollPane);
				
		JTextArea output = new JTextArea(outputMsg);
		output.setEditable(false);
		scrollPane.setViewportView(output);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(205, 255, 239));
		panel_4.setBounds(13, 312, 637, 90);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		String ordersmsg = "";
		JLabel lblOrdersdate = new JLabel("訂購日期：");	// OrdersDate
		lblOrdersdate.setBounds(16, 9, 241, 20);
		panel_4.add(lblOrdersdate);		
		ordersmsg = "訂購日期：" + OrdersDate;
		lblOrdersdate.setText(ordersmsg);
		
		JLabel lblOrderscustomer = new JLabel("客戶名稱：");
		lblOrderscustomer.setBounds(16, 34, 241, 20);
		panel_4.add(lblOrderscustomer);
		ordersmsg = "客戶名稱：" + Orderscustomerno + "-" + Orderscustomername;
		lblOrderscustomer.setText(ordersmsg);
		
		JLabel lblOrdersseria_number = new JLabel("訂單編號:");
		lblOrdersseria_number.setBounds(16, 60, 241, 20);
		panel_4.add(lblOrdersseria_number);
		ordersmsg = "訂單編號：" + Ordersserial_number;
		lblOrdersseria_number.setText(ordersmsg);
		
		
		JLabel lblNewLabel_2 = new JLabel("商品編號：");
		lblNewLabel_2.setBounds(269, 21, 79, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("訂購數量：");
		lblNewLabel_2_1.setBounds(269, 55, 79, 16);
		panel_4.add(lblNewLabel_2_1);
			
//		comboBox List data	
			List<String> itemlist = new ArrayList<String>();
			
			List<Item> listdata=new ItemDaoImpl().selectAll();	
			for(Item oneData:listdata)
			{
				String selectItem = oneData.getItemno() + "-" + oneData.getItemname();
				itemlist.add(selectItem);
			}
			String[] item = new String[itemlist.size()];
			itemlist.toArray(item);
//	end of	comboBox List data	
		JComboBox searchingBox = new JComboBox(item);
		searchingBox.setBounds(352, 17, 166, 26);
		panel_4.add(searchingBox);
		
		tordersqty = new JTextField();
		tordersqty.setColumns(10);
		tordersqty.setBounds(360, 50, 71, 26);
		panel_4.add(tordersqty);
		
		JButton btnNewButton = new JButton("結 束");
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
		btnNewButton.setBounds(530, 16, 87, 29);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("新 增");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strSelected = searchingBox.getSelectedItem().toString();
				String[] words = strSelected.split("-");
				String sItemno = words[0];
				
				if ((tordersqty.getText().length() > 0))
				{
					int outqty=Integer.parseInt(tordersqty.getText());
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem == null)
					{
						Tool.alert(" 商品編號不存在， 請重新輸入！");
					}
					else
					{
						if (outqty > 0)
						{//outputMsg += "商品編號\t商品名稱\t廠商編號 售 價 訂購量\n";
							Orders orders = new Orders(OrdersEmployeeno, OrdersDate, Orderscustomerno, Ordersserial_number, sItemno, outqty);
							new OrdersDaoImpl().add(orders);
							
					// write serial_number 
							if (!overWriteSerial_number)
							{
								oneSerial_no.setSerial_number( oneSerial_no.getSerial_number() + 1);	
								new Serial_noDaoImpl().update(oneSerial_no);
								overWriteSerial_number = true;
							}
					// change inventory
							thisItem.setQty(thisItem.getQty() - outqty);
							new ItemServiceImpl().updateItem(thisItem);
							
							
							String Msg = output.getText();
							Msg += sItemno +"\t"+ thisItem.getItemname() +"\t "+ thisItem.getFactoryno() +"\t";
							Msg += thisItem.getPrice()+"\t" + outqty +"\n";
							output.setText(Msg);
							tordersqty.setText("");
						}
						else
						{
							Tool.alert(" 沒有訂購數量， 請重新輸入！");
						}
					}
				}				
			}
		});
		btnNewButton_1.setBounds(530, 50, 87, 29);
		panel_4.add(btnNewButton_1);

	}
}
