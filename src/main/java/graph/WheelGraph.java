package graph;

public class WheelGraph extends Graph {
    /**
     * Creates the wheel graph: a single hub node connected to each node of the (n-1)-node cycle graph.
     *
     * @param n the number of vertices
     */
    public WheelGraph(int n) {
        for (int i = 2; i < n; i++) {
            super.addEdge(0, i);
            super.addEdge(i-1, i);
        }
        if (n > 1) {
            super.addEdge(n - 1, 1);
            super.addEdge(0, 1);
        } else if (n == 1) {
            super.addVertex(0);
        }
    }
}
