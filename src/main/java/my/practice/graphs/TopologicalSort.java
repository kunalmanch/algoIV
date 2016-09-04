package my.practice.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kmishra on 8/27/2016.
 */
public class TopologicalSort {

    public static boolean topologicalSort(Vertex v, Set<Vertex> visited, Set<Vertex> recStack, Deque<Vertex> op) {
        if (!visited.contains(v)) {
            visited.add(v);
            recStack.add(v);
            if (v.edges != null) {
                for (Vertex c : v.edges) {
                    if (!visited.contains(c) && !topologicalSort(c, visited, recStack, op)) {
                        return false;
                    } else if (recStack.contains(c)) {
                        return false;
                    }
                }
            }
        }
        recStack.remove(v);
        op.push(v);
        return true;
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
        v2.addChild(v5);
        v3.addChild(v5);
        v4.addChild(v5);
        v5.addChild(v1);
        Deque<Vertex> stack = new ArrayDeque<>();
        if (!topologicalSort(v1, new HashSet<>(), new HashSet<>(), stack)) {
            System.err.println("cycle detected!");
        } else {
            while (!stack.isEmpty()) {
                System.err.println(stack.pop().val);
            }
        }
    }
}
