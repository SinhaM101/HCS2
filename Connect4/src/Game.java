import java.awt.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Game
{
  private GridDisplay display;
  private JOptionPane jPane; 
//  private Location heroLoc;
//  private String heroImage;
  private Location player1Loc;
  private String player1Image;
  private Location player2Loc;
  private String player2Image;
  private boolean p1;
  private boolean win;
  private String[][] board;
  public Game()
  {
    //create GridDisplay with 6 rows and 7 columns, and title "Game"
    display = new GridDisplay(6, 7);
    jPane = new JOptionPane();
    display.setTitle("Game");
    
    p1 = true;
    player1Loc = new Location (0,0);
    player2Loc = new Location (0,0);
    
    //put hero in bottom-left corner
    board = new String [6][7];
    for (int i = 0; i < board.length; i ++)
      for (int j = 0; j < board[0].length; j ++)
        board[i][j] = ".";

      printBoard();
      paintAll(new Color (0,0,0));
  }

  public void initilize()
  {
    p1 = true;
    player1Loc = new Location (0,0);
    player2Loc = new Location (0,0);
    
    //put hero in bottom-left corner
    board = new String[6][7];
    for (int i = 0; i < board.length; i ++)
      for (int j = 0; j < board[0].length; j ++)
        board[i][j] = ".";
    win = false;
    display.resetGrid();
    paintAll(new Color (0,0,0));
  }
  


  public void play()
  {
    while (true)
    {
      //wait 100 milliseconds for mouse or keyboard
      display.pause(100);
      
      //check if any locations clicked or keys pressed
      Location clickLoc = display.checkLastLocationClicked();
      //int key = display.checkLastKeyPressed();
      
      if (clickLoc != null)
      {
        //a location was clicked
        if (board[clickLoc.getRow()][clickLoc.getCol()].equals("."))
          locationClicked(clickLoc);
      }
      
      if (win == true)
        break;
    }
  }

  public void paintAll(Color c)
  {
    for (int i = 0; i < board.length; i ++)
      for (int j = 0; j < board[0].length; j ++)
        display.setColor(new Location (i, j), c);
  }

  private Location lowestLoc (Location loc)
  {
    while (board[loc.getRow()][loc.getCol()].equals("."))
    {
      if (display.isValid(new Location (loc.getRow() + 1, loc.getCol())))
      {
        if (board[loc.getRow() + 1][loc.getCol()].equals("."))
          loc = new Location (loc.getRow() + 1, loc.getCol());
        else
          return loc;
      }
      else
        return loc;
    }
    return loc;
  }

  //called when the user clicks on a location.
  //that location is passed to this method.
  private void locationClicked(Location loc)
  {
    loc = lowestLoc(loc);
    if (p1)
    {
      player1Loc = loc;
      player1Image = "P1.png";
      if (board[loc.getRow()][loc.getCol()].equals("."))
      {
        board[loc.getRow()][loc.getCol()] = "1";
        display.setImage(player1Loc, player1Image);
      }
      int x = win();
      System.out.println(x);
      if (x == 1)
      {
        System.out.println("Player1 won!"); 
        display.checkerBoard(new Color (250, 60, 91));
        // display.paintAll(new Color (225,225,225));
        win = true;
        display.pause(5000);
        if (display.showConfirmDialog(true))
            {
              display.showMessageDialog("Click on board Player 1");
              initilize();
              return;
            }
        // jOptionPane.showMessageDialog(new JOptionPane(), "Player 1 Won!");
      }
      else if (x == 2)
      {
        System.out.println("Player2 won!");
        display.checkerBoard(new Color (250, 250, 60));
        // display.paintAll(new Color (225,255,225));
        display.pause(5000);
        if (display.showConfirmDialog(false))
          {
            display.showMessageDialog("Click on board Player 2");
            initilize();
            
            return;
          }
        win = true;
      }
      p1 = false;
      printBoard();
    }
    else
    {
      player2Loc = loc;
      player2Image = "P2.png";
      if (board[loc.getRow()][loc.getCol()].equals("."))
      {
        board[loc.getRow()][loc.getCol()] = "2";
        display.setImage(player2Loc, player2Image);
      }
      int x = win();
      System.out.println(x);
      if (x == 1)
      {
        System.out.println("Player1 won!"); 
        display.checkerBoard(new Color (250, 60, 91));
        display.pause(5000);
        // display.paintAll(new Color (255,225,225));

        if (display.showConfirmDialog(true))
        {
            
          display.showMessageDialog("Click on board Player 1");
          initilize();
            
          return;
        }
        win = true;
      }
      else if (x == 2)
      {
        System.out.println("Player1 won!"); 
        // display.paintAll(new Color (225,255,225));
        display.checkerBoard(new Color (250, 250, 60));
        display.pause(5000);
        if (display.showConfirmDialog(false))
          {
            display.showMessageDialog("Click on board Player 1");
            initilize();
            
          return;}
        win = true;
      }
      p1 = true;
      printBoard();
    }
  }

  // Returns 1 if P1 won
  // Returns 2 if P2 won
  // Returns 0 if no one won
  public int win()
  {
    // String[][] board
    int count = 0;

    Location playerLoc;
    String who;
    int turn;
    if (p1)
    {
      playerLoc = player1Loc;
      who = "1";
      turn = 1;
    }
    else
    {
      playerLoc = player2Loc;
      who = "2";
      turn = 2;
    }
      // Horizontal Check
      for (int i = 0; i < board[0].length; i++) {
        if (board[playerLoc.getRow()][i].equals(who))
          count ++;
        else
          count = 0;

        if (count >= 4)
          return turn;
      }

      // Vertical Check
      for (int i = 0; i < board.length; i ++)
      {
        if (board[i][playerLoc.getCol()].equals(who))
          count ++;
        else
          count = 0;

        if (count >= 4)
          return turn;
      }

      // Diagonal DownrightA
      // height = board.length
      // width = board[0].length
      int y = board.length - 1;
      int x;
      for (int loop = 0; y >= 0; loop++)
      {
        x = 0;
        int otherY = y;

        while (x <= board[0].length - 1 && otherY <= board.length - 1) // GO diagonally right downwards
        {
          if (display.isValid(new Location (x, otherY)))
          if (board[x][otherY] == who)
            count ++;
          else
            count = 0;
          
            if (count >= 4)
              return turn;
            
          x ++;
          otherY ++;
          y = board.length - 1; // fixes row skipping bug
        }
        y -= loop;
      }

      count = 0;

      // Diagonal DownrightB
      // height = board.length
      // width = board[0].length
      x = board[0].length - 1;
      for (int loop = 0; x >= 0; loop++)
      {
        y = 0;
        int otherX = x;
        while (y <= board.length - 1 && otherX <= board[0].length) // Go diagonally right other way
        {
          if (display.isValid(new Location (otherX, y)))
          if (board[otherX][y] == who)
            count ++;
          else 
            count = 0;
          
            if (count >= 4)
              return turn;
          
              y ++;
              otherX ++;
              x = board[0].length - 1;
        }
        x -= loop;
      }

      count = 0;

      // Diagonal DownLeftA
      // height = board.length
      // width = board[0].length
      y = board.length - 1;
      for (int loop = 0; y >= 0; loop ++)
      {
        x = board[0].length - 1;
        int otherY = y;
        while (x >= 0 && otherY <= board.length - 1)
        {
          if (display.isValid(new Location (x, otherY)))
          if (board[x][otherY] == who)
            count ++;
          else 
            count = 0;

            if (count >= 4)
              return turn;

          x --;
          otherY ++;
          y = board.length - 1;
        }
        y -= loop;
      }

      count = 0;

      // Diagonal DownLeftB
      // height = board.length
      // width = board[0].length
      x = board[0].length - 1;
      for (int loop  = 0; x >+ 0; loop ++)
      {
        y = 0;
        int otherX = x;

        while (y <= board.length && otherX >= 0)
        {
          if (display.isValid(new Location (otherX, y)))
          if (board[otherX][y] == who)
            count ++;
          else
            count = 0;
          
            if (count >= 4)
            return turn;

            y ++;
            otherX --;
            x = board[0].length - 1;
        }
        x -= loop;
      }

    if (count >= 4)
      return turn;

    return 0;
  }

  public void printBoard()
  {
    for (int i = 0; i < board.length; i ++) {
      for (int j = 0; j < board[0].length; j++)
        System.out.print(board[i][j] + " ");
      System.out.println();
    }
    System.out.println();
  }

  //called when the user presses a key.
  //each key on the keyboard has a unique key code.
  //that key code is passed to this method.
//  private void keyPressed(int key)
//  {
//    //print key code
//    System.out.println("key code:  " + key);

//    if (key == 32)
//    {
//      //space key was pressed

//      //pick new location for hero
//      int col = heroLoc.getCol();
//      Location newLoc;
//      if (col == 4)
//        newLoc = new Location(2, 0);  //bottom-left cell
//      else
//        newLoc = new Location(2, col + 1);  //next cell to right

//      //erase image at old location
//      display.setImage(heroLoc, null);

//      //remember new location
//      heroLoc = newLoc;

//      //show image at new location
//      display.setImage(heroLoc, heroImage);
//    }
//    else
//    {
//      //some other key was pressed

//      //show help message
//      display.showMessageDialog("Press SPACE to move.\nClick to change color.");
//    }
//  }
  
  //this method is called at regular intervals
  public void step()
  {
    //maybe change color of random location to black
    if (Math.random() < 0.1)
    {
      int row = (int)(Math.random() * 3);
      int col = (int)(Math.random() * 5);
      display.setColor(new Location(row, col), new Color(0, 0, 0));
    }
  }
  
  //this code starts a game when you click the run button
  public static void main(String[] args)
  {
    Game g = new Game();
    g.play();
  }
}
