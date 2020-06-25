package ujeongri.com.gh.game.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerView  {
	private int x, y;
	private int a = 10;

	public PlayerView() {
//		setLayout(null);
//	this.setBounds(300, 300, 44, 92);


	Image pappIcon = new ImageIcon("src/images/antppap.png").getImage().getScaledInstance(44, 92, 0);
	ImageIcon realicon = new ImageIcon(pappIcon);

//	JButton pappButton = new JButton(realicon);
//	pappButton.setBounds(300, 300, 44, 92);
//	pappButton.setBorderPainted(false);
	JLabel pappLabel = new JLabel(new ImageIcon(pappIcon));
	pappLabel.setBounds(300, 300, 44, 98);

//	pappLabel.addKeyListener(new KeyAdapter() {
//	});

//	KeyL = new KeyBoardTestListenter();
//	pappButton.addKeyListener((KeyListener) KeyL);
//	setFocusable(true);

//	x = 100;
//	y = 100;

//	toolkit = this.getToolkit();


//	this.add(pappButton);
	pappLabel.setVisible(true);
	}

}
//	class move implements KeyListener {
//
//		@Override
//		public void keyTyped(KeyEvent e) {
//			//좌표를 n만큼 이동하고 이미지를 반복한다.
//			
//		}
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			int keyCode = e.getKeyCode();
// 			String strKey = KeyEvent.getKeyText(keyCode);
//			System.out.println("Pressed Up");
//
// 			if( strKey.equals("Up")) {
// 				System.out.println("Pressed Up");
//
// 				if( y > 0 )	{
// 					y -= 10;
// 				} repaint();
// 			}
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//			
//		}
//		
//	}
//	
//	
//} 