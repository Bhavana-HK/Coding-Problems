// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    int count=0;
    int number=0;
    
    public int kthSmallest(TreeNode root, int k) {
      count=k;
      traverseTree(root);
      return number;
    }
    
    public void traverseTree(TreeNode root){
      if(root.left != null) traverseTree(root.left);
      
      count--;
      if(count==0){
        number = root.val;
        return;
      }
      
      if(root.right != null) traverseTree(root.right);
    }
    
  }