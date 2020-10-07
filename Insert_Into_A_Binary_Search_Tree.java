/*
#701 : Medium
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. 
It is guaranteed that the new value does not exist in the original BST. Notice that there may exist multiple valid ways for the insertion, as long as 
the tree remains a BST after insertion. You can return any of them.
*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // get out quick
        if (root == null)
            return new TreeNode(val);
        
        // init
        TreeNode curr = root;
        TreeNode parent = null;
        
        // find the place to insert the new node (a leaf)
        while ( curr != null) {
            parent = curr;
            if (val < curr.val) 
                curr = curr.left;
            else
                curr = curr.right;
        }
        
        // decide whether the new node goes left or right
        if (val < parent.val)
            parent.left = new TreeNode(val);
        else
            parent.right = new TreeNode(val);
        
        // print out the tree linearly
        Inorder(root);
        
        // return
        return root;
    }
    
    // print an inorder traversal of the bst
    static void Inorder(TreeNode root) {
        if (root == null) 
            return; 
        else { 
            Inorder(root.left); 
            System.out.print( root.val +" "); 
            Inorder(root.right); 
        } 
    }
