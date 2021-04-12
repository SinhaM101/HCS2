import java.util.*;

public class MonishSinhaBot implements Strategy
{
    private int p1Wins = 0;
    private int p2Wins = 0;
    private int numWins = 0;
    private String [][] board;
    private Location loc;
    //Called when a series starts against a new opponent.
    //Play continues until one player reaches given number of wins.
    public void seriesStarted(int numWinsNeeded)
    {
        numWins = numWinsNeeded;
        loc = new Location (0,0);
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
    //3 = cruiser (length 3),
    //4 = battleship (length 4), and
    //5 = carrier (length 5).
    public int[][] placeShips()
    {
        int random = (int)(Math.random() * 7 + 1);
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
        int [][] ma4 = {
            {2, 2, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0, 0, 1, 0, 0},
            {4, 0, 0, 3, 0, 0, 0, 1, 0, 0},
            {4, 0, 0, 3, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int [][] ma5 = {
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 2, 2, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 4, 4, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int [][] ma6 = {
            {0, 0, 5, 5, 5, 5, 5, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 4, 4, 4, 4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        int [][] ma7 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 2, 2, 0},
            {0, 0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 4, 4, 4, 0, 0}
        };
        if (random == 1)
            return ma1;
        else if (random == 2)
            return ma2;
        else if (random == 3)
            return ma3;
        else if (random == 4)
            return ma4;
        else if (random == 5)
            return ma5;
        else if (random == 6)
            return ma6;
        else
            return ma7;
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
        {
        for (int r = 0; r < board.length; r ++)
            for (int c = 0; c < board[0].length; c ++)
            {
                if (board[r][c].equals("x"))
                {
                    if (c - 1 >= 0)
                    {
                        if (board[r][c-1].equals("."))
                        {
                            loc = new Location (r, c-1);
                            return loc;
                        }
                    }
                    if (c + 1 <= 9)
                    {
                        if (board[r][c+1].equals("."))
                        {
                            loc = new Location (r, c+1);
                            return loc;
                        }
                    }
                    if (r - 1 >= 0)
                    {
                        if (board[r-1][c].equals("."))
                        {
                            loc = new Location (r-1, c);
                            return loc;
                        }
                    }
                    if (r + 1 <= 9)
                    {
                        if (board[r+1][c].equals("."))
                        {
                            loc = new Location (r+1,c);
                            return loc;
                        }
                    }
                }
            }
        } 
        if (board[row][col].equals("m") || board[row][col].equals("x"))
        { 
            row = (int)(Math.random() * 10);
            col = (int)(Math.random() * 10);
        }
        loc = new Location (row,col);
        return loc;
    } 

    //Called after getTarget, to inform player that recently fired shot did not hit opponent ship.
    public void targetMissed()
    {
        board[loc.getRow()][loc.getCol()] = "m";
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
        if (shipSunk == 0)
            System.out.println("hit");
        else if (shipSunk == 1)
            {System.out.println("destroyer(1) sunk!"); loc = null;}
        else if (shipSunk == 2)
            {System.out.println("submarine(2) sunk!"); loc = null;}
        else if (shipSunk == 3)
            {System.out.println("cruiser(3) sunk!"); loc = null;}
        else if (shipSunk == 4)
            {System.out.println("battleship(4) sunk!"); loc = null;}
        else if (shipSunk == 5)
            {System.out.println("carrier(5) sunk!"); loc = null;}
    }

    public void opponentShot(int row, int col)
    {
        // printBoard();
    }

    //Called at the end of a round outcome is +1 if this strategy won,
    //-1 if this strategy lost, and 0 if a tie occurred.
    //opponentShips is a 10x10 array showing the location of all opponent ships, where
    //0 = empty,
    //1 = destroyer (length 2),
    //2 = submarine (length 3),
    //3 = cruiser (length 3),
    //4 = battleship (length 4), and
    //5 = carrier (length 5).
    public void roundEnded(int outcome, int[][] opponentShips)
    {
        board = new String [10][10];
        for (int i = 0; i < 10; i ++)
            for (int j = 0; j < 10; j ++)
                board[i][j] = ".";
        if (outcome > 0)
            System.out.println("You won this round!");
        else if (outcome == 0)
            System.out.println("You tied this round!");
        else
            System.out.println("You lost this round!");
    }

    public void seriesEnded(int numRoundsWon, int numRoundsLost, int numRoundsTied)
    {
        System.out.println("You won " + numRoundsWon + " rounds");
        System.out.println("You lost " + numRoundsLost + " rounds");
        System.out.println("You tied " + numRoundsTied + " rounds");
    }
}
