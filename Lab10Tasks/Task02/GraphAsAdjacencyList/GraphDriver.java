
public class GraphDriver {
    // Driver program to test methods of graph class
    public static void main(String[] args) {

        String[] labels = new String[]{"A", "B", "C", "D", "E"};


        // Total 5 vertices in graph
        Graph graph1 = new Graph(5, labels);

        graph1.addDirectedEdge(1, 0);
        graph1.addDirectedEdge(0, 2);
        graph1.addDirectedEdge(2, 1);
        graph1.addDirectedEdge(0, 3);
        graph1.addDirectedEdge(1, 4);

        System.out.println("The directed graph is:  ");
        graph1.displayGraph();

        Graph graph2 = new Graph(5, labels);

        graph2.addUndirectedEdge(1, 0);
        graph2.addUndirectedEdge(0, 2);
        graph2.addUndirectedEdge(2, 1);
        graph2.addUndirectedEdge(0, 3);
        graph2.addUndirectedEdge(1, 4);

        System.out.println("The undirected graph is:  ");
        graph2.displayGraph();

    }
}