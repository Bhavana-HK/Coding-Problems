// https://leetcode.com/problems/binary-tree-level-order-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      traverseTree(res, root, 0);
      return res;
    }
  
  public void traverseTree(List<List<Integer>> res, TreeNode root, int height){
    if(root==null)
      return;
    if(height >= res.size())
      res.add(new ArrayList<>());
    res.get(height).add(root.val);
    traverseTree(res, root.left, height+1);
    traverseTree(res, root.right, height+1);
  }
}