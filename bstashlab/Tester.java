public class Tester 
{
    public static void main(String[] args) 
    {
        testHash();
    }

    public static void testTree()
    {
        MyTreeSet<Integer> free = new MyTreeSet<Integer>(true);
        free.add(1);
        free.add(2);
        free.add(12);
        free.add(6);
        free.add(-2);
    }

    public static void testHash()
    {
        MyHashSet<Integer> test = new MyHashSet<Integer> (10);
        test.add(1);
    }
}
