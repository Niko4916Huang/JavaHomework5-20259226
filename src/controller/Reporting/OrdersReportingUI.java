package controller.Reporting;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.item.ItemUI;
import controller.orders.OrdersUI;
import dao.impl.ReceivedDaoImpl;
import model.Employee;
import model.Received;
import service.impl.OrdersServiceImpl;
import service.impl.ReceivedServiceImpl;
import util.ClockPanel;
import util.Tool;
import util.Tool2;

public class OrdersReportingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersReportingUI frame = new OrdersReportingUI();
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
	public OrdersReportingUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee employee = (Employee) Tool.read("employee.txt");
		Received received  = (Received) Tool.read("received.txt");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 255, 239));		// light green
		panel.setBounds(18, 6, 793, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("銷 貨 報 表 查 詢");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(321, 1, 198, 26);
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
		btnReceiving.setBounds(2, 24, 117, 29);
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

		JButton btnbase = new JButton(" 基本資料");
		btnbase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemUI frame = new ItemUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnbase.setBounds(2, 319, 117, 29);
		panel_1.add(btnbase);
		
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(4, 360, 117, 29);
		panel_1.add(btnExit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 110, 105, 190);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("報表作業");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 6, 77, 16);
		panel_3.add(lblNewLabel_1);
		
		JButton btnreceiving = new JButton("進 貨");
		btnreceiving.addMouseListener(new MouseAdapter() {
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
		btnreceiving.setBounds(6, 34, 95, 29);
		panel_3.add(btnreceiving);
		
		JButton btnorders = new JButton("銷 貨");
		btnorders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					OrdersReportUI frame = new OrdersReportUI();
					frame.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnorders.setBounds(6, 68, 95, 29);
		panel_3.add(btnorders);
		
		JButton btnenventory = new JButton("存 貨");
		btnenventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemInventoryUI frame = new ItemInventoryUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnenventory.setBounds(6, 102, 95, 29);
		panel_3.add(btnenventory);
		
		/*******************************************************************/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 10, 630, 355);
		panel_2.add(scrollPane);
		
		JTextArea output = new JTextArea();
		output.setEditable(false);
		scrollPane.setViewportView(output);	
		
		// Indate -> IndateFrom;  Itemno -> IndateTo
		String Ordering = "==> 依 [商品] 編號排列 - 列印明細";
		String show = "";
		switch(received.getInqty())
		{
		case 1:
			// order by customerno
			Ordering = "==> 依 [客戶] 編號排列 - 列印明細";
			show = new OrdersServiceImpl().findByIndateOrderbyCustomerno(received.getIndate(), received.getItemno());
			break;
		case 2:
			Ordering = "==> 依 [商品] 編號 - 統計";
			show = new OrdersServiceImpl().groupbyItemno(received.getIndate(), received.getItemno());
			break;
		case 3:
			Ordering = "==> 依 [客戶] 編號 - 統計";
			show = new OrdersServiceImpl().groupbyCustomerno(received.getIndate(), received.getItemno());
			break;
		default:
			// Inqty == 0, order by itemno
			show = new OrdersServiceImpl().findByIndateOrderbyItemno(received.getIndate(), received.getItemno());
			break;
		}
		
		String 	showout = "查詢日期 - 起："+received.getIndate()+"   迄："+received.getItemno()+"\t"+Ordering+"\n";
		//System.out.println(show);
		if (show.length() > 0)
		{			
			switch(received.getInqty())
			{
			case 1:
				showout += "客戶編號\t客戶名稱\t商品編號\t商品名稱\t銷貨日期\t售 價\t銷貨量\t小 計\n";		
				break;
			case 2:
				showout += "商品編號\t商品名稱\t廠商編號\t售 價\t銷貨量\t小 計\n";		
				break;
			case 3:
				showout += "客戶編號\t客戶名稱\t商品編號\t商品名稱\t售 價\t銷貨量\t小 計\n";
				break;
			default:
				// Inqty == 0, order by itemno
				showout += "商品編號\t商品名稱\t銷貨日期\t客戶編號\t客戶名稱\t售 價\t銷貨量\t小 計\n";	
				break;
			}
			showout += "=============================================================================================\n";
			output.setText(showout + show);

		}
		else
		{
			show = "查無本日: " + received.getIndate() + "進貨資料!";
			output.setText(show);
		}
		
		JButton btnReturn = new JButton("回上頁");
		btnReturn.addMouseListener(new MouseAdapter() {
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

		btnReturn.setBounds(161, 375, 117, 29);
		panel_2.add(btnReturn);
		
		JButton btnPrint = new JButton("列 印");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				} catch (Exception exc) {
					System.out.println(exc);
				}
			}
		});
		btnPrint.setBounds(384, 375, 117, 29);
		panel_2.add(btnPrint);
	}

}
