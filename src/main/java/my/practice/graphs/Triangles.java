package my.practice.graphs;

import com.sun.javafx.geom.Edge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Count number of triangles in a graph.
 */
public class Triangles {

    public static int countTriangles(Vertex root) {
        int count = 0;
        Deque<Vertex> stack = new ArrayDeque<>();
        Set<Vertex> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            visited.add(root);
            if (root.edges != null) {
                for (Vertex v1 : root.edges) {
                    if (visited.contains(v1)) continue;
                    stack.push(v1);
                    if (v1.edges != null) {
                        for (Vertex v2 : v1.edges) {
                            if (visited.contains(v2)) continue;
                            if (v2.edges != null && v2.edges.contains(root)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
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
        v5.addChild(v1);

        System.err.println(countTriangles(v1));
    }
}
