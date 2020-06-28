package ujeongri.com.gh.main.view;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 

public class TestView extends JFrame{
	JButton move;
	
	public TestView() {
		super("TEST");
		this.init();
		
		this.run();
		
	}
	
	public void init() {
		
	}
	
	public void run() {
		JFrame frame = new JFrame();
		frame.setSize(1440, 900);
		
		ImageIcon icon = new ImageIcon("src/images/ppap/antppap.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);
		
		JPanel panel = new JPanel() {
		
		public void paintComponent(Graphics g) {
		g.drawImage(icon2.getImage(), 300, 300, null);
		}
		};
		
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int x = move.getX();
				
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					
				}
			}
		});
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	




}