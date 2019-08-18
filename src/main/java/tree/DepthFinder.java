package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFinder {
    public int getDepthRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepthRecursive(node.left) + 1;
        int right = getDepthRecursive(node.right) + 1;
        return Math.max(left, right);
    }

    public int getDepthTraversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            start++;
            if(currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if(start == end) {
                end = queue.size();
                start = 0;
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        DepthFinder depthFinder = new DepthFinder();
        /**
         * build a tree
         *        *
         *       / \
         *      *   *
         *     / \ / \
         *    *  **   *
         *       /
         *      *
         */
        TreeNode root = new TreeNode("");
        System.out.println(depthFinder.getDepthRecursive(root));
        System.out.println(depthFinder.getDepthTraversal(root));
        root.left = new TreeNode("");
        root.right = new TreeNode("");
        root.left.left = new TreeNode("");
        root.left.right = new TreeNode("");
        root.right.left = new TreeNode("");
        root.right.right = new TreeNode("");
        root.right.left.left = new TreeNode("");
        System.out.println(depthFinder.getDepthRecursive(root));
        System.out.println(depthFinder.getDepthTraversal(root));


    }
}
