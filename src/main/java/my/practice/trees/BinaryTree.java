package my.practice.trees;

import java.util.*;

public class BinaryTree {

    static BinaryTreeNode head, prev;

    /**
     * /**
     * Given an array of values, create a balanced binary tree.
     */
    public static BinaryTreeNode createBalancedTree(int[] a) {
        if (a == null || a.length == 0) return null;
        BinaryTreeNode root = new BinaryTreeNode(a[0]);
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; !queue.isEmpty(); i++) {
            BinaryTreeNode parent = queue.poll();
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < a.length) {
                parent.left = new BinaryTreeNode(a[l]);
                queue.add(parent.left);
            }
            if (r < a.length) {
                parent.right = new BinaryTreeNode(a[r]);
                queue.add(parent.right);
            }
        }
        return root;
    }

    public static BinaryTreeNode createBalancedBST(int[] a, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + ((hi - lo) >> 1);
        BinaryTreeNode root = new BinaryTreeNode(a[mid]);
        root.left = createBalancedBST(a, lo, mid - 1);
        root.right = createBalancedBST(a, mid + 1, hi);
        return root;
    }

    /**
     * Print each row of the tree in order.
     * Terminate each row with a carriage return.
     */
    public static void printNodes(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currLevel = 1, nextLevel = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode parent = queue.poll();
            System.err.print(parent.val);
            if (parent.left != null) {
                nextLevel++;
                queue.add(parent.left);
            }

            if (parent.right != null) {
                nextLevel++;
                queue.add(parent.right);
            }

            if (--currLevel == 0) {
                currLevel = nextLevel;
                nextLevel = 0;
                System.err.println("");
            } else {
                System.err.print(",");
            }
        }
    }

    public static void treeToList(BinaryTreeNode root) {
        if (root == null) return;
        treeToList(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        treeToList(root.right);
    }

    public static void printLevelOrder(BinaryTreeNode node) {
        int h = height(node);
        for (int i = h; i >= 1; i--) {
            recLevelOrderHelper(node, i);
            System.err.println("");
        }
    }

    private static void recLevelOrderHelper(BinaryTreeNode node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.err.print(node.val + " ");
        } else if (level > 1) {
            recLevelOrderHelper(node.left, level - 1);
            recLevelOrderHelper(node.right, level - 1);
        }
    }

    private static void printWidthOrder(BinaryTreeNode root) {
        class NodeWidth {
            BinaryTreeNode node;
            int width;

            private NodeWidth(BinaryTreeNode node, int width) {
                this.node = node;
                this.width = width;
            }
        }
        Deque<NodeWidth> queue = new ArrayDeque<>();
        HashMap<Integer, List<BinaryTreeNode>> map = new HashMap<>();
        int minWidth = Integer.MAX_VALUE, maxWidth = Integer.MIN_VALUE;
        queue.add(new NodeWidth(root, 0));
        addToMap(map, root, 0);
        while (!queue.isEmpty()) {
            NodeWidth parent = queue.poll();

            if (parent.node.left != null) {
                queue.add(new NodeWidth(parent.node.left, parent.width - 1));
                minWidth = Math.min(minWidth, parent.width - 1);
                addToMap(map, parent.node.left, parent.width - 1);
            }

            if (parent.node.right != null) {
                queue.add(new NodeWidth(parent.node.right, parent.width + 1));
                maxWidth = Math.max(maxWidth, parent.width + 1);
                addToMap(map, parent.node.right, parent.width + 1);
            }
        }

        for (int i = minWidth; i <= maxWidth; i++) {
            List<BinaryTreeNode> list = map.get(i);
            if (list != null) {
                for (BinaryTreeNode node : list) {
                    System.err.print(node.val + " ");
                }
                System.err.println("");
            }
        }
    }

    private static void addToMap(HashMap<Integer, List<BinaryTreeNode>> map, BinaryTreeNode node, int width) {
        List<BinaryTreeNode> list;
        if ((list = map.get(width)) == null) {
            list = new ArrayList<>();
            map.put(width, list);
        }
        list.add(node);
    }

    public static int height(BinaryTreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};

        printNodes(createBalancedTree(a));
        System.err.println("");
        BinaryTreeNode root = createBalancedBST(a, 0, a.length - 1);
        printNodes(root);
        System.err.println("");
        printLevelOrder(root);
        System.err.println("width wise");
        printWidthOrder(root);
        System.err.println("");
        treeToList(root);
        System.err.println(head);
        BinaryTreeNode curr = head;
        while (curr != null) {
            System.err.print(curr + "-->");
            curr = curr.right;
        }
    }
}
