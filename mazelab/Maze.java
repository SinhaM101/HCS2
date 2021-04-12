import java.awt.Color;
import java.io.*;
import java.util.*;

public class Maze
{
  private static final Color WALL_COLOR = new Color(0, 0, 0);
  private static final Color PATH_COLOR = new Color(255, 255, 255);
  private static final Color VISIT_COLOR = new Color(255, 0, 0);
  private static ArrayList<Color> rain = new ArrayList<Color> ();
  
  public static void main(String[] args)
  {
    rain.add(new Color(255, 0, 0)); // red
    //rain.add(new Color(255,165,0)); // orange
    //rain.add(new Color(255,255,0)); // yellow
    //rain.add(new Color(0,140,0)); // green
    rain.add(new Color(0,0,255)); // blue
    //rain.add(new Color(75,0,140)); // indigo
    GridDisplay grid = load("maze1.txt");
    //solveRecursive(grid, 1, 1);
    solveStack(grid);
    //solveQueue(grid);
    //solveArray(grid);
    //gradiantStack(grid);
    //gradiantQueue(grid);
    solveSimultaneous(grid);
    //generateMaze(15, 25);
    System.out.println("Done");
    //testingStack();
    //testingQueue();
  }

  public static void testingStack()
  {
    Stack <String> x = new ArrayStack<String> ();
    //x.push("fun");
    System.out.println(x.isEmpty());
    x.push("bad");
    x.push("sun");
    x.push("moon");
    x.pop();
    System.out.println(x.peek());
    System.out.println(x.isEmpty());
  }

  public static void testingQueue()
  {
    Queue <String> x = new LLQueue <String> ();
    System.out.println(x.isEmpty());
    x.enqueue("hello");
    x.enqueue("bye");
    System.out.println(x.peek());
    x.dequeue();
    System.out.println(x.peek());
    System.out.println(x.isEmpty());
  }
  
  public static void solveRecursive(GridDisplay grid, int row, int col)
  {
    if (!(grid.getColor(new Location(row,col)).equals(PATH_COLOR)))
    {
      
    }
    else
    {
      grid.setColor(new Location(row, col), VISIT_COLOR);
      grid.pause(5);
      if (grid.getColor(new Location(row-1,col)).equals(PATH_COLOR))
        solveRecursive(grid, row-1, col);
      if(grid.getColor(new Location(row+1,col)).equals(PATH_COLOR))
        solveRecursive(grid, row+1, col);
      if(grid.getColor(new Location(row,col-1)).equals(PATH_COLOR))
        solveRecursive(grid, row, col-1);
      if(grid.getColor(new Location(row,col+1)).equals(PATH_COLOR))
        solveRecursive(grid, row, col+1);
    }
  }
  
  public static void solveStack(GridDisplay grid)
  {
    ArrayStack<Location> toVisit = new ArrayStack<Location>();
    Location loc = new Location(1,1);
    toVisit.push(loc);
    while (!toVisit.isEmpty())
    {
      Location temp = toVisit.pop();
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        grid.setColor(temp, VISIT_COLOR);
        grid.pause(5);
        toVisit.push(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.push(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.push(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.push(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
  }
  
  public static void solveQueue(GridDisplay grid)
  {
    LLQueue<Location> toVisit = new LLQueue<Location>();
    Location loc = new Location(1,1);
    toVisit.enqueue(loc);
    //System.out.println(toVisit.peek());
    
    while(!toVisit.isEmpty())
    {
      Location temp = toVisit.dequeue();
      
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        grid.setColor(temp, VISIT_COLOR);
        //System.out.println(temp);
        grid.pause(5);
        toVisit.enqueue(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.enqueue(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.enqueue(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.enqueue(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
    
  }

  // Extra Credit

  public static void solveArray(GridDisplay grid)
  {
    ArrayList<Location> toVisit = new ArrayList<Location>();
    Location loc = new Location(1, 1);
    toVisit.add(loc);
    //System.out.println(toVisit.peek());
    
    while(!toVisit.isEmpty())
    {
      Location temp = null;
      if (toVisit.size() > 1)
      {
        int pres = toVisit.get(0).getRow() + toVisit.get(0).getCol();
        int spot = 0;
        for (int i = 1; i < toVisit.size(); i ++)
        {
          if (pres < toVisit.get(i).getRow() + toVisit.get(i).getCol())
          {
            pres = toVisit.get(i).getRow() + toVisit.get(i).getCol();
            spot = i;
          }
        }
        System.out.println(spot);
        temp = toVisit.remove(spot);
      }
      else
        temp = toVisit.remove(toVisit.size()-1);
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        grid.setColor(temp, VISIT_COLOR);
        //System.out.println(temp);
        grid.pause(5);
        toVisit.add(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.add(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.add(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.add(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
    
  }

  public static void gradiantStack (GridDisplay grid)
  {
    ArrayStack<Location> toVisit = new ArrayStack<Location>();
    Location loc = new Location(1,1);
    toVisit.push(loc);
    int spot = 0;
    int r = 255;
    int g = 0;
    int b = 0;
    while (!toVisit.isEmpty())
    {
      Location temp = toVisit.pop();
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        if (spot == rain.size()-1)
          spot = 0;
        r -= 15;
        b += 15;
        grid.setColor(temp, new Color (r, g ,b));
        if (b == 225)
          b = 0;
        if (r == 0)
          r = 225;
        
        grid.pause(5);
        toVisit.push(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.push(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.push(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.push(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
  }

  public static void gradiantQueue(GridDisplay grid)
  {
    LLQueue<Location> toVisit = new LLQueue<Location>();
    Location loc = new Location(1,1);
    toVisit.enqueue(loc);
    int spot = 0;
    int r = 255;
    int g = 0;
    int b = 0;
    while (!toVisit.isEmpty())
    {
      Location temp = toVisit.dequeue();
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        if (spot == rain.size()-1)
          spot = 0;
        r -= 15;
        b += 15;
        grid.setColor(temp, new Color (r, g ,b));
        if (b == 225)
          b = 0;
        if (r == 0)
          r = 225;
        
        grid.pause(5);
        toVisit.enqueue(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.enqueue(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.enqueue(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.enqueue(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
  }

  public static void solveSimultaneous(GridDisplay grid)
  {
    // ArrayList<Location> toVisit = new ArrayList<Location>();
    // ArrayList<Location> toDisit = new ArrayList<Location>();
    // Location loc = new Location(1, 1);
    // Location doc = new Location(grid.getNumRows()-2, grid.getNumCols()-2);
    // toVisit.add(loc);
    // toDisit.add(doc);
    // //System.out.println(toVisit.peek());
    
    // while(!toVisit.isEmpty() && !toDisit.isEmpty())
    // {
    //   Location temp = null;
    //   if (toVisit.size() > 1)
    //   {
    //     int pres = toVisit.get(0).getRow() + toVisit.get(0).getCol();
    //     int spot = 0;
    //     for (int i = 1; i < toVisit.size(); i ++)
    //     {
    //       if (pres < toVisit.get(i).getRow() + toVisit.get(i).getCol())
    //       {
    //         pres = toVisit.get(i).getRow() + toVisit.get(i).getCol();
    //         spot = i;
    //       }
    //     }
    //     System.out.println(spot);
    //     temp = toVisit.remove(spot);
    //   }
    //   else
    //     temp = toVisit.remove(toVisit.size()-1);
    //   if (grid.getColor(temp).equals(PATH_COLOR))
    //   {
    //     grid.setColor(temp, rain.get(0));
    //     //System.out.println(temp);
    //     grid.pause(5);
    //     toVisit.add(new Location(temp.getRow()+1, temp.getCol()));
    //     toVisit.add(new Location(temp.getRow()-1, temp.getCol()));
    //     toVisit.add(new Location(temp.getRow(), temp.getCol()+1));
    //     toVisit.add(new Location(temp.getRow(), temp.getCol()-1));
    //   }
    

    // Location temp2 = null;
    //   if (toDisit.size() > 1)
    //   {
    //     int pres = toDisit.get(0).getRow() + toDisit.get(0).getCol();
    //     int spot = 0;
    //     for (int i = 1; i < toDisit.size(); i ++)
    //     {
    //       if (pres < toDisit.get(i).getRow() + toDisit.get(i).getCol())
    //       {
    //         pres = toDisit.get(i).getRow() + toDisit.get(i).getCol();
    //         spot = i;
    //       }
    //     }
    //     System.out.println(spot);
    //     temp2 = toVisit.remove(spot);
    //   }
    //   else
    //     temp2 = toVisit.remove(toVisit.size()-1);
    //   if (grid.getColor(temp2).equals(PATH_COLOR))
    //   {
    //     grid.setColor(temp2, rain.get(1));
    //     //System.out.println(temp);
    //     grid.pause(5);
    //     toDisit.add(new Location(temp2.getRow()+1, temp2.getCol()));
    //     toDisit.add(new Location(temp2.getRow()-1, temp2.getCol()));
    //     toDisit.add(new Location(temp2.getRow(), temp2.getCol()+1));
    //     toDisit.add(new Location(temp2.getRow(), temp2.getCol()-1));
    //   }
    // }
  }

  public static GridDisplay generateMaze (int row, int col)
  {
    GridDisplay grid = new GridDisplay (row, col);
    return grid;
  }
  
  public static GridDisplay load(String file)
  {
    try
    {
      BufferedReader in = new BufferedReader(new FileReader(file));
      String line = in.readLine();
      ArrayList<String> lines = new ArrayList<String>();
      while (line != null)
      {
        lines.add(line);
        if (line.length() != lines.get(0).length())
          throw new RuntimeException("inconsistent line length");
        line = in.readLine();
      }
      
      GridDisplay grid = new GridDisplay(lines.size(), lines.get(0).length());
      grid.setTitle(file);
      for (int row = 0; row < grid.getNumRows(); row++)
      {
        for (int col = 0; col < grid.getNumCols(); col++)
        {
          char ch = lines.get(row).charAt(col);
          Color c;
          if (ch == 'X')
            c = WALL_COLOR;
          else if (ch == '.')
            c = PATH_COLOR;
          else
            throw new RuntimeException("invalid char:  '" + ch + "'");          
          grid.setColor(new Location(row, col), c);
        }
      }
      in.close();
      return grid;
    }
    catch(IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}