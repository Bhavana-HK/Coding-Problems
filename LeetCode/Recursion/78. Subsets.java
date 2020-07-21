
// https://leetcode.com/problems/subsets/
import java.util.*;

class Subsets {
  public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
    // add the current list to the result array
    subsets.add(new ArrayList<>(current));

    // walk though the rest of the elements
    for (int i = index; i < nums.length; i++) {
      // 2 things: we're including the current element and then we are not.
      // 1st include that element, generate the subsets (including it)
      // 2nd dont include that elemts, carry on
      current.add(nums[i]);
      generateSubsets(i + 1, nums, current, subsets);
      current.remove(current.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return subsets;

    // send a black list to contain the current list to be added
    generateSubsets(0, nums, new ArrayList<Integer>(), subsets);

    return subsets;

  }

  public static void main(String[] args) {
    Subsets s = new Subsets();
    System.out.println(s.subsets(new int[] { 1, 2, 3, 4 }));
  }
}