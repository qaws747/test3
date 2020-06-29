package ujeongri.com.gh.game.view;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ujeongri.com.gh.main.view.TestView;

public class PlayerController extends ForestView {
	private JFrame frame;
	ImageIcon picon2;
	
	public PlayerController() {
		test();
	}

	public PlayerController(JFrame frame, ImageIcon picon2, ImageIcon icon2, JPanel panel) {
		super(icon2, panel);
		this.frame = frame;
		this.icon2 = icon2;
	}
	
	
	public void test() {
		
		frame.setSize(1440, 900);
		
		ImageIcon picon = new ImageIcon("src/images/ppap/antppap.png");
		Image pimg = picon.getImage();
		Image pimg2 = pimg.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon picon2 = new ImageIcon(pimg2);
		
		
		JLabel plabel = new JLabel() {
			
			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 300, 300, null);
			}
		};
		
		JPanel panel2 = new JPanel();
		
		panel2.add(panel);
		panel2.add(plabel);
		frame.add(panel2);
		frame.setVisible(true);
		
	}
}