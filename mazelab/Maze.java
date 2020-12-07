import java.awt.Color;
import java.io.*;
import java.util.*;

public class Maze
{
  private static final Color WALL_COLOR = new Color(0, 0, 0);
  private static final Color PATH_COLOR = new Color(255, 255, 255);
  private static final Color VISIT_COLOR = new Color(255, 0, 0);
  
  public static void main(String[] args)
  {
    GridDisplay grid = load("maze3.txt");
    //solveRecursive(grid, 1, 1);
    //solveStack(grid);
    //solveQueue(grid);
    solveArray(grid);
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
    //System.out.println(x.peek());
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
      grid.pause(1);
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
        grid.pause(1);
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
        grid.pause(10);
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
    Location loc = new Location(1,1);
    toVisit.add(loc);
    //System.out.println(toVisit.peek());
    
    while(!toVisit.isEmpty())
    {
      Location temp = toVisit.remove(toVisit.size()-1);
      
      if (grid.getColor(temp).equals(PATH_COLOR))
      {
        grid.setColor(temp, VISIT_COLOR);
        //System.out.println(temp);
        grid.pause(1);
        toVisit.add(new Location(temp.getRow()+1, temp.getCol()));
        toVisit.add(new Location(temp.getRow()-1, temp.getCol()));
        toVisit.add(new Location(temp.getRow(), temp.getCol()+1));
        toVisit.add(new Location(temp.getRow(), temp.getCol()-1));
      }
    }
    
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