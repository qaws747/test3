package ujeongri.com.gh.main.view;

import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test2 extends JFrame implements Runnable {
	JLabel bgLabel = new JLabel();
	// panel 생성
	JPanel wPanel = new JPanel();
	JPanel papPanel = new JPanel();
	JPanel rgPanel = new JPanel();
	JPanel foxPanel = new JPanel();
	JPanel shopPanel = new JPanel();
	
	Image foxDown = new ImageIcon("src/images/fox/antfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxLt = new ImageIcon("src/images/fox/ltfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxRt = new ImageIcon("src/images/fox/rtfox.png").getImage().getScaledInstance(35, 75, 0);
	
	JLabel papLabel;
	JLabel upLabel;
	JLabel downLabel;
	JLabel rtLabel;
	JLabel ltLabel;

	JLabel sLabel = new JLabel();
	JLabel wLabel = new JLabel();
	JLabel rgLabel = new JLabel();
	JLabel foxDLabel = new JLabel();
	JLabel foxLLabel = new JLabel();
	JLabel foxRLabel = new JLabel();

	
	
	public Test2() {
		super("우 - 정 - 리");
		this.setBounds(0, 0, 1440, 900);
		
		foxDLabel = new JLabel(new ImageIcon(foxDown));
		foxDLabel.setSize(35, 75);
		foxDLabel.setLocation(700, 150);
		foxLLabel = new JLabel(new ImageIcon(foxLt));
		foxLLabel.setSize(35, 75);
		foxRLabel = new JLabel(new ImageIcon(foxRt));
		foxRLabel.setSize(35, 75);
		
		shopPanel.add(foxDLabel);
		
		run();
		this.add(shopPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void run() {
		while (true) {
			shopPanel.add(foxDLabel);
			foxDLabel.setVisible(true);
			foxLLabel.setVisible(true);
			foxLLabel.setVisible(true);
			foxRLabel.setVisible(true);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}
	}

}
