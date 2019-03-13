package Graph;

import java.util.HashSet;

public class GraphNode {
    HashSet<GraphNode> neighbors; // list of a node's neighbors
    String data;
    
    GraphNode(String data) {
        this.data = data;
        this.neighbors = new HashSet<>();
    }
    
    // add a node to this node's list of neighbors
    public void addNeighbor(GraphNode node) {
        // add the node as a neighbor of this.node
        this.neighbors.add(node);
        // add this.node as a neighbor of the node
        // since this is an undirected graph
        node.neighbors.add(this);
    }
    
    // return a String representation of a node's neighbors
    public String getNeighbors() {
        StringBuilder sb = new StringBuilder();
        for (GraphNode n: neighbors) {
            sb.append(n.data);
            sb.append(" ");
        }
        return sb.toString();
    }
}
