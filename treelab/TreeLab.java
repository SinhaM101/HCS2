import java.io.*;
import java.util.*;

public class TreeLab {
  public static TreeNode<Integer> randomTree(int numNodes, int maxValue) {
    if (numNodes == 0)
      return null;
    TreeNode<Integer> t = new TreeNode<Integer>((int) (Math.random() * maxValue) + 1);
    int leftNodes = (int) (Math.random() * numNodes);
    t.setLeft(randomTree(leftNodes, maxValue));
    t.setRight(randomTree(numNodes - 1 - leftNodes, maxValue));
    return t;
  }

  public static <E> int replace(TreeNode<E> t, E oldValue, E newValue) 
  {
    if (t == null)
      return 0;
    else 
    {
      if (t.getValue().equals(oldValue)) 
      {
        t.setValue(newValue);
        return (1 + replace(t.getLeft(), oldValue, newValue) + replace(t.getRight(), oldValue, newValue));
      } 
      else
        return (replace(t.getLeft(), oldValue, newValue) + replace(t.getRight(), oldValue, newValue));
    }
    // Counting does't really work but the replace works
  }

  public static <E> int countNodesAtDepth(TreeNode<E> t, int depth) 
  {
    int count = 0;
    if (depth == 0)
      return 1;
    if (depth == 1)
      {
        if (t != null)
        {
          if (t.getLeft() != null)
            count ++;
           if (t.getRight() != null)
            count ++;
        }
        return count;
      }
    else
    {
      if (t != null)
      {
        if (t.getLeft() != null && t.getRight() != null)
          return (countNodesAtDepth(t.getLeft(), depth - 1) + countNodesAtDepth(t.getRight(), depth - 1));
        else if (t.getLeft() == null && t.getRight() != null)
          return (countNodesAtDepth(t.getRight(), depth-1));
        else if (t.getLeft() != null && t.getRight() == null)
          return (countNodesAtDepth(t.getLeft(), depth-1));
      }
      return 0;
    }

  }

  public static <E> boolean onlyHas(TreeNode<E> t, E value) 
  {
    if (t == null)
      return true;
    if (!(t.getValue().equals(value)))
      return false;
    else
        return (onlyHas(t.getLeft(), value) && onlyHas(t.getRight(), value));
  }

  public static <E> TreeNode<E> build(int numLevels, E value) 
  {
    if (numLevels == 0)
      return null;
    else
    {
      TreeNode<E> tree = new TreeNode<E> (value);
      tree.setRight(build(numLevels-1, value));
      tree.setLeft(build(numLevels-1, value));
      return tree;
    }
  }

  public static <E> void save(TreeNode<E> t, PrintWriter out) 
  {
    if (t == null)
      out.println("$");
    else
    {
      out.println(t.getValue());
      save(t.getLeft(),out);
      save(t.getRight(),out);
    }
  }

  public static <E> void saveToFile(TreeNode<E> t, String fileName) {
    try {
      PrintWriter out = new PrintWriter(new FileWriter(fileName));
      save(t, out);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  public static TreeNode<String> load(Scanner in) 
  {
    String var = in.nextLine();
    TreeNode<String> top = new TreeNode<String> (var);
    if (var.equals("$"))
      return null;
    else
    {
      top.setLeft(load(in));
      top.setRight(load(in));
      return top;
    }    
  }

  public static TreeNode<String> loadFromFile(String fileName) {
    try {
      Scanner in = new Scanner(new File(fileName));
      TreeNode<String> t = load(in);
      in.close();
      return t;
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  // used in twentyQuestions method
  public static Scanner userInput = new Scanner(System.in);

  public static void twentyQuestions(TreeNode<String> t) 
  {
    if (t == null)
    {
      System.out.print("I give up. Who/what is it?");
      String val = userInput.nextLine();
      t = new TreeNode <String> (val); 
    }
    System.out.println("Is it " + t.getValue() + " ?");
    String val = userInput.nextLine();
    if (val.equals("yes") && t.getLeft() == null)
      System.out.println("I win!");
    else if (val.equals("no") && t.getLeft() == null)
    {
      System.out.println("I give up. Who/what is it?");
      val = userInput.nextLine();
      System.out.println("What distinguishes a " + val +  " from a " + t.getValue() + "?");
      System.out.println("a " + val + " is");
      String neww = userInput.nextLine();
      String old = t.getValue();
      t.setValue(neww);
      t.setLeft(new TreeNode <String> (val));
      t.setRight(new TreeNode <String> (old));
    }
    else if (val.equals("yes"))
      twentyQuestions(t.getLeft());
    else
      twentyQuestions(t.getRight());
  }

  public static void testTwentyQuestions() {
    String fileName = "knowledge.txt";
    TreeNode<String> knowledge = loadFromFile(fileName);
    TreeDisplay<String> display = new TreeDisplay<String>();
    display.showTree(knowledge);
    while (true) {
      twentyQuestions(knowledge);
      display.showTree(knowledge);
      saveToFile(knowledge, fileName);
      System.out.println("----------------------------------------");
    }
  }

  // Extra Credit
  
  public static <E> void reflect(TreeNode<E> t)
  {
    if (t == null)
    {
      
    }
    else
    {
      reflect(t.getLeft());
      reflect(t.getRight());
      TreeNode <E> val = t.getLeft();
      t.setLeft(t.getRight());
      t.setRight(val);
    }
  }

  public static <E> List<E> leafList(TreeNode<E> t)
  {
    ArrayList <E> list = new ArrayList<E>();
    return (lList(t,list));
  }

  public static <E> List<E> lList(TreeNode<E> t, ArrayList<E> list)
  {
    if (t == null)
      return list;
    if (t.getLeft() == null && t.getRight() == null)
    {
      list.add(t.getValue());
      return list;
    }
    else
    {
        lList(t.getLeft(),list);
        lList(t.getRight(),list);
        return list;
    }
  }

  // public static <E> TreeNode<E> cond(TreeNode<E> t, TreeNode <E> pre)
  // {
  //   if (t == null)
  //   {}
  //   else
  //   {
  //     if (pre == null)
  //     {
  //       if (t.getLeft() != null && t.getRight() == null)
  //         t = t.getLeft();
  //       else if (t.getLeft() == null && t.getRight() != null)
  //         t = t.getRight();
  //     }
  //     if (t.getLeft() != null && t.getRight() != null)
  //     {
  //       pre = t;
  //       cond(t.getLeft(),pre);
  //       cond(t.getRight(),pre);
  //     }
      
  //   }
  //   return null;
  // }

  // public static Integer eval(TreeNode<String> expression, int depth, int num)
  // {
  //   if (depth == 0)
  //   {
  //     if (expression.getLeft().getLeft() == null && expression.getLeft().getRight() == null)
  //       num += Integer.parseInt(expression.getLeft().getValue());
  //     else if (expression.getRight().getLeft() == null && expression.getRight().getRight() == null)
  //       num += Integer.parseInt(expression.getRight().getValue());
  //     else if (expression.getRight().getLeft() != null && expression.getRight().getRight() != null)
  //       eval(expression, depth + 1, num);
  //   }
  //   else if (depth == 1)
  //   {
  //     //num = Integer.parseInt()
  //   }
  // }
}