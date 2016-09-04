package my.practice.dp;

/**
 * Created by kmishra on 9/1/2016.
 */
public class FloydWarshall {

    public static void floydWarshall(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        long[][] dp = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = graph[i][j];
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        //print
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long dist = dp[i][j] >= Integer.MAX_VALUE ? -1 : dp[i][j];
                System.err.print(dist + "\t");
            }
            System.err.println("");
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] graph = {
            {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}
