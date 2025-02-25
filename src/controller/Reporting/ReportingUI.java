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
import model.Employee;
import model.Received;
import service.impl.ReceivedServiceImpl;
import util.ClockPanel;
import util.Tool;
import util.Tool2;

public class ReportingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportingUI frame = new ReportingUI();
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
	public ReportingUI() {
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
		
		JLabel lblNewLabel = new JLabel("進 貨 報 表 查 詢");
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
		btnreceiving.setEnabled(false);
		btnreceiving.setBounds(6, 34, 95, 29);
		panel_3.add(btnreceiving);
		
		JButton btnorders = new JButton("銷 貨");
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
		
		JButton btnCsv = new JButton("輸出 CSV");
		btnCsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String csvFile = "Receivingdata.csv"; // Name of the CSV file 		
		        
				String strFrom = 	"起："+received.getIndate();
				String strTo = "迄："+received.getItemno();
				
				String[] headers = {"進貨日期", "商品編號", "商   品   名   稱", "廠商編號", "進 價", "售 價", "進貨量"}; // CSV headers 
				
				switch(received.getInqty())
				{
				case 1:
					// order by factoryno
					//Ordering = "==> 依 [廠商] 編號排列 - 列印明細";
					String[] titles1 = {"依 [廠商] 編號排列", " - 列印明細 ", " ", "查詢日期 - ",  strFrom, strTo};
					//show = new ReceivedServiceImpl().orderbyFactoryno(received.getIndate(), received.getItemno());
					String[][] data1 = new ReceivedServiceImpl().csvOrderbyFactoryno(received.getIndate(), received.getItemno());
					Tool2.csvWrite(csvFile, titles1, headers, data1);
					break;
				case 2:
					//Ordering = "==> 依 [商品] 編號 - 統計";
					
					String[] titles2 = {"依 [商品] 編號", " - 統計 ", " ", "查詢日期 - ",  strFrom, strTo};
					String[] headers2 = {"商品編號", "商   品   名   稱", "廠商編號", "進 價", "售 價", "進貨量", "小    計"}; // CSV headers
					//show = new ReceivedServiceImpl().groupbyItemno(received.getIndate(), received.getItemno());
					String[][] data2 = new ReceivedServiceImpl().csvGroupbyItemno(received.getIndate(), received.getItemno());
					Tool2.csvWrite(csvFile, titles2, headers2, data2);
					break;
				case 3:
					//Ordering = "==> 依 [廠商] 編號 - 統計";
					String[] titles3 = {"依 [廠商] 編號", " - 統計 ", " ", "查詢日期 - ",  strFrom, strTo};
					String[] headers3 = {"廠商編號", "商品編號", "商   品   名   稱",  "進 價", "進貨量", "小    計"}; // CSV headers
					//show = new ReceivedServiceImpl().groupbyFactoryno(received.getIndate(), received.getItemno());
					String[][] data3 = new ReceivedServiceImpl().csvGroupbyFactoryno(received.getIndate(), received.getItemno());
					Tool2.csvWrite(csvFile, titles3, headers3, data3);
					break;
				default:
					// Inqty == 0, order by itemno
					//"進貨日期\t商品編號\t商品名稱\t廠商編號\t進 價\t售 價\t進貨量\n";	
					String[] titles0 = {"依 [商品] 編號排列", " - 列印明細 ", " ", "查詢日期 - ",  strFrom, strTo};
					
					//show = new ReceivedServiceImpl().orderbyItemno(received.getIndate(), received.getItemno());
					String[][] data = new ReceivedServiceImpl().csvOrderbyItemno(received.getIndate(), received.getItemno());
					Tool2.csvWrite(csvFile, titles0, headers, data);
					break;
				}				
		                       
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
		btnCsv.setBounds(442, 375, 117, 29);
		panel_2.add(btnCsv);
	
		
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
			// order by factoryno
			Ordering = "==> 依 [廠商] 編號排列 - 列印明細";
			show = new ReceivedServiceImpl().orderbyFactoryno(received.getIndate(), received.getItemno());
			break;
		case 2:
			Ordering = "==> 依 [商品] 編號 - 統計";
			show = new ReceivedServiceImpl().groupbyItemno(received.getIndate(), received.getItemno());
			break;
		case 3:
			Ordering = "==> 依 [廠商] 編號 - 統計";
			show = new ReceivedServiceImpl().groupbyFactoryno(received.getIndate(), received.getItemno());
			break;
		default:
			// Inqty == 0, order by itemno
			show = new ReceivedServiceImpl().orderbyItemno(received.getIndate(), received.getItemno());
			break;
		}
		
		String 	showout = "查詢日期 - 起："+received.getIndate()+"   迄："+received.getItemno()+"\t"+Ordering+"\n";
		//System.out.println(show);
		if (show.length() > 0)
		{			
			switch(received.getInqty())
			{
			case 2:
				showout += "商品編號\t商品名稱\t廠商編號\t進 價\t售 價\t進貨量\t小 計\n";		
				break;
			case 3:
				showout += "廠商編號\t商品編號\t商品名稱\t進 價\t進貨量\t小 計\n";
				break;
			default:
				// Inqty == 0, order by itemno
				showout += "進貨日期\t商品編號\t商品名稱\t廠商編號\t進 價\t售 價\t進貨量\n";	
				break;
			}
			showout += "=================================================================================\n";
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

		btnReturn.setBounds(82, 375, 117, 29);
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
		btnPrint.setBounds(266, 375, 117, 29);
		panel_2.add(btnPrint);
		

	
		
	}

}
