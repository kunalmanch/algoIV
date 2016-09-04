package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

import static my.practice.trees.BinaryTree.createBalancedTree;

/**
 * Created by kmishra on 8/30/2016.
 */
public class PreOrder {

    public static void iterativePreOrderTraversal(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.err.println(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
    }

    public static void recursivePreOrderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        System.err.println(root.val);
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        BinaryTreeNode root = createBalancedTree(a);
        recursivePreOrderTraversal(root);
        System.err.println("=======");
        iterativePreOrderTraversal(root);
    }
}
