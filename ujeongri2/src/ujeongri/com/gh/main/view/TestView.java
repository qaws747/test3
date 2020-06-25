package ujeongri.com.gh.main.view;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 

public class TestView extends JFrame{
	private int x;
	private int y;
	

 
 public TestView(int x, int y) throws HeadlessException {
		super();
		this.x = x;
		this.y = y;
	}
public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
public TestView() {
	 super("우 - 정 - 리");
		this.setBounds(100, 100, 1440, 900);
		this.setLayout(null);
		this.setVisible(true);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
		ImageIcon pappIcon = new ImageIcon("src/images/antppap.png");
		JButton pappButton = new JButton(pappIcon);
		pappButton.setBounds(300, 300, 44, 98);
		pappButton.setBorderPainted(false);
		
		pappButton.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent k){
				   
			    switch(k.getKeyCode()){
			     case KeyEvent.VK_UP:
			      k.setLocation(k.getX(), k.getY()-10);
			      break;
			   
			     case KeyEvent.VK_DOWN:
			      k.setLocation(k.getX(), k.getY()+10);
			      break;
			     case KeyEvent.VK_LEFT:
			      k.setLocation(k.getX()-10, k.getY());
			      break;
			     case KeyEvent.VK_RIGHT:
			      k.setLocation(k.getX()+10, k.getY());
			      break;
			   
			    }
		});

  

 }
 public static void main(String[] args) {
  new TestView();
  
 
}



}