package ujeongri.com.gh.game.view;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ujeongri.com.gh.main.run.ThreadRun;

public class ForestView extends JFrame{
//	private Image pIcon;
	
 
 public ForestView() {
  super("우 - 정 - 리");
//  this.pIcon = pIcon;
  this.setBounds(0, 0, 1440, 900);
  this.forest();
 }
 
// public Image getpIcon() {
//	return pIcon;
//}
//
//public void setpIcon(Image pIcon) {
//	this.pIcon = pIcon;
//}

//라벨 이벤트때도 광역으로 쓸 수 있도록 위로 빼놓음
 JLabel bgLabel = new JLabel();
 JLabel papLabel = new JLabel();

 public void forest() {

 //panel 생성
 JPanel panel = new JPanel();
 //패널 위치값 초기화
 panel.setLayout(null);
 //패널 투명하게 없어도 되네
// panel.setOpaque(false);
 
 //배경 이미지 만들고 라벨에 붙임
 Image background = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
 bgLabel = new JLabel(new ImageIcon(background));
 bgLabel.setBounds(0, 0, 1440, 900);
 
 //빱이 이미지 만들고 라벨에 붙임
 Image pIcon = new ImageIcon("src/images/ppap/antppap.png").getImage().getScaledInstance(44, 98, 0);
 papLabel = new JLabel(new ImageIcon(pIcon));
 papLabel.setBounds(715, 10, 44, 98);
 
 
 //패널에 라벨들 붙임
 panel.add(papLabel);
 panel.add(bgLabel);
 
 //this에 패널 붙임
 this.add(panel);

// this.add(tv);
// panel.setVisible(true);
 this.setVisible(true);
 this.addKeyListener(new key());
 this.setFocusable(true);
 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 
class key implements KeyListener/*, Runnable*/ {

	@Override
	public void keyPressed(KeyEvent e) {
		Point p = papLabel.getLocation();
		
		if(e.getKeyCode() == 37) {
			ThreadRun tr1 = new ThreadRun();
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
	@Override
	public void keyReleased(KeyEvent e) {}

//	@Override
//	public void run() {
//		String str;
//		while(true) {
//			Image pIcon = new ImageIcon(str).getImage().getScaledInstance(44, 98, 0);
//			JLabel papLabel = new JLabel(new ImageIcon(pIcon));
//			papLabel.setBounds(715, 10, 44, 98);
//			try {
//				Thread.sleep(1000);
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//	}
//		
//		
//	}

	
}

}