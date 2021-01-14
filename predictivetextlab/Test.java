public class Test
{
    public static void main(String[] args)
    {
        //testSet();
        //testMap();
        //testTally();
        testPredictor();
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
        
        System.out.println(map.put("A", 7));
        System.out.println(map.put("A", 10));
        System.out.println(map.put("B", 8));
        System.out.println(map.put("C", 2));

        for (String currentString : map.keySet())
        {
            System.out.println(currentString + ": " + map.get(currentString));
        }
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

    public static void testPredictor()
    {
        TextPredictor x = new TextPredictor();
        String[] seuss = {"I", "am", "Sam", "Sam", "I", "am"};
        String[] lucas = {"I", "am", "your", "father"};
        x.record(seuss);
        //x.display();
        x.record(lucas);
        //x.display();
        String[] test1 = {"say", "hi", "to", "am", "covfefe"};
        Tally t = x.predict(test1);
        System.out.println(t.getWords() + ": " + t.getTotal());
    }
}