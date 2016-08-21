package my.practice.sort;

import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest Sums.
 */
public class KSmallestPairs {

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        int[] idx = new int[nums1.length];
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            int t = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (idx[i] < nums2.length && nums1[i] + nums2[idx[i]] < min) {
                    t = i;
                    min = nums1[i]+nums2[idx[i]];
                }
            }
            if (t != -1) {
                list.add(new int[]{nums1[t], nums2[idx[t]]});
                idx[t]++;
            }

        }
        return list;
    }

    public static void print(List<int[]> list) {
        for (int[] a : list) {
            System.err.println(a[0] + " " + a[1]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,7,11};
        int[] b = {2,4,6};
        print(kSmallestPairs(a, b, 10));
    }
}
