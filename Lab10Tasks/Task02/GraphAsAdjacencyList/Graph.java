import java.util.LinkedList;

public class Graph {

    int numVertices;

    LinkedList<String>[] adjacencyList;
    String[] labels;

    Graph(int numVertices, String[] labels) {
        this.labels =  labels;
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++)
            adjacencyList[i] = new LinkedList<String>();

    }

    //To add a directed edge to graph
    void addDirectedEdge(int v, int w)  {
        //adjacencyList[v].add(w); // Add w to v’s list.
        adjacencyList[v].add(labels[w]);
    }

    //To add undirected edge to graph
    void addUndirectedEdge(int v, int w) {
            /*adjacencyList[v].add(w); 
            adjacencyList[w].add(v); */
        adjacencyList[v].add(labels[w]);
        adjacencyList[w].add(labels[v]);
    }

    void displayGraph(){
        for (int i = 0; i < adjacencyList.length; i++){
            System.out.println(labels[i] + " ----> " + adjacencyList[i]);
        }
        System.out.println();

    }
}