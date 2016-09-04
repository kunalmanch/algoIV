package my.practice.arrays;

/**
 * Given an array, return the max number of elements greater than an index in the array
 * where these elements are on the right side of this index
 */
public class MaxPrefix {

    private static class Node {
        private Node left, right;
        private int val;
        private int rightCount;
        private int leftCount;

        private Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val + " : " + leftCount + " : " + rightCount);
        }
    }

    private Node root;

    public static int maxPrefix(int[] a) {
        MaxPrefix maxPrefix = new MaxPrefix();
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1, prefix = 0; i >= 0; i--, prefix = 0) {
            Node n = new Node(a[i]);
            if (maxPrefix.root == null) {
                maxPrefix.root = n;
            }
            Node itr = maxPrefix.root;
            while (true) {
                if (n.val == itr.val) break;
                if (n.val < itr.val) {
                    itr.leftCount++;
                    prefix += itr.rightCount + 1; //+1 for the current node.
                    if (itr.left == null) {
                        itr.left = n;
                        break;
                    }
                    itr = itr.left;
                } else {
                    itr.rightCount++;
                    if (itr.right == null) {
                        itr.right = n;
                        break;
                    }
                    itr = itr.right;
                }
            }
            max = Math.max(max, prefix);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10,-4,6,2,8,9,4};
        int[] b = {10,9,1,2,3,4};
        System.err.println(maxPrefix(a));
        System.err.println(maxPrefix(b));
    }
}
