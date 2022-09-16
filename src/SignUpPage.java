import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpPage implements ActionListener{
	
	JFrame frame = new JFrame("Sign-Up");
	JLabel username = new JLabel("Username " );
	JLabel password = new JLabel("Password ");
	JLabel email = new JLabel("Email ");
	JLabel age = new JLabel("Age ");
	JLabel gender = new JLabel("Gender ");
	
	JTextField userField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JTextField emailField = new JTextField();
	JTextField ageField = new JTextField();
	JRadioButton genderMale = new JRadioButton("Male");
	JRadioButton genderFemale = new JRadioButton("Female");
	JButton signUp = new JButton("Sign Up");
	JButton signIn = new JButton ("Sign In");
	
	ButtonGroup group = new ButtonGroup();
	
	JLabel labelMessage = new JLabel();
	
	static ArrayList<String> usernameList = new ArrayList();
	static ArrayList<String> emailList = new ArrayList();
	
	
	SignUpPage(){
		
		frame.setSize(450,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xfff7d4));
		frame.setVisible(true);
		
		username.setBounds(100,100,100,50);
		password.setBounds(100,130,100,50);
		email.setBounds(100,160,100,50);
		age.setBounds(100,190,100,50);
		gender.setBounds(100,220,100,50);
		
		userField.setBounds(190,115,120,20);
		passField.setBounds(190,145,120,20);
		emailField.setBounds(190,175,120,20);
		ageField.setBounds(190,205,120,20);
		genderFemale.setBounds(190,235,70,25);
		genderMale.setBounds(280,235,55,25);
		
		signIn.setBounds(125,300,90,25);
		signIn.setFocusable(false);
		signIn.addActionListener(this);
		
		signUp.setBounds(225,300,90,25);
		signUp.setFocusable(false);
		signUp.addActionListener(this);
		
		labelMessage.setBounds(70,25,300,100);
		labelMessage.setFont(new Font("Dialog", Font.BOLD, 15));
		labelMessage.setForeground(Color.red);
		
		
		group.add(genderFemale);
		group.add(genderMale);
		
		frame.add(username);
		frame.add(password);
		frame.add(email);
		frame.add(age);
		frame.add(gender);
		
		frame.add(genderMale);
		frame.add(genderFemale);
		
		frame.add(userField);
		frame.add(passField);
		frame.add(emailField);
		frame.add(ageField);
		frame.add(signUp);
		frame.add(signIn);
		frame.add(labelMessage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUp) {
			if((userField.getText().equals("") || passField.getPassword().equals("") || 
					emailField.getText().equals("") || ageField.getText().equals(""))
					|| (genderMale.isSelected() == false && genderFemale.isSelected() == false)
					|| !(emailField.getText().contains("@")) || !(emailField.getText().contains(".com"))
					|| !(isInt(ageField.getText())) ) {
				labelMessage.setText("Please, fill all the blank cells correctly");
			}
			else if(usernameList.contains(userField.getText())) {
				labelMessage.setText("This username has taken.");
			}
			else if(emailList.contains(emailField.getText())) {
				labelMessage.setText("This email has already used.");
			}
			else {
				usernameList.add(userField.getText());
				emailList.add(emailField.getText());
				userIDs user = new userIDs(userField.getText(), String.valueOf(passField.getPassword()), emailField.getText(), ageField.getText(), genderFemale.isSelected());
				labelMessage.setText("Successful, loading...");
				
				frame.dispose();
				new LoginPage();
			}
		}
		else if(e.getSource() == signIn) {
			frame.dispose();
			new LoginPage();
		}
		
	}
	
	boolean isInt(String age){
		try {
			int this_age = Integer.parseInt(age);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
