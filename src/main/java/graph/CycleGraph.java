package graph;

public class CycleGraph extends Graph {
    /**
     * Create the cycle graph C_n over n nodes.
     *
     * @param n the number of vertices
     */
    public CycleGraph(int n) {
        for (int i = 1; i < n; i++) {
            super.addEdge(i-1, i);
        }
        if (n > 1) {
            super.addEdge(n - 1, 0);
        } else {
            super.addVertex(0);
        }
    }
}
