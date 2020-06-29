package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopView extends JFrame {

//	private ImageIcon shopicon = null;
//	private ImageIcon pappIcon = null;

//	private int x, y;

	public ShopView() {
		super("우 - 정 - 리");
		this.shop();
	}

	public void shop() {
		this.setBounds(100, 100, 1440, 900);
//		this.setLayout(null);

		JPanel panel = new JPanel();
		// shop map 설정
//		Image shopIcon = new ImageIcon("src/images/shopmap.png").getImage().getScaledInstance(1440, 900, 0);
//		JLabel mapLabel = new JLabel(new ImageIcon(shopIcon));
//		mapLabel.setBounds(0, 0, 1440, 900);
		
		ImageIcon sicon = new ImageIcon("src/images/shopmap.png");
		Image simg = sicon.getImage();
		Image simg2 = simg.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
		ImageIcon sicon2 = new ImageIcon(simg2);
		
		JLabel mapLabel = new JLabel() {
			public void paintComponent(Graphics g) {
				g.drawImage(sicon2.getImage(), 100, 100, null);
			}
		};

		// 빱이 설정
		ImageIcon icon = new ImageIcon("src/images/ppap/antppap.png");
		Image img = icon.getImage();
		Image img2 = img.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(img2);

		JButton button = new JButton() {

			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 300, 300, null);
			}
		};

		// 왕눈이
		ImageIcon wicon = new ImageIcon("src/images/wangnunramgi/wangnun.png");
		Image wimg = wicon.getImage();
		Image wimg2 = wimg.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon wicon2 = new ImageIcon(wimg2);

		JButton wbutton = new JButton() {

			public void paintComponent(Graphics g) {
				g.drawImage(wicon2.getImage(), 400, 300, null);
			}
		};
		mapLabel.add(button);
		mapLabel.add(wbutton);
//		panel.add(button);
//		panel.add(wbutton);
		panel.add(mapLabel);

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}