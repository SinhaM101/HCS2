public class Game
{
  private GridDisplay display;
//  private Location heroLoc;
//  private String heroImage;
  private Location player1Loc;
  private String player1Image;
  private Location player2Loc;
  private String player2Image;
  private boolean p1;
  private String[][] board;
  public Game()
  {
    //create GridDisplay with 6 rows and 7 columns, and title "Game"
    display = new GridDisplay(6, 7);
    display.setTitle("Game");
    display.paintAll(new Color (0,0,0));
    p1 = true;
    player1Loc = new Location (0,0);
    player2Loc = new Location (0,0);
    
    //put hero in bottom-left corner
    board = new String[6][7];
    for (int i = 0; i < board.length; i ++)
      for (int j = 0; j < board[0].length; j ++)
        board[i][j] = ".";

      printBoard();

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
      
//      if (key != -1)
//      {
//        //a key was pressed
//        keyPressed(key);
//      }
      
      //step();

//      else if (x == 0)
//        System.out.println("Noone won!");
    }
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
      {System.out.println("Player1 won!"); display.paintAll(new Color (225,117,108));}
      else if (x == 2)
      {System.out.println("Player2 won!"); display.paintAll(new Color (244,255,98));}
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
      {System.out.println("Player1 won!"); display.paintAll(new Color (255,0,17));}
      else if (x == 2)
        {System.out.println("Player1 won!"); display.paintAll(new Color (244,255,98));}
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

      // Diagonal Check up --> down
      for(int i = playerLoc.getCol() + 1, j = playerLoc.getRow() + 1; i < board.length && j< board[0].length; i++, j++)
      {
        if (display.isValid(new Location (j, i)))
        if (board[j][i] != who)
        {
          count = 1;
          break;
        }
        count ++;
      }

    //Diagonal Check 2 down --> up
    for (int i = playerLoc.getCol() - 1, j = playerLoc.getRow() - 1; i >= 0 && j >= 0; i --, j--)
    {
      if (display.isValid(new Location (j, i)))
      if(board[i][j] != who)
      {
        count = 1;
        break;
      }
      count ++;
    }

    // Diagonal Check 3 
    for (int i = playerLoc.getCol() + 1, j = playerLoc.getRow() - 1; i < board.length && j >= 0; i ++, j --)
    {
      if (display.isValid(new Location (j, i)))
      if (board[j][i] != who)
      {
        count = 1;
        break;
      }
      count ++;
    }

    //Diagonal Check 4
    for (int i = playerLoc.getCol() - 1, j = playerLoc.getRow() + 1; i >= 0 && j < board[0].length; i --, j ++)
    {
      if (display.isValid(new Location (j, i)))
      if (board[j][i] != who)
      {
        count = 1;
        break;
      }
      count ++;
    }

    if (count >= 4)
      return turn;

    return 0;
  }

//  public boolean isVertical()
//  {
////    System.out.println(board[0].length);
//    int r = board.length - 1;
//    int count = 0;
//    for (int c = 0; c < board[0].length; c ++)
//    {
//      if (board[r][c].equals("1")) // Bottom-Left of map
//      {
//        count ++;
//        System.out.println(c);
////        System.out.println(count);
//          while ((display.isValid(new Location(r, c)) && board[r][c].equals("1")))
//          {
//            System.out.println("C:" + c);
//            if (count == 4)
//              return true;
//            count ++;
//
//            if (display.isValid(new Location(r, c - 1)))
//              c --;
//          }
//      }
//      else if (board[r][c].equals("2")) // Bottom-Left of map
//      {
//        count ++;
//        System.out.println(c);
////        System.out.println(count);
//        while ((display.isValid(new Location(r, c)) && board[r][c].equals("2")))
//        {
//          System.out.println("C:" + c);
//          if (count == 4)
//            return true;
//          count ++;
//
//          if (display.isValid(new Location(r, c - 1)))
//            c --;
//        }
//      }
//    }
//    return false;
//  }

//  public boolean isHorizontal()
//  {
//    int connected = 0;
//    int c = 0;
//    for(int r = board.length - 1; r >= 0; r--)
//    {
//      if (display.isValid(new Location (r, c)))
//      if(board[r][c].equals("1"))
//      {
//        while(board[r][c].equals("1"))
//        {
//          if(connected == 4)
//            return true;
//
//          connected++;
//          if(display.isValid(new Location (r,c + 1)))
//            c++;
//        }
//      }
//      else if(board[r][c].equals("2"))
//      {
//        while(board[r][c].equals("2"))
//        {
//          if(connected == 4)
//            return true;
//
//          connected++;
//          if(display.isValid(new Location (r,c++)))
//            c++;
//        }
//      }
//      else
//      {
//        if(display.isValid(new Location (r,c++)))
//          c++;
//      }
//    }
//    return false;
//  }

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
//
//    if (key == 32)
//    {
//      //space key was pressed
//
//      //pick new location for hero
//      int col = heroLoc.getCol();
//      Location newLoc;
//      if (col == 4)
//        newLoc = new Location(2, 0);  //bottom-left cell
//      else
//        newLoc = new Location(2, col + 1);  //next cell to right
//
//      //erase image at old location
//      display.setImage(heroLoc, null);
//
//      //remember new location
//      heroLoc = newLoc;
//
//      //show image at new location
//      display.setImage(heroLoc, heroImage);
//    }
//    else
//    {
//      //some other key was pressed
//
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
