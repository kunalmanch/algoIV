package my.practice.trees;

import java.util.ArrayDeque;
import java.util.Deque;

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
            String s = "null,";
            if (parent.left != null) {
                s = parent.left.val + ",";
                queue.add(parent.left);
            }
            sb.append(s);
            s = "null,";
            if (parent.right != null) {
                s = parent.right.val + ",";
                queue.add(parent.right);
            }
            sb.append(s);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static BinaryTreeNode deserialize(String serialized) {
        String[] nodes = serialized.split(",");
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(nodes[0]));
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; !queue.isEmpty(); i++) {
            BinaryTreeNode parent = queue.poll();
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < nodes.length) {
                parent.left = nodes[l].equals("null") ? null : new BinaryTreeNode(Integer.parseInt(nodes[l]));
                if (parent.left != null) queue.add(parent.left);
            }
            if (r < nodes.length) {
                parent.right = nodes[r].equals("null") ? null : new BinaryTreeNode(Integer.parseInt(nodes[r]));
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
