import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class DrawDisplay
{
  private JLabel label;
  private BufferedImage image;
  
  public DrawDisplay(int size)
  {
    image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, size, size);
    
    JFrame frame = new JFrame("DrawDisplay");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    label = new JLabel(new ImageIcon(image));
    frame.getContentPane().add(label);   
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public void drawSquare(int x, int y, int size)
  {
    Graphics g = image.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(x, y, size, size);
    label.setIcon(new ImageIcon(image));
  }
}