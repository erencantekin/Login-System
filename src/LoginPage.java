import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame("Login");
	JLabel username = new JLabel("Username ");
	JLabel password = new JLabel("Password ");
	JLabel messageLabel = new JLabel();
	static JTextField usernameField = new JTextField();
	static JPasswordField passwordField = new JPasswordField();
	JButton signin = new JButton("Sign In");
	JButton signup = new JButton("Sign Up");
	
	LoginPage(){
		
		frame.setSize(450,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xfff7d4));
		frame.setResizable(false);
		frame.setVisible(true);
		
		username.setBounds(100,100,100,100);
		password.setBounds(100,135,100,100);
		
		usernameField.setBounds(175,137,150,25);
		passwordField.setBounds(175,173,150,25);
		
		signin.setFont(new Font(null, Font.BOLD, 10));
		signin.setBounds(105,225,100,25);
		signin.setFocusable(false);
		signin.addActionListener(this);
		
		signup.setFont(new Font(null, Font.BOLD, 10));
		signup.setBounds(215,225,100,25);
		signup.setFocusable(false);
		signup.addActionListener(this);
		
		messageLabel.setBounds(95,250,250,150);
		messageLabel.setFont(new Font(null,Font.BOLD,12));
		messageLabel.setForeground(Color.red);
		
		frame.add(username);
		frame.add(password);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(signin);
		frame.add(signup);
		frame.add(messageLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signup) {
			frame.dispose();
			SignUpPage registerPage = new SignUpPage();
		}
		else if(e.getSource() == signin) {
			if(userIDs.user_id.get(usernameField.getText()) != null) {
				new profile();
				frame.dispose();
			}
			else if (usernameField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")){
				messageLabel.setText("Please enter valid username and password");
			}
			else {
				messageLabel.setText("Your username or password is incorrect");
			}
		}
		
	}
}
