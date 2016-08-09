package my.practice.trees;

/**
 * Created by kmishra on 8/5/2016.
 */
public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
