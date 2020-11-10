/*
#1026 : Medium
Given the root of a binary tree, find the maximum value V for which there exist different 
nodes A and B where V = |A.val - B.val| and A is an ancestor of B.  A node A is an ancestor 
of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
*/
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
    int maxDiff = 0;
    
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        
        dfs(root,root.val,root.val);
        return maxDiff;
    }
    
    // dfs
    private void dfs (TreeNode tn, int minVal, int maxVal) {
        if (tn == null)
            return;
        
        minVal = Math.min(minVal,tn.val);
        maxVal = Math.max(maxVal,tn.val);
        maxDiff = Math.max(maxDiff,maxVal-minVal);
        
        dfs(tn.left,minVal,maxVal);
        dfs(tn.right,minVal,maxVal);
    }
}
