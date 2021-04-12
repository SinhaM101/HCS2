import java.util.*;

public class SimpleMap<K,V>
{
  private ArrayList<Entry<K,V>> entries;
  
  public SimpleMap()
  {
    entries = new ArrayList<Entry<K,V>>();
  }
  
  public int size()
  {
    return entries.size();
  }
  
  public V get(Object key)
  {
    for (Entry<K,V> e : entries)
      if(e.getKey().equals(key))
        return e.getValue();
    return null;
  }
  
  public V put(K key, V value)
  {
    V val = get(key);
    if (val == null)
      entries.add(new Entry<K,V> (key, value));
    else
      for (Entry<K,V> e : entries)
        if (e.getKey().equals(key))
          e.setValue(value);
    return val;
  }
  
  public V remove(Object key)
  {
    V val = null;
    for (int i = 0; i < entries.size(); i ++)
    {
      if (entries.get(i).getKey().equals(key))
        {
          val = entries.get(i).getValue();
          entries.remove(i);
        }
    }
    return val;
  }
  
  public SimpleSet<K> keySet()
  {
    SimpleSet<K> s = new SimpleSet<K>();
    for (Entry<K,V> e : entries)
      s.add(e.getKey());
    return s;
  }
  
  public String toString()
  {
    return entries.toString();
  }
}