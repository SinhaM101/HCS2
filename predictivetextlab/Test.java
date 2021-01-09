public class Test
{
    public static void main(String[] args)
    {
        //testSet();
        //testMap();
        testTally();
    }

    public static void testSet()
    {
        SimpleSet <String> set = new SimpleSet<String>();
        set.add("hello");
        set.add("goodbye");
        System.out.println(set.contains("hello"));
        System.out.println("The size of the set is " + set.size());
        set.remove("goodbye");
        System.out.println("The size of the set is " + set.size());
        System.out.println(set.contains("hello"));
    }

    public static void testMap()
    {
        SimpleMap <String, Integer> map = new SimpleMap<String, Integer>();
        
    }

    public static void testTally()
    {
        Tally t = new Tally();
        t.addWord("wood");
        t.addWord("a");
        t.addWord("wood");
        t.addWord("chuck");
        t.addWord("chuck");
        t.addWord("wood");
        System.out.println("count: " + t.getCount("chuck"));
        System.out.println("total: " + t.getTotal());
        System.out.println("words: " + t.getWords());
    }
}