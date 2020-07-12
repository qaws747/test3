package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForestView extends JFrame {

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean keySpace = false;
	boolean playerMove = false;

	// 라벨 이벤트때도 광역으로 쓸 수 있도록 위로 빼놓음
	JLabel bgLabel = new JLabel();
	// panel 생성
	JPanel panel = new JPanel();
	JPanel papPanel = new JPanel();

	Image background = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
//	Image img = new ImageIcon("src/images/wangnunramgi/ppap.png").getImage().getScaledInstance(150, 392, 0);
	Image current = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(44, 98, 0);
	Image up = new ImageIcon("src/images/ppap/postppap1.png").getImage().getScaledInstance(44, 98, 0);
	Image down = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(44, 98, 0);
	Image rt = new ImageIcon("src/images/ppap/rtppap.png").getImage().getScaledInstance(44, 98, 0);
	Image lt = new ImageIcon("src/images/ppap/ltppap.png").getImage().getScaledInstance(44, 98, 0);

	JLabel papLabel;
	JLabel upLabel;
	JLabel downLabel;
	JLabel rtLabel;
	JLabel ltLabel;

	int x, y; // 케릭터의 현재 좌표를 받을 변수

	public ForestView() {
		super("우 - 정 - 리");

		this.setBounds(0, 0, 1440, 900);
		this.forest();

	}

	public void forest() {
		// 패널 위치값 초기화
//		this.setLayout(null);
		// 패널 투명하게 없어도 되네
// panel.setOpaque(false);

		// 배경 이미지 만들고 라벨에 붙임
		Image background = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
		bgLabel = new JLabel(new ImageIcon(background));
		bgLabel.setBounds(0, 0, 1440, 900);

		// 빱이 이미지 만들고 라벨에 붙임
//		Image img = new ImageIcon("src/images/wangnunramgi/ppap.png").getImage().getScaledInstance(150, 392, 0);
//		Image current = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(44, 98, 0);
//		Image img = new ImageIcon(str).getImage().getScaledInstance(44, 98, 0);
//		Image current = new ImageIcon().getImage().getScaledInstance(44, 98, 0);
//		papLabel = new JLabel(new ImageIcon(current));
//		papLabel.setBounds(715, 10, 44, 98);
		papLabel = new JLabel(new ImageIcon(current));
		papLabel.setSize(44, 98);
		upLabel = new JLabel(new ImageIcon(up));
		upLabel.setSize(44, 98);
		downLabel = new JLabel(new ImageIcon(down));
		downLabel.setBounds(0, 0, 44, 98);
		rtLabel = new JLabel(new ImageIcon(rt));
		rtLabel.setBounds(0, 0, 44, 98);
		ltLabel = new JLabel(new ImageIcon(lt));
		ltLabel.setBounds(0, 0, 44, 98);

		// 패널에 라벨들 붙임
		papPanel.add(papLabel);
		papPanel.setOpaque(false);
		papPanel.setBounds(715, 10, 44, 98);
		papPanel.addKeyListener(new key());
		papPanel.setFocusable(true);
		panel.add(bgLabel);

		// this에 패널 붙임
		this.add(papPanel);
		this.add(panel);
		this.setVisible(true);
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
				if ((p.x >= 710 && p.x <= 720) || p.y <= 10) {
					ShopView sv = new ShopView();
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
//			Point p = papLabel.getLocation();

			switch (e.getKeyCode()) {
			case 37:
				keyLeft = false;
//				papPanel.setLocation(p.x - 20, p.y);
				break; // 왼쪽
			case 38:
				keyUp = false;
//				papPanel.setLocation(p.x, p.y - 20);
				break;// 위
			case 39:
				keyRight = false;
//				papPanel.setLocation(p.x + 20, p.y);
				break;// 오른쪽
			case 40:
				keyDown = false;
//				papPanel.setLocation(p.x, p.y + 20);
				break;// 아래
			}
		}

	}
}