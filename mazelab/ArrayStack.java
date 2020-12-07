import java.util.ArrayList;

//import sun.tools.serialver.resources.serialver;

public class ArrayStack<E> implements Stack<E>
{
  public ArrayList<E> values;

  public ArrayStack ()
  {
    values = new ArrayList<E> ();
  }
  
  public boolean isEmpty()
  {
    if (values.size() == 0)
      return true;
    else
      return false;
  }
  
  public void push(E obj)
  {
      values.add(obj);
  }

  public E pop()
  {
    E old = values.get(values.size()-1);
    values.remove(values.size()-1);
    return old;
  }

  public E peek()
  {
    return values.get(values.size()-1);
  }
}