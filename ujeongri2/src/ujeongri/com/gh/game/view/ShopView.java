package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopView extends JFrame {

	public ShopView() {
		super("우 - 정 - 리");
		this.setBounds(0, 0, 1440, 900);
		this.shop();
	}

	JLabel sLabel = new JLabel();
	JLabel papLabel = new JLabel();
	JLabel wLabel = new JLabel();
	JLabel rgLabel = new JLabel();
	
	
	public void shop() {
//		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		// shop map 설정
//		Image shopIcon = new ImageIcon("src/images/shopmap.png").getImage().getScaledInstance(1440, 900, 0);
//		JLabel mapLabel = new JLabel(new ImageIcon(shopIcon));
//		mapLabel.setBounds(0, 0, 1440, 900);
		
		Image shop = new ImageIcon("src/images/shopmap.png").getImage().getScaledInstance(1440, 900, 0);
		sLabel = new JLabel(new ImageIcon(shop));
		sLabel.setBounds(0, 0, 1440, 900);
		
		// 빱이 설정
		Image pIcon = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(36, 75, 0);
		papLabel = new JLabel(new ImageIcon(pIcon));
		papLabel.setBounds(450, 550, 35, 75);

		// 왕눈이
		Image wIcon = new ImageIcon("src/images/wangnunramgi/wangnun.png").getImage().getScaledInstance(35, 75, 0);
		wLabel = new JLabel(new ImageIcon(wIcon));
		wLabel.setBounds(400, 300, 35, 75);
		
		//람지
		Image rgIcon = new ImageIcon("src/images/wangnunramgi/ramgi.png").getImage().getScaledInstance(35, 75, 0);
		rgLabel = new JLabel(new ImageIcon(rgIcon));
		rgLabel.setBounds(400, 375, 35, 75);
		
		panel.add(papLabel);
		panel.add(wLabel);
		panel.add(rgLabel);
		panel.add(sLabel);

		this.add(panel);

		this.setVisible(true);
		 this.addKeyListener(new key());
		 this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
			Point p = papLabel.getLocation();
			
			if(e.getKeyCode() == 37) {
				papLabel.setLocation(p.x-20, p.y); //왼쪽
			}
			if(e.getKeyCode() == 38) {
				papLabel.setLocation(p.x, p.y-20); //위
			}
			if(e.getKeyCode() == 39) {
				papLabel.setLocation(p.x+20, p.y); //오른쪽
			}
			if(e.getKeyCode() == 40) {
				papLabel.setLocation(p.x, p.y+20); //아래
			}
		}

		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		
	}

}