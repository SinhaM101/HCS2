public class Battleship
{
  public static void main(String[] args)
  {
    Display display = new Display(10);
    Strategy strategy1 = new MonishSinhaBot();
    Strategy strategy2 = new SinhaBot1();
    int numWinsNeeded = 10;
    int winner = Game.play(strategy1, strategy2, display, numWinsNeeded);
    System.out.println("winner = " + winner);
  }
}