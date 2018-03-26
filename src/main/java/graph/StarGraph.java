package graph;

public class StarGraph extends Graph {
    /**
     * Creates the Star graph with n nodes: one center node, connected to (n-1) outer nodes.
     *
     * @param n the number of vertices
     */
    public StarGraph(int n) {
        for (int i = 1; i < n; i++) {
            super.addEdge(0, i);
        }
        if (n == 1) {
            super.addVertex(0);
        }
    }
}
