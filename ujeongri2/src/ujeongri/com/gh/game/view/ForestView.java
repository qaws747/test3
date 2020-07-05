package ujeongri.com.gh.game.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForestView extends JFrame implements Runnable, KeyListener {

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean playerMove = false;

	// 라벨 이벤트때도 광역으로 쓸 수 있도록 위로 빼놓음
	JLabel bgLabel = new JLabel();
	JLabel papLabel = new JLabel();
	// panel 생성
	JPanel panel = new JPanel();
	Toolkit tk = Toolkit.getDefaultToolkit();

	Image background = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
	Image img = new ImageIcon("src/images/wangnunramgi/ppap.png").getImage().getScaledInstance(150, 392, 0);
	Image buffimg;// 더블버퍼링용 입니다.
	Graphics gc;
	Thread th;
	int x, y; // 케릭터의 현재 좌표를 받을 변수
	int cnt; // 무한 루프를 카운터 하기 위한 변수
	int moveStatus; // 케릭터가 어디를 바라보는지 방향을 받을 변수

	public ForestView() {
		super("우 - 정 - 리");
		this.setBounds(0, 0, 1440, 900);
		this.forest();
		this.setVisible(true);
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void forest() {
		// 패널 위치값 초기화
		panel.setLayout(null);
		// 패널 투명하게 없어도 되네
// panel.setOpaque(false);

		// 배경 이미지 만들고 라벨에 붙임
//		Image background = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
//		bgLabel = new JLabel(new ImageIcon(background));
//		bgLabel.setBounds(0, 0, 1440, 900);

		// 빱이 이미지 만들고 라벨에 붙임
//		Image img = new ImageIcon("src/images/wangnunramgi/ppap.png").getImage().getScaledInstance(150, 392, 0);
//		papLabel = new JLabel(new ImageIcon(img));
//		papLabel.setBounds(715, 10, 44, 98);

		// 패널에 라벨들 붙임
		panel.add(papLabel);
		panel.add(bgLabel);

		// this에 패널 붙임
		this.add(panel);
	}
	
	public void init() {
		// 캐랙터 시작 위치
		x = 450;
		y = 550;

		moveStatus = 2;
//케릭터가 시작할때 바라보는 방향은 아래쪽입니다.
// 0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽

	}

	public void start() { // 기본적인 명령처리

		this.addKeyListener(this);
		th = new Thread(this);
		th.start();
	}
	public void run() { // 스레드 메소드, 무한 루프
		while (true) {
			try {
				keyProcess();
				repaint();

				Thread.sleep(20);
				cnt++;

			} catch (Exception e) {
			}
		}
	}
	public void paint(Graphics g) { // 더블버퍼링을 사용합니다.
		// 캐릭터가 사라지는 지점을 만든다.
		buffimg = createImage(1440, 900);
		gc = buffimg.getGraphics();
		update(g);
		
	}

	public void update(Graphics g) {
		// 더블 버퍼링을 이용해 버퍼에 그려진것을 가져옵니다.
		DrawImg();
		back(g);
		g.drawImage(buffimg, 0, 0, papLabel);
		
	}
	
	public void back(Graphics g) {
		g.drawImage(background, 0, 0, bgLabel);
	}

	public void DrawImg() {
		MoveImage(img, x, y, 53, 98);
//케릭터를 걸어가게 만들기 위해 추가로 만든 메소드 입니다.
		
		
	}

	public void MoveImage(Image img, int x, int y, int width, int height) {
//케릭터 이미지, 케릭터 위치, 케릭터 크기를 받습니다.
//받은 값을 이용해서 위의 이미지칩셋에서 케릭터를 잘라내
//표출하도록 계산하는 메소드 입니다.

		gc.setClip(x, y, width, height);
//현재 좌표에서 케릭터의 크기 만큼 이미지를 잘라 그립니다.

		if (playerMove) { // 케릭터의 움직임 여부를 판단합니다.
			if (cnt / 10 % 4 == 0) {
				gc.drawImage(img, x - (width * 0), y - (height * moveStatus), this);

			} else if (cnt / 10 % 4 == 1) {
				gc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);

			} else if (cnt / 10 % 4 == 2) {
				gc.drawImage(img, x - (width * 2), y - (height * moveStatus), this);

			} else if (cnt / 10 % 4 == 3) {
				gc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);
			}
//케릭터의 방향에 따라 걸어가는 모션을 취하는 
//케릭터 이미지를 시간차를 이용해 순차적으로 그립니다.

		} else {
			gc.drawImage(img, x - (width * 1), y - (height * moveStatus), this);
//케릭터가 움직이지 않으면 정지한 케릭터를 그립니다.

		}
	}


		public void keyProcess() {
			// 여기서는 단순 케릭터가 이동하는 좌표 말고도
			// 케릭터의 움직임 여부및 방향을 체크 합니다.
			playerMove = false;

			if (keyUp) {
				playerMove = true;
				y -= 8;
				moveStatus = 0;
			}

			if (keyDown) {
				y += 8;
				moveStatus = 2;
				playerMove = true;
			}

			if (keyLeft) {
				x -= 8;
				moveStatus = 3;
				playerMove = true;
			}

			if (keyRight) {
				x += 8;
				moveStatus = 1;
				playerMove = true;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				keyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				keyRight = true;
				break;
			case KeyEvent.VK_UP:
				keyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = true;
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				keyLeft = false;
				break;
			case KeyEvent.VK_RIGHT:
				keyRight = false;
				break;
			case KeyEvent.VK_UP:
				keyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				keyDown = false;
				break;
			}

		}
}
