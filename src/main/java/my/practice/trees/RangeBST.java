package my.practice.trees;

/**
 * Created by kmishra on 8/24/2016.
 */
public class RangeBST {

    private BinaryTreeNode root;

    public void add(int val) {
        if (root == null) {
            root = new BinaryTreeNode(val);
            return;
        }
        BinaryTreeNode itr = root;
        while (true) {
            if (val < itr.val) {
                if (itr.left != null) {
                    itr = itr.left;
                    continue;
                }
                itr.left = new BinaryTreeNode(val);
                itr.orderId++;
                break;
            } else {
                if (itr.right != null) {
                    itr = itr.right;
                    continue;
                }
                itr.right = new BinaryTreeNode(val);
                itr.right.orderId = itr.orderId + 1;
                break;
            }
        }
    }

    public int countNodesWithinRange(int lo, int hi) {
        int[] id = {0};
        assignOrderId(root, id);
        int loOrderId = countNodesForSearch(root, lo, -1);
        int hiOrderId = countNodesForSearch(root, hi, -1);
        return hiOrderId - loOrderId + 1;
    }

    private int countNodesForSearch(BinaryTreeNode root, int val, int prevOrderId) {
        if (root == null) return prevOrderId;
        if (root.val == val) return root.orderId;
        BinaryTreeNode node = root.val > val ? root.left : root.right;
        return countNodesForSearch(node, val, root.orderId);
    }

    private static void assignOrderId(BinaryTreeNode root, int[] orderId) {
        if (root == null) return;
        assignOrderId(root.left, orderId);
        root.orderId = orderId[0]++;
        assignOrderId(root.right, orderId);
    }

    public static void main(String[] args) {
        RangeBST rangeBST = new RangeBST();
        rangeBST.add(4);
        rangeBST.add(2);
        rangeBST.add(1);
        rangeBST.add(3);
        rangeBST.add(6);
        rangeBST.add(5);
        rangeBST.add(7);
        System.err.println(rangeBST.countNodesWithinRange(3, 5));
    }

}
