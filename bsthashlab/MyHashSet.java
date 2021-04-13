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
    throw new RuntimeException("implement me");
  }
  
  public boolean contains(Object obj)
  {
    throw new RuntimeException("implement me");
  }
  
  public boolean add(E obj)
  {
    throw new RuntimeException("implement me");
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
