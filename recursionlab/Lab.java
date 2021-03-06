import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Lab
{
  public static ListNode <String> test1 = new ListNode <String> ("a", new ListNode <String> ("b", null));
  public static ListNode <String> test2 = new ListNode <String> ("a", new ListNode <String> ("b", null));
  //pre:  n >= 0
  public int fact(int n)
  {
    if (n == 0)
      return 1;
    else
      return n * fact(n - 1);
  }
  
  public int product(ListNode<Integer> list)
  {
    if (list.getValue() == null)
      return 1;
    else if (list.getNext() == null)
      return list.getValue();
    else
      return list.getValue() * product(list.getNext());
  }
  
  public String withoutStars(String s)
  {
    if (s.length() == 0)
      return "";
    else if ((!(s.substring(0,1).equals("*"))))
      return ((s.substring(0,1) + withoutStars(s.substring(1))));
    else
       return withoutStars(s.substring(1));
  }
  
  //pre:  n >= 0
  public int sumSquares(int n)
  {
    if (n == 0)
      return 0;
    else
      return (n * n) + sumSquares(n - 1);
  }
 
  //pre:  0 <= index < size of list
  public <E> E replaceValueAt(ListNode<E> list, int index, E newValue)
  {
    E val = list.getValue();
    if (index == 0)
    {
      list.setValue(newValue);
      return val;
    }
    else
      return replaceValueAt(list.getNext(), index-1, newValue);
  }
  
  
  //pre:  exponent >= 0
  public int pow(int base, int exponent)
  {
    if (exponent == 0)
      return 1;
    else
      return base * pow(base,exponent-1);
  }
  
  public ListNode<String> toLetterList(String s)
  {
    if (s.length() == 0)
      return null;
    else
      return (new ListNode <String> (s.substring(0,1), toLetterList(s.substring(1))));
  }
  
  public <E> boolean sameList(ListNode<E> list1, ListNode<E> list2)
  {
    if (list1 == null && list2 == null)
      return true;
    else
    {
      if (list1 == null || list2 == null)
        return false;
      else if (list1.getValue().equals(list2.getValue()))
        return sameList(list1.getNext(), list2.getNext());
      else
        return false;
    }
  }
  
  public String reverse(String s)
  {
    if (s.length() == 0)
      return "";
    else
      return (s.substring(s.length() - 1, s.length()) + reverse(s.substring(0,s.length()-1)));
  }
  
  //pre:  x, y, size, and depth are nonnegative
  public void fractal(DrawDisplay drawDisplay, int x, int y, int size, int depth)
  {
    if (depth == 0)
      drawDisplay.drawSquare(x, y,size);
    else
    {
      fractal(drawDisplay, x, y, size/2, depth - 1);
      fractal(drawDisplay, x + size/2, y, size/2, depth - 1);
      fractal(drawDisplay, x, y + size/2, size/2, depth - 1);
    }
  }
  
  // Extracredit
  
  public static boolean isPrime(int n)
  {
    return backPrime(n,2);
  }
  
  public static boolean backPrime(int n, int d)
  {
    if (n <= 2)
      return (n == 2);
    if (n % d == 0)
      return false;
    if (d * d > n)
      return true;
    else
      return backPrime(n, d + 1);
    
  }
  
  public static int max(int[] a)
  {
    return backMax(a,a.length);
  }
  
  public static int backMax(int[] a, int size)
  {
    if (size == 1)
      return a[0];
    else
      return Math.max(a[size-1], backMax(a, size - 1));
  }
}