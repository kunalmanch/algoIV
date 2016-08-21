package my.practice.trees;

/**
 * Created by kmishra on 8/18/2016.
 */
public class BSTFromPreOrder {

    int[] pre;
    Index preIdx;

    public BinaryTreeNode bstFromPre() {
        return bstFromPre(pre[preIdx.idx], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BinaryTreeNode bstFromPre(int key, int min, int max) {
        if (preIdx.idx >= pre.length) return null;
        BinaryTreeNode root = null;
        if (min < key && key < max) {
            root = new BinaryTreeNode(key);
            preIdx.idx++;
            if (preIdx.idx < pre.length) {
                root.left = bstFromPre(pre[preIdx.idx], key, max);
                root.right = bstFromPre(pre[preIdx.idx], min, key);
            }
        }
        return root;
    }

}
