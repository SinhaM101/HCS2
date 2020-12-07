// I will eat your lousy code and anything that eats it.

import java.io.*;

public class RecursionMonster
{
  public static void main(String[] args) throws IOException
  {
    Lab lab = new Lab();
    
    //product
    test("product", "1 element", lab.product(list(23)) == 23);
    test("product", "2 elements", lab.product(list(17, 19)) == 323);
    test("product", "3 elements", lab.product(list(7, 11, 13)) == 1001);
    test("product", "7 elements", lab.product(list(1, 1, 1, 1, 2, 3, 5)) == 30);
    
    //withoutStars
    test("withoutStars", "empty", lab.withoutStars("").equals(""));
    test("withoutStars", "a", lab.withoutStars("a").equals("a"));
    test("withoutStars", "*", lab.withoutStars("*").equals(""));
    test("withoutStars", "ab", lab.withoutStars("ab").equals("ab"));
    test("withoutStars", "a*", lab.withoutStars("a*").equals("a"));
    test("withoutStars", "*b", lab.withoutStars("*b").equals("b"));
    test("withoutStars", "**", lab.withoutStars("**").equals(""));
    test("withoutStars", "a***bcd**e", lab.withoutStars("a***bcd**e").equals("abcde"));
    test("withoutStars", "*abc***de*", lab.withoutStars("*abc***de*").equals("abcde"));
    
    //sumSquares
    test("sumSquares", "0", lab.sumSquares(0) == 0);
    test("sumSquares", "1", lab.sumSquares(1) == 1);
    test("sumSquares", "2", lab.sumSquares(2) == 5);
    test("sumSquares", "3", lab.sumSquares(3) == 14);
    test("sumSquares", "4", lab.sumSquares(4) == 30);
    test("sumSquares", "5", lab.sumSquares(5) == 55);
    test("sumSquares", "6", lab.sumSquares(6) == 91);
    test("sumSquares", "7", lab.sumSquares(7) == 140);
    test("sumSquares", "8", lab.sumSquares(8) == 204);
    test("sumSquares", "9", lab.sumSquares(9) == 285);
    test("sumSquares", "10", lab.sumSquares(10) == 385);
    test("sumSquares", "20", lab.sumSquares(100) == 338350);
    
    //replaceValueAt
    ListNode<String> list = parse("a");
    test("replaceValueAt", "index 0, 1 element", lab.replaceValueAt(list, 0, "b").equals("a") &&
         list.getValue().equals("b") && list.getNext() == null);
    list = parse("ab");
    test("replaceValueAt", "index 0, 2 elements", lab.replaceValueAt(list, 0, "c").equals("a") &&
         toString(list).equals("cb"));
    list = parse("ab");
    test("replaceValueAt", "index 1, 2 elements", lab.replaceValueAt(list, 1, "c").equals("b") &&
         toString(list).equals("ac"));
    list = parse("abc");
    test("replaceValueAt", "index 0, 3 elements", lab.replaceValueAt(list, 0, "d").equals("a") &&
         toString(list).equals("dbc"));
    list = parse("abc");
    test("replaceValueAt", "index 1, 3 elements", lab.replaceValueAt(list, 1, "d").equals("b") &&
         toString(list).equals("adc"));
    list = parse("abc");
    test("replaceValueAt", "index 2, 3 elements", lab.replaceValueAt(list, 2, "d").equals("c") &&
         toString(list).equals("abd"));
    list = parse("abcdefghij");
    test("replaceValueAt", "index 7, 10 elements", lab.replaceValueAt(list, 7, "k").equals("h") &&
         toString(list).equals("abcdefgkij"));
    list = parse("abcdefghij");
    test("replaceValueAt", "index 9, 10 elements", lab.replaceValueAt(list, 9, "k").equals("j") &&
         toString(list).equals("abcdefghik"));
    
    //pow
    test("pow", "exponent 0", lab.pow(1001, 0) == 1);
    test("pow", "exponent 1", lab.pow(19, 1) == 19);
    test("pow", "exponent 2", lab.pow(17, 2) == 289);
    test("pow", "exponent 3", lab.pow(13, 3) == 2197);
    test("pow", "exponent 4", lab.pow(11, 4) == 14641);
    test("pow", "exponent 5", lab.pow(7, 5) == 16807);
    test("pow", "exponent 6", lab.pow(5, 6) == 15625);
    test("pow", "exponent 7", lab.pow(3, 7) == 2187);
    test("pow", "exponent 8", lab.pow(2, 8) == 256);
    test("pow", "base 1", lab.pow(1, 23) == 1);
    
    //toLetterList
    test("toLetterList", "empty", lab.toLetterList("") == null);
    test("toLetterList", "1 element", lab.toLetterList("a").getValue().equals("a") &&
         lab.toLetterList("a").getNext() == null);
    test("toLetterList", "2 elements", toString(lab.toLetterList("ab")).equals("ab"));
    test("toLetterList", "3 elements", toString(lab.toLetterList("abc")).equals("abc"));
    test("toLetterList", "4 elements", toString(lab.toLetterList("abcd")).equals("abcd"));
    test("toLetterList", "5 elements", toString(lab.toLetterList("abcde")).equals("abcde"));
    test("toLetterList", "10 elements", toString(lab.toLetterList("abcdefghij")).equals("abcdefghij"));
    
    //sameList
    test("sameList", "empty, empty", lab.sameList(null, null));
    test("sameList", "empty, 1 element", !lab.sameList(null, parse("a")));
    test("sameList", "1 element, empty", !lab.sameList(parse("a"), null));
    test("sameList", "a, a", lab.sameList(parse("a"), parse("a")));
    test("sameList", "a, b", !lab.sameList(parse("a"), parse("b")));
    test("sameList", "a, ab", !lab.sameList(parse("a"), parse("ab")));
    test("sameList", "ab, a", !lab.sameList(parse("ab"), parse("a")));
    test("sameList", "ab, ab", lab.sameList(parse("ab"), parse("ab")));
    test("sameList", "ab, ac", !lab.sameList(parse("ab"), parse("ac")));
    test("sameList", "ab, cb", !lab.sameList(parse("ab"), parse("cb")));
    test("sameList", "abcdefghij, abcdefghij", lab.sameList(parse("abcdefghij"), parse("abcdefghij")));
    test("sameList", "abcdefghi, abcdefghij", !lab.sameList(parse("abcdefghi"), parse("abcdefghij")));
    test("sameList", "abcdefghij, abcdefghi", !lab.sameList(parse("abcdefghij"), parse("abcdefghi")));
    test("sameList", "abcdefghij, abcdefghkj", !lab.sameList(parse("abcdefghij"), parse("abcdefghkj")));
    test("sameList", "abcdefghij, abcdefghik", !lab.sameList(parse("abcdefghij"), parse("abcdefghik")));
    test("sameList", "equals", lab.sameList(new ListNode<String>("ab", null),
                                            new ListNode<String>("ba".substring(1) + "ba".substring(0, 1), null)));
    
    //reverse
    test("reverse", "empty", lab.reverse("").equals(""));
    test("reverse", "a", lab.reverse("a").equals("a"));
    test("reverse", "bc", lab.reverse("bc").equals("cb"));
    test("reverse", "def", lab.reverse("def").equals("fed"));
    test("reverse", "abcdefghijklmnopqrstuvwxyz", lab.reverse("abcdefghijklmnopqrstuvwxyz").equals("zyxwvutsrqponmlkjihgfedcba"));

    //fractal
    lab.fractal(new DrawDisplay(512), 0, 0, 512, 8);

    BufferedReader fileIn = new BufferedReader(new FileReader("Lab.java"));
    String line = fileIn.readLine();
    while (line != null)
    {                                                                                                                                                      if (line.contains("for") || line.contains("while")) System.out.println(line);
      line = fileIn.readLine();
    }
    fileIn.close();
    
    System.out.println("Some of your code is OK");
  }

  private static ListNode<Integer> list(int ... a)
  {
    ListNode<Integer> list = null;
    for (int i = a.length - 1; i >= 0; i--)
      list = new ListNode<Integer>(a[i], list);
    return list;
  }
  
  private static ListNode<String> parse(String s)
  {
    ListNode<String> list = null;
    for (int i = s.length() - 1; i >= 0; i--)
      list = new ListNode<String>(s.substring(i, i + 1), list);
    return list;
  }
  
  private static <E> String toString(ListNode<E> list)
  {
    String s = "";
    while (list != null)
    {
      s += list.getValue();
      list = list.getNext();
    }
    return s;
  }
  
  private static void test(String method, String testCase, boolean b)
  {
    if (!b)
    {                                                                                                                                                      String[] adjectives = {"spotty", "revolting", "slovenly", "pathetic", "grimy", "rotting", "unbelievable", "unattractive", "superficial", "undisciplined", "polluted", "indecent", "fermenting", "indescribable", "sycophantic", "dismal", "decrepit", "sickening", "fatuous", "appalling", "infantile", "brain-dead", "freakish", "unimpressive", "distasteful"};String[] quantities = {"heap", "loaf", "pool", "piece", "dollop", "chunk", "smudge", "sliver", "bowl", "bucket", "mountain", "blob", "load", "earful", "pile", "tank", "stack", "array", "set", "tub"};String[] nouns = {"donkey poop", "warts", "used chewing gum", "slime-mould", "pimple pus", "ape puke", "pigeon droppings", "maggot brains", "toenail clippings", "elephant dung", "pigs ears", "hamster urine", "ear wax", "whale waste", "dingo's kidneys", "bat guano", "spittoon spillage", "second-hand toilet paper", "sinus clots", "frog fat"};String adj = random(adjectives);if ("aeiou".contains(adj.substring(0, 1)))method += " is an " + adj;else method += " is a " + adj;method += " " + random(quantities) + " of " + random(adjectives) + " " + random(nouns);//http://datahamster.com/autoinsult/
      throw new RuntimeException(method + " for case " + testCase);
    }
  }
  
  private static String random(String ... a)
  {
    return a[(int)(Math.random() * a.length)];
  }
}
