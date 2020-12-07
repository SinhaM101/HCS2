public class LLQueue<E> implements Queue<E>
{
  private ListNode<E> first;
  private ListNode<E> last;

  public LLQueue()
  {
    //first.setNext(last);
  }
  
  //INSERT CODE BELOW
  public boolean isEmpty()
  {
    if (first != null)
      return false;
    else
      return true;
  }
  
  public void enqueue(E obj)
  {
    if (first == null)
      {
        first = new ListNode<E>(obj, null);
        last = first;
      }
    else
      {
        if (last == null)
          last = new ListNode<E>(obj, null);
        else
        {
          last.setNext(new ListNode<E>(obj, null));
          last = last.getNext();
        }
      }
  }
  
  public E dequeue()
  {
    E val = first.getValue();
    first = last;
    if (last.getNext() == null)
      return val;
    else
      last = last.getNext();
    return val;
  }
  
  public E peek()
  {
    return first.getValue();
  }
}