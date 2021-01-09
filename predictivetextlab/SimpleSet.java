import java.util.*;

public class SimpleSet<E>
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
    for (E s : elements)
      if (s == obj)
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
}