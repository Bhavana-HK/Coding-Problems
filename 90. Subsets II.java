
// https://leetcode.com/problems/subsets-ii/
import java.util.*;

class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    Arrays.sort(nums);
    generateSubsets(0, nums, new ArrayList<>(), subsets);
    return subsets;
  }

  public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(current));

    for (int i = index; i < nums.length; i++) {
      if (i == index || nums[i] != nums[i - 1]) {
        current.add(nums[i]);
        generateSubsets(i + 1, nums, current, subsets);
        current.remove(current.size()-1);
      }
    }

  }

  public static void main(String[] args) {
    System.out.println(new SubsetsII().subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}