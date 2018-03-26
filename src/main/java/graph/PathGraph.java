package graph;

public class PathGraph extends Graph {
    /**
     * Creates the Path graph of n nodes linearly connected by n-1 edges.
     *
     * @param n the number of vertices
     */
    public PathGraph(int n) {
        for (int i = 1; i < n; i++) {
            super.addEdge(i-1, i);
        }
        if (n == 1) {
            super.addVertex(0);
        }
    }
}
