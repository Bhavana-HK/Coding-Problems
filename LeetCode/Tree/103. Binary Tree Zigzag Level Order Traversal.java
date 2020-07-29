// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public void traverse(TreeNode root, List<List<Integer>> list, int height){
        if(root == null)
            return;
        
        if(list.size() - 1 < height)
            list.add(new LinkedList<Integer>());
        
        if(height%2 == 1)
            list.get(height).add(0, root.val);
        else
            list.get(height).add(root.val);
        
        traverse(root.left, list, height + 1);
        traverse(root.right, list, height + 1);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }
}