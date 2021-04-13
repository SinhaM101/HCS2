import java.util.*;

public class MyTreeSet<E extends Comparable<E>>
{
  private TreeNode<E> root;
  private int size;
  private TreeDisplay<E> display;
  
  public MyTreeSet(boolean useDisplay)
  {
    root = null;
    size = 0;
    if (useDisplay)
      display = new TreeDisplay<E>();
    else
      display = null;
    updateDisplay();
  }
  
  public int size()
  {
    return size;
  }
  
  //precondition: set is not empty
  public E pkMin(TreeNode<E> temp, E min)
  {
    if (temp == null)
    {
      return min;
    }
    else
    {
      if (temp.getLeft() != null)
        if (temp.getLeft().getValue().compareTo(min) <= -1)
          pkMin(temp.getLeft(), temp.getLeft().getValue());
        else
          pkMin(temp.getLeft(), min);
    }
  }
  
  public E peekMin()
  {
    E mine = (root.getValue());
    if (root.getLeft() != null)
  }
  
  public boolean contains(E obj)
  {
    throw new RuntimeException("implement me");
  }
  
  public boolean add(E obj)
  {
    throw new RuntimeException("implement me");
  }
  
  private void updateDisplay()
  {
    if (display != null)
    {
      display.setTitle("size:  " + size);
      display.setRoot(root);
    }
  }
  
  public String toString()
  {
    return toString(root);
  }
  
  private String toString(TreeNode<E> t)
  {
    if (t == null)
      return ".";
    else
      return t.getValue() + toString(t.getLeft()) + toString(t.getRight());
  }
}