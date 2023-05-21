// JavaChatClientView.java
// 실질적인 채팅 창
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class MakeRoom extends JFrame {
	private JPanel contentPane;
	private JTextField txtInput;
	private String UserName;
	private JButton btnSend;
	private static final  int BUF_LEN = 128; //  Windows 처럼 BUF_LEN 을 정의
	private Socket socket; // 연결소켓
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private JLabel lblUserName;
	//private JTextArea textArea;
	private JTextPane textArea;
	private ImageIcon imgIcon, newImgIcon;
	private Image img, updatedImg;
	
	/**
	 * Create the frame.
	 */
	public MakeRoom(String username, String ip_addr, String port_no) {
		setTitle("<dynamite>");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		imgIcon = new ImageIcon("src/profile.png");
		img = imgIcon.getImage();
		img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		imgIcon = new ImageIcon("src/chat.png");
		img = imgIcon.getImage();
		img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		
		JPanel headerpanel = new JPanel();
		headerpanel.setLayout(null);
		headerpanel.setBounds(0, 0, 300, 50);
		headerpanel.setBackground(new Color(240, 240, 240));
		contentPane.add(headerpanel);
		
		JLabel lblNewLabel = new JLabel("\uB300\uD654\uC0C1\uB300 \uC120\uD0DD");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setSize(290, 50);
		lblNewLabel.setLocation(10, 0);
		headerpanel.add(lblNewLabel);
		
		
		
		JScrollPane makescrollPane = new JScrollPane();
		makescrollPane.setLayout(null);
		makescrollPane.setBorder(null);
		makescrollPane.setBackground(new Color(255, 255, 255));
		makescrollPane.setBounds(0, 50, 300, 340);
		contentPane.add(makescrollPane);
		
				
		
		JPanel makepanel = new JPanel();
		makepanel.setLayout(null);
		makepanel.setBounds(0, 390, 300, 80);
		makepanel.setBackground(new Color(240, 240, 240));
		contentPane.add(makepanel);
		
		//채팅탭의 헤더의 버튼
		JButton btnMake = new JButton("\uC0DD\uC131");
		btnMake.setLayout(null);
		btnMake.setBounds(130,10, 60, 60);
		makepanel.add(btnMake);
		
		for(int i = 0; i<10 ; i++) {
			Friend view = new Friend(username);
			makescrollPane.add(view);
		}
		
		
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 12));
		btnCancel.setLayout(null);
		btnCancel.setBounds(200,10, 60, 60);
		makepanel.add(btnCancel);
		

		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.addWindowListener((WindowListener) new WindowAdapter(){
            public void windowClosing(WindowEvent e) { 
            	dispose();
        		//System.out.println("windowClosing()");
            }
    });
		
		

		
				
		setVisible(true);
	
		//AppendText("User " + username + " connecting " + ip_addr + " " + port_no);
		UserName = username;
		//lblUserName.setText(username+">");
		
	}
}
