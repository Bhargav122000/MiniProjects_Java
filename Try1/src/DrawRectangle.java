import java.awt.*;
import javax.swing.*;

/* Create a new graphics component that draws two <strong class="highlight">rectangles</strong> 
*/
public class DrawRectangle extends JPanel
{
private int width;
private int length;
private int y;
private int x;
   // overrides javax.swing.JComponent.paintComponent
   public void paintComponent(Graphics g)
   {
      //Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
		
      //Construct a rectangle then <strong class="highlight">draw</strong> it
      Rectangle box = new Rectangle(x, y, width, length);
      g2.draw(box);
   }
   public DrawRectangle(int x, int y, int Width, int Length)
   {	   
	   this.x = x;
	   this.y = y;
	   this.width = Width;
	   this.length = Length;	   
   }

public static void main(String[] args)
{
   JFrame frame = new JFrame();
   final int FRAME_WIDTH = 300;
   final int FRAME_HEIGHT = 400;
	
   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
   frame.setTitle("Test Picture");
   frame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
   JPanel jPanel1=new JPanel();//panel1
   jPanel1.setVisible(true);
   DrawRectangle component1 = new 
         DrawRectangle(20, 20 , 20 ,20);// panel2 on which i am trying to draw rectangle
   component1.setVisible(true);
   jPanel1.add(component1);//adding panel2 on to panel1
  
   frame.add(jPanel1);
   frame.setVisible(true);
}
}




