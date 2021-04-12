import java.util.*;
public class SinhaBot2 implements Strategy
{
    private int p1Wins = 0;
    private int p2Wins = 0;
    private int numWins = 0;
    private String [][] board;
    private Location loc = new Location (0,0);
    private ArrayList <Location> target = new ArrayList <Location>();
    private ArrayList <Location> fires = new ArrayList <Location>();
    //Called when a series starts against a new opponent.
    //Play continues until one player reaches given number of wins.
    public void seriesStarted(int numWinsNeeded)
    {
        numWins = numWinsNeeded;
        // if (p1Wins == numWinsNeeded || p2Wins == numWinsNeeded)
        board = new String [10][10];
        for (int i = 0; i < 10; i ++)
            for (int j = 0; j < 10; j ++)
                board[i][j] = ".";
        //printBoard();
    }

    //Called when a new round starts.
    //Returns a 10x10 array showing the location of all ships, where
    //0 = empty,
    //1 = destroyer (length 2),
    //2 = submarine (length 3),
    //3 = cruiser (length 4),
    //4 = battleship (length 4), and
    //5 = carrier (length 5).
    public int[][] placeShips()
    {
        int random = (int)(Math.random() * 3 + 1);
        System.out.println("This is it:" + random);
        int[][] ma1 =  {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 2, 2, 2, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 4, 0},
                {3, 3, 3, 0, 0, 5, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
              };
        int[][] ma2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 1, 1, 0, 0, 2, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 2, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 2, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 3, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 5, 5, 5, 5, 0}
          };
        int[][] ma3 = {
            {0, 0, 5, 5, 5, 5, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 2, 2, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 4}
          };
        if (random == 1)
          return ma1;
        else if (random == 2)
          return ma2;
        else
          return ma3;
    }

    public void printBoard()
    {
        for (int i = 0; i < board.length; i ++)
        {
            for (int j = 0; j < board[0].length; j ++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Called when this strategy must fire a shot at opponent.
    //Returns (row, col) to fire at opponent.
    public Location getTarget()
    {
        int row = (int)(Math.random() * 10);
        int col = (int)(Math.random() * 10);
        if (board[row][col].equals("m") || board[row][col].equals("x"))
        { 
            row = (int)(Math.random() * 10);
            col = (int)(Math.random() * 10);
        }
        if (target.size() != 0)
        {
            loc = target.get(0);
            target.remove(0);
            fires.add(loc);
            if (!board[loc.getRow()][loc.getCol()].equals("m") || !board[loc.getRow()][loc.getCol()].equals("x"))
                return loc;
        }
        loc = new Location (row,col);
        fires.add(loc);
        return loc;
    } 

    //Called after getTarget, to inform player that recently fired shot did not hit opponent ship.
    public void targetMissed()
    {
        board[loc.getRow()][loc.getCol()] = "m";
        System.out.println("miss");
        System.out.println();
    }
    
    //Called after getTarget, to inform player that recently fired shot hit opponent's ship.
    //shipSunk is ID of ship completely sunk
    //(1 = destroyer, 2 = submarine, 3 = cruiser, 4 = battleship, and 5 = carrier),
    //or 0 if ship has not sunk yet.
    public void targetHit(int shipSunk)
    {
        System.out.println();
        board[loc.getRow()][loc.getCol()] = "x";
        if (loc.getCol() - 1 >= 0)
        {
            if (!board[loc.getRow()][loc.getCol()].equals("m") || !board[loc.getRow()][loc.getCol()].equals("x"))
                target.add(new Location (loc.getRow(), loc.getCol() - 1));
        }
        if (loc.getCol() + 1 <= 9)
        {
            if (!board[loc.getRow()][loc.getCol()].equals("m") || !board[loc.getRow()][loc.getCol()].equals("x"))
                target.add(new Location (loc.getRow(), loc.getCol() + 1));
        }
        if (loc.getRow() - 1 >= 0)
        {
            if (!board[loc.getRow()][loc.getCol()].equals("m") || !board[loc.getRow()][loc.getCol()].equals("x"))
                target.add(new Location (loc.getRow() - 1, loc.getCol()));
        }
        if (loc.getRow() + 1 <= 9)
        {
            if (!board[loc.getRow()][loc.getCol()].equals("m") || !board[loc.getRow()][loc.getCol()].equals("x"))
                target.add(new Location (loc.getRow() + 1, loc.getCol()));
        }
        if (shipSunk == 0)
            System.out.println("hit");
        else if (shipSunk == 1)
            {System.out.println("destroyer(1) sunk!"); target = new ArrayList <Location>();}
        else if (shipSunk == 2)
            {System.out.println("submarine(2) sunk!"); target = new ArrayList <Location>();}
        else if (shipSunk == 3)
            {System.out.println("cruiser(3) sunk!"); target = new ArrayList <Location>();}
        else if (shipSunk == 4)
            {System.out.println("battleship(4) sunk!"); target = new ArrayList <Location>();}
        else if (shipSunk == 5)
            {System.out.println("carrier(5) sunk!"); target = new ArrayList <Location>();}
    }

    public void opponentShot(int row, int col)
    {
        //printBoard();
    }

    public void roundEnded(int outcome, int[][] opponentShips)
    {
        board = new String [10][10];
        for (int i = 0; i < 10; i ++)
            for (int j = 0; j < 10; j ++)
                board[i][j] = ".";
    }

    public void seriesEnded(int numRoundsWon, int numRoundsLost, int numRoundsTied)
    {
        System.out.println("You won " + numRoundsWon + " rounds");
        System.out.println("You lost " + numRoundsLost + " rounds");
        System.out.println("You tied " + numRoundsTied + " rounds");
    }
}
