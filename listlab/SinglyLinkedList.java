public class SinglyLinkedList<E> implements List<E>
{
  //leave these fields public for testing (do not declare any other fields)
  public ListNode<E> first;
  public int size;
  
  public SinglyLinkedList()
  {
    first = null;
    size = 0;
  }

  public int size() 
  {
    return size;
  }
    
  public E get(int index)
  {
    if(index > size)
      return null;
    ListNode<E> temp = first;
    for(int i = 0;i < index;i++)
      temp = temp.getNext();
    return temp.getValue();
  }
    
  public E set(int index, E obj)
  {
    ListNode<E> temp = first;
    
    if(index > size)
      return null;
    if(index == 0) 
    {
      E e = first.getValue();
      first.setValue(obj);
      return e;
    }
    
    for(int i = 0;i < index; i++)
      temp = temp.getNext();
    E e = temp.getValue();
    temp.setValue(obj);
    
    return e;
  }

  public boolean add(E obj) 
  {
    size++;
    ListNode<E> temp = first;
    if(temp == null) 
    {
      first = new ListNode<>(obj, null);
      return true;
    }
    while(temp.getNext() != null)
      temp = temp.getNext();
    temp.setNext(new ListNode<>(obj,null));
    return true;
  }

  public E remove(int index) 
  {
    ListNode<E> temp = first;

    if(index>size)
      return null;
    if(index==0 && size!=1) 
    {
      E e = first.getValue();
      first.setValue(first.getNext().getValue());
      first.setNext(first.getNext().getNext());
      size--;
      return e;
    }
    if(index == 0)
    {
      E e = first.getValue();
      first = null;
      size--;
      return e;
    }

    if(size==index+1)
    {
      for(int i =0;i<index-1; i++)
        temp = temp.getNext();
      E e = temp.getNext().getValue();
      temp.setNext(null);
      size--;
      return e;
    }

    for(int i =0;i<index; i++)
      temp = temp.getNext();
    E e = temp.getValue();

    temp.setValue(temp.getNext().getValue());
    temp.setNext(temp.getNext().getNext());

    size--;
    return e;
  }

}