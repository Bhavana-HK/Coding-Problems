// https://leetcode.com/problems/relative-sort-array/

import java.util.*;

class ReativelySorted {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int k = 0;
        int[] res = new int[arr1.length];
        for (int i : arr2) {
            for (int j = 0; j < map.get(i); j++)
                res[k++] = i;
            map.remove(i);
        }

        for (int i : map.keySet()) {
            for (int j = 0; j < map.get(i); j++)
                res[k++] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ans = (new ReativelySorted().relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 },
                new int[] { 2, 1, 4, 3, 9, 6 }));
        for (int i : ans)
            System.out.print(i + " ");
    }
}