package Graph;

public class GraphMain {
    public static void main(String[] args) {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");
        GraphNode g = new GraphNode("g");
        
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);
        b.addNeighbor(e);
        c.addNeighbor(g);
//        f.addNeighbor(g);
        
        UndirectedGraph graph = new UndirectedGraph();
        graph.nodes.add(a);
        graph.nodes.add(b);
        graph.nodes.add(c);
        graph.nodes.add(d);
        graph.nodes.add(e);
        graph.nodes.add(f);
        graph.nodes.add(g);
        
        System.out.println(graph.printGraph());
        
        //graph.dfsPrint(a);
        //graph.bfsPrint(a);
        
        System.out.println(graph.routeBetweenNodes(c, e));
        System.out.println(graph.routeBetweenNodes(a, f));
    }
}
