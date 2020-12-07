public class Test
{
  public static int fact(int n)
  {
    return new Spy(new RecursionDisplay("fact", "n")).fact(n);
  }
  
  public static int product(ListNode<Integer> list)
  {
    return new Spy(new RecursionDisplay("product", "list")).product(list);
  }
  
  public static String withoutStars(String s)
  {
    return new Spy(new RecursionDisplay("withoutStars", "s")).withoutStars(s);
  }
  
  public static int sumSquares(int n)
  {
    return new Spy(new RecursionDisplay("sumSquares", "n")).sumSquares(n);
  }
  
  public static <E> E replaceValueAt(ListNode<E> list, int index, E newValue)
  {
    return new Spy(new RecursionDisplay("replaceValueAt", "list", "index", "newValue")).replaceValueAt(list, index, newValue);
  }
 
  public static int pow(int base, int exponent)
  {
    return new Spy(new RecursionDisplay("pow", "base", "exponent")).pow(base, exponent);
  }
 
  public static ListNode<String> toLetterList(String s)
  {
    return new Spy(new RecursionDisplay("toLetterList", "s")).toLetterList(s);
  }
  
  public static <E> boolean sameList(ListNode<E> list1, ListNode<E> list2)
  {
    return new Spy(new RecursionDisplay("sameList", "list1", "list2")).sameList(list1, list2);
  }
  
  public static String reverse(String s)
  {
    return new Spy(new RecursionDisplay("reverse", "s")).reverse(s);
  }
  
  public static void fractal(int depth)
  {
    if (depth <= 2)
      new Spy(new RecursionDisplay("fractal", "x", "y", "size", "depth")).fractal(new DrawDisplay(600), 0, 0, 600, depth);
    else
      new Lab().fractal(new DrawDisplay(600), 0, 0, 600, depth);
  }
  
  public static String toString(Object obj)
  {
    if (obj == null)
      return "null";
    else if (obj instanceof String)
      return "\"" + obj + "\"";
    else if (obj instanceof ListNode)
    {
      ListNode node = (ListNode)obj;
      if (node.getNext() == null)
        return "[ " + toString(node.getValue()) + " ]";
      else
        return "[ " + toString(node.getValue()) + " ] --> " + toString(node.getNext());
    }
    else
      return obj.toString();
  }
}