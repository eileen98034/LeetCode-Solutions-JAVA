/*
#563 : Easy
Given the root of a binary tree, return the sum of every tree node's tilt.
The tilt of a tree node is the absolute difference between the sum of all 
left subtree node values and all right subtree node values. If a node does 
not have a left child, then the sum of the left subtree node values is treated 
as 0. The rule is similar if there the node does not have a right child.
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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tilt = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if ((node.left == null || map.containsKey(node.left)) &&
                (node.right == null || map.containsKey(node.right))) {
                stack.pop();
                int left = map.containsKey(node.left) ? map.get(node.left) : 0;
                int right = map.containsKey(node.right) ? map.get(node.right) : 0;
                tilt += Math.abs(left - right);
                map.put(node, left + right + node.val);
            } else {
                if (node.left != null && !map.containsKey(node.left)) {
                    stack.push(node.left); 
                }
                
                if (node.right != null && !map.containsKey(node.right)) {
                    stack.push(node.right);
                }      
            }
        }
        return tilt;
    }
}
