package ujeongri.com.gh.game.view;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Girin extends JFrame {

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean keySpace = false;
	boolean playerMove = false;

	// 배경화면 라벨
	JLabel bgLabel = new JLabel();
	// 빱 라벨
	JLabel papLabel;
	JLabel upLabel;
	JLabel downLabel;
	JLabel rtLabel;
	JLabel ltLabel;

	JPanel papPanel = new JPanel();
	JPanel bgPanel = new JPanel();

	Image current = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(39, 94, 0);
	Image up = new ImageIcon("src/images/ppap/postppap1.png").getImage().getScaledInstance(39, 94, 0);
	Image down = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(39, 94, 0);
	Image rt = new ImageIcon("src/images/ppap/rtppap.png").getImage().getScaledInstance(39, 94, 0);
	Image lt = new ImageIcon("src/images/ppap/ltppap.png").getImage().getScaledInstance(39, 94, 0);

	int x, y;

	public Girin() {
		super("우 - 정 - 리");
		this.setBounds(0, 0, 1440, 900);
		this.cafe();
		this.setLayout(null);
	}

	public void cafe() {

		Image cafeImg = new ImageIcon("src/images/girin.png").getImage().getScaledInstance(610, 850, 0);
		bgLabel = new JLabel(new ImageIcon(cafeImg));
		bgLabel.setBounds(300, 10, 1440, 900);

		papLabel = new JLabel(new ImageIcon(current));
		papLabel.setSize(39, 94);
		upLabel = new JLabel(new ImageIcon(up));
		upLabel.setSize(39, 94);
		downLabel = new JLabel(new ImageIcon(down));
		downLabel.setSize(39, 94);
		rtLabel = new JLabel(new ImageIcon(rt));
		rtLabel.setSize(39, 94);
		ltLabel = new JLabel(new ImageIcon(lt));
		ltLabel.setSize(39, 94);

		papPanel.add(ltLabel);
		papPanel.setOpaque(false);
		papPanel.setBounds(950, 350, 39, 94);

		bgPanel.add(bgLabel);

		this.add(papPanel);
		this.add(bgPanel);

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
				if (p.x >= 450) {
					papPanel.add(ltLabel);
					upLabel.setVisible(false);
					downLabel.setVisible(false);
					papLabel.setVisible(false);
					rtLabel.setVisible(false);
					ltLabel.setVisible(true);
					papPanel.setLocation(p.x - 29, p.y);
				}
				;
				break; // 왼쪽
			case 38:
				keyUp = true;
				if (p.y >= 5) {
					papPanel.add(upLabel);
					upLabel.setVisible(true);
					downLabel.setVisible(false);
					papLabel.setVisible(false);
					rtLabel.setVisible(false);
					ltLabel.setVisible(false);
					papPanel.setLocation(p.x, p.y - 20);
				}
				;
				break;// 위
			case 39:
				keyRight = true;
				if (p.x <= 970) {
					papPanel.add(rtLabel);
					upLabel.setVisible(false);
					downLabel.setVisible(false);
					papLabel.setVisible(false);
					rtLabel.setVisible(true);
					ltLabel.setVisible(false);
					papPanel.setLocation(p.x + 20, p.y);
				}
				;
				break;// 오른쪽
			case 40:
				keyDown = true;
				if (p.y <= 729) {
					papPanel.add(downLabel);
					upLabel.setVisible(false);
					downLabel.setVisible(true);
					papLabel.setVisible(false);
					rtLabel.setVisible(false);
					ltLabel.setVisible(false);
					papPanel.setLocation(p.x, p.y + 20);
				}
				;
				break;// 아래
			case KeyEvent.VK_SPACE:
				keySpace = true;
				if ((p.x >= 925 && p.x <= 970) && (p.y >= 250 && p.y <= 400)) {
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
