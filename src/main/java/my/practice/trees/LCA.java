package my.practice.trees;

/**
 * LCA for a bt.
 */
public class LCA {

    public static BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2) {
        if (root == null) return null;

        if (root.val == n1 || root.val == n2) return root;

        BinaryTreeNode l = lca(root.left, n1, n2);
        BinaryTreeNode r = lca(root.right, n1, n2);

        if (l != null && r != null) return root;

        return l != null ? l : r;
    }
}
