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
    int hash = fixHash(obj.hashCode());
    ListNode<E> temp = buckets[hash];
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
    int hashed = fixHash(obj.hashCode());

    ListNode<E> newHash = buckets[hashed];
    if(newHash == null)
    {
      buckets[hashed] = new ListNode<>(obj,null);
      size ++;
      return true;
    }
    if(newHash.getValue().equals(obj))
    {
      return false;
    }
    while(newHash.getNext() != null)
    {
      if(newHash.getNext().getValue().equals(obj))
      {
        return false;
      }
      newHash = newHash.getNext();
    }
    newHash.setNext(new ListNode<>(obj,null));
    size++;
    return true;
  }
  
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
