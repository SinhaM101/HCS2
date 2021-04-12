import java.util.*;
public class SinhaBot1 implements Strategy
{
    private int p1Wins = 0;
    private int p2Wins = 0;
    private int numWins = 0;
    private Location hit = new Location (0,0);
    private ArrayList <Location> fires = new ArrayList <Location> ();
    private Location loc = new Location (0,0);
    private ArrayList <Location> target = new ArrayList <Location>();
    //Called when a series starts against a new opponent.
    //Play continues until one player reaches given number of wins.
    public void seriesStarted(int numWinsNeeded)
    {
        numWins = numWinsNeeded;
        // if (p1Wins == numWinsNeeded || p2Wins == numWinsNeeded)

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

    //Called when this strategy must fire a shot at opponent.
    //Returns (row, col) to fire at opponent.
    public Location getTarget()
    {
        Location temp = new Location (0,0);
        int row = (int)(Math.random() * 10);
        int col = (int)(Math.random() * 10);
        if (!fires.contains(new Location (row, col)))
        {
            if (!hit.equals(new Location(0,0)))
            {
                if (col - 1 >= 0)
                    target.add(new Location (row, col - 1));
                if (col + 1 <= 9)
                    target.add(new Location (row, col + 1));
                if (row - 1 >= 0)
                    target.add(new Location (row - 1, col));
                if (row + 1 <= 9)
                    target.add(new Location (row + 1, col));
            }
            if (target.size() != 0)
            {
            Location lemp = target.get(0);
            target.remove(0);
            return lemp;
            }
            
        }
        else
        {
            if (target.size() != 0)
            {
            Location kemp = target.get(0);
            target.remove(0);
            return kemp;
            }
        }
        row = (int)(Math.random() * 10);
        col = (int)(Math.random() * 10);
        temp = new Location (row, col);
        return (temp);
        // else
        // {
        
        // }
        // return loc;
    } 

    //Called after getTarget, to inform player that recently fired shot did not hit opponent ship.
    public void targetMissed()
    {
        fires.add(loc);
        hit = new Location (0,0);
        System.out.println("miss");

    }
    
    //Called after getTarget, to inform player that recently fired shot hit opponent's ship.
    //shipSunk is ID of ship completely sunk
    //(1 = destroyer, 2 = submarine, 3 = cruiser, 4 = battleship, and 5 = carrier),
    //or 0 if ship has not sunk yet.
    public void targetHit(int shipSunk)
    {
        hit = loc;
        fires.add(loc);
        if (shipSunk == 0)
            System.out.println("hit");
        else if (shipSunk == 1)
            System.out.println("destroyer(1) sunk!");
        else if (shipSunk == 2)
            System.out.println("submarine(2) sunk!");
        else if (shipSunk == 3)
            System.out.println("cruiser(3) sunk!");
        else if (shipSunk == 4)
            System.out.println("battleship(4) sunk!");
        else if (shipSunk == 5)
            System.out.println("carrier(5) sunk!");
    }

    public void opponentShot(int row, int col)
    {

    }

    public void roundEnded(int outcome, int[][] opponentShips)
    {

    }

    public void seriesEnded(int numRoundsWon, int numRoundsLost, int numRoundsTied)
    {

    }
}
