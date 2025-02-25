package controller.receiving;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ReceivingUI;
import controller.ReportUI;
import controller.item.ItemUI;
import model.Employee;
import model.Item;
import model.Received;
import service.impl.ItemServiceImpl;
import service.impl.ReceivedServiceImpl;
import util.ClockPanel;
import util.Tool;


public class AddReceivingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Tinqty;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReceivingUI frame = new AddReceivingUI();
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
	public AddReceivingUI() {
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
		Received received  = (Received) Tool.read("received.txt");
		String ReceivingDate = received.getIndate();
		
		JLabel lblNewLabel = new JLabel("商品進貨 - 新增作業");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(12, 35, 255));		// font - blue
		lblNewLabel.setBounds(284, 3, 216, 26);
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
		
		String outputMsg = "進貨日期："+ ReceivingDate +"\n";
				outputMsg += "商品編號\t商品名稱\t  廠商編號\t進 價\t進貨量\n";
				outputMsg += "========================================================\n";

				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 10, 637, 315);
		panel_2.add(scrollPane);
				
		JTextArea output = new JTextArea(outputMsg);
		output.setEditable(false);
		scrollPane.setViewportView(output);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(205, 255, 239));
		panel_4.setBounds(20, 340, 613, 61);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("商品編號：");
		lblNewLabel_2.setBounds(6, 21, 79, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("進貨量：");
		lblNewLabel_2_1.setBounds(279, 21, 62, 16);
		panel_4.add(lblNewLabel_2_1);
			
//		comboBox List data	
			List<String> itemlist = new ArrayList<String>();
			
			List<Item> listdata=new ItemServiceImpl().findAllItem();	
			for(Item oneData:listdata)
			{
				String selectItem = oneData.getItemno() + "-" + oneData.getItemname();
				itemlist.add(selectItem);
			}
			String[] item = new String[itemlist.size()];
			itemlist.toArray(item);
//	end of	comboBox List data	
		JComboBox searchingBox = new JComboBox(item);
		searchingBox.setBounds(78, 17, 166, 26);
		panel_4.add(searchingBox);
/*
		Titemno = new JTextField();
		Titemno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String sItemno = Titemno.getText().trim();
				if (sItemno.length() > 0)
				{
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem == null)
					{
						Tool.alert(" 商品編號不存在， 請重新輸入！");
					}
				}				
			}
		});
		Titemno.addActionListener(		// press ENTER will work
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {	
					// TODO Auto-generated method stub
					String sItemno = Titemno.getText().trim();
					if (sItemno.length() > 0)
					{
						Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
						if(thisItem == null)
						{
							Tool.alert(" 商品編號不存在， 請重新輸入！");
						}
					}
					
				}			
			} );
		Titemno.setBounds(75, 16, 79, 26);
		panel_4.add(Titemno);
		Titemno.setColumns(10);
*/
		
		Tinqty = new JTextField();
		Tinqty.setColumns(10);
		Tinqty.setBounds(341, 16, 71, 26);
		panel_4.add(Tinqty);
		
		JButton btnNewButton = new JButton("結 束");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		btnNewButton.setBounds(520, 16, 87, 29);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("新 增");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String strSelected = searchingBox.getSelectedItem().toString();
				String[] words = strSelected.split("-");
				String sItemno = words[0];
				
				if ((Tinqty.getText().length() > 0))
				{
					int Inqty=Integer.parseInt(Tinqty.getText());
					Item thisItem = new ItemServiceImpl().findByItemno(sItemno);
					if(thisItem == null)
					{
						Tool.alert(" 商品編號不存在， 請重新輸入！");
					}
					else
					{
						if (Inqty > 0)
						{//outputMsg += "商品編號\t商品名稱\t廠商編號 進 價 進貨量\n";
							Received received = new Received(ReceivingDate, sItemno, thisItem.getFactoryno(), Inqty);
							new ReceivedServiceImpl().addItem(received);
							String Msg = output.getText();
							Msg += sItemno +"\t"+ thisItem.getItemname() +"\t "+ thisItem.getFactoryno() +"\t";
							Msg += thisItem.getCost()+"\t" + Inqty +"\n";
							output.setText(Msg);
							Tinqty.setText("");
						}
						else
						{
							Tool.alert(" 沒有進貨量， 請重新輸入！");
						}
					}
				}				
			}
		});
		btnNewButton_1.setBounds(432, 16, 87, 29);
		panel_4.add(btnNewButton_1);


		
	}
}
