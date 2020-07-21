// https://leetcode.com/problems/merge-intervals/

import java.util.*;

class MergeIntervals {
  public static int[][] merge(int[][] intervals) {
    if (intervals.length == 0)
      return intervals;

    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    List<int[]> list = new ArrayList<>();
    int[] newInterval = intervals[0];
    list.add(newInterval);

    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1])
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      else {
        newInterval = interval;
        list.add(newInterval);
      }
    }

    list.forEach(item -> System.out.println(item[0] + " " + item[1]));

    return list.toArray(new int[list.size()][]);
  }

  public static void main(String[] args) {
    merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 8 } });
    // merge(new int[][] { { 1, 4 }, { 0, 4 } });
  }
}

/**
 * List<int[]> list = new ArrayList<>(); if(intervals.length == 0) return new
 * int[0][]; int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE; for
 * (int[] i : intervals) { if (i[0] < min) min = i[0]; if (i[1] > max) max =
 * i[1]; }
 * 
 * int[] axis = new int[max - min + 1]; for (int[] interval : intervals) { for
 * (int i = interval[0]; i <= interval[1]; i++) axis[i - min]++; }
 * 
 * // System.out.println(axis.length);
 * 
 * // for(int a:axis) // System.out.print(a); // System.out.println();
 * 
 * int i = 0; while (i < axis.length) { int[] current = { i+min, 0 }; while (i <
 * axis.length && axis[i] != 0) i++; current[1] = i + min - 1;
 * list.add(current); while (i < axis.length && axis[i] == 0) i++; }
 * 
 * // for (int[] n : list) { // for ( int j : n) // System.out.print(j + " ");
 * // System.out.println(" "); // }
 * 
 * int[][] result = new int[list.size()][]; for (i = 0; i < list.size(); i++)
 * result[i] = list.get(i); return result;
 * 
 */