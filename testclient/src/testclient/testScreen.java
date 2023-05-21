package testclient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
 
public class testScreen extends JFrame {
	private JPanel contentPane;
	private JTextField txtInput;
	private String UserName;
	private static final  int BUF_LEN = 128; //  Windows ó�� BUF_LEN �� ����
	private Socket socket; // �������
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	private JLabel lblUserName;
	private ImageIcon imgIcon, newImgIcon;
	private Image img, updatedImg;
 
    public testScreen(String username, String ip_addr, String port_no) {
    	setTitle("<dynamite>");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 632);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// �޴���
		JPanel panelLeftMenu = new JPanel();
		panelLeftMenu.setLayout(new GridLayout(8,1));
		panelLeftMenu.setBounds(0,0,50,600);
		panelLeftMenu.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelLeftMenu);
		
		//ģ��â ��ư
		JButton btnFriendList = new JButton();
		btnFriendList.setText("");
		imgIcon = new ImageIcon("src/profile.png");
		img = imgIcon.getImage();
		img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		btnFriendList.setIcon(imgIcon);
		btnFriendList.setBounds(0, 0, 50, 50);
		btnFriendList.setHorizontalAlignment(JLabel.CENTER);
		btnFriendList.setBorderPainted(false);
		btnFriendList.setContentAreaFilled(false);
		btnFriendList.setFocusPainted(false);
		panelLeftMenu.add(btnFriendList);

		
		//ä�� ��ư
		JButton btnChatList = new JButton();
		btnChatList.setText("");
		imgIcon = new ImageIcon("src/chat.png");
		img = imgIcon.getImage();
		img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		btnChatList.setIcon(imgIcon);
		btnChatList.setBounds(0, 0, 50, 50);
		btnChatList.setHorizontalAlignment(JLabel.CENTER);
		btnChatList.setBorderPainted(false);
		btnChatList.setContentAreaFilled(false);
		btnChatList.setFocusPainted(false);
		panelLeftMenu.add(btnChatList);
		
		
		
		// ������ ��� ����
		JPanel panelFriend = new JPanel();
		panelFriend.setLayout(new GridLayout(8,1));
		panelFriend.setBounds(51,-15,281,585);
		panelFriend.setBackground(Color.WHITE);
		contentPane.add(panelFriend);
		
		
		
		JPanel panelFriendHeader = new JPanel();
		panelFriendHeader.setLayout(new GridLayout(1,5));
		panelFriend.add(panelFriendHeader);
		
		imgIcon = new ImageIcon("src/user.png");
		img = imgIcon.getImage();
		img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		
		
		
		JLabel lblFriend = new JLabel("  \uCE5C\uAD6C");
		panelFriendHeader.add(lblFriend);
		lblFriend.setBackground(new Color(255, 255, 255));
		lblFriend.setFont(new Font("����", Font.BOLD, 22));
		
		
		

		
		JScrollPane scrollPaneFriendList = new JScrollPane();
		panelFriend.add(scrollPaneFriendList);
		
		JTextPane textPaneFriendList = new JTextPane();
		scrollPaneFriendList.add(textPaneFriendList);
		
		
		JPanel panelChat = new JPanel();
		panelChat.setBounds(51, 591, 288, -592);
		panelFriend.setLayout(new GridLayout(8,1));
		panelFriend.setBounds(50,0,300,600);
		panelFriend.setBackground(Color.WHITE);
		contentPane.add(panelChat);
		
		JScrollPane scrollPaneChatList = new JScrollPane();
		panelChat.add(scrollPaneChatList);
		
		JPanel panelChatHeader = new JPanel();
		panelChat.add(panelChatHeader);
		//panelChatHeader.setLayout(new GridLayout(1, 5));
		
		
		JTextPane textPaneChatList = new JTextPane();
		scrollPaneChatList.add(textPaneChatList);
		
		JLabel lblChat = new JLabel("  \uCC44\uD305");
		panelChatHeader.add(lblChat);
		lblChat.setFont(new Font("����", Font.BOLD, 22));
		lblChat.setBackground(Color.WHITE);
		
		
		//��ưŬ��(FriendList)
		btnFriendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFriendList.setEnabled(false);
				btnChatList.setEnabled(true);
				panelFriend.setVisible(true);
				panelChat.setVisible(false);
			}
		});
		//��ưŬ��(ChatList)
		btnChatList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFriendList.setEnabled(true);
				btnChatList.setEnabled(false);
				panelFriend.setVisible(false);
				panelChat.setVisible(true);
			}
		});
		
		setVisible(true);
		
		
		class Chatmove implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//btnFriendList.setEnabled(false);
				//btnChatList.setEnabled(true);
				panelFriend.setVisible(false);
				panelChat.setVisible(true);
			}
			
		}
		
		class Freindmove implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//btnFriendList.setEnabled(true);
				//btnChatList.setEnabled(false);
				panelFriend.setVisible(true);
				panelChat.setVisible(false);
			}
			
		}
    }
}
