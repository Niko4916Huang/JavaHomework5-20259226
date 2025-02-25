package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;

import model.Employee;
import model.Received;
import util.ClockPanel;
import util.DatePicker;
import util.Tool;
import controller.item.ItemUI;
import controller.receiving.AddReceivingUI;
import controller.receiving.QueryReceivingUI;
import controller.orders.OrdersUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ReceivingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivingUI frame = new ReceivingUI();
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
	public ReceivingUI() throws Exception {
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
		
		
		
		JLabel lblNewLabel = new JLabel("進 貨 作 業");
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
		btnReceiving.setEnabled(false);
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
		
		
		JButton btnExit = new JButton("登  出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(2, 356, 117, 29);
		panel_1.add(btnExit);
		
		/*******************************************************************/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(167, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		/*
		 * 
		 * DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
      		JFormattedTextField today = new JFormattedTextField(dateFormat);
      
      //  直接格式化輸出現在時間的方法
         SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd 
                                     HH:mm:ss.SSS");
         Date current = new Date();
         System.out.println(sdFormat.format(current));
      
		 */
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date current = new Date();
	// date formatter	
			MaskFormatter mf2 = new MaskFormatter("####/##/##");
	// for 	JFormattedTextField
			
		JFormattedTextField receivingDate = new JFormattedTextField(mf2);
		receivingDate.setText(sdFormat.format(current));
		receivingDate.setBounds(245, 92, 107, 26);
		panel_2.add(receivingDate);		
		
		JButton btnPickDate = new JButton("日曆");
		btnPickDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 				
				receivingDate.setText(new DatePicker(f).setPickedDate());
			}
		});
		btnPickDate.setBounds(364, 92, 69, 29);
		panel_2.add(btnPickDate);
		
		JLabel lblNewLabel_2 = new JLabel("進貨日期：");
		lblNewLabel_2.setBounds(155, 97, 81, 16);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewadd = new JButton("新  增");
		btnNewadd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Querydate = receivingDate.getText();
				//System.out.println("Querydate:"+Querydate);
				Received received = new Received(Querydate, "0000", "0000", 0);				
				Tool.save(received, "received.txt");
				
				AddReceivingUI frame = new AddReceivingUI();
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
				
				String Querydate = receivingDate.getText();
				
				//System.out.println("Querydate:"+Querydate);
				Received received = new Received(Querydate, "0000", "0000", 0);				
				Tool.save(received, "received.txt");
				
				QueryReceivingUI frame = new QueryReceivingUI();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnQuery.setBounds(155, 218, 117, 29);
		panel_2.add(btnQuery);

	}
}
