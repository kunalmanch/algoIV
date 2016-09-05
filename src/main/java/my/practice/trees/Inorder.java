package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

import static my.practice.trees.BinaryTree.createBalancedTree;

/**
 * Created by kmishra on 9/4/2016.
 */
public class Inorder {

    public static void iterative(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        boolean notDone = true;
        while (notDone) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.isEmpty()) {
                root = stack.pop();
                System.err.println(root.val);
                root = root.right;
            } else {
                notDone = false;
            }
        }
    }

    public static void recursice(BinaryTreeNode root) {
        if (root == null) return;
        recursice(root.left);
        System.err.println(root.val);
        recursice(root.right);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        BinaryTreeNode root = createBalancedTree(a);
        recursice(root);
        System.err.println("======");
        iterative(root);
    }

}
