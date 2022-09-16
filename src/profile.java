
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class profile {
	
	JFrame frame = new JFrame("Profile");
	JLabel picLabel = new JLabel();
	JLabel username = new JLabel("Username: ");
	JLabel password = new JLabel("Password: ");
	JLabel email = new JLabel("Email: ");
	JLabel age = new JLabel("Age: ");
	JLabel gender = new JLabel("Gender: ");
	ImageIcon profilePic = new ImageIcon("C:\\Users\\lenovo\\Desktop\\Eclipse Workspace\\LoginSystem\\src\\profileIcon.jpg");
	profile(){
		frame.setSize(450,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xfff7d4));
		frame.setVisible(true);
		
		picLabel.setIcon(profilePic);
		picLabel.setBounds(150,5,200,200);
		
		username.setBounds(30,175,500,100);
		password.setBounds(30,225,500,100);
		email.setBounds(30,275,500,100);
		age.setBounds(275,175,500,100);
		gender.setBounds(275,225,500,100);
		
		username.setText(username.getText() + LoginPage.usernameField.getText());
		password.setText(password.getText() + (userIDs.user_id.get(LoginPage.usernameField.getText())).get(1));
		email.setText(email.getText() + (userIDs.user_id.get(LoginPage.usernameField.getText())).get(2));
		age.setText(age.getText() + (userIDs.user_id.get(LoginPage.usernameField.getText())).get(3));
		gender.setText(gender.getText() + (userIDs.user_id.get(LoginPage.usernameField.getText())).get(4));
		
		frame.add(picLabel);
		frame.add(username);
		frame.add(password);
		frame.add(email);
		frame.add(age);
		frame.add(gender);
		
	}
}
