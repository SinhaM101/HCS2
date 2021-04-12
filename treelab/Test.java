public class Test 
{
    public static void main(String[] args) 
    {
        // TreeNode<Integer> myTree = TreeLab.randomTree(10, 3);
        // TreeDisplay<Integer> display = new TreeDisplay<Integer>();
        // display.showTree(myTree);
        //testReplace();
        //testcountNodes();
        //testonlyHas();
        //testBuild();
        testSave();
        //testReflect();
    }

    public static void testReplace()
    {
        // TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node2 = new TreeNode<Integer>(6);
        // TreeNode<Integer> node3 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node4 = new TreeNode<Integer>(6);
        // node1.setLeft(node2);
        // node2.setLeft(node3);
        // node1.setRight(node4);
        // node2.setRight(node3);
        TreeNode<String> n = null;
        //TreeNode<Integer> myTree = TreeLab.randomTree(10, 3);
        //TreeDisplay<Integer> display = new TreeDisplay<Integer>();
        //display.showTree(myTree);

        //TreeDisplay<Integer> display2 = new TreeDisplay<Integer>();
        int numChanged =  TreeLab.replace(n, "a", "b");
        //display2.showTree(myTree);
        System.out.println(numChanged);
    }

    public static void testcountNodes()
    {
        // TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node2 = new TreeNode<Integer>(6);
        // TreeNode<Integer> node3 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node4 = new TreeNode<Integer>(6);
        // TreeNode<Integer> node5 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node6 = new TreeNode<Integer>(1);
        // TreeNode<Integer> node7 = new TreeNode<Integer>(1);
        // node1.setLeft(node2);
        // node1.setRight(node4);
        // node2.setLeft(node3);
        // node2.setRight(node3);
        // node4.setRight(node5);
        // node5.setLeft(node6);
        // node5.setRight(node7);
        TreeNode<Integer> myTree = TreeLab.randomTree(10, 3);

        TreeDisplay<Integer> display = new TreeDisplay<Integer>();
        display.showTree(myTree);

        int numChanged =  TreeLab.countNodesAtDepth(myTree, 2);
        display.showTree(myTree);
        System.out.println(numChanged);
    }

    public static void testonlyHas()
    {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(1);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(1);
        node1.setLeft(node2);
        node2.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node3);
        TreeDisplay<Integer> display = new TreeDisplay<Integer>();
        display.showTree(node1);
        //TreeNode<Integer> myTree = TreeLab.randomTree(10, 3);

        boolean has =  TreeLab.onlyHas(node1, 1);
        display.showTree(node1);
        System.out.println(has);
    }

    public static void testBuild()
    {
        TreeNode <Integer> build = TreeLab.build(4, 50);
        TreeDisplay <Integer> display = new TreeDisplay<Integer>();
        display.showTree(build);
    }

    public static void testSave()
    {
        TreeNode<Integer> myTree = TreeLab.build(3,1);
        TreeDisplay <Integer> display = new TreeDisplay<Integer>();
        display.showTree(myTree);
        TreeLab.saveToFile(myTree, "knowledge.txt");
        
    }

    public static void testReflect()
    {
        TreeNode<Integer> myTree = TreeLab.randomTree(10, 3);
        TreeDisplay <Integer> display = new TreeDisplay<Integer>();
        display.showTree(myTree);

        TreeDisplay <Integer> display2 = new TreeDisplay<Integer>();
        TreeLab.reflect(myTree);
        display2.showTree(myTree);
    }
}
