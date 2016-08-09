package my.practice.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kmishra on 8/7/2016.
 */
public class WordDistance {

    public static int distance(String[] a, String wordA, String wordB) {
        int dist = Integer.MAX_VALUE;
        int idxA = -1, idxB = -1;
        for (int i = 0; i < a.length; i++) {
            if (wordA.equals(a[i])) {
                idxA = i;
            }

            if (wordB.equals(a[i])) {
                idxB = i;
            }

            if (idxA != -1 && idxB != -1) {
                dist = Math.min(Math.abs(idxA - idxB), dist);
            }
        }
        return dist;
    }

    public static int distanceFast(String[] a, String wordA, String wordB) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            List<Integer> list;
            if ((list = map.get(a[i])) == null) {
                list = new ArrayList<>();
                map.put(a[i], list);
            }
            list.add(i);
        }

        List<Integer> idxAList = map.get(wordA);
        List<Integer> idxBList = map.get(wordB);
        int i = 0, j = 0, dist = Integer.MAX_VALUE;
        while (i < idxAList.size() && j < idxBList.size()) {
            int idxA = idxAList.get(i);
            int idxB = idxBList.get(j);
            dist = Math.min(dist, Math.abs(idxA - idxB));
            if (idxA < idxB) i++;
            else j++;
        }
        return dist;
    }

    public static void main(String[] args) {
        String[] a = {"practice", "makes", "perfect", "coding", "makes"};
        System.err.println(distance(a, "coding", "practice"));
        System.err.println(distance(a, "coding", "makes"));
        System.err.println(distanceFast(a, "coding", "practice"));
        System.err.println(distanceFast(a, "coding", "makes"));
    }
}
