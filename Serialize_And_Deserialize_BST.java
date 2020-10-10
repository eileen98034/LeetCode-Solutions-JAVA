/*
449 : Medium
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization 
algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the 
original tree structure.  The encoded string should be as compact as possible.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null){
            return "$";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[]dataStr = data.split(",");
        return deserialize(dataStr, new int[]{0});
    }
    
    private TreeNode deserialize(String[]dataArr, int[]idx){
        if(dataArr[idx[0]].equals("$")){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[idx[0]++]));
        root.left = deserialize(dataArr, idx);
        root.right = deserialize(dataArr, idx);
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
