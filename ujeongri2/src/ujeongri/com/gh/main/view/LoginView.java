package ujeongri.com.gh.main.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ujeongri.com.gh.game.view.ShopView;

public class LoginView extends JFrame {

	public LoginView() {
		this.setBounds(500, 500, 400, 100);
		
		JPanel panel3 = new JPanel();
		
		JTextField id = new JTextField(10);
		panel3.add(new JLabel("ID"));
		panel3.add(id);
		
		JPasswordField password = new JPasswordField(10);
		panel3.add(new JLabel("PASSWORD"));
		panel3.add(password);
		
		JButton btn3 = new JButton("login");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn3) {
					ShopView sv = new ShopView();
					dispose();
				}
				
			}
		});
		
		this.add(panel3, BorderLayout.NORTH);
		this.add(btn3, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}