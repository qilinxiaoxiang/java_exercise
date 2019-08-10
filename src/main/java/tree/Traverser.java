package tree;

import java.util.LinkedList;
import java.util.Stack;

public class Traverser {
    public void recursiveIn(TreeNode current) {
        if (current != null) {
            recursiveIn(current.left);
            System.out.print(current.val);
            recursiveIn(current.right);
        }
    }

    public void nonRecursiveIn(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.val);
                current = current.right;
            }
        }
    }

    public void recursivePre(TreeNode current) {
        if (current != null) {
            System.out.print(current.val);
            recursivePre(current.left);
            recursivePre(current.right);
        }
    }

    public void nonRecursivePre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.print(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }
    
    public void recursivePost(TreeNode current){
        if(current != null) {
            recursivePost(current.left);
            recursivePost(current.right);
            System.out.print(current.val);
        }
    }

    public void nonRecursivePost(TreeNode root){
        TreeNode temp = root;
        while (temp != null && temp.visited == false){
            if (temp.left != null && !temp.left.visited) {
                temp = temp.left;
            } else if (temp.right != null && !temp.right.visited) {
                temp = temp.right;
            }else{
                System.out.print(temp.val);
                temp.visited = true;
                temp = root;
            }
        }
    }

    public void nonRecursivePost1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                if(!current.visited){
                    current.visited = true;
                    stack.push(current);
                    current = current.right;
                }else{
                    System.out.print(current.val);
                    current = null;
                }
            }
        }

    }
}
