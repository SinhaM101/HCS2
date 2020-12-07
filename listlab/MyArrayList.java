public class MyArrayList<E> implements List<E> 
{
  // leave these fields public for testing (do not declare any other fields)
  public E[] data;
  public int size;

  public MyArrayList() 
  {
    // by default, our array will have room for only one element
    data = (E[]) new Object[1]; // this line results in an unavoidable warning
    size = 0;
  }

  public int size() 
  {
    return size;
  }

  public E get(int index) 
  {
    //System.out.println(data[index]);
    return data[index];
  }

  public E set(int index, E obj)
  {
    E old = data[index];
    //System.out.println(old);
    //System.out.println(obj);
    data[index] = obj;
    return old;
  }
  
  public boolean add(E obj)
  {
    if (size < data.length)
    {
        data[size] = obj; 
        size += 1;
        return true;
    }
    else
    {
      E[] newbe;
      newbe = (E[]) new Object[data.length * 2];
      for (int i = 0; i < data.length; i ++)
        newbe[i] = data[i];
      newbe[data.length] = obj;
      data = newbe;
      int count = 0;
      for (int i = 0; i < data.length; i ++)
        if (data[i] != null)
          count += 1;
      size = count;
      return true;
    }
  } 

  public void add(int index, E obj)
    {
        if (size == data.length)
        {
            E[] dataCopy = (E[])new Object[size * 2];
            for(int i = 0; i < data.length; i++)
                dataCopy[i] = data[i];
            data = dataCopy;
        }
        if (index == 0)
            for (int i = size; i > 0; i--)
                data[i] = data[i-1];
        else
            for (int i = size; i >= index; i--)
                data[i] = data[i-1];
        data[index] = obj;
        size++;
    }

  /*public void add(int index, E obj) // insert
  {
    if (size == data.length)
    {
      E[] small;
      small = (E[]) new Object[data.length];
      int spot = 0;
      for (int i = index; i < data.length; i ++)
        if (data[i] != null)
          {small[spot] = data[i]; spot += 1;}

      E[] newbe;
      newbe = (E[]) new Object[data.length * 2];
      for (int i = 0; i < index; i ++)
        newbe[i] = data[i];
      newbe[index] = obj;
      
      int s = index + 1;
      for (int i = 0; i < small.length; i ++)
        if (small[i] != null)
          {newbe[s] = small[i]; s += 1;}
      data = newbe;
      size += 1;
    }
    else
    {
      E[] small;
      small = (E[]) new Object[data.length];
      int spot = 0;
      for (int i = index; i < data.length; i ++)
        if (data[i] != null)
          {small[spot] = data[i]; spot += 1;}

      E[] newbe;
      newbe = (E[]) new Object[data.length];    
      for (int i = 0; i < index; i ++)
        newbe[i] = data[i];
      newbe[index] = obj;
      int s = 0;
      for (int i = index + 1; i < small.length; i ++)
        if (small[s] != null)
          {newbe[i] = small[s]; s += 1;}

      data = newbe;
      size += 1;
    }
  }
  */

  public E remove(int index)
  {
    E temp = data[index];
    if (index == data.length-1)
    {
      data[index] = null;
      size -= 1;
      return temp;
    }
    else
    {

      for (int i = index; i < data.length-1; i ++)
        if (data[i] == null)
          {
            size -= 1;
            return temp;
          }
        else
        data[i] = data[i+1];
        
      data[data.length - 1] = null;
      size -= 1;
      return temp;
    }
  }
}