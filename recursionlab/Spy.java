public class Spy extends Lab
{
  private RecursionDisplay display;
  
  public Spy(RecursionDisplay display)
  {
    this.display = display;
  }
  
  public int fact(int n)
  {
    int row = display.showArguments(n);
    display.step();
    int result = super.fact(n);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public int product(ListNode<Integer> list)
  {
    int row = display.showArguments(list);
    display.step();
    int result = super.product(list);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public String withoutStars(String s)
  {
    int row = display.showArguments(s);
    display.step();
    String result = super.withoutStars(s);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public int sumSquares(int n)
  {
    int row = display.showArguments(n);
    display.step();
    int result = super.sumSquares(n);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public <E> E replaceValueAt(ListNode<E> list, int index, E newValue)
  {
    int row = display.showArguments(list, index, newValue);
    display.step();
    E result = super.replaceValueAt(list, index, newValue);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public int pow(int base, int exponent)
  {
    int row = display.showArguments(base, exponent);
    display.step();
    int result = super.pow(base, exponent);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public ListNode<String> toLetterList(String s)
  {
    int row = display.showArguments(s);
    display.step();
    ListNode<String> result = super.toLetterList(s);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public <E> boolean sameList(ListNode<E> list1, ListNode<E> list2)
  {
    int row = display.showArguments(list1, list2);
    display.step();
    boolean result = super.sameList(list1, list2);
    display.showResult(row, result);
    display.step();
    return result;
  }
  
  public String reverse(String s)
  {
    int row = display.showArguments(s);
    display.step();
    String result = super.reverse(s);
    display.showResult(row, result);
    display.step();
    return result;
  }
    
  public void fractal(DrawDisplay drawDisplay, int x, int y, int size, int depth)
  {
    int row = display.showArguments(x, y, size, depth);
    display.step();
    super.fractal(drawDisplay, x, y, size, depth);
    display.showResult(row, "Done");
    display.step();
  }
}