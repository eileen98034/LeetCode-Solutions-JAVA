/*
#133 : Medium
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // get out quick
        if (node == null) 
            return null;
        
        Map<Integer,Node> nodeMap = new HashMap<>();
        return cloneGraph(node,nodeMap);
    }
    
    private Node cloneGraph(Node node, Map<Integer,Node> nodeMap) {
        if (nodeMap.containsKey(node.val))
            return nodeMap.get(node.val);
        
        Node newNode = new Node(node.val);
        nodeMap.put(node.val, newNode);
        for (Node neighbor : node.neighbors) 
            newNode.neighbors.add(cloneGraph(neighbor, nodeMap));
        return newNode;
    }

}
