// https://leetcode.com/problems/subtree-of-another-tree/

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
      if(s==null)
        return false;
      if(isEqual(s,t)) 
        return true;
      return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
  
  public boolean isEqual(TreeNode s, TreeNode t) {
    if(s==null && t==null)
      return true;
    if((s==null || t==null) || s.val!=t.val)
      return false;
    else return isEqual(s.left, t.left) && isEqual(s.right, t.right);
  }
  
}