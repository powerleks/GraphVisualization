package graph;

public class CompleteGraph extends Graph {
    /**
     * Creates the complete graph with n nodes.
     *
     * @param n the number of vertices
     */
    public CompleteGraph(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                super.addEdge(i, j);
            }
        }
        if (n == 1) {
            super.addVertex(0);
        }
    }
}
