package my.practice.trees;

import javax.print.DocFlavor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by kmishra on 8/8/2016.
 */
public class SerializeBinaryTree {

    public static String serialize(BinaryTreeNode root) {
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        sb.append(root.val);
        sb.append(',');
        while (!queue.isEmpty()) {
            BinaryTreeNode parent = queue.poll();
            if (parent.left == null) {
                sb.append("null,");
            } else {
                queue.add(parent.left);
                sb.append(parent.left.val);
                sb.append(',');
            }
            if (parent.right == null) {
                sb.append("null,");
            } else {
                sb.append(parent.right.val);
                sb.append(',');
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static BinaryTreeNode deserialize(String serialized) {
        String[] nodes = serialized.split(",");
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(nodes[0]));
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; !queue.isEmpty(); i++) {
            BinaryTreeNode parent = queue.poll();
            if (2 * i + 1 < nodes.length) {
                parent.left = nodes[2 * i + 1].equals("null") ? null : new BinaryTreeNode(Integer.parseInt(nodes[2 * i + 1]));
                if (parent.left != null) queue.add(parent.left);
            }
            if (2 * i + 2 < nodes.length) {
                parent.right = nodes[2 * i + 2].equals("null") ? null : new BinaryTreeNode(Integer.parseInt(nodes[2 * i + 2]));
                if (parent.right != null) queue.add(parent.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        System.err.println(serialize(root));
        root = deserialize(serialize(root));
        BinaryTree.printNodes(root);
    }
}
