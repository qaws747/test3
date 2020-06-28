
package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopView extends JFrame{
	
//	private ImageIcon shopicon = null;
//	private ImageIcon pappIcon = null;

//	private int x, y;

	public ShopView() {
		super("우 - 정 - 리");
//		setTitle("우 - 정 - 리");
		this.setBounds(100, 100, 1440, 900);
//		this.setLayout(null);

		JPanel panel = new JPanel();
		//shop map 설정
		
		ImageIcon shopIcon = new ImageIcon("src/images/shopmap.png");
		Image im = shopIcon.getImage();
		Image im2 = im.getScaledInstance(2880, 1800, Image.SCALE_SMOOTH);
		ImageIcon shopIcon2 = new ImageIcon(im2);
		
		JLabel mapLabel = new JLabel() {
			public void paintComponent(Graphics g) {
				g.drawImage(shopIcon2.getImage(), 0, 0, null);
			}
		};
//		mapLabel.setLocation(0, 0);
		
		
		//빱이 설정
		ImageIcon pappIcon = new ImageIcon("src/images/ppap/antppap.png");
		Image pi = pappIcon.getImage();
		Image pi2 = pi.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
		ImageIcon pappIcon2 = new ImageIcon(pi2);
		
		JButton pappButton = new JButton(pappIcon2) {
			public void paintComponent(Graphics g) {
				g.drawImage(pappIcon2.getImage(), 0, 0, null);
			}
		};
		pappButton.setLocation(300, 300);
//		pappButton.setBounds(300, 300, 44, 98);
		pappButton.setBorderPainted(false);
		
//		pappButton.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_UP) {
////					bt.removeAll();
////					bt.add(new ButtonMainView(null));
////					bt.repaint();
//					ButtonMainView bmv = new ButtonMainView();
//					dispose();
//				}
//			}
//			
//			
//		});
		
		//왕눈이 
		ImageIcon wangnunIcon = new ImageIcon("src/images/wangnunramgi/wangnun.png");
		JButton wangnunButton = new JButton(wangnunIcon);
		wangnunButton.setBounds(200, 500, 44, 98);
		wangnunButton.setBorderPainted(false);
		
		mapLabel.add(wangnunButton);
		mapLabel.add(pappButton);
		panel.add(mapLabel);

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

} 