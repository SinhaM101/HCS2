public class MazeMonster
{
  public static void main(String[] args)
  {
    StackQueueMonster.main(null);

    new Thread()
    {
      public void run()
      {
        GridDisplay grid = Maze.load("maze4.txt");
        grid.setTitle("solveRecursive");
        Maze.solveRecursive(grid, 1, 1);
        System.out.println("Finished:  solveRecursive");
      }
    }.start();

    new Thread()
    {
      public void run()
      {
        GridDisplay grid = Maze.load("maze4.txt");
        grid.setTitle("solveStack");
        Maze.solveStack(grid);
        System.out.println("Finished:  solveStack");
      }
    }.start();
    
    new Thread()
    {
      public void run()
      {
        GridDisplay grid = Maze.load("maze4.txt");
        grid.setTitle("solveQueue");
        Maze.solveQueue(grid);
        System.out.println("Finished:  solveQueue");
      }
    }.start();
  }
}