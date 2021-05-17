public class Tester 
{
    public static void main(String[] args) 
    {
        testHash();
    }

    public static void testTree()
    {
        MyTreeSet<Product> free = new MyTreeSet<Product>(true);
        free.add(new Product("apple", 1));
        free.add(new Product("apple", 2));
        free.add(new Product("apple", 3));
        free.add(new Product("samsung", 1));
        free.add(new Product("samsung", 2));
        System.out.println(free.contains(new Product("apple", 1)));
    }

    public static void testHash()
    {
        MyHashSet<Product> test = new MyHashSet<Product> (5);
        test.add(new Product("apple", 1));
        test.add(new Product("apple", 2));
        test.add(new Product("apple", 4));
        test.add(new Product("samsung", 1));
        test.add(new Product("samsung", 2));
        System.out.println(test.toString());
//        System.out.println(test.contains(new Product("apple", 3)));
//        System.out.println(test.remove(new Product("apple", 1)));
//        System.out.println(test.contains(new Product("apple", 1)));
    }
}
