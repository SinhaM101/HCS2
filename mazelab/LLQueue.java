public class LLQueue<E> implements Queue<E>
{
  private ListNode<E> first;
  private ListNode<E> last;
  
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
    if (isEmpty())
      {
        last = new ListNode<E>(obj, null);
        first = last;
      }
    else
      {
        last.setNext(new ListNode<E>(obj, null));
        last = last.getNext();
      }
  }
  
  public E dequeue()
  {
    E val = first.getValue();
    first = first.getNext();
    return val;
  }
  
  public E peek()
  {
    return first.getValue();
  }
}