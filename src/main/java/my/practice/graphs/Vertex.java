package my.practice.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmishra on 8/23/2016.
 */
public class Vertex {
    public int val;
    public List<Vertex> edges;

    public Vertex(int val) {
        this.val = val;
    }

    public void addChild(Vertex v) {
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(v);
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
