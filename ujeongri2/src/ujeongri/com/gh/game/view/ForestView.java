package ujeongri.com.gh.game.view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForestView extends JFrame {
	
	public ForestView() {
		super("우 - 정 - 리");
		this.setBounds(100, 100, 1440, 900);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		
		ImageIcon forest = new ImageIcon("src/images/forest.png");
		JLabel label = new JLabel(forest);
		label.setBounds(0, 0, 720, 450);
		
		ImageIcon pappIcon = new ImageIcon("src/images/ppap/antppap.png");
		JButton pappButton = new JButton(pappIcon);
		pappButton.setSize(44, 98);
		pappButton.setLocation(600, 0);
//		pappButton.setBounds(300, 300, 44, 98);
		pappButton.setBorderPainted(false);
		
		label.add(pappButton);
		panel.add(label);
//		panel.add(pappButton);
		this.add(panel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

}
