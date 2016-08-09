package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kmishra on 8/6/2016.
 */
public class InvertBinaryTree {

    /**
     * invert a binary tree whose right nodes are only leaf nodes
     * such that the left most node is the root.
     * @return
     */
    public static BinaryTreeNode invert(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        BinaryTreeNode newRoot = root, prev = root;
        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.pop();
            prev.right = curr;
            curr.left = curr.right;
            curr.right = null;
            prev = curr;
        }
        return newRoot;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.left.left = new BinaryTreeNode(6);
        root.left.left.right = new BinaryTreeNode(7);

        BinaryTree.printNodes(root);

        BinaryTreeNode newRoot = invert(root);
        BinaryTree.printNodes(newRoot);
    }
}
