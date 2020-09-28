/*
#112 Path Sum: Easy
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        Stack<TreeNode> nodeStk = new Stack<>();
        TreeNode temp = null; 
        
        while (root != null || !nodeStk.isEmpty()) {
            while(root != null) {
                nodeStk.push(root);
                sum -= root.val; // subtract node values from sum going down the path
                temp = root;
                root = root.left;
            }

            // evaluate
            root = nodeStk.peek();
            if ((root.left==null && root.right==null) && sum == 0)
                return true;
            if (root.right != null && root.right != temp)
                root = root.right;
            else {
                sum += root.val;
                temp = nodeStk.pop();
                root = null;
            }
        }
        return false;
    }
}
