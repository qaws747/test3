package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerView {
	private int x, y;
	private int a = 10;

	public PlayerView() {
//		setLayout(null);
//	this.setBounds(300, 300, 44, 92);
		ImageIcon icon = new ImageIcon("src/images/ppap/antppap.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);
		
		JPanel panel = new JPanel() {
		
		public void paintComponent(Graphics g) {
		g.drawImage(icon2.getImage(), 300, 300, null);
		}
		};
		
		panel.setVisible(true);

	}
	
//	public void run() {
//		ImageIcon icon = new ImageIcon("src/images/ppap/antppap.png");
//		Image img = icon.getImage();
//		Image img2 = img.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
//		ImageIcon icon2 = new ImageIcon(img2);
//		
//		JPanel panel = new JPanel() {
//		
//		public void paintComponent(Graphics g) {
//		g.drawImage(icon.getImage(), 300, 300, null);
//		}
//		};
//		
//	}
}