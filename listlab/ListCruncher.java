import java.lang.reflect.*;
import java.util.*;

public class ListCruncher
{
  //if implemented correctly,   will finish for up to 100,000,000
  //if implemented incorrectly, will finish for up to      10,000
  private static final int MAX = 1000000;
  
  public static void main(String[] args) throws IllegalAccessException, InvocationTargetException
  {
    testMyArrayList();
    
    testSinglyLinkedList();

    //testDoublyLinkedList();
  }
  
  public static void testMyArrayList() throws IllegalAccessException, InvocationTargetException
  {
    System.out.println("Level 1:  testing MyArrayList for correctness");
    
    MyArrayList<String> list = new MyArrayList<String>();
    
    //constructor
    test("constructor", "", list.size == 0 && Arrays.toString(list.data).equals("[null]"));
    
    //add(E)
    test("add(E)", "1st", list.add("a") && list.size == 1 && Arrays.toString(list.data).equals("[a]"));
    test("add(E)", "2nd", list.add("b") && list.size == 2 && Arrays.toString(list.data).equals("[a, b]"));
    test("add(E)", "3rd", list.add("c") && list.size == 3 && Arrays.toString(list.data).equals("[a, b, c, null]"));
    test("add(E)", "4th", list.add("d") && list.size == 4 && Arrays.toString(list.data).equals("[a, b, c, d]"));
    test("add(E)", "5th", list.add("e") && list.size == 5 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, null, null, null]"));
    test("add(E)", "6th", list.add("f") && list.size == 6 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, null, null]"));
    test("add(E)", "7th", list.add("g") && list.size == 7 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, null]"));
    test("add(E)", "8th", list.add("h") && list.size == 8 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h]"));
    test("add(E)", "9th", list.add("i") && list.size == 9 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h, i, null, null, null, null, null, null, null]"));
    test("add(E)", "10th", list.add("j") && list.size == 10 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h, i, j, null, null, null, null, null, null]"));
    test("add(E)", "11th", list.add("k") && list.size == 11 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h, i, j, k, null, null, null, null, null]"));
    test("add(E)", "12th", list.add("l") && list.size == 12 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h, i, j, k, l, null, null, null, null]"));
    test("add(E)", "13th", list.add("m") && list.size == 13 &&
         Arrays.toString(list.data).equals("[a, b, c, d, e, f, g, h, i, j, k, l, m, null, null, null]"));
    
    //get
    String s = "abcdefghijklm";
    for (int i = 0; i < 13; i++)
      test("get", "index " + i, list.get(i).equals(s.substring(i, i + 1)) && list.size == 13);
    
    //set
    String s2 = "ABCDEFGHIJKLM";
    for (int i = 0; i < 13; i++)
      test("set", "index " + i, list.set(i, s2.substring(i, i + 1)).equals(s.substring(i, i + 1))
             && list.size == 13 && list.get(i).equals(s2.substring(i, i + 1)));
    
    //more add(E)
    test("add(E)", "14th", list.add("n") && list.size == 14 &&
         Arrays.toString(list.data).equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, n, null, null]"));
    test("add(E)", "15th", list.add("o") && list.size == 15 &&
         Arrays.toString(list.data).equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, n, o, null]"));
    test("add(E)", "16th", list.add("p") && list.size == 16 &&
         Arrays.toString(list.data).equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, n, o, p]"));
    
    //remove
    list = new MyArrayList<String>();
    list.add("a");
    test("remove", "index 0, size 1, length 1", list.remove(0).equals("a") && list.size == 0 &&
         Arrays.toString(list.data).equals("[null]"));
    list.add("a");
    list.add("b");
    test("remove", "index 1, size 2, length 2", list.remove(1).equals("b") && list.size == 1 &&
         Arrays.toString(list.data).equals("[a, null]"));
    list.add("b");
    test("remove", "index 0, size 2, length 2", list.remove(0).equals("a") && list.size == 1 &&
         Arrays.toString(list.data).equals("[b, null]"));
    test("remove", "index 0, size 1, length 2", list.remove(0).equals("b") && list.size == 0 &&
         Arrays.toString(list.data).equals("[null, null]"));
    list.add("a");
    list.add("b");
    list.add("c");
    test("remove", "index 2, size 3, length 4", list.remove(2).equals("c") && list.size == 2 &&
         Arrays.toString(list.data).equals("[a, b, null, null]"));
    list.add("c");
    test("remove", "index 1, size 3, length 4", list.remove(1).equals("b") && list.size == 2 &&
         Arrays.toString(list.data).equals("[a, c, null, null]"));
    list.set(1, "b");
    list.add("c");
    test("remove", "index 0, size 3, length 4", list.remove(0).equals("a") && list.size == 2 &&
         Arrays.toString(list.data).equals("[b, c, null, null]"));
    test("remove", "index 1, size 2, length 4", list.remove(1).equals("c") && list.size == 1 &&
         Arrays.toString(list.data).equals("[b, null, null, null]"));
    list.add("c");
    test("remove", "index 0, size 2, length 4", list.remove(0).equals("b") && list.size == 1 &&
         Arrays.toString(list.data).equals("[c, null, null, null]"));
    test("remove", "index 0, size 1, length 4", list.remove(0).equals("c") && list.size == 0 &&
         Arrays.toString(list.data).equals("[null, null, null, null]"));
    for (int i = 0; i < 8; i++)
      list.add(s.substring(i, i + 1));
    test("remove", "index 2, size 8, length 8", list.remove(2).equals("c") && list.size == 7 &&
         Arrays.toString(list.data).equals("[a, b, d, e, f, g, h, null]"));
    test("remove", "index 1, size 7, length 8", list.remove(1).equals("b") && list.size == 6 &&
         Arrays.toString(list.data).equals("[a, d, e, f, g, h, null, null]"));
    
    
    System.out.println("Level 2:  testing MyArrayList for efficiency");
    
    list = new MyArrayList<String>();
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX; i++)
      list.add("a");
    System.out.println("time for " + MAX + " calls to add(E):  " + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    for (int i = 0; i < MAX; i++)
      list.get(i);
    System.out.println("time for " + MAX + " calls to get:  " + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    while (list.size() > 0)
      list.remove(list.size() - 1);
    System.out.println("time for " + MAX + " calls to remove(lastIndex):  " + (System.currentTimeMillis() - start));
    
    try
    {
      Method method = MyArrayList.class.getMethod("add", int.class, Object.class);
      
      System.out.println("Level 3:  testing MyArrayList add(int, E) for correctness");
      
      //add(int, E)
      list = new MyArrayList<String>();
      method.invoke(list, 0, "a");
      test("add(int, E)", "index 0, size 0, length 1", list.size == 1 &&
           Arrays.toString(list.data).equals("[a]"));
      method.invoke(list, 1, "b");
      test("add(int, E)", "index 1, size 1, length 1", list.size == 2 &&
           Arrays.toString(list.data).equals("[a, b]"));
      list = new MyArrayList<String>();
      list.add("a");
      method.invoke(list, 0, "b");
      test("add(int, E)", "index 0, size 1, length 1", list.size == 2 &&
           Arrays.toString(list.data).equals("[b, a]"));
      list.remove(1);
      method.invoke(list, 1, "a");
      test("add(int, E)", "index 1, size 1, length 2", list.size == 2 &&
           Arrays.toString(list.data).equals("[b, a]"));
      list.remove(0);
      method.invoke(list, 0, "b");
      test("add(int, E)", "index 0, size 1, length 2", list.size == 2 &&
           Arrays.toString(list.data).equals("[b, a]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      method.invoke(list, 2, "c");
      test("add(int, E)", "index 2, size 2, length 2", list.size == 3 &&
           Arrays.toString(list.data).equals("[a, b, c, null]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      method.invoke(list, 1, "c");
      test("add(int, E)", "index 1, size 2, length 2", list.size == 3 &&
           Arrays.toString(list.data).equals("[a, c, b, null]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      method.invoke(list, 0, "c");
      test("add(int, E)", "index 0, size 2, length 2", list.size == 3 &&
           Arrays.toString(list.data).equals("[c, a, b, null]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      method.invoke(list, 3, "d");
      test("add(int, E)", "index 3, size 3, length 4", list.size == 4 &&
           Arrays.toString(list.data).equals("[a, b, c, d]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      method.invoke(list, 2, "d");
      test("add(int, E)", "index 2, size 3, length 4", list.size == 4 &&
           Arrays.toString(list.data).equals("[a, b, d, c]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      method.invoke(list, 1, "d");
      test("add(int, E)", "index 1, size 3, length 4", list.size == 4 &&
           Arrays.toString(list.data).equals("[a, d, b, c]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      method.invoke(list, 0, "d");
      test("add(int, E)", "index 0, size 3, length 4", list.size == 4 &&
           Arrays.toString(list.data).equals("[d, a, b, c]"));
      list = new MyArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      list.add("d");
      list.add("e");
      list.add("f");
      method.invoke(list, 2, "g");
      test("add(int, E)", "index 2, size 6, length 8", list.size == 7 &&
           Arrays.toString(list.data).equals("[a, b, g, c, d, e, f, null]"));
      method.invoke(list, 1, "h");
      test("add(int, E)", "index 1, size 7, length 8", list.size == 8 &&
           Arrays.toString(list.data).equals("[a, h, b, g, c, d, e, f]"));
      method.invoke(list, 0, "i");
      test("add(int, E)", "index 0, size 8, length 8", list.size == 9 &&
           Arrays.toString(list.data).equals("[i, a, h, b, g, c, d, e, f, null, null, null, null, null, null, null]"));
      
      
      System.out.println("Level 4:  testing MyArrayList add(int, E) for efficiency");
      
      list = new MyArrayList<String>();
      start = System.currentTimeMillis();
      for (int i = 0; i < MAX; i++)
        method.invoke(list, i, "a");
      System.out.println("time for " + MAX + " calls to add(int, E):  " + (System.currentTimeMillis() - start));
    }
    catch(NoSuchMethodException e)
    {
      System.out.println("Did NOT implement add(int, E)");
    }
    
    System.out.println("Done testing MyArrayList");
  }
  
  public static void test(String method, String testCase, boolean b)
  {
    if (!b)
      throw new RuntimeException("Yum!  Method " + method + " so crunchy for case " + testCase + "!");
  }
  
 public static void testSinglyLinkedList() throws IllegalAccessException, InvocationTargetException
 {
   List<String> list = new SinglyLinkedList<String>();
   
   System.out.println("Level 5:  testing SinglyLinkedList for correctness");
   
   //constructor
   test("constructor", "", list.size() == 0);
   
   //add(E)
   test("add(E)", "1st", list.add("a") && list.size() == 1 && list.get(0).equals("a"));
   test("add(E)", "2nd", list.add("b") && list.size() == 2 && list.get(0).equals("a") &&
        list.get(1).equals("b"));
   test("add(E)", "3rd", list.add("c") && list.size() == 3 && list.get(0).equals("a") &&
        list.get(1).equals("b") && list.get(2).equals("c"));
   test("add(E)", "4th", list.add("d") && list.size() == 4 && list.get(0).equals("a") &&
        list.get(1).equals("b") && list.get(2).equals("c") && list.get(3).equals("d"));
   
   //set
   test("set", "index 0", list.set(0, "e").equals("a") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("b") && list.get(2).equals("c") && list.get(3).equals("d"));
   test("set", "index 1", list.set(1, "f").equals("b") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("c") && list.get(3).equals("d"));
   test("set", "index 2", list.set(2, "g").equals("c") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("g") && list.get(3).equals("d"));
   test("set", "index 3", list.set(3, "h").equals("d") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("g") && list.get(3).equals("h"));
   
   //remove
   test("remove", "index 0, size 4", list.remove(0).equals("e") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("g") && list.get(2).equals("h"));
   list.add("i");
   test("remove", "index 1, size 4", list.remove(1).equals("g") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("i"));
   list.add("j");
   test("remove", "index 2, size 4", list.remove(2).equals("i") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("j"));
   list.add("k");
   test("remove", "index 3, size 4", list.remove(3).equals("k") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("j"));
   test("remove", "index 1, size 3", list.remove(1).equals("h") && list.size() == 2 && list.get(0).equals("f") &&
        list.get(1).equals("j"));
   test("remove", "index 0, size 2", list.remove(0).equals("f") && list.size() == 1 && list.get(0).equals("j"));
   test("remove", "index 0, size 1", list.remove(0).equals("j") && list.size() == 0);
   list.add("a");
   test("add after remove", "1st", list.size() == 1 && list.get(0).equals("a"));
   list.add("b");
   test("add after remove", "2nd", list.size() == 2 && list.get(0).equals("a") && list.get(1).equals("b"));
   list.add("c");
   test("add after remove", "3rd", list.size() == 3 && list.get(0).equals("a") && list.get(1).equals("b") &&
        list.get(2).equals("c"));
   list.remove(0);
   list.remove(0);
   list.remove(0);
   test("remove", "all", list.size() == 0);
   
   try
   {
     Method method = SinglyLinkedList.class.getMethod("add", int.class, Object.class);
     
     System.out.println("Level 6:  testing SinglyLinkedList add(int, E) for correctness");
     
     //add(int, E)
     method.invoke(list, 0, "a");
     test("add", "index 0, size 0", list.size() == 1 && list.get(0).equals("a"));
     method.invoke(list, 1, "b");
     test("add", "index 1, size 1", list.size() == 2 && list.get(0).equals("a") && list.get(1).equals("b"));
     method.invoke(list, 0, "c");
     test("add", "index 0, size 2", list.size() == 3 && list.get(0).equals("c") && list.get(1).equals("a") &&
          list.get(2).equals("b"));
     method.invoke(list, 3, "d");
     test("add", "index 3, size 3", list.size() == 4 && list.get(0).equals("c") && list.get(1).equals("a") &&
          list.get(2).equals("b") && list.get(3).equals("d"));
     method.invoke(list, 2, "e");
     test("add", "index 2, size 4", list.size() == 5 && list.get(0).equals("c") && list.get(1).equals("a") &&
          list.get(2).equals("e") && list.get(3).equals("b") && list.get(4).equals("d"));
     method.invoke(list, 1, "f");
     test("add", "index 1, size 5", list.size() == 6 && list.get(0).equals("c") && list.get(1).equals("f") &&
          list.get(2).equals("a") && list.get(3).equals("e") && list.get(4).equals("b") &&
          list.get(5).equals("d"));
     method.invoke(list, 0, "g");
     test("add", "index 0, size 6", list.size() == 7 && list.get(0).equals("g") && list.get(1).equals("c") &&
          list.get(2).equals("f") && list.get(3).equals("a") && list.get(4).equals("e") &&
          list.get(5).equals("b") && list.get(6).equals("d"));
     
     System.out.println("Level 7:  testing SinglyLinkedList for efficiency");
     
     long start = System.currentTimeMillis();
     list.add("a");
     for (int i = 0; i < MAX; i++)
       method.invoke(list, 1, "a");
     System.out.println("time for " + MAX + " calls to add(1, E):  " + (System.currentTimeMillis() - start));
     start = System.currentTimeMillis();
     for (int i = 0; i < MAX; i++)
       list.get(1);
     System.out.println("time for " + MAX + " calls to get(1):  " + (System.currentTimeMillis() - start));
     start = System.currentTimeMillis();
     for (int i = 0; i < MAX; i++)
       list.set(1, "b");
     System.out.println("time for " + MAX + " calls to set(1):  " + (System.currentTimeMillis() - start));
     start = System.currentTimeMillis();
     while (list.size() > 1)
       list.remove(1);
     list.remove(0);
     System.out.println("time for " + MAX + " calls to remove(1):  " + (System.currentTimeMillis() - start)); 
   }
   catch(NoSuchMethodException e)
   {
     System.out.println("Did NOT implement add(int, E)");
     System.out.println("Efficiency not tested");
   }
   
   System.out.println("Done testing SinglyLinkedList");
 }
  
 public static void testDoublyLinkedList()
 {
   DoublyLinkedList<String> list = new DoublyLinkedList<String>();
   List<String> x = list;
   
   System.out.println("Level 8:  testing DoublyLinkedList for correctness");
   
   //constructor
   test("constructor", "", list.size() == 0);
   
   //add(E)
   test("add(E)", "1st", list.add("a") && list.size() == 1 && list.get(0).equals("a"));
   test("add(E)", "2nd", list.add("b") && list.size() == 2 && list.get(0).equals("a") &&
        list.get(1).equals("b"));
   test("add(E)", "3rd", list.add("c") && list.size() == 3 && list.get(0).equals("a") &&
        list.get(1).equals("b") && list.get(2).equals("c"));
   test("add(E)", "4th", list.add("d") && list.size() == 4 && list.get(0).equals("a") &&
        list.get(1).equals("b") && list.get(2).equals("c") && list.get(3).equals("d"));
   
   //set
   test("set", "index 0", list.set(0, "e").equals("a") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("b") && list.get(2).equals("c") && list.get(3).equals("d"));
   test("set", "index 1", list.set(1, "f").equals("b") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("c") && list.get(3).equals("d"));
   test("set", "index 2", list.set(2, "g").equals("c") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("g") && list.get(3).equals("d"));
   test("set", "index 3", list.set(3, "h").equals("d") && list.size() == 4 && list.get(0).equals("e") &&
        list.get(1).equals("f") && list.get(2).equals("g") && list.get(3).equals("h"));
   
   //remove
   test("remove", "index 0, size 4", list.remove(0).equals("e") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("g") && list.get(2).equals("h"));
   list.add("i");
   test("remove", "index 1, size 4", list.remove(1).equals("g") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("i"));
   list.add("j");
   test("remove", "index 2, size 4", list.remove(2).equals("i") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("j"));
   list.add("k");
   test("remove", "index 3, size 4", list.remove(3).equals("k") && list.size() == 3 && list.get(0).equals("f") &&
        list.get(1).equals("h") && list.get(2).equals("j"));
   test("remove", "index 1, size 3", list.remove(1).equals("h") && list.size() == 2 && list.get(0).equals("f") &&
        list.get(1).equals("j"));
   test("remove", "index 0, size 2", list.remove(0).equals("f") && list.size() == 1 && list.get(0).equals("j"));
   test("remove", "index 0, size 1", list.remove(0).equals("j") && list.size() == 0);
   list.add("a");
   test("add after remove", "1st", list.size() == 1 && list.get(0).equals("a"));
   list.add("b");
   test("add after remove", "2nd", list.size() == 2 && list.get(0).equals("a") && list.get(1).equals("b"));
   list.add("c");
   test("add after remove", "3rd", list.size() == 3 && list.get(0).equals("a") && list.get(1).equals("b") &&
        list.get(2).equals("c"));
   list.remove(0);
   list.remove(0);
   list.remove(0);
   test("remove", "all", list.size() == 0);
   
   //add(int, E)
   list.add(0, "a");
   test("add", "index 0, size 0", list.size() == 1 && list.get(0).equals("a"));
   list.add(1, "b");
   test("add", "index 1, size 1", list.size() == 2 && list.get(0).equals("a") && list.get(1).equals("b"));
   list.add(0, "c");
   test("add", "index 0, size 2", list.size() == 3 && list.get(0).equals("c") && list.get(1).equals("a") &&
        list.get(2).equals("b"));
   list.add(3, "d");
   test("add", "index 3, size 3", list.size() == 4 && list.get(0).equals("c") && list.get(1).equals("a") &&
        list.get(2).equals("b") && list.get(3).equals("d"));
   list.add(2, "e");
   test("add", "index 2, size 4", list.size() == 5 && list.get(0).equals("c") && list.get(1).equals("a") &&
        list.get(2).equals("e") && list.get(3).equals("b") && list.get(4).equals("d"));
   list.add(1, "f");
   test("add", "index 1, size 5", list.size() == 6 && list.get(0).equals("c") && list.get(1).equals("f") &&
        list.get(2).equals("a") && list.get(3).equals("e") && list.get(4).equals("b") &&
        list.get(5).equals("d"));
   list.add(0, "g");
   test("add", "index 0, size 6", list.size() == 7 && list.get(0).equals("g") && list.get(1).equals("c") &&
        list.get(2).equals("f") && list.get(3).equals("a") && list.get(4).equals("e") &&
        list.get(5).equals("b") && list.get(6).equals("d"));
   
   System.out.println("Level 9:  testing DoublyLinkedList for efficiency");
   
   long start = System.currentTimeMillis();
   list.add("a");
   for (int i = 0; i < MAX; i++)
   {
     if (Math.random() < 0.5)
       list.add(1, "a");
     else
       list.add(list.size() - 1, "a");
   }
   System.out.println("time for " + MAX + " calls to add(int, E):  " + (System.currentTimeMillis() - start));
   start = System.currentTimeMillis();
   for (int i = 0; i < MAX; i++)
   {
     if (Math.random() < 0.5)
       list.get(1);
     else
       list.get(list.size() - 1);
   }
   System.out.println("time for " + MAX + " calls to get:  " + (System.currentTimeMillis() - start));
   start = System.currentTimeMillis();
   for (int i = 0; i < MAX; i++)
   {
     if (Math.random() < 0.5)
       list.set(1, "b");
     else
       list.set(list.size() - 1, "b");
   }
   System.out.println("time for " + MAX + " calls to set:  " + (System.currentTimeMillis() - start));
   start = System.currentTimeMillis();
   while (list.size() > 1)
   {
     if (Math.random() < 0.5)
       list.remove(1);
     else
       list.remove(list.size() - 1);
   }
   list.remove(0);
   System.out.println("time for " + MAX + " calls to remove:  " + (System.currentTimeMillis() - start)); 
   
   System.out.println("Done testing DoublyLinkedList");
 }
}


