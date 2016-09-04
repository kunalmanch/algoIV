package my.practice.graphs;

import java.util.*;

/**
 * Shortest paths between two vertices in an undirected graph.
 */
public class UGShortestPaths {

    public static class UGVertex {
        private Vertex v;
        private int d;

        UGVertex(Vertex v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    public static int shortestPaths(Vertex src, Vertex dest) {
        int paths = 0;
        int shortestDist = Integer.MAX_VALUE;
        Deque<UGVertex> queue = new ArrayDeque<>();
        queue.add(new UGVertex(src, 0));
        Set<Vertex> visited = new HashSet<>();
        boolean first = true;
        while (!queue.isEmpty()) {
            UGVertex curr = queue.poll();
            visited.add(curr.v);
            if (curr.v == dest) {
                if (first) {
                    first = false;
                    shortestDist = curr.d;
                    paths++;
                } else if (curr.d == shortestDist){
                    paths++;
                }
                continue;
            }
            if (curr.v.edges == null) continue;
            for (Vertex v : curr.v.edges) {
                if (!visited.contains(v)) {
                    queue.add(new UGVertex(v, curr.d + 1));
                }
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        v1.addChild(v2);
        v1.addChild(v3);
        v1.addChild(v4);
        v4.addChild(v5);
        v3.addChild(v5);
        v2.addChild(v5);

        System.err.println(shortestPaths(v1, v5));
    }
}
