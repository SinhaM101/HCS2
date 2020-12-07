public class Lab
{
  public static void changeAll(ListNode<Integer> list)
  {
    while (list != null)

{

  list.setValue(list.getValue() + 1);

  list = list.getNext();

}
  }
  
  public static int size(ListNode<String> list)
  {
    int total = 0;
    
    while (list != null)
    {
      total ++;
      list = list.getNext();
    }
    return total;
  }
  
  public static boolean contains(ListNode<String> list, String value)
  {
    while (list != null)
    {
      if (list.getValue().equals(value))
      return true;
      list = list.getNext();
    }
    return false;
  }
  
  public static boolean add(ListNode<String> list, String value)
  {
    if (contains(list, value))
      return false;
        
    if (list.getNext() == null)
    {list.setNext(new ListNode<String> (value,null)); return true;}
    
    while (list.getNext().getNext() != null)
      list = list.getNext();
    
    list.getNext().setNext(new ListNode<String> (value, null));
    return true;
  }
  
  //precondition:  value is not first in list
  public static boolean remove(ListNode<String> list, String value)
  {
    if (!contains(list, value))
      return false;
    
    while (list.getNext() != null)
    {
      
      if (list.getNext().getValue().equals(value))
      {
        if (list.getNext().getNext() == null)
        {
          list.setNext(null);
          break;
        }
        list.setNext(list.getNext().getNext());
      }
      
      list = list.getNext();
      
    }
    
    return true;
  }
  
  public static ListNode<String> toList(String[] array)
  {
    if (array.length == 0)
      return null;
    ListNode<String> list = new ListNode<String>(array[0],null); 
      
    for (int i = 1; i < array.length; i += 1)
    {
      add(list,array[i]);
    }
    
    return list;
  }
  
  // Extra Credit
  
  public static <E> boolean hasDuplicate(ListNode<E> list)
  {
    int[] animals = new int[7];
    while (list.getNext() != null)
    {
     if (list.getValue() == "mouse")
        animals[0] += 1;
      else if (list.getValue() == "chicken")
       animals[1] += 1;
      else if (list.getValue() == "pig")
       animals[2] += 1;
      else if (list.getValue() == "sheep")
        animals[3] += 1;
      else if (list.getValue() == "duck")
        animals[4] += 1;
     else if (list.getValue() == "horse")
        animals[5] += 1;
      else if (list.getValue() == "cow")
        animals[6] += 1;
      
      list = list.getNext();
    }
    if (list.getValue() == "mouse")
        animals[0] += 1;
      else if (list.getValue() == "chicken")
        animals[1] += 1;
      else if (list.getValue() == "pig")
        animals[2] += 1;
      else if (list.getValue() == "sheep")
        animals[3] += 1;
      else if (list.getValue() == "duck")
        animals[4] += 1;
      else if (list.getValue() == "horse")
        animals[5] += 1;
      else if (list.getValue() == "cow")
        animals[6] += 1;
     
      for (int i = 0; i < animals.length; i ++)
        if (animals[i] >= 2)
          return true;
    
    return false;
  }
  
  public static ListNode<Integer> insert(ListNode<Integer> list, int value)
  {
    
    if (list.getValue() < value)
      
    while (list.getNext().getValue() <= value)
    {list = list.getNext(); System.out.println(list.getValue());}
    
    list.setNext(new ListNode <Integer> (value,list.getNext().getNext()));
    System.out.println(list.getNext().getValue());
    return list;
  }
  
  public static ListNode<Integer> sort(ListNode<Integer> list)
  {
    int count = 0;
    if (list.getValue() != null)
      count += 1;
    while (list.getNext() != null)
    {count += 1; list = list.getNext();}
    
    int[] sort = new int[count];
    if (list.getValue() != null)
      sort[0] = list.getValue();
    while (list.getNext() != null)
    {count += 1; list = list.getNext();}
    
    System.out.println(count);
    return null;
  }
}