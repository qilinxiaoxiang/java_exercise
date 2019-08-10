package tree;

public class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");
        TreeNode k = new TreeNode("K");
        a.left = b;
        a.right = e;
        b.right = c;
        c.left = d;
        e.right = f;
        f.left = g;
        g.left = h;
        g.right = k;
        Traverser traverser = new Traverser();
        traverser.recursivePre(a);
        System.out.println();
        traverser.nonRecursivePre(a);
        System.out.println();
        traverser.recursiveIn(a);
        System.out.println();
        traverser.nonRecursiveIn(a);
        System.out.println();
        traverser.recursivePost(a);
        System.out.println();
//        traverser.nonRecursivePost(a);
        System.out.println();
        traverser.nonRecursivePost1(a);

    }
}
