package my.practice.trees;

/**
 * Given a bst, find the closest number to a given range.
 */
public class ClosestNum {

    public static void closest(BinaryTreeNode node, int val, int[] res) {
        if (node == null) return;
        if (node.val == val) return;
        if (res[0] > Math.abs(val - node.val)) {
            res[0] = Math.abs(val - node.val);
            res[1] = node.val;
        }
        BinaryTreeNode next = node.val < val ? node.right : node.left;
        closest(next, val, res);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(75);
        root.left = new BinaryTreeNode(72);
        root.right = new BinaryTreeNode(78);
        int[] res = new int[]{Integer.MAX_VALUE, 0};
        closest(root, 73, res);
        System.err.println(res[1]);
    }
}
