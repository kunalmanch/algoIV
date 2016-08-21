package my.practice.graphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by kmishra on 8/13/2016.
 */
public class ShortestPath {

    private static class VertexDistance implements Comparable<VertexDistance> {
        int idx;
        int dist;

        private VertexDistance(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(VertexDistance o) {
            return this.dist - o.dist;
        }
    }

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>();
        pq.add(new VertexDistance(src, dist[src]));
        int count = 0;
        while (count < graph.length) {
            VertexDistance u = pq.poll();
            set.add(u.idx);
            for (int v = 0; v < graph[0].length; v++) {
                if (!set.contains(v) && u.dist != Integer.MAX_VALUE &&
                        graph[u.idx][v] > 0 && dist[u.idx] + graph[u.idx][v] < dist[v]) {
                    dist[v] = dist[u.idx] + graph[u.idx][v];
                    pq.add(new VertexDistance(v, dist[v]));
                }
            }
            count++;
        }
        printDijkstra(dist);
    }

    private static void printDijkstra(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.err.println("vertex " + i + " distance " + dist[i]);
        }
    }

    public static void primsMST(int[][] graph) {
        int[] dist = new int[graph.length];
        int[] parent = new int[graph.length];
        for (int i = 1; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>();
        pq.add(new VertexDistance(0, dist[0]));
        int count = 0;
        while (count < graph.length) {
            VertexDistance u = pq.poll();
            set.add(u.idx);
            for (int v = 0; v < graph[0].length; v++) {
                if (!set.contains(v) && u.dist != Integer.MAX_VALUE &&
                        graph[u.idx][v] > 0 && graph[u.idx][v] < dist[v]) {
                    dist[v] = graph[u.idx][v];
                    parent[v] = u.idx;
                    pq.add(new VertexDistance(v, dist[v]));
                }
            }
            count++;
        }
        printMST(dist, parent);
    }

    private static void printMST(int[] dist, int[] parent) {
        for (int i = 1; i < dist.length; i++) {
            System.err.println(parent[i] + " - " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);

        int graph2[][] = {{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
        };

        // Print the solution
        primsMST(graph2);
    }
}
