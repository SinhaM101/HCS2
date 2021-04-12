import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class TreeMonster
{
  public static void main(String[] args) throws IOException, IllegalAccessException, InvocationTargetException
  {
    String testTree = "136-7-2314912-484---------141-1---3-8----";
    
    System.out.println("replace ...");
    test(TreeLab.replace(null, "a", "b") == 0);
    TreeNode<String> t = new TreeNode<String>("a");
    test(TreeLab.replace(t, "b", "c") == 0);
    test(t.getValue().equals("a") && t.getLeft() == null && t.getRight() == null);
    test(TreeLab.replace(t, "ba".substring(1), "c") == 1);
    test(t.getValue().equals("c") && t.getLeft() == null && t.getRight() == null);
    t = parse(testTree);
    test(TreeLab.replace(t, "1", "5") == 6);
    test(toString(t).equals("536-7-2354952-484---------545-5---3-8----"));
    t = parse(testTree);
    test(TreeLab.replace(t, "3", "4") == 3);
    test(toString(t).equals("146-7-2414912-484---------141-1---4-8----"));
    System.out.println("replace PASSED");
    
    System.out.println("countNodesAtDepth ...");
    test(TreeLab.countNodesAtDepth(null, 10) == 0);
    test(TreeLab.countNodesAtDepth(new TreeNode<String>("a"), 0) == 1);
    test(TreeLab.countNodesAtDepth(new TreeNode<String>("a"), 1) == 0);
    test(TreeLab.countNodesAtDepth(new TreeNode<String>("a"), 2) == 0);
    t = parse(testTree);
    test(TreeLab.countNodesAtDepth(t, 0) == 1);
    test(TreeLab.countNodesAtDepth(t, 1) == 2);
    test(TreeLab.countNodesAtDepth(t, 2) == 2);
    test(TreeLab.countNodesAtDepth(t, 3) == 4);
    test(TreeLab.countNodesAtDepth(t, 4) == 5);
    test(TreeLab.countNodesAtDepth(t, 5) == 3);
    test(TreeLab.countNodesAtDepth(t, 6) == 2);
    test(TreeLab.countNodesAtDepth(t, 7) == 1);
    test(TreeLab.countNodesAtDepth(t, 8) == 0);
    test(TreeLab.countNodesAtDepth(t, 9) == 0);
    System.out.println("countNodesAtDepth PASSED");
    
    System.out.println("onlyHas ...");
    test(TreeLab.onlyHas(new TreeNode<String>("a"), "a"));
    test(TreeLab.onlyHas(parse("111-1-1111111-111---------111-1---1-1----"), "1"));
    test(!TreeLab.onlyHas(parse("111-1-1211111-111---------111-1---1-1----"), "1"));    
    System.out.println("onlyHas PASSED");
    
    System.out.println("build ...");
    test(TreeLab.build(0, "zebra") == null);
    TreeNode<Integer> built = TreeLab.build(1, 5);
    test(built.getValue() == 5 && isLeaf(built));
    built = TreeLab.build(2, 7);
    test(built.getValue() == 7 && built.getLeft().getValue() == 7 &&
         isLeaf(built.getLeft()) && built.getRight().getValue() == 7 &&
         isLeaf(built.getRight()) && built.getLeft() != built.getRight());
    test(toString(TreeLab.build(4, "x")).equals("xxxxxxxxxxxxxxx----------------"));
    System.out.println("build PASSED");
    
    System.out.println("save ...");
    TreeLab.saveToFile(null, "test.txt");
    test(loadString("test.txt").equals("$"));
    TreeLab.saveToFile(new TreeNode<String>("b"), "test.txt");
    test(loadString("test.txt").equals("b$$"));
    TreeLab.saveToFile(parse("ab---"), "test.txt");
    test(loadString("test.txt").equals("ab$$$"));
    TreeLab.saveToFile(parse("a-b--"), "test.txt");
    test(loadString("test.txt").equals("a$b$$"));
    TreeLab.saveToFile(parse(testTree), "test.txt");
    test(loadString("test.txt").equals("13$731$$2$$1$4$$6$248$1$1$8$$44$$1$3$$9$$"));
    System.out.println("save PASSED");
    
    System.out.println("load ...");
    saveString("$", "test.txt");
    test(toString(TreeLab.loadFromFile("test.txt")).equals("-"));
    saveString("b$$", "test.txt");
    test(toString(TreeLab.loadFromFile("test.txt")).equals("b--"));
    saveString("ab$$$", "test.txt");
    test(toString(TreeLab.loadFromFile("test.txt")).equals("ab---"));
    saveString("a$b$$", "test.txt");
    test(toString(TreeLab.loadFromFile("test.txt")).equals("a-b--"));
    saveString("13$731$$2$$1$4$$6$248$1$1$8$$44$$1$3$$9$$", "test.txt");
    test(toString(TreeLab.loadFromFile("test.txt")).equals(testTree));
    System.out.println("load PASSED");
    
    try
    {
      Method method = TreeLab.class.getMethod("reflect", TreeNode.class);
      System.out.println("reflect ...");
      t = new TreeNode<String>("a");
      method.invoke(null, t);
      test(t.getValue().equals("a") && t.getLeft() == null && t.getRight() == null);
      t = parse(testTree);
      method.invoke(null, t);
      test(toString(t).equals("1632-7-9413--484-21141-------3---1---8---"));
      System.out.println("reflect PASSED <----------");
    }
    catch(NoSuchMethodException e)
    {
    }
    
    try
    {
      Method method = TreeLab.class.getMethod("leafList", TreeNode.class);
      System.out.println("leafList ...");
      test(method.invoke(null, (TreeNode<String>)null).toString().equals("[]"));
      test(method.invoke(null, new TreeNode<String>("a")).toString().equals("[a]"));
      test(method.invoke(null, parse(testTree)).toString().equals("[1, 2, 4, 8, 4, 3, 9]"));
      System.out.println("leafList PASSED IF LINEAR TIME <----------");
    }
    catch(NoSuchMethodException e)
    {
    }

    try
    {
      Method method = TreeLab.class.getMethod("condense", TreeNode.class);
      System.out.println("condense ...");
      test(method.invoke(null, (TreeNode<String>)null) == null);
      t = new TreeNode<String>("a");
      TreeNode<String> t2 = (TreeNode<String>)method.invoke(null, t);
      test(t == t2 && t2.getValue().equals("a") &&
           t2.getLeft() == null && t2.getRight() == null);
      test(toString((TreeNode<String>)method.invoke(null, parse("ab---"))).equals("b--"));
      test(toString((TreeNode<String>)method.invoke(null, parse("a-b--"))).equals("b--"));
      test(toString((TreeNode<String>)method.invoke(null, parse(testTree))).equals("172344912--84--------43----"));
      System.out.println("condense PASSED <----------");
    }
    catch(NoSuchMethodException e)
    {
    }
    
    System.out.println("testing twentyQuestions");
    TreeLab.testTwentyQuestions();
  }
  
  private static void test(boolean condition)
  {
    if (!condition)
    {                                                                                                                                                                                              String message = new String[]{"You twig.", "Find the root of the problem.", "Make like a tree and leave.", "Your code has been node. Can it be yessed?", "Trees not for you? Try branching out.", "Stumped?"}[(int)(Math.random() * 6)];
      throw new RuntimeException("Test case failed. " + message);
    }
  }
  
  private static TreeNode<String> parse(String s)
  {
    if (s.equals("-"))
      return null;
    TreeNode<String> root = new TreeNode<String>(s.substring(0, 1));
    LinkedList<TreeNode<String>> nodes = new LinkedList<TreeNode<String>>();
    nodes.add(root);
    int i = 1;
    while (i < s.length() && nodes.size() > 0)
    {
      TreeNode<String> node = nodes.remove(0);
      String value = s.substring(i, i + 1);
      if (!value.equals("-"))
      {
        TreeNode<String> child = new TreeNode<String>(value);
        node.setLeft(child);
        nodes.add(child);
      }
      value = s.substring(i + 1, i + 2);
      if (!value.equals("-"))
      {
        TreeNode<String> child = new TreeNode<String>(value);
        node.setRight(child);
        nodes.add(child);
      }
      i += 2;
    }
    if (i < s.length() != nodes.size() > 0)
      throw new RuntimeException("illegal tree string:  " + s);
    return root;
  }
  
  private static <E> String toString(TreeNode<E> t)
  {
    if (t == null)
      return "-";
    LinkedList<TreeNode<E>> toVisit = new LinkedList<TreeNode<E>>();
    toVisit.add(t);
    String s = "";
    while (toVisit.size() > 0)
    {
      t = toVisit.remove(0);
      if (t == null)
        s += "-";
      else
      {
        s += t.getValue();
        toVisit.add(t.getLeft());
        toVisit.add(t.getRight());
      }
    }
    return s;
  }
  
  private static void saveString(String s, String file) throws IOException
  {
    PrintWriter out = new PrintWriter(new FileWriter(file));
    for (int i = 0; i < s.length(); i++)
      out.println(s.substring(i, i + 1));
    out.close();
  }
  
  private static String loadString(String file) throws IOException
  {
    Scanner in = new Scanner(new File(file));
    String s = "";
    while (in.hasNextLine())
      s += in.nextLine();
    in.close();
    return s;
  }
  
  private static <E> boolean isLeaf(TreeNode<E> t)
  {
    return t.getLeft() == null && t.getRight() == null;
  }
}