package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JRadioButton;
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
import controller.Reporting.ItemInventoryUI;
import controller.Reporting.OrdersReportUI;
import controller.Reporting.ReportingUI;
import controller.orders.OrdersUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReportUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportUI frame = new ReportUI();
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
	public ReportUI() throws Exception {
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
		
		
		
		JLabel lblNewLabel = new JLabel("進 貨 報 表 作 業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(322, 3, 201, 26);
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
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
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
		btnreceiving.setEnabled(false);
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
		
		/***************************************************************/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_2.setBounds(155, 47, 656, 410);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("進貨日期：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(130, 36, 97, 23);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("起： ");
		lblNewLabel_2_1.setBounds(175, 69, 41, 16);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("迄：");
		lblNewLabel_2_2.setBounds(175, 110, 41, 16);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("排列選項：");
		lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(130, 161, 97, 23);
		panel_2.add(lblNewLabel_2_3);
		
		JRadioButton select0 = new JRadioButton("依 商品 編號 - 列印明細");
		select0.setSelected(true);
		select0.setBounds(257, 182, 242, 23);
		panel_2.add(select0);
		
		JRadioButton select1 = new JRadioButton("依 廠商 編號 - 列印明細");
		//select1.setSelected(true);
		select1.setBounds(257, 217, 242, 23);
		panel_2.add(select1);
				
		JRadioButton select2 = new JRadioButton("依 商品 - 統計");
		select2.setBounds(257, 252, 141, 23);
		panel_2.add(select2);
		
		JRadioButton select3 = new JRadioButton("依 廠商 - 統計");
		select3.setBounds(257, 287, 141, 23);
		panel_2.add(select3);
		
		
		// Group the radio buttons
		ButtonGroup selectingGroup = new ButtonGroup();
		selectingGroup.add(select0);
		selectingGroup.add(select1);
		selectingGroup.add(select2);
		selectingGroup.add(select3);
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date current = new Date();
		// date formatter	
			MaskFormatter mf2From = new MaskFormatter("####/##/##");
			MaskFormatter mf2To = new MaskFormatter("####/##/##");
		// for 	JFormattedTextField
		
		JFormattedTextField indatFrom = new JFormattedTextField(mf2From);
		indatFrom.setText(sdFormat.format(current));
		indatFrom.setBounds(238, 66, 124, 21);
		panel_2.add(indatFrom);
	
		JFormattedTextField indateTo = new JFormattedTextField(mf2To);
		indateTo.setText(sdFormat.format(current));
		indateTo.setBounds(238, 107, 124, 21);
		panel_2.add(indateTo);
	

		JButton btnPickDateFrom = new JButton("日曆");
		btnPickDateFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create frame new object  f
				final JFrame f_from = new JFrame();
				//set text which is collected by date picker i.e. set date 				
				indatFrom.setText(new DatePicker(f_from).setPickedDate());
			}
		});
		btnPickDateFrom.setBounds(382, 64, 69, 29);
		panel_2.add(btnPickDateFrom);				
		
		JButton btnPickDateTo = new JButton("日曆");
		btnPickDateTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create frame new object  f
				final JFrame f_to = new JFrame();
				//set text which is collected by date picker i.e. set date 				
				indateTo.setText(new DatePicker(f_to).setPickedDate());
			}
		});
		btnPickDateTo.setBounds(382, 105, 69, 29);
		panel_2.add(btnPickDateTo);

		
		JButton btnNewButton = new JButton("查 詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				// order by 
				Integer orderby = 0;		// order by itemno
				if (select1.isSelected())
				{
					orderby = 1;			// order by factoryno
				}
				if (select2.isSelected())
				{
					orderby = 2;			// group by itemno
				}
				if (select3.isSelected())
				{
					orderby = 3;			// group by factoryno
				}
				
				String QuerydateFr = indatFrom.getText();
				String QuerydateTo = indateTo.getText();
				
				if (QuerydateTo.compareTo(QuerydateFr) >= 0)
				{
					//System.out.println("QuerydateTo is bigger");
					Received received = new Received(QuerydateFr, QuerydateTo, "0000", orderby);
					Tool.save(received, "received.txt");
				}
				else
				{
					//System.out.println("QuerydateTo is smaller");
					Received received1 = new Received(QuerydateFr, QuerydateFr, "0000", orderby);				
					Tool.save(received1, "received.txt");
				}

				ReportingUI frame = new ReportingUI();
				frame.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setBounds(270, 340, 117, 29);
		panel_2.add(btnNewButton);
	
	}
}
