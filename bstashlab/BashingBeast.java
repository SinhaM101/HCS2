import java.util.*;

public class BashingBeast
{
  public static void main(String[] args)
  {
    //testMyTreeSet();
    testMyHashSet();
  }
  
  public static void testMyTreeSet()
  {
    System.out.println("Bashing BST ... ");
    
    Product p = new Product("bravo", 2);
    test(new Product("bravo", 2).compareTo(new Product("alfa", 3)) > 0);
    test(new Product("bravo", 2).compareTo(new Product("charlie", 1)) < 0);
    test(new Product("bravo", 2).compareTo(new Product("bravo", 3)) < 0);
    test(new Product("bravo", 2).compareTo(new Product("bravo", 1)) > 0);
    test(new Product("bravo", 2).compareTo(new Product("bravo", 2)) == 0);
    
    MyTreeSet<Integer> set = new MyTreeSet<Integer>(false);
    test(set.size() == 0);
    test(set.toString().equals("."));
    test(!set.contains(4));
    
    test(set.add(4));
    test(set.size() == 1);
    test(set.toString().equals("4.."));
    test(set.peekMin() == 4);
    test(set.toString().equals("4.."));
    test(!set.contains(3));
    test(set.contains(4));
    test(!set.contains(5));
    test(set.toString().equals("4.."));
    test(set.toString().equals("4.."));
    test(!set.add(4));
    test(set.size() == 1);
    test(set.toString().equals("4.."));
    
    test(set.add(2));
    test(set.size() == 2);
    test(set.toString().equals("42..."));
    test(set.peekMin() == 2);
    test(set.toString().equals("42..."));
    test(!set.contains(1));
    test(set.contains(2));
    test(!set.contains(3));
    test(set.contains(4));
    test(!set.contains(5));
    test(set.toString().equals("42..."));
    test(!set.add(2));
    test(!set.add(4));
    test(set.size() == 2);
    test(set.toString().equals("42..."));
    
    test(set.add(6));
    test(set.size() == 3);
    test(set.toString().equals("42..6.."));
    test(set.peekMin() == 2);
    test(!set.contains(1));
    test(set.contains(2));
    test(!set.contains(3));
    test(set.contains(4));
    test(!set.contains(5));
    test(set.contains(6));
    test(!set.contains(7));
    test(!set.add(2));
    test(!set.add(4));
    test(!set.add(6));
    test(set.size() == 3);
    test(set.toString().equals("42..6.."));
    
    test(set.add(3));
    test(set.add(5));
    test(set.size() == 5);
    test(set.toString().equals("42.3..65..."));
    test(set.peekMin() == 2);
    test(!set.contains(1));
    test(set.contains(2));
    test(set.contains(3));
    test(set.contains(4));
    test(set.contains(5));
    test(set.contains(6));
    test(!set.contains(7));
    test(!set.add(2));
    test(!set.add(3));
    test(!set.add(4));
    test(!set.add(5));
    test(!set.add(6));
    test(set.size() == 5);
    test(set.toString().equals("42.3..65..."));
    
    test(set.add(1));
    test(set.add(7));
    test(set.size() == 7);
    test(set.toString().equals("421..3..65..7.."));
    test(set.peekMin() == 1);
    for (int i = 1; i <= 7; i++)
      test(set.contains(i));
    for (int i = 1; i <= 7; i++)
      test(!set.add(i));
    test(set.size() == 7);
    test(set.toString().equals("421..3..65..7.."));
    
    MyTreeSet<String> set2 = new MyTreeSet<String>(false);
    String s = "xqeklhandspcmyvtiowg";
    for (int i = 0; i < s.length(); i++)
      test(set2.add(s.substring(i, i + 1)));
    test(set2.size() == s.length());
    test(set2.toString().equals("xqea.dc...khg..i..l.nm..po...s.vt..w..y.."));
    test(set2.peekMin().equals("a"));
    for (char ch = 'a'; ch <= 'z'; ch++)
      test(set2.contains("" + ch) == s.contains("" + ch));
    for (char ch = 'a'; ch <= 'z'; ch++)
    {
      if (s.contains("" + ch))
        test(!set2.add("" + ch));
    }
    test(set2.size() == s.length());
    test(set2.toString().equals("xqea.dc...khg..i..l.nm..po...s.vt..w..y.."));

    int[] a = new int[1000000];
    for (int i = 0; i < a.length; i++)
      a[i] = i;
    for (int i = 0; i < a.length; i++)
    {
      int r = (int)(Math.random() * (a.length - i) + i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    set = new MyTreeSet<Integer>(false);
    System.out.print("add      ... ");
    long start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.add(a[i]));
    for (int i = 0; i < a.length; i++)
      test(!set.add(a[i]));
    int elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    System.out.print("size     ... ");
    start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.size() == a.length);
    elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    System.out.print("peekMin  ... ");
    start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.contains(i));
    elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    System.out.print("contains ... ");
    start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.contains(i));
    elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    
    System.out.println("... MyTreeSet PASSED!");
  }
  
  public static void testMyHashSet()
  {
    System.out.println("Bashing Hashing ... ");
    
    String[] models = {
      "alfa", "bravo", "charlie", "delta", "echo",
      "foxtrot", "golf", "hotel", "indigo", "juliett",
      "kilo", "lima", "mike", "november", "oscar",
      "papa", "quebec", "romeo", "sierra", "tango",
      "uniform", "victor", "whiskey", "xray", "yankee", "zulu"};
    Map<String, Integer> map = new TreeMap<String, Integer>();
    Set<Integer> codes = new TreeSet<Integer>();
    for (int i = 0; i < 1000000; i++)
    {
      String model = models[(int)(Math.random() * models.length)];
      int version = (int)(Math.random() * 11);
      Product p = new Product(model, version);
      String key = p.toString();
      int code = p.hashCode();
      Integer oldCode = map.get(key);
      if (oldCode == null)
        map.put(key, code);
      else
        test(code == oldCode);
      codes.add(code);
    }
    System.out.println("Product codes:  " + codes.size());
    
    MyHashSet<Integer> set = new MyHashSet<Integer>(3);
    test(set.size() == 0);
    test(set.toString().equals("0: null\n1: null\n2: null\n"));
    test(!set.contains(1));
    test(!set.contains(4));
    test(set.size() == 0);
    test(set.toString().equals("0: null\n1: null\n2: null\n"));
    
    test(set.add(1));
    test(set.size() == 1);
    test(set.toString().equals("0: null\n1: 1\n2: null\n"));
    test(!set.contains(0));
    test(set.contains(1));
    test(!set.contains(4));
    test(!set.add(1));
    test(set.size() == 1);
    test(set.toString().equals("0: null\n1: 1\n2: null\n"));

    test(set.add(0));
    test(set.size() == 2);
    test(set.toString().equals("0: 0\n1: 1\n2: null\n"));
    test(set.contains(0));
    test(set.contains(1));
    test(!set.contains(3));
    test(!set.contains(4));
    test(!set.add(0));
    test(!set.add(1));
    test(set.size() == 2);
    test(set.toString().equals("0: 0\n1: 1\n2: null\n"));
    
    test(set.add(4));
    test(set.size() == 3);
    test(set.toString().equals("0: 0\n1: 1, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 1\n2: null\n"));
    test(set.contains(0));
    test(set.contains(1));
    test(!set.contains(3));
    test(set.contains(4));
    test(!set.contains(7));
    test(!set.add(0));
    test(!set.add(1));
    test(!set.add(4));
    test(set.size() == 3);
    test(set.toString().equals("0: 0\n1: 1, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 1\n2: null\n"));
    
    test(set.add(10));
    test(set.size() == 4);
    test(set.toString().equals("0: 0\n1: 1, 4, 10\n2: null\n") ||
         set.toString().equals("0: 0\n1: 1, 10, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 1, 10\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 10, 1\n2: null\n") ||
         set.toString().equals("0: 0\n1: 10, 1, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 10, 4, 1\n2: null\n"));
    test(set.contains(0));
    test(set.contains(1));
    test(!set.contains(3));
    test(set.contains(4));
    test(!set.contains(7));
    test(set.contains(10));
    test(!set.add(0));
    test(!set.add(1));
    test(!set.add(4));
    test(!set.add(10));
    test(set.size() == 4);
    test(set.toString().equals("0: 0\n1: 1, 4, 10\n2: null\n") ||
         set.toString().equals("0: 0\n1: 1, 10, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 1, 10\n2: null\n") ||
         set.toString().equals("0: 0\n1: 4, 10, 1\n2: null\n") ||
         set.toString().equals("0: 0\n1: 10, 1, 4\n2: null\n") ||
         set.toString().equals("0: 0\n1: 10, 4, 1\n2: null\n"));
    
    MyHashSet<String> set2 = new MyHashSet<String>(4);
    String s = "xqeklhandspcmyvtiowg";
    for (int i = 0; i < s.length(); i++)
      test(set2.add(s.substring(i, i + 1)));
    test(set2.size() == s.length());
    for (char ch = 'a'; ch <= 'z'; ch++)
      test(set2.contains("" + ch) == s.contains("" + ch));
    for (char ch = 'a'; ch <= 'z'; ch++)
    {
      if (s.contains("" + ch))
        test(!set2.add("" + ch));
    }
    test(set2.size() == s.length());
    
    int[] a = new int[1000000];
    for (int i = 0; i < a.length; i++)
      a[i] = i;
    for (int i = 0; i < a.length; i++)
    {
      int r = (int)(Math.random() * (a.length - i) + i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    set = new MyHashSet<Integer>(a.length / 10);
    System.out.print("add      ... ");
    long start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.add(a[i]));
    for (int i = 0; i < a.length; i++)
      test(!set.add(a[i]));
    int elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    System.out.print("size     ... ");
    start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.size() == a.length);
    elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    System.out.print("contains ... ");
    start = System.currentTimeMillis();
    for (int i = 0; i < a.length; i++)
      test(set.contains(i));
    elapsed = (int)(System.currentTimeMillis() - start);
    System.out.println(a.length + " in " + elapsed + " ms");
    
    System.out.println("... MyHashSet PASSED!");
  }
  
  public static void test(boolean b)
  {
    if (!b)
      throw new RuntimeException("did not pass");
  }
}