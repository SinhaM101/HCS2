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
      if(e.getKey() == key)
        return e.getValue();
    return null;
  }
  
  public V put(K key, V value)
  {
    V val = null;
    for (Entry<K,V> e : entries)
      if (e.getKey() == key)
        {
          val = e.getValue(); 
          e.setValue(value);
        }
    return val;
  }
  
  public V remove(Object key)
  {
    V val = null;
    for (Entry<K,V> e : entries)
    {
      if (e.getKey() == key)
      {
        val = e.getValue();
        e.setValue(null);
        return val;
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