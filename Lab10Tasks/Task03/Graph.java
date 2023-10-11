import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;

    public Graph(List<Edge> Edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge Edge: Edges){
            int src = Edge.source;
            int dest = Edge.dest;

            adjList.get(src).add(dest);
        }
    }

    public boolean isReachable(int src, int dest){
        boolean[] visited = new boolean[numVertices];
        return isReachable(src, dest, visited);
    }

    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    private boolean isReachable(int src, int dest, boolean[] visited)
    {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src-1] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == dest) {
                return true;
            }
            for(int v:adjList.get(curr)) {
                if(visited[v] == false) {
                    queue.add(v);
                    visited[v-1] = true;
                }
            }
        }

        return false;


    }
}