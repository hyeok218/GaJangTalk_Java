import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;

public class Friend extends JPanel {
	private JPanel contentPane;
	private String UserName;
	private ImageIcon imgIcon, newImgIcon;
	private Image img, updatedImg;
	
	public Friend (String username){
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(105);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		contentPane.setBorder(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 300, 80);
		
		
		JButton btnUserName = new JButton(username);
		btnUserName.setHorizontalAlignment(SwingConstants.LEFT);
		btnUserName.setBackground(new Color(255, 255, 255));
		btnUserName.setBorder(null);
		btnUserName.setLayout(null);
		btnUserName.setBounds(60, 12, 200, 20);
		add(btnUserName);
	
		
		JButton btnIcon = new JButton("");
		imgIcon = new ImageIcon("src/profile.jpg");
		img = imgIcon.getImage();
		img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(img);
		btnIcon.setIcon(imgIcon);
		btnIcon.setHorizontalAlignment(JLabel.CENTER);
		btnIcon.setBorderPainted(false);
		btnIcon.setContentAreaFilled(false);
		btnIcon.setFocusPainted(false);
		btnIcon.setBackground(new Color(128, 128, 255));
		btnIcon.setForeground(new Color(128, 128, 255));
		btnIcon.setBorder(null);
		btnIcon.setLayout(null);
		btnIcon.setBounds(5, 12, 50, 50);
		add(btnIcon);
		
		JCheckBox chckbxSelect = new JCheckBox("");
		chckbxSelect.setBorder(null);
		chckbxSelect.setLayout(null);
		add(chckbxSelect);
		chckbxSelect.setBackground(new Color(255, 255, 255));
		chckbxSelect.setBounds(250, 28, 20, 20);
		
		
		
	}
	
}
