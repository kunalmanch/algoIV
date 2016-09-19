package my.practice.graphs;

import java.util.PriorityQueue;

/**
 * BFS Solution to Snake and Ladder game.
 */
public class SnakeAndLadder {

    private static class Node implements Comparable<Node> {
        int idx;
        int moves;

        Node(int i, int m) {
            idx = i;
            moves = m;
        }

        @Override
        public int compareTo(Node that) {
            return this.moves - that.moves;
        }
    }

    public static int minMoves(int[] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        pq.add(new Node(-1, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.idx >= board.length - 1) {
                min = Math.min(min, curr.moves);
            } else {
                for (int move = curr.idx + 1; move <= curr.idx + 6; move++) {
                    if (move >= board.length) {
                        min = Math.min(min, 1 + curr.moves);
                        continue;
                    }
                    int nextIdx = (board[move] == 0 ? move : board[move]);
                    pq.add(new Node(nextIdx, 1 + curr.moves));
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] board = {0, 3, 0, 0};
        System.err.println(minMoves(board));
    }

}
