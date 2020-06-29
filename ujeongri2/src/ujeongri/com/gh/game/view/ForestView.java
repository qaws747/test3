package ujeongri.com.gh.game.view;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ujeongri.com.gh.main.view.TestView;

public class ForestView extends JFrame{
	
	
	public ForestView() {
		super("우 - 정 - 리");
		this.setBounds(100, 100, 1440, 900);
//		this.setLayout(null);
		this.forest();
	}
	

	

	public void forest() {
	//panel 생성
	JPanel panel = new JPanel();
	
//	//숲 배경 설정
//	ImageIcon icon = new ImageIcon("src/images/forest.png");
//	Image img = icon.getImage();
//	Image img2 = img.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
//	ImageIcon icon2 = new ImageIcon(img2);
//	//이미지 라벨에 붙이기
//	JLabel label = new JLabel(icon2);
	
//	TestView tv = new TestView();
	Image icon = new ImageIcon("src/images/forest.png").getImage().getScaledInstance(1440, 900, 0);
	JLabel label = new JLabel(new ImageIcon(icon));
	label.setBounds(0, 0, 1440, 900);
	
	//빱 이미지 설정
	ImageIcon picon = new ImageIcon("src/images/ppap/antppap.png");
	Image pimg = picon.getImage();
	Image pimg2 = pimg.getScaledInstance(44, 98, Image.SCALE_SMOOTH);
	ImageIcon picon2 = new ImageIcon(pimg2);
	//button에 붙이고 사이즈 조정
	JLabel label2 = new JLabel() {
		
		public void paintComponent(Graphics g) {
			g.drawImage(picon2.getImage(), 300, 300, null);
		}
	};
	
//	TestView tv = new TestView();
	
//	tv.add(label);
//	label.add(tv);
	panel.add(label);
	panel.add(label2);
	this.add(panel);
//	this.add(tv);
//	panel.setVisible(true);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}