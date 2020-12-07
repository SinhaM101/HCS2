public class StackQueueMonster
{
  public static void main(String[] args)
  {
    System.out.println("Level 1:  Stack Attack!");
    
    pause();
    Stack<String> s = new ArrayStack<String>();
    stest(s.isEmpty());
    s.push("A");
    stest(!s.isEmpty() && s.peek().equals("A"));
    s.push("B");
    stest(!s.isEmpty() && s.peek().equals("B"));
    s.push("C");
    stest(!s.isEmpty() && s.peek().equals("C"));
    stest(s.pop().equals("C") && !s.isEmpty() && s.peek().equals("B"));
    s.push("D");
    stest(!s.isEmpty() && s.peek().equals("D"));
    stest(s.pop().equals("D") && !s.isEmpty() && s.peek().equals("B"));
    stest(s.pop().equals("B") && !s.isEmpty() && s.peek().equals("A"));
    s.push("E");
    stest(!s.isEmpty() && s.peek().equals("E"));
    stest(s.pop().equals("E") && !s.isEmpty() && s.peek().equals("A"));
    stest(s.pop().equals("A") && s.isEmpty());
    s.push("F");
    stest(!s.isEmpty() && s.peek().equals("F"));
    stest(s.pop().equals("F") && s.isEmpty());
    
    Stack<Integer> s2 = new ArrayStack<Integer>();
    Integer obj = new Integer(42);
    long start = System.currentTimeMillis();
    int size = 1000000;
    for (int i = 0; i < size; i++)
    {
      s2.push(obj);
      s2.peek();
    }
    while (!s2.isEmpty())
    {
      s2.peek();
      s2.pop();
    }
    System.out.println("time = " + (System.currentTimeMillis() - start) + " for size " + size);                                                                                                    pause();System.out.println("You've got the knack for stack!");pause();
    
    System.out.println("Level 2:  Queue Bugaboo");
    pause();
    
    Queue<String> q = new LLQueue<String>();
    qtest(q.isEmpty());
    q.enqueue("A");
    qtest(!q.isEmpty() && q.peek().equals("A"));
    q.enqueue("B");
    qtest(!q.isEmpty() && q.peek().equals("A"));
    q.enqueue("C");
    qtest(!q.isEmpty() && q.peek().equals("A"));
    qtest(q.dequeue().equals("A") && !q.isEmpty() && q.peek().equals("B"));
    q.enqueue("D");
    qtest(!q.isEmpty() && q.peek().equals("B"));
    qtest(q.dequeue().equals("B") && !q.isEmpty() && q.peek().equals("C"));
    qtest(q.dequeue().equals("C") && !q.isEmpty() && q.peek().equals("D"));
    q.enqueue("E");
    qtest(!q.isEmpty() && q.peek().equals("D"));
    qtest(q.dequeue().equals("D") && !q.isEmpty() && q.peek().equals("E"));
    qtest(q.dequeue().equals("E") && q.isEmpty());
    q.enqueue("F");
    qtest(!q.isEmpty() && q.peek().equals("F"));
    qtest(q.dequeue().equals("F") && q.isEmpty());
    
    Queue<Integer> q2 = new LLQueue<Integer>();
    start = System.currentTimeMillis();
    for (int i = 0; i < size; i++)
    {
      q2.enqueue(obj);
      q2.peek();
    }
    while (!q2.isEmpty())
    {
      q2.peek();
      q2.dequeue();
    }
    System.out.println("time = " + (System.currentTimeMillis() - start) + " for size " + size);                                                                                                    pause();System.out.println("You do queue, too!");
  }
  
  public static void stest(boolean b)
  {
    if (!b)
      throw new RuntimeException                                                                                                    ("Game Over:  Your stacking is lacking.  Back to hacking.");
  }
  
  public static void qtest(boolean b)
  {
    if (!b)
      throw new RuntimeException                                                                                                    ("Game Over:  Your queue is through.  Do anew.");
  }
  
  public static void pause()
  {
    try{Thread.sleep(1000);}catch(Exception e){}
  }
}