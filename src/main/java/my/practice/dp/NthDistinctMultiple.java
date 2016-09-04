package my.practice.dp;

import java.util.PriorityQueue;

/**
 * Find the nth distinct multiple for a given set of numbers.
 */
public class NthDistinctMultiple {

    private static class Node implements Comparable<Node> {
        int num;
        int og;
        int factor;

        Node(int n, int og, int f) {
            num = n;
            this.og = og;
            factor = f;
        }

        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }

    public static int nthDistinctMultiple(int n, int[] set) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int k : set) {
            pq.add(new Node(k, k, 1));
        }
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Node node = pq.poll();
            int next = node.num + node.og;
            pq.add(new Node(next, node.og, node.factor + 1));
            if (prev == node.num) {
                i--;
            } else {
                ans = node.num;
                prev = node.num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] set = {4, 6};
        System.err.println(nthDistinctMultiple(6, set));
    }
}
