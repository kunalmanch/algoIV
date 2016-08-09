package my.practice.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Using the below node list find the path that uses all the nodes without duplicating one.
 [ JFK,LXA,SNA,RKJ,LXA,SNA ]
 Note: Each pair of nodes define a directed edge like so:
 [ (JFK -> LXA),(SNA -> RKJ),(LXA -> SNA) ]
 */
public class FlightItinerary {

    static void printItinerary(String[] trip) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < trip.length; i += 2) {
            String from = trip[i];
            String to = trip[i + 1];
            map.put(from, to);
        }

        String root = getRoot(map);

        dfs(root, map);
    }

    private static void dfs(String from, Map<String, String> map) {
        if (from == null) return;
        String to = map.get(from);
        if (to != null) System.err.println(from + "->" + to);
        dfs(to, map);
    }

    private static String getRoot(Map<String, String> map) {
        Collection<String> destinations = map.values();
        Set<String> froms = map.keySet();
        String root = null;
        for (String from : froms) {
            if (!destinations.contains(from)) {
                root = from;
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String[] trip = { "JFK","LXA","SNA","RKJ","LXA","SNA"};
        printItinerary(trip);
    }
}
