// https://leetcode.com/problems/shortest-way-to-form-string/

// import java.util.*;

class ShortestWaySubsequence {

	public int shortestWay(String source, String target) {
		int minSubsequence = 1;
		int i = 0; // target
		int j = 0; // src
		char[] src = source.toCharArray();
		char[] tar = target.toCharArray();
		int iteration = 0;
		while (i < tar.length) {
			// System.out.println(j + " " + i);
			while (j < src.length && src[j] != tar[i])
				j++;
			if (j == src.length && iteration == 0) {
				iteration = 1;
				minSubsequence++;
				j = 0;
			} else if (j == src.length && iteration == 1)
				return -1;
			else if (src[j] == tar[i]) {
				iteration = 0;
				i++;
				j++;
			}
		}
		return minSubsequence;
	}

	public static void main(String[] args) {
		System.out.println(new ShortestWaySubsequence().shortestWay("abc", "abcbc"));
		System.out.println(new ShortestWaySubsequence().shortestWay("abc", "acdbc"));
		System.out.println(new ShortestWaySubsequence().shortestWay("xyz", "xzyxz"));

	}
}

/**
 * From any string, we can form a subsequence of that string by deleting some
 * number of charecters(possibly no deletions)
 * 
 * Given 2 strings source and target, return the minimum number of subsequences
 * of source such that their concatination equals target. If task is impossible,
 * return -1.
 * 
 * Example 1: Input : source="abc" target="abcbc" Output: 2
 * 
 * Example 2: Input : source="abc" target="acdbc" Output: -1
 * 
 * Example 3: Input: source="xyz" target="xzyxz" Output: 3
 */