package my.practice.graphs;

import java.util.*;

/**
 * Created by kmishra on 8/24/2016.
 */
public class BaseballTraffic {

    private static class City {
        int pop;
        List<City> neighbours;

        private City(int pop) {
            this.pop = pop;
        }

        private void addNeighbour(City n) {
            if (neighbours == null) neighbours = new ArrayList<>();
            neighbours.add(n);
        }
    }

    public static void gameNightTraffic(List<City> cities) {
        int globalPop = 0;
        List<City> leafs = new ArrayList<>();
        for (City c : cities) {
            globalPop += c.pop;
            if (c.neighbours != null && c.neighbours.size() == 1) {
                leafs.add(c);
            }
        }
        int[] sum = new int[cities.size()];
        int[] max = new int[cities.size()];
        for (int i = 0; i < leafs.size(); i++) {
            City c = leafs.get(i);
            System.err.println(c.pop + " : " + (Math.abs(globalPop - c.pop - sum[i] - max[i])));
            if (c.neighbours == null || c.neighbours.isEmpty()) continue;
            City next = c.neighbours.get(0);
            int nIdx = cities.indexOf(next);
            sum[nIdx] += c.pop + sum[i];
            max[nIdx] = Math.max(max[nIdx], c.pop + sum[i]);
            if (next.neighbours != null) {
                next.neighbours.remove(c);
                if (next.neighbours.size() == 1) {
                    leafs.add(next);
                }
            }
        }
    }


    public static void main(String[] args) {
        City c1 = new City(1);
        City c2 = new City(2);
        City c3 = new City(3);
        City c4 = new City(4);
        City c5 = new City(5);
        c1.addNeighbour(c5);
        c2.addNeighbour(c5);
        c3.addNeighbour(c5);
        c4.addNeighbour(c5);
        c5.addNeighbour(c1);
        c5.addNeighbour(c2);
        c5.addNeighbour(c3);
        c5.addNeighbour(c4);

        List<City> cities = new ArrayList<>();
        cities.add(c1);
        cities.add(c2);
        cities.add(c3);
        cities.add(c4);
        cities.add(c5);

        gameNightTraffic(cities);
    }
}
