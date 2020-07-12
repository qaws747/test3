package ujeongri.com.gh.game.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ujeongri.com.gh.game.view.PlayerController.key;

public class PlayerController extends JFrame {

	Image image;
	Insets insets;

	public PlayerController() {
		super();
		ImageIcon icon = new ImageIcon("src/images/wangnunramgi/ppap.png");
		image = icon.getImage();

		this.addKeyListener(new key());

//	    image = createImage(new FilteredImageSource(image.getSource(),
//	        new CropImageFilter(0, 0, 600, 1000)));
	}


	public class key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case 37: BufferedImage img = ((BufferedImage) image).getSubimage(0, 500, 500, 1000); //fill in the corners of the desired crop location here
			BufferedImage copyOfImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics g = copyOfImage.createGraphics();
			g.drawImage(img, 0, 0, null);
//			return copyOfImage;
				break;

			case 38:
				break;

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String args[]) {
		JFrame f = new PlayerController();
		f.setSize(500, 1000);
		f.show();
	}

}