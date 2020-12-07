public interface List<E>
{
  int size();
  
  E get(int index);
  
  //replaces the element at position index with obj; returns the element formerly at the specified position
  E set(int index, E obj);
  
  //appends obj to end of list; returns true
  boolean add(E obj);
  
  //removes element from position index, moving elements at position index + 1 and higher to the left
  //(subtracts 1 from their indices) and adjusts size; returns the element formerly at the specified position
  E remove(int index);
}