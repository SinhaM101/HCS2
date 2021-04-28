public class ListNode<E>
{
  private E value;
  private ListNode<E> next;
  
  public ListNode(E v, ListNode<E> n)
  {
    value = v;
    next = n;
  }
  
  public E getValue()
  {
    return value;
  }
  
  public ListNode<E> getNext()
  {
    return next;
  }
  
  public void setValue(E v)
  {
    value = v;
  }
  
  public void setNext(ListNode<E> n)
  {
    next = n;
  }
}