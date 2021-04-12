import java.util.*;

public class Tally
{
  private Map<String,Integer> map;
  private ArrayList<String> elements;
  
  public Tally()
  {
    map = new TreeMap<String,Integer>();
    elements = new ArrayList<String>();
  }
  
  public void addWord(String word)
  {
    if (map.containsKey(word))
     map.put(word,map.get(word)+1);
    else
      map.put(word,1);
  }
  
  public int getCount(String word)
  {
    if (map.get(word) == null)
      return 0;
    return map.get(word);
  }
  
  public int getTotal()
  {
    int count = 0;
    for (String k : map.keySet())
      count += map.get(k);
    return count;
  }

  public ArrayList<String> getWords()
  {
    ArrayList<String> words = new ArrayList<String>();
    for (String k : map.keySet())
      words.add(k);
    for (int i = 0; i < words.size(); i ++) // sorts words lowest to highest by length
      for (int j = i + 1; j < words.size(); j ++)
        if (map.get(words.get(i)) < map.get(words.get(j)))
          {
            String temp = words.get(i);
            words.set(i,words.get(j)); 
            words.set(j,temp);
          }
    return words;
  }
}