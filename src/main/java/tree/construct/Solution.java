package tree.construct;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 项峥
 * @Date: 2021/7/4 23:44
 */
public class Solution {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            this.indexMap.put(inorder[i], i);
        }
        return buildTree(0, length - 1, length - 1);
    }

    private TreeNode buildTree(int leftBoundaryOfInOrder, int rightBoundaryOfInOrder, int indexOfPostOrder) {
        // 递归终止条件
        if (leftBoundaryOfInOrder > rightBoundaryOfInOrder) {
            return null;
        }
        int value = postorder[indexOfPostOrder];
        TreeNode treeNode = new TreeNode(value);
        Integer indexOfInOrder = indexMap.get(value);
        // 从后续遍历拿到尾端点, 递归右子树
        treeNode.right = buildTree(indexOfInOrder + 1, rightBoundaryOfInOrder, indexOfPostOrder - 1);
        // 拿到右子树长度
        int rightSubTreeLength = rightBoundaryOfInOrder - (indexOfInOrder + 1) + 1;
        // 从后续遍历拿到尾端点, 递归左子树
        treeNode.left = buildTree(leftBoundaryOfInOrder, indexOfInOrder - 1, indexOfPostOrder - rightSubTreeLength - 1);
        return treeNode;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
