package util;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//小時鐘面板
public class ClockPanel extends JPanel {
 private static final long serialVersionUID = 1L;
private JLabel timeLabel;
 private SimpleDateFormat timeFormat;

 public ClockPanel() {
     setLayout(new GridBagLayout()); // 使用 GridBagLayout 以讓時間居中
     timeLabel = new JLabel();
     timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
     timeFormat = new SimpleDateFormat("HH:mm:ss");

     updateTime(); // 初始化時間

     add(timeLabel);
 }

 public void updateTime() {
     // 更新時間
     String currentTime = timeFormat.format(new Date());
     timeLabel.setText(currentTime);
 }
}
