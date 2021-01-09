import java.util.*;

public class TextPredictor
{
  private Map<String,Tally> map;
  
  public TextPredictor()
  {
    map = new TreeMap<String,Tally>();
  }
  
  public void record(String[] words)
  {
    for (int i = 0; i < words.length; i ++)
    {
      
    }
  }
  
  public Tally predict(String[] recentWords)
  {
    throw new RuntimeException("Implement me");
  }
}