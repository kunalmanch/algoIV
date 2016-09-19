package my.practice.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space,
 * ‘G’ represents guards and ‘W’ represents walls in a Bank.
 * Replace all of the O’s in the matrix with their shortest distance from a guard, without being able to go through any walls.
 * Also, replace the guards with 0 and walls with -1 in output matrix.
 */
public class BankGaurds {

    private static class Node {
        int i, j, dist;

        Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return i + " " + j + " " + dist;
        }
    }

    public static int[][] shortestDistance(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                if (mat[i][j] == 'G') {
                    queue.add(new Node(i, j, 0));
                    dp[i][j] = 0;
                }
            }
        }
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = curr.i + row[k];
                int j = curr.j + col[k];
                if (isValid(i, j, mat) && isSafe(i, j, mat, dp)) {
                    Node child = new Node(i, j, curr.dist + 1);
                    dp[i][j] = curr.dist + 1;
                    queue.add(child);
                }
            }
        }

        return dp;
    }

    private static boolean isSafe(int i, int j, char[][] mat, int[][] dp) {
        if (mat[i][j] != 'O' || dp[i][j] != -1) return false;
        return true;
    }

    private static boolean isValid(int i, int j, char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (i < 0 || i > m - 1) return false;
        if (j < 0 || j > n - 1) return false;

        return true;
    }

    public static void main(String[] args) {
        char matrix[][] =
        {
            {'O', 'O', 'O', 'O', 'G'},
            {'O', 'W', 'W', 'O', 'O'},
            {'O', 'O', 'O', 'W', 'O'},
            {'G', 'W', 'W', 'W', 'O'},
            {'O', 'O', 'O', 'O', 'G'}
        };

        int[][] sol = shortestDistance(matrix);
        for (int[] a : sol) {
            for (int i : a) {
                System.err.print(i + " ");
            }
            System.err.println("");
        }
    }
}
