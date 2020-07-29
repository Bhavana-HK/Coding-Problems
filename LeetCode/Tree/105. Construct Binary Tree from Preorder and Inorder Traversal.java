// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    
    public TreeNode traverse(int[] preorder, int[] inorder, int preStart, int inStart, int n){
        if(n<=0)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        
        int end = inStart;
        while(inorder[end] != preorder[preStart])
            end++;
        int numLeft = end - inStart;
        int numRight = n - numLeft - 1;
        
        node.left = traverse(preorder, inorder, preStart + 1, inStart ,numLeft);
        node.right = traverse(preorder, inorder, preStart + 1 + numLeft, end + 1, numRight);
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, inorder, 0, 0, preorder.length);
    }
}