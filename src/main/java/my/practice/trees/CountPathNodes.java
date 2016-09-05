package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Count nodes between two nodes in a BT.
 */
public class CountPathNodes {

    public static int countNodes(BinaryTreeNode root, int n1, int n2) {
        BinaryTreeNode lca = LCA.lca(root, n1, n2);

        if (lca == null) return 0;
        int count1 = count(lca, n1);
        int count2 = count(lca, n2);

        return count1 + count2 - 1;
    }

    private static int count(BinaryTreeNode node, int n) {
        class Node {
            BinaryTreeNode node;
            int k;

            Node(BinaryTreeNode n, int i) {
                node = n;
                k = i;
            }
        }

        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(new Node(node, 0));

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.node.val == n) return curr.k;

            if (curr.node.left != null) {
                stack.push(new Node(curr.node.left, curr.k + 1));
            }

            if (curr.node.right != null) {
                stack.push(new Node(curr.node.right, curr.k + 1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(3);
        System.err.println(countNodes(root, 4, 3));
    }
}
