package my.practice.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Detect cycle in a graph.
 */
public class CycleDetection {

    public static boolean cycleExists(Vertex v, Set<Vertex> recStack, Set<Vertex> visited) {
        if (!visited.contains(v)) {
            visited.add(v);
            recStack.add(v);
            if (v.edges != null) {
                for (Vertex c : v.edges) {
                    if (!visited.contains(c) && cycleExists(c, recStack, visited)) {
                        return true;
                    } else if (recStack.contains(c)) {
                        return true;
                    }
                }
            }
        }
        recStack.remove(v);
        return false;
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        v1.addChild(v2);
        v2.addChild(v3);
        v3.addChild(v4);
        v4.addChild(v5);
//        v4.addChild(v1);
        System.err.println(cycleExists(v1, new HashSet<>(), new HashSet<>()));
    }
}
