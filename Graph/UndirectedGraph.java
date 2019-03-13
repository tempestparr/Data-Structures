package Graph;

import java.util.*;

public class UndirectedGraph {

    public ArrayList<GraphNode> nodes; // list of all nodes in a graph
    public HashSet<GraphNode> visited; // list of nodes that have been marked 'visited'

    public UndirectedGraph() {
        this.nodes = new ArrayList<>();
        this.visited = new HashSet<>();
    }

    // prints out the breadth-first search of a graph
    public void bfsPrint(GraphNode root) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        visited.add(root); // mark the root visited
        queue.add(root); // add the root to the end of the queue

        while (!queue.isEmpty()) {
            GraphNode r = queue.remove(); // remove the node from the front of the queue

            System.out.println(r.data); // print the node

            // loop through all the node's neighbors
            for (GraphNode n : r.neighbors) {
                // if the neighbor node has not been visited
                if (!visited.contains(n)) {
                    visited.add(n); // mark the neighbor node as visited
                    queue.add(n); // add the neighbor node to the end of the queue
                }
            }
        }
    }

    // returns if there is a route between two nodes using BFS
    public boolean routeBetweenNodes(GraphNode root, GraphNode destination) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode r = queue.remove();
            
            // if the node is the destination node,
            // then there is a route between root and destination
            if (r == destination) {
                return true;
            }

            for (GraphNode n : r.neighbors) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

        return false;
    }

    // prints out the depth-first search of a graph
    public void dfsPrint(GraphNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data); // print the node
        visited.add(root); // mark the node as visited
        
        // loop through all the node's neighbors
        for (GraphNode n : root.neighbors) {
            // if the node has not been visited
            if (!visited.contains(n)) {
                // recursively call dfsPrint on that node
                dfsPrint(n);
            }
        }
    }

    // prints all the nodes of a graph with their neighboring nodes
    public String printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            sb.append(nodes.get(i).data);
            sb.append(": ");
            sb.append(nodes.get(i).getNeighbors());
            sb.append("\n");
        }
        return sb.toString();
    }
}
