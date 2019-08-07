package tree;

public class Subtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) { // empty tree is not subtree of any trees
            return false;
        }
        return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) { // traverse is over
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if(root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

