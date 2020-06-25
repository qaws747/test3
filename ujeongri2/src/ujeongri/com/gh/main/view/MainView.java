package ujeongri.com.gh.main.view;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainView extends JFrame {
	
	public MainView() {
		super("우 - 정 - 리");
//		setLayout(null);

		this.setBounds(100, 100, 1440, 900);
		
		JPanel panel1 = new JPanel();
		
		Image icon = new ImageIcon("src/images/mainfont.png").getImage().getScaledInstance(1440, 900, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		
		panel1.add(label, "Center");
		
		JButton bt = new JButton();
		
		bt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//					bt.removeAll();
//					bt.add(new ButtonMainView(null));
//					bt.repaint();
					ButtonMainView bmv = new ButtonMainView();
					dispose();
				}
			}
		});
		panel1.add(bt, "center");
		this.add(panel1);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
}