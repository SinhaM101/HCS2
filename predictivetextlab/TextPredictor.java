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
    if (!map.containsKey(""))
    {
      map.put("", new Tally());
    }
    map.get("").addWord(words[0]);
    for (int i = 1; i < words.length; i ++)
    {
      if (!map.containsKey(words[i-1]))
      {
        map.put(words[i-1], new Tally());
      }
      map.get(words[i-1]).addWord(words[i]);
    }
  }
  
  public Tally predict(String[] recentWords)
  {
    if (recentWords.length == 0)
      return null;
    else if (map.containsKey(recentWords[recentWords.length-1]))
      return map.get(recentWords[recentWords.length-1]);
    return null;
  }

  public void display()
  {
    for (String k : map.keySet())
    {
      if (k.equals(""))
        System.out.println("key: " + "EMPTY");
      else
        System.out.println("key: " + k);
      System.out.println("value: " + map.get(k).getWords() + ": " + map.get(k).getTotal());
    }
  }
}