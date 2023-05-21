// JavaChatClientMain.java
// Java Client ����import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtIpAddress;
	private JTextField txtPortNumber;
	private ImageIcon imgIcon, newImgIcon;
	private Image img, updatedImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
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
	public StartScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * JLabel lblNewLabel = new JLabel("User Name"); lblNewLabel.setBounds(12, 39,
		 * 82, 33); contentPane.add(lblNewLabel);
		 */
		
		txtUserName = new JTextField();
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setBounds(70, 260, 300, 50);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		/*
		 * JLabel lblIpAddress = new JLabel("IP Address"); lblIpAddress.setBounds(12,
		 * 100, 82, 33); contentPane.add(lblIpAddress);
		 */
		
		txtIpAddress = new JTextField();
		txtIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtIpAddress.setText("127.0.0.1");
		txtIpAddress.setColumns(10);
		txtIpAddress.setBounds(70, 330, 300, 50);
		contentPane.add(txtIpAddress);
		
		/*
		 * JLabel lblPortNumber = new JLabel("Port Number"); lblPortNumber.setBounds(12,
		 * 163, 82, 33); contentPane.add(lblPortNumber);
		 */
		
		txtPortNumber = new JTextField();
		txtPortNumber.setText("30000");
		txtPortNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPortNumber.setColumns(10);
		txtPortNumber.setBounds(70, 400, 300, 50);
		contentPane.add(txtPortNumber);
		
		
		
		
		JButton btnConnect = new JButton("");
		//btnConnect = new JButton(new ImageIcon("kakao_login_small.png"));
		btnConnect.setBounds(90, 472, 260, 40);
		//btnConnect.setFont(new Font("����", Font.PLAIN, 14));
		imgIcon = new ImageIcon("src/login_brown.jpg");
		img = imgIcon.getImage();
		img = img.getScaledInstance(260, 40, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		btnConnect.setIcon(imgIcon);
		btnConnect.setHorizontalAlignment(JLabel.CENTER);
		btnConnect.setBorderPainted(false);
		btnConnect.setContentAreaFilled(false);
		btnConnect.setFocusPainted(false);
		
		contentPane.add(btnConnect);
		
		
		//btnConnect.setBorderPainted(false);

		//btnConnect.setFocusPainted(false);

		//btnConnect.setContentAreaFilled(false);

		
		JPanel page1=new JPanel() {
	        Image background=new ImageIcon(StartScreen.class.getResource("kakao_login.png")).getImage();
	            public void paint(Graphics g) {//�׸��� �Լ�
	                g.drawImage(background, 0, 0, null);//background�� �׷���
	            }
	        };
		
		
		Myaction action = new Myaction();
		btnConnect.addActionListener(action);
		txtUserName.addActionListener(action);
		txtIpAddress.addActionListener(action);
		txtPortNumber.addActionListener(action);
		
		setSize(460,750);//�������� ũ��
        //setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
        page1.setLayout(null); //���̾ƿ� �����ϱ� ����.
        page1.setBounds(0, 0, 1400, 1600);//�г��� ��ġ�� ũ��.
        getContentPane().add(page1);
	}
	class Myaction implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = txtUserName.getText().trim();
			String ip_addr = txtIpAddress.getText().trim();
			String port_no = txtPortNumber.getText().trim();
			MainScreen view = new MainScreen(username, ip_addr, port_no);
			setVisible(false);
		}
	}
}
