/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
*/

/*
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Queue<Integer> levelQ = new LinkedList<Integer>();
        Queue<Node> nodeQ = new LinkedList<Node>();
        
        if (root != null) {
            nodeQ.offer(root);
            levelQ.offer(1);
        }
        
        while (!nodeQ.isEmpty()) {
            Node temp = nodeQ.poll();
            int level = levelQ.poll();
            
            if (levelQ.isEmpty())
                temp.next = null;
            else if (levelQ.peek() > level) 
                temp.next = null;
            else
                temp.next = nodeQ.peek();
            
            if(temp.left != null) {
                nodeQ.offer(temp.left);
                levelQ.offer(level+1);
            }
            
            if (temp.right != null) {
                nodeQ.offer(temp.right);
                levelQ.offer(level+1);
            }
        }
        
        return root;
        
    }
}
