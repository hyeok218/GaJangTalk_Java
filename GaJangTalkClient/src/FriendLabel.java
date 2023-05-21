import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendLabel extends JPanel {
	private JPanel friendPane;
	private JLabel lblUserName;
	private JLabel lblTime;
	private JButton btnIcon;
	
	public FriendLabel(String UserIcon, String UserName) {
		setLayout(null);
		
		friendPane = new JPanel();
		friendPane.setBackground(new java.awt.Color(155, 187, 212));
		friendPane.setBounds(10,10,100,50);
		add(friendPane);
		friendPane.setLayout(null);
		
		btnIcon = new JButton(UserIcon);
		btnIcon.setBounds(11,11,30,30);
		friendPane.add(btnIcon);
		
		lblUserName = new JLabel(UserName);
		lblUserName.setFont(new Font("굴림", Font.BOLD, 10));
		lblUserName.setBounds(51,11,50,20);
		friendPane.add(lblUserName);
		
		
		lblTime = new JLabel("null");
		lblTime.setBackground(Color.white);
		lblTime.setFont(new Font("굴림", Font.BOLD, 8));
		lblTime.setBounds(51,25,50,15);
		friendPane.add(lblTime);
	}
}
