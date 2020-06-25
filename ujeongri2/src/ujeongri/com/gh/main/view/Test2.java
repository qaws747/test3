import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test2 extends JFrame{
 JLabel la = new JLabel("@");
 MyPanel panel = new MyPanel(); // 패널 객체
 
 public Test2(){
  setTitle("방향키로 움직이기");
  setSize(300,300); // 창크기
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시역활
  this.setContentPane(panel); // 패널 적용
  setVisible(true); // 창패널 보여주기 여부
  panel.requestFocus(); // 포커스 점령
 }
 
 class MyPanel extends JPanel{
  public MyPanel(){
   setLayout(null); // 널레이아웃
   la.setSize(20,20);
   la.setLocation(50,50);
   add(la);
   addKeyListener(new MyKeyListener()); //리스너 적응
  }
 }
 
 class MyKeyListener extends KeyAdapter{
  public void keyPressed(KeyEvent e){
   int key = e.getKeyCode();
   switch(key){   
   case KeyEvent.VK_UP:
    if(la.getY() <= 0)
     return;
    else
     la.setLocation(la.getX(),la.getY()-5);
    break;
    
   case KeyEvent.VK_DOWN:
    if(la.getY()+la.getHeight()+5 > panel.getHeight())
     return;
    else
     la.setLocation(la.getX(),la.getY()+5);
    break;
    
   case KeyEvent.VK_LEFT:
    if(la.getX() <= 0)
     return;
    else
     la.setLocation(la.getX()-5,la.getY());
    break;
    
   case KeyEvent.VK_RIGHT:
    if(la.getX() + la.getWidth()+5 > panel.getWidth())
     return;
    else
     la.setLocation(la.getX()+5,la.getY());
    break;
   }
  }
 }
 
 public static void main(String args[]){
  new Test2();
 }
}
