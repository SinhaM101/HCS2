public class MyHashSet<E>
{
  private ListNode<E>[] buckets;
  private int size;
  
  public MyHashSet(int numBuckets)
  {
    //this line will give you a warning.  ignore it.
    buckets = (ListNode<E>[])new ListNode[numBuckets];
    
    size = 0;
  }
  
  public int size()
  {
    return size;
  }

  public boolean contains(Object obj)
  {
    int index = fixHash(obj.hashCode());
    ListNode<E> temp = buckets[index];
    if (temp == null)
      return false;
    if (temp.getValue().equals(obj))
      return true;
    temp = temp.getNext();
    while (temp != null)
    {  
      if (temp.getValue().equals(obj))
        return true;
      temp = temp.getNext();
    }
    return false;
  }
  
  public int fixHash (int temp)
  {
    return (temp % buckets.length);
  }

  public boolean add(E obj)
  {
    int index = fixHash(obj.hashCode());

    ListNode<E> temp = buckets[index];
    if(temp == null)
    {
      buckets[index] = new ListNode<>(obj,null);
      size ++;
      return true;
    }
    if(temp.getValue().equals(obj))
      return false;
    while(temp.getNext() != null)
    {
      if(temp.getNext().getValue().equals(obj))
        return false;
      temp = temp.getNext();
    }
    temp.setNext(new ListNode<>(obj,null));
    size++;
    return true;
  }

  // Extracredit

  public boolean remove (E obj)
  {
    for (int i = 0; i < size; i ++)
    {
      ListNode <E> temp = buckets[i];
      if (temp != null) {
        if (temp.getValue().equals(obj))
        {
          if (temp.getNext() != null)
          {
            temp = temp.getNext();
            return true;
          }
          else
          {
            temp = null;
            return true;
          }
        }
        else
        {
          while (temp != null)
          {
            if (temp.getNext() != null)
              if (temp.getNext().getValue().equals(obj))
              {
                temp.setNext(temp.getNext().getNext());
                size--;
                return true;
              }
            temp = temp.getNext();
          }
        }
      }
    }
    return false;
  }

  //  public boolean remove(E obj)
//  {
//      for (int i = 0; i < size; i ++)
//      {
//        ListNode<E> temp = buckets[i];
//        if (temp != null)
//        {
//          if (temp.getValue().equals(obj))
//            if (temp.getNext() != null)
//            {
//              temp = temp.getNext();
//              size--;
//              return true;
//            } else
//            {
//              temp = null;
//              size--;
//              return true;
//            }
//        } else
//        {
//          while (temp != null)
//          {
//            if (temp.getNext() != null)
//              if (temp.getNext().getValue().equals(obj))
//              {
//                temp.setNext(temp.getNext().getNext());
//                size--;
//                return true;
//              }
//            temp = temp.getNext();
//          }
//        }
//      }
//    return false;
//
  
  public String toString()
  {
    String s = "";
    for (int i = 0; i < buckets.length; i++)
      s += i + ": " + toString(buckets[i]) + "\n";
    return s;
  }
  
  private String toString(ListNode<E> list)
  {
    if (list == null)
      return "null";
    else if (list.getNext() == null)
      return list.getValue().toString();
    else
      return list.getValue() + ", " + toString(list.getNext());
  }
}
