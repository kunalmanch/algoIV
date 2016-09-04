package my.practice.matrix;

import java.util.PriorityQueue;

/**
 * Created by kmishra on 8/30/2016.
 */
public class KthLargest {

    private static class Node implements Comparable<Node> {
        int val;
        int row;
        int col;

        private Node(int v, int r, int c) {
            val = v;
            row = r;
            col = c;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }

    public static int kthLargest(int[][] mat, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int m = mat.length;
        int n = mat[0].length;
        //insert the first row.
        for (int i = 0; i < n; i++) {
            pq.add(new Node(mat[0][i], 0, i));
        }
        int ans = -1;
        while (k-- > 0) {
            Node node = pq.poll();
            ans = node.val;
            if (node.row + 1 < m) {
                pq.add(new Node(mat[node.row + 1][node.col], node.row + 1, node.col));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {11,12,13},
                {14,15,16},
                {17,18,19}
        };

        System.err.println(kthLargest(mat, 6));
    }
}
