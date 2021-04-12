import java.util.*;

public class SimpleSet<E> implements Iterable<E>
{
  private ArrayList<E> elements;
  
  public SimpleSet()
  {
    elements = new ArrayList<E>();
  }
  
  public int size()
  {
    return elements.size();
  }
  
  public boolean contains(Object obj)
  {
    for (Object s : elements)
      if (s.equals(obj))
        return true;
    return false;
  }
  
  public boolean add(E obj)
  {
    if (!contains(obj))
    {
        elements.add(obj);
        return true;
    }
    return false;
  }
  
  public boolean remove(Object obj)
  {
    if (contains(obj))
    {
        elements.remove(obj);
        return true;
    }
    return false;
  }
  
  public String toString()
  {
    return elements.toString();
  }

  public Iterator<E> iterator()
  {
    return elements.iterator();
  }
}