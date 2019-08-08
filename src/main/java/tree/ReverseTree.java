package tree;

import java.util.LinkedList;

public class ReverseTree {
    public void nonRecursiveReverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempRoot = stack.pop();
            TreeNode temp = tempRoot.left;
            tempRoot.left = tempRoot.right;
            tempRoot.right = temp;
            if(tempRoot.left != null) {
                stack.push(tempRoot.left);
            }
            if(tempRoot.right != null) {
                stack.push(tempRoot.right);
            }
        }
    }

    public void recursiveReverse(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursiveReverse(root.left);
            recursiveReverse(root.right);
        }
    }
}
