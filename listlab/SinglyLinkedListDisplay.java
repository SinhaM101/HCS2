import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.reflect.*;
import javax.swing.*;

public class SinglyLinkedListDisplay implements ActionListener
{
  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public static void main(String[] args)
  {
    new SinglyLinkedListDisplay(new SinglyLinkedList<String>());
  }
  
  private SinglyLinkedList<String> list;
  private JLabel imageLabel;
  private JLabel returnLabel;
  private BufferedImage image;
  private int nextChar;
  private JButton removeButton;
  
  public SinglyLinkedListDisplay(SinglyLinkedList<String> list)
  {
    this.list = list;
    nextChar = 0;
    image = new BufferedImage(700, 100, BufferedImage.TYPE_INT_RGB);
    
    JFrame frame = new JFrame("SinglyLinkedList");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
    
    imageLabel = new JLabel();
    update();
    frame.getContentPane().add(imageLabel);
    
    returnLabel = new JLabel(" ");
    returnLabel.setFont(new Font(null, Font.PLAIN, 18));
    frame.getContentPane().add(returnLabel);
    
    JButton button = new JButton("Fill with test data");
    button.setActionCommand("fill");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    
    button = new JButton("size()");
    button.setActionCommand("size");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    
    button = new JButton("get(int index)");
    button.setActionCommand("get");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    
    button = new JButton("set(int index, E obj)");
    button.setActionCommand("set");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    
    button = new JButton("add(E obj)");
    button.setActionCommand("add");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    
    try
    {
      if (SinglyLinkedList.class.getMethod("add", int.class, Object.class) != null)
      {
        button = new JButton("add(int index, E obj)");
        button.setActionCommand("insert");
        button.addActionListener(this);
        frame.getContentPane().add(button);
      }
    }
    catch(NoSuchMethodException e)
    {
    }
    
    removeButton = new JButton("remove(int index)");
    removeButton.setActionCommand("remove");
    removeButton.addActionListener(this);
    frame.getContentPane().add(removeButton);
    
    frame.pack();
    frame.setVisible(true);    
  }
  
  private void update()
  {
    Graphics g = image.getGraphics();
    
    ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                     RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, image.getWidth(), image.getHeight());
    
    g.setColor(Color.BLACK);
    g.drawString("size:  " + list.size, 10, 20);
    if (list.first == null)
      g.drawString("first:  null", 10, 70);
    else
    {
      g.drawString("first", 10, 70);
      g.drawLine(40, 65, 70, 65);
      g.drawLine(65, 60, 70, 65);
      g.drawLine(65, 70, 70, 65);
    }
    
    int x = 70;
    ListNode<String> temp = list.first;
    while (temp != null)
    {
      g.drawRect(x, 50, 30, 30);
      g.drawString("" + temp.getValue(), x + 10, 70);
      g.drawRect(x + 30, 50, 30, 30);
      if (temp.getNext() == null)
        g.drawLine(x + 60, 50, x + 30, 80);
      else
      {
        g.drawLine(x + 45, 65, x + 90, 65);
        g.drawLine(x + 85, 60, x + 90, 65);
        g.drawLine(x + 85, 70, x + 90, 65);
      }
      x += 90;
      temp = temp.getNext();
    }
    
    imageLabel.setIcon(new ImageIcon(image));
  }
  
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();
    
    returnLabel.setText(" ");
    String obj = ALPHABET.charAt(nextChar) + "";
    
    if (command.equals("fill"))
    {
      list.size = (int)(Math.random() * 6 + 1);
      list.first = null;
      //create reversed list of characters
      String chars = "";
      for (int i = 0; i < list.size; i++)
      {
        chars = ALPHABET.charAt(nextChar) + chars;
        nextChar = (nextChar + 1) % 26;
      }
      for (int i = 0; i < list.size; i++)
        list.first = new ListNode<String>(chars.charAt(i) + "", list.first);
      update();
      returnLabel.setText("filled with test data");
    }
    else if (command.equals("size"))
    {
      int result = list.size();
      returnLabel.setText("size() returned:  " + result);
    }
    else if (command.equals("add"))
    {
      boolean result = list.add(obj);
      nextChar = (nextChar + 1) % 26;
      update();
      returnLabel.setText("add(\"" + obj + "\") method returned:  " + result);
    }
    else if (command.equals("get") || command.equals("set") ||
             command.equals("remove") || command.equals("insert"))
    {
      int numOptions = list.size;
      if (command.equals("insert"))
        numOptions++;
      
      if (numOptions == 0)
        return;
      
      Object[] options = new Object[numOptions];
      for (int i = 0; i < options.length; i++)
        options[i] = i;
      
      Object selection = JOptionPane.showInputDialog(removeButton, null, "index",
                                                     JOptionPane.PLAIN_MESSAGE, null, options,
                                                     options[(int)(Math.random() * options.length)]);
      if (selection != null)
      {
        int index = (int)selection;
        String result;
        if (command.equals("get"))
        {
          result = list.get(index);
          returnLabel.setText("get(" + index + ") returned " + result);
        }
        else if (command.equals("set"))
        {
          result = list.set(index, obj);
          nextChar = (nextChar + 1) % 26;
          returnLabel.setText("set(" + index + ", \"" + obj + "\") returned " + result);
        }
        else if (command.equals("insert"))
        {
          try
          {
            SinglyLinkedList.class.getMethod("add", int.class, Object.class).invoke(list, index, obj);
            nextChar = (nextChar + 1) % 26;
            returnLabel.setText("add(" + index + ", \"" + obj + "\") called");
          }
          catch(NoSuchMethodException ex)
          {
            ex.printStackTrace();
            throw new RuntimeException("cannot call add at index");
          }
          catch(IllegalAccessException ex)
          {
            ex.printStackTrace();
            throw new RuntimeException("cannot call add at index");
          }
          catch(InvocationTargetException ex)
          {
            ex.printStackTrace();
            throw new RuntimeException("cannot call add at index");
          }
        }
        else //if (command.equals("remove"))
        {
          result = list.remove(index);
          returnLabel.setText("remove(" + index + ") returned " + result);
        }
        
        update();
      }
    }
    else
      throw new RuntimeException("Illegal command:  " + command);
  }
}