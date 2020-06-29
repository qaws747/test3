package ujeongri.com.gh.main.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TestView extends JFrame { 
	ImageIcon icon2;
	
	public TestView() {
//		this.run();
		
		this.setSize(1440, 900);
		
		ImageIcon icon = new ImageIcon("src/images/ppap/antppap.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);
		
		
		JLabel label = new JLabel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 300, 300, null);
			}
		};
		
		
		
		this.add(label);
		this.setVisible(true);
	}
	
	public void run() {
//		label.addKeyListener(new KeyAdapter() {
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				String strKey = KeyEvent.getKeyText(keyCode);
//				
//				int x = label.getX();
//				int y = label.getY();
//				
////				if(strKey.equals("UP")) {
////					y += 10;
////				} else if
//				if(x > 0 || y >0) {
//				switch(strKey) {
//				case "w" : y += 10; break;
//				case "s" : y -= 10; break;
//				case "d" : x += 10; break;
//				case "a" : x -= 10; break;
//				default : return;
//				}
//				}
//				label.setLocation(x, y);
//				
//			}
//		});
		
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	




}