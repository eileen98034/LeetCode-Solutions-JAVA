/*
#938 : Easy
Given the root node of a binary search tree, return the sum of values of 
all nodes with a value in the range [low, high].
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        int sum = 0;
        Stack<TreeNode> nodeStk = new Stack<>();
        nodeStk.push(root);
        
        while (!nodeStk.isEmpty()) {
            TreeNode temp = nodeStk.pop();
            if (temp.val >= low && temp.val <= high) 
                sum += temp.val;
            
            if (temp.left != null)
                nodeStk.push(temp.left);
            
            if (temp.right != null)
                nodeStk.push(temp.right);
        }
        
        return sum;
    }
}
