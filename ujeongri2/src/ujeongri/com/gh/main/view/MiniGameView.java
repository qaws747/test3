package ujeongri.com.gh.main.view;

	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.*;

	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;
	import javax.sound.sampled.LineUnavailableException;
	import javax.swing.*;


	public class MiniGameView extends JPanel {
		private MainView mf;
		private MiniGameView miniGameView;
		GameManager gm = new GameManager();
		File file = new File("src\\com\\kh\\project\\bgm\\띠딩2.wav");
		AudioInputStream stream;
		Clip clip;
		
		//플레이어 호출
		Player p;
		
		int[] yarr = {-15, -13, -10, -6, -4, 4, 6, 10, 13, 15};
		int[] x1arr = {-12, -10, -8, -6, -4, -4, -6, -8, -10, -12};
		int[] x2arr = {12, 10, 8, 6, 4, 4, 6, 8, 10, 12};
		
		//이미지 모음
		Image background;
		Image ladder = new ImageIcon("src/image/minigame/사다리.png").getImage().getScaledInstance(70, 160, 0);
		Image obst = new ImageIcon("src/image/minigame/broken-bottle.png").getImage().getScaledInstance(30, 30, 0);
		Image penzL = new ImageIcon("src/image/minigame/pengL.gif").getImage().getScaledInstance(80, 80, 0);
		Image penzR = new ImageIcon("src/image/minigame/pengR.gif").getImage().getScaledInstance(80, 80, 0);
		Image monster1 = new ImageIcon("src\\image\\minigame\\angryshark.png").getImage().getScaledInstance(50, 60, 0);
		Image garbage1 = new ImageIcon("src/image/minigame/담배.png").getImage().getScaledInstance(50, 50, 0);
		Image garbage2 = new ImageIcon("src/image/minigame/can1.png").getImage().getScaledInstance(50, 50, 0);
		Image garbage3 = new ImageIcon("src/image/minigame/과자봉지.png").getImage().getScaledInstance(50, 50, 0);

		//펭귄 패널
		
		JPanel penz_p = new JPanel();
		//상어 패널
		JPanel monster_p1 = new JPanel();
		JPanel monster_p2 = new JPanel();
		JPanel monster_p3 = new JPanel();
		//쓰레기 패널
		JPanel garbage_p1 = new JPanel();
		JPanel garbage_p2 = new JPanel();
		JPanel garbage_p3 = new JPanel();
		
		JPanel gameOver_p = new JPanel();

		//라벨(배경, 펭귄왼쪽, 펭귄오른쪽)
		JLabel label;
		JLabel penz_l;
		JLabel penz_r;
		//상어 라벨
		JLabel monster_l1;
		JLabel monster_l2;
		JLabel monster_l3;
		
		JLabel gameOver_l;
		JLabel top_l;
		
		JButton over_b;
		
		boolean keyUp = false;
		boolean keyDown = false;
		boolean keyLeft = false;
		boolean keyRight = false; 
		boolean playerMove = false;
		boolean jumping = false;
		boolean falling = false;
		
		int direction;
		int countGarbege = 0;
		public static int count = 0;

		int xm1 = monster_p1.getX();
		int ym1 = monster_p1.getY();
		int xm2 = monster_p2.getX();
		int ym2 = monster_p2.getY();
		int xm3 = monster_p3.getX();
		int ym3 = monster_p3.getY();
		
		JLabel obst1_2;
		JLabel obst2_2;
		JLabel obst3_1;
		JLabel obst3_2;
		JLabel obst4_2;
		
		Thread th;
		
		Thread tp = new Jump();
		Thread tf = new Fall();
		Thread g1 = new Thread(new Garbagespawn());
		
		//상어랑 hit 판별 생성자
		
		public boolean hit() {
		
			int x1 = penz_p.getX();
			int y1 = penz_p.getY();
			int xm1 = monster_p1.getX();
			int xm2 = monster_p2.getX();
			int xm3 = monster_p3.getX();
			int xo1_2 = obst1_2.getX();
			int xo2_2 = obst2_2.getX();
			int xo3_1 = obst3_1.getX();
			int xo3_2 = obst3_2.getX();
			int xo4_2 = obst4_2.getX();
			
			if(y1 == 520) {
				if(((x1-10) <= xo1_2) && ((x1+25) >= xo1_2)) {
					return true;
				}
			} else if(y1 == 370) {
				if((((x1-25) <= xm1) && ((x1+55) >= xm1))
						||(((x1-10) <= xo2_2) && ((x1+25) >= xo2_2))) {
					return true;
				}
			} else if(y1 == 220) {
				if(((x1-25) <= xm2) && ((x1+55) >= xm2)
						|| ((x1-10) <= xo3_1) && ((x1+25) >= xo3_1)) {
					return true;
				}
			} else if(y1 == 70) {
				if((((x1-25) <= xm3) && ((x1+55) >= xm3))
						||(((x1-10) <= xo4_2) && ((x1+25) >= xo4_2))){
					return true;
				}
			} 
			return false;
		
		}
			
		public boolean gbbl = false;
		
		public MiniGameView() {}
		public MiniGameView(MainView mf, Player p) {
			try {
				stream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(stream);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			this.p = p;
			this.miniGameView = this;
			this.mf = mf;
			
			this.setLayout(null);
			MusicPlayer.MusicStart("src\\com\\kh\\project\\bgm\\너구리-처음꺼.wav");
			//배경이미지
			background = new ImageIcon("src/image/minigame/minigamebackground.png").getImage().getScaledInstance(360, 640, 0);
			label = new JLabel(new ImageIcon(background));
			label.setBounds(0, 0, 360, 640);
			
			//상어 라벨
			monster_l1 =  new JLabel(new ImageIcon(monster1));
			monster_l1.setBounds(0, 0, 50, 60);
			monster_l2 =  new JLabel(new ImageIcon(monster1));
			monster_l2.setBounds(0, 0, 50, 60);
			monster_l3 =  new JLabel(new ImageIcon(monster1));
			monster_l3.setBounds(0, 0, 50, 60);
			
			//라벨
			penz_l = new JLabel(new ImageIcon(penzL));
			penz_l.setSize(80, 140);
			penz_l.setLocation(0, 0);
			penz_r = new JLabel(new ImageIcon(penzR));
			penz_r.setSize(80, 140);
			penz_r.setLocation(0, 0);
			
			
			over_b = new JButton(new ImageIcon(new ImageIcon("src/image/minigame/toxic-waste.png").getImage().getScaledInstance(98, 35, 0)));
			over_b.setBounds(131, 530, 98, 35);
			
			
			//방해물
			obst1_2 = new JLabel(new ImageIcon(obst));
			obst1_2.setBounds(150, 590, 30, 30);
			obst2_2 = new JLabel(new ImageIcon(obst));
			obst2_2.setBounds(5000, 4400, 30, 30);
			obst3_1 = new JLabel(new ImageIcon(obst));
			obst3_1.setBounds(240, 290, 30, 30);
			obst3_2 = new JLabel(new ImageIcon(obst));
			obst3_2.setBounds(160, 290, 30, 30);
			obst4_2 = new JLabel(new ImageIcon(obst));
			obst4_2.setBounds(10, 140, 30, 30);
			
			//사다리
			JLabel ladder1_1 = new JLabel(new ImageIcon(ladder));
			ladder1_1.setBounds(50, 460, 90, 160);
			JLabel ladder1_2 = new JLabel(new ImageIcon(ladder));
			ladder1_2.setBounds(280, 460, 90, 160);
			JLabel ladder2_1 = new JLabel(new ImageIcon(ladder));
			ladder2_1.setBounds(-10, 310, 90, 160);
			JLabel ladder2_2 = new JLabel(new ImageIcon(ladder));
			ladder2_2.setBounds(250, 310, 90, 160);
			JLabel ladder3_1 = new JLabel(new ImageIcon(ladder));
			ladder3_1.setBounds(20, 160, 90, 160);
			JLabel ladder3_2 = new JLabel(new ImageIcon(ladder));
			ladder3_2.setBounds(170, 160, 90, 160);
			
			top_l = new JLabel();
			top_l.setBounds(0, 0, 360, 640);
			
			
			//펭귄 패널에 위치 크기 조정
			penz_p.add(penz_l);
			penz_p.setOpaque(false);
			penz_p.setLocation(280, 520);
			penz_p.setSize(80, 140);
			//상어 패널에 라벨 붙이고 위치 크5기 조정
			monster_p1.add(monster_l1);
			monster_p1.setBounds(0, 60, 50, 60);
			monster_p1.setOpaque(false);
			monster_p2.add(monster_l2);
			monster_p2.setBounds(0, 240, 50, 60);
			monster_p2.setOpaque(false);
			monster_p3.add(monster_l3);
			monster_p3.setBounds(0, 370, 50, 60);
			monster_p3.setOpaque(false);
			
			if(hit()==true) {
				MusicPlayer.MusicStart("src\\com\\kh\\project\\bgm\\쓰레기1.wav");
				this.add(over_b);
				
			}
			
			this.add(top_l);
			
			//해당 패널에 다른 패널 및 라벨들 붙여주기
			this.add(penz_p);
			
			this.add(monster_p1);
			this.add(monster_p2);
			this.add(monster_p3);
			
			
			this.add(obst1_2);
			this.add(obst2_2);
			this.add(obst3_1);
			this.add(obst3_2);
			this.add(obst4_2);
			
			this.add(ladder1_1);
			this.add(ladder1_2);
			this.add(ladder2_1);
			this.add(ladder2_2);
			this.add(ladder3_1);
			this.add(ladder3_2);
			
			this.add(label);
			Thread tm1 = new Thread(new Monster(this));
			tm1.start();
			
			//키보드 입력
			penz_p.addKeyListener(new Key());
			penz_p.setFocusable(true);
			
			mf.add(this);
			mf.setVisible(true);
			mf.repaint();
		}

		class Key implements KeyListener{
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int x = penz_p.getX();
				int y = penz_p.getY();
				
				if(((x >= 120 && x <= 200) && (y == 370))
						|| ((x >= 70 && x <= 80) && (y == 220))
						|| (((x >= 90 && x <= 110) || (x >= 220 && x <= 250)) && (y == 70))) {
				new Fall().start();
				}
				
				if(!gbbl) {
					gbbl = true;
					System.out.println(gbbl);
					g1.start();
				}
				
				for(int i = 0; i < count; i++) {
					if((gm.getLarr()[i].getX() + 10 < x)&&(gm.getLarr()[i].getX() +30 > x)||
							(gm.getLarr()[i].getX() < x-10)&&(gm.getLarr()[i].getX() > x+30)) {
						if(gm.getLarr()[i].getY() == y) {
							gm.getLarr()[i].setLocation(1000, 1000);
							clip.start();
							countGarbege++;
							System.out.println(countGarbege);
							try {
								stream = AudioSystem.getAudioInputStream(file);
								clip = AudioSystem.getClip();
								clip.open(stream);
							} catch (Exception e1) {
								
								e1.printStackTrace();
							}
							
						}
					}
				}
				
				if(hit()==true) {
					p.setMyGarbage(p.getMyGarbage() + countGarbege);
					ChangePanel.changePanel(mf, miniGameView, new GemeOverView(mf, p, countGarbege));
					
				}
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					keyUp = true;
					direction = 0;
					System.out.println("up");
					//올라갈 수 있는 사다리 구역 범위 지정
					if((((x >= 50 && x <= 60) || (x >= 280 && x <= 290 )) && (y <= 520 && y >= 380))
							|| (((x >= -10 && x <= 0) || (x >= 250 && x <= 260 )) && (y <= 370 && y >= 230))
							|| (((x >= 20 && x <= 30) || (x >= 170 && x <= 180 )) && (y <= 220 && y >= 80))) {
						penz_p.setLocation(x, y-10);
						System.out.println(penz_p.getLocation());
					}; break;
				case KeyEvent.VK_DOWN: 
					keyDown = true;
					direction = 0;
					System.out.println("down");
					//내려갈 수 있는 사다리 구역 범위 지정
					if((((x >= 50 && x <= 60) || (x >= 280 && x <= 290 )) && (y <= 510 && y >= 370))
							|| (((x >= -10 && x <= 0) || (x >= 250 && x <= 260 )) && (y <= 360 && y >= 220))
							|| (((x >= 20 && x <= 30) || (x >= 170 && x <= 180 )) && (y <= 210 && y >= 70))) {
						penz_p.setLocation(x, y+10);
						System.out.println(penz_p.getLocation());
					}; break;
				case KeyEvent.VK_LEFT:
					keyLeft = true;
					direction = 1;
					System.out.println("left");
					//층마다 좌우로 움직일 수 있는 범위 지정
					if((x > -20) && (y == 70 || y == 220 || y == 370 || y == 520)) {
						penz_p.add(penz_l);
						penz_r.setVisible(false);
						penz_l.setVisible(true);
						penz_p.setLocation(x-10, y);
						System.out.println(penz_p.getLocation());
					}; break;
				case KeyEvent.VK_RIGHT:
					keyRight = true;
					direction = 2;
					System.out.println("right");
					//층마다 좌우로 움직일 수 있는 범위 지정
					if((x < 300) && (y == 70 || y == 220 || y == 370 || y == 520)) {
						penz_p.add(penz_r);
						penz_l.setVisible(false);
						penz_r.setVisible(true);
						penz_p.setLocation(x+10, y);
					}; break;
				case KeyEvent.VK_SPACE:
					if(!jumping) {
						jumping = true;
						new Jump().start();
						System.out.println("펭즈의 좌표" + penz_p.getLocation());
					}
					jumping = false;
					break;
				default: break;
				}
				penz_p.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT :
				keyLeft = false;
				break;
				case KeyEvent.VK_RIGHT :
				keyRight = false;
				break;
				case KeyEvent.VK_UP :
				keyUp = false;
				break;
				case KeyEvent.VK_DOWN :
				keyDown = false;
				break;
				}
			}
		}
		
		
		class Fall extends Thread {
			int x = penz_p.getX();
			int y = penz_p.getY();
			
			@Override
			public void run() {
				
				for(int i = 0; i < 15; i++){
					y += 10;
					penz_p.setLocation(x, y);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		class Jump extends Thread{
			//x, y 좌표 배열로 선언
			int x = penz_p.getX();
			int y = penz_p.getY();
			
			@Override
			public void run() {
				jumping = true;
				for(int i = 0; i < 10; i++) {
					if(direction == 1) {
						y += yarr[i];
						x += x1arr[i];
						if(x <-20) {
							x = 20;
							penz_p.setLocation(x, y);
						} else {
							penz_p.setLocation(x, y);
						}
					} else if(direction == 2) {
						
						y += yarr[i];
						x += x2arr[i];
						if(x > 300) {
							x = 300;
							penz_p.setLocation(x, y);
						} else {
							penz_p.setLocation(x, y);
						}
					}
					try {
						penz_p.repaint();
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}

		class Garbagespawn implements Runnable{
			int x = penz_p.getX();
			int y = penz_p.getY();
			@Override
			public void run() {
				while(count!=10) {
					top_l.add(gm.getLarr()[count]);
					count++;
					
					try {
						Thread.sleep(2000);
						top_l.repaint();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		
		
		class MyMouseAdapter extends MouseAdapter {
			@Override
			public void mousePressed(MouseEvent e) {
//				ChangePanel.changePanel(mf, miniGameView, new HomeView(mf, p));
			}
		}

	}
		
