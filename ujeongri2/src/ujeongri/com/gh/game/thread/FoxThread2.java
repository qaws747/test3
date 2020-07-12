package ujeongri.com.gh.game.thread;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FoxThread2 extends Thread {

	JPanel foxPanel = new JPanel();
	JPanel shopPanel = new JPanel();
	Image foxDown = new ImageIcon("src/images/fox/antfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxLt = new ImageIcon("src/images/fox/ltfox.png").getImage().getScaledInstance(35, 75, 0);
	Image foxRt = new ImageIcon("src/images/fox/rtfox.png").getImage().getScaledInstance(35, 75, 0);

	JLabel sLabel = new JLabel();
	JLabel foxDLabel = new JLabel();
	JLabel foxLLabel = new JLabel();
	JLabel foxRLabel = new JLabel();

	public FoxThread2() {
	}

	@Override
	public void run() {
		while (true) {
			shopPanel.add(foxDLabel);
			foxLLabel.setVisible(true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
