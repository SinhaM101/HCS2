import java.util.*;

import javax.lang.model.util.ElementScanner14;

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
  public E peekMin() 
  {
      TreeNode<E> temp = root;
      while (temp.getLeft() != null) 
        temp = temp.getLeft();
      return temp.getValue();
  }

  public boolean contains(E obj) 
  {
    TreeNode<E> find = root;
    while (true) 
    {
      if (find == null) 
        return false;
      if (find.getValue().compareTo(obj) == 0) 
        return true;
      if(find.getValue().compareTo(obj) < 0)
        find = find.getRight();
      else
        find = find.getLeft();
    }
  }
  
  public boolean add(E obj)
  {
    if(root == null)  
    {
      root = new TreeNode<>(obj);
      size++;
      updateDisplay();
      return true;
    }
    TreeNode <E> temp = root;
    while(true)
    {
      if(temp.getValue().compareTo(obj)==0)
      {
        updateDisplay();
        return false;
      }
      if(temp.getValue().compareTo(obj) > 0)
      {
        if(temp.getLeft() != null)
        {
          temp = temp.getLeft();
        }
        else
        {
          temp.setLeft(new TreeNode<> (obj));
          size++;
          updateDisplay();
          return true;
        }
      }
      else
      {
        if(temp.getRight() != null)
        {
          temp = temp.getRight();
        }
        else
        {
          temp.setRight(new TreeNode<>(obj));
          size++;
          updateDisplay();
          return true;
        }
      }
    }
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