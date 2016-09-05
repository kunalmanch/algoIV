package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

import static my.practice.trees.BinaryTree.createBalancedTree;

/**
 * Created by kmishra on 8/30/2016.
 */
public class PostOrder {

    public static void recursicePostOrder(BinaryTreeNode root) {
        if (root == null) return;
        recursicePostOrder(root.left);
        recursicePostOrder(root.right);
        System.err.println(root.val);
    }

    public static void postOrderTrv2Stack(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack1 = new ArrayDeque<>();
        Deque<BinaryTreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.err.println(stack2.pop().val);
        }
    }

    public static void postOrderTrv1Stack(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        do {
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (!stack.isEmpty() && stack.peek() == root.right) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                System.err.println(root.val);
                root = null;
            }

        } while (!stack.isEmpty());
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        BinaryTreeNode root = createBalancedTree(a);
        recursicePostOrder(root);
        System.err.println("======");
        postOrderTrv2Stack(root);
        System.err.println("======");
        postOrderTrv1Stack(root);
    }
}
