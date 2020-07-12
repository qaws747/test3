package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.spec.KeySpec;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ujeongri.com.gh.game.run.ThreadRun;
import ujeongri.com.gh.game.view.ForestView.key;

public class ShopView extends JFrame  {

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean keySpace = false;
	boolean playerMove = false;

	// 라벨 이벤트때도 광역으로 쓸 수 있도록 위로 빼놓음
	JLabel bgLabel = new JLabel();
	// panel 생성
	JPanel wPanel = new JPanel();
	JPanel papPanel = new JPanel();
	JPanel rgPanel = new JPanel();
	JPanel foxPanel = new JPanel();
	JPanel shopPanel = new JPanel();
	JPanel notPanel = new JPanel();

//	Image img = new ImageIcon("src/images/wangnunramgi/ppap.png").getImage().getScaledInstance(150, 392, 0);
	Image current = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(35, 75, 0);
	Image up = new ImageIcon("src/images/ppap/postppap1.png").getImage().getScaledInstance(35, 75, 0);
	Image down = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(35, 75, 0);
	Image rt = new ImageIcon("src/images/ppap/rtppap.png").getImage().getScaledInstance(35, 75, 0);
	Image lt = new ImageIcon("src/images/ppap/ltppap.png").getImage().getScaledInstance(35, 75, 0);

	Image wIcon = new ImageIcon("src/images/wangnunramgi/wangnun.png").getImage().getScaledInstance(35, 75, 0);
	Image rgIcon = new ImageIcon("src/images/wangnunramgi/ramgi.png").getImage().getScaledInstance(35, 75, 0);

	Image foxDown = new ImageIcon("src/images/fox/antfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxLt = new ImageIcon("src/images/fox/ltfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxRt = new ImageIcon("src/images/fox/rtfox.png").getImage().getScaledInstance(35, 75, 0);
	
	Image notyet = new ImageIcon("src/images/notyet.png").getImage().getScaledInstance(900, 150, 0);

	JLabel papLabel;
	JLabel upLabel;
	JLabel downLabel;
	JLabel rtLabel;
	JLabel ltLabel;

	JLabel sLabel = new JLabel();
	JLabel wLabel = new JLabel();
	JLabel rgLabel = new JLabel();
	public JLabel foxDLabel = new JLabel();
	JLabel foxLLabel = new JLabel();
	JLabel foxRLabel = new JLabel();
	
	JLabel notLabel = new JLabel();

	public ShopView() {
		super("우 - 정 - 리");
		this.setBounds(0, 0, 1440, 900);
		this.shop();
		this.setLayout(null);
	}

	public void shop() {

		shopPanel.setLayout(null);

		Image shop = new ImageIcon("src/images/shopmap.png").getImage().getScaledInstance(1440, 900, 0);
		sLabel = new JLabel(new ImageIcon(shop));
		sLabel.setBounds(0, 0, 1440, 900);

		// 왕눈이
		Image wIcon = new ImageIcon("src/images/wangnunramgi/wangnun.png").getImage().getScaledInstance(35, 75, 0);
		wLabel = new JLabel(new ImageIcon(wIcon));
		wLabel.setBounds(400, 300, 35, 75);

		// 람지
		Image rgIcon = new ImageIcon("src/images/wangnunramgi/ramgi.png").getImage().getScaledInstance(35, 75, 0);
		rgLabel = new JLabel(new ImageIcon(rgIcon));
		rgLabel.setBounds(400, 375, 35, 75);

		foxDLabel = new JLabel(new ImageIcon(foxDown));
		foxDLabel.setSize(35, 75);
		foxDLabel.setLocation(700, 150);
		foxLLabel = new JLabel(new ImageIcon(foxLt));
		foxLLabel.setSize(35, 75);
		foxRLabel = new JLabel(new ImageIcon(foxRt));
		foxRLabel.setSize(35, 75);
		new ThreadRun();

		// 빱이 설정
		papLabel = new JLabel(new ImageIcon(current));
		papLabel.setSize(33, 75);
		upLabel = new JLabel(new ImageIcon(up));
		upLabel.setSize(33, 75);
		downLabel = new JLabel(new ImageIcon(down));
		downLabel.setSize(33, 75);
		rtLabel = new JLabel(new ImageIcon(rt));
		rtLabel.setSize(33, 75);
		ltLabel = new JLabel(new ImageIcon(lt));
		ltLabel.setSize(33, 75);

		notLabel = new JLabel(new ImageIcon(notyet));
		notLabel.setSize(900, 150);
		notLabel.setLocation(300, 700);
		
		notPanel.add(notLabel);
		
		shopPanel.add(wLabel);
		shopPanel.add(rgLabel);
//		shopPanel.add(foxDLabel);
		shopPanel.add(sLabel);
		
		
		papPanel.add(papLabel);
		papPanel.setOpaque(false);
		papPanel.setBounds(450, 550, 33, 75);
//		papPanel.addKeyListener(new key());
//		papPanel.setFocusable(true);
		
		this.add(notPanel);
		this.add(papPanel);
		this.add(shopPanel);

		this.setVisible(true);
		this.addKeyListener(new key());
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public class key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {

			int x = papPanel.getX();
			int y = papPanel.getY();

			Point p = papPanel.getLocation();

			switch (e.getKeyCode()) {
			case 37:
				keyLeft = true;
				papPanel.add(ltLabel);
				upLabel.setVisible(false);
				downLabel.setVisible(false);
				papLabel.setVisible(false);
				rtLabel.setVisible(false);
				ltLabel.setVisible(true);
				papPanel.setLocation(p.x - 29, p.y);
				break; // 왼쪽
			case 38:
				keyUp = true;
				papPanel.add(upLabel);
				upLabel.setVisible(true);
				downLabel.setVisible(false);
				papLabel.setVisible(false);
				rtLabel.setVisible(false);
				ltLabel.setVisible(false);
				papPanel.setLocation(p.x, p.y - 20);
				break;// 위
			case 39:
				keyRight = true;
				papPanel.add(rtLabel);
				upLabel.setVisible(false);
				downLabel.setVisible(false);
				papLabel.setVisible(false);
				rtLabel.setVisible(true);
				ltLabel.setVisible(false);
				papPanel.setLocation(p.x + 20, p.y);
				break;// 오른쪽
			case 40:
				keyDown = true;
				papPanel.add(downLabel);
				upLabel.setVisible(false);
				downLabel.setVisible(true);
				papLabel.setVisible(false);
				rtLabel.setVisible(false);
				ltLabel.setVisible(false);
				papPanel.setLocation(p.x, p.y + 20);

				break;// 아래
			case KeyEvent.VK_SPACE:
				keySpace = true;
				if ((p.x >= 300 && p.x <= 400) && (p.y >= 800 && p.y <= 900)) {
					ForestView fv = new ForestView();
				}
				if ((p.x >= 350 && p.x <= 400) && (p.y >= 450 && p.y <= 500)) {
					Girin g = new Girin();
				}
				if ((p.x >= 150 && p.x <= 250) && (p.y >= 0 && p.y <= 5)) {
					shopPanel.add(notLabel);
					notLabel.setBounds(300, 700, 900, 150);
					notLabel.setVisible(true);
				}
				break;
			default:
				break;
			}

			papPanel.repaint();
		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			Point p = papLabel.getLocation();

			switch (e.getKeyCode()) {
			case 37:
				keyLeft = false;
				break; // 왼쪽
			case 38:
				keyUp = false;
				break;// 위
			case 39:
				keyRight = false;
				break;// 오른쪽
			case 40:
				keyDown = false;
				break;// 아래

			}
		}

	}


}