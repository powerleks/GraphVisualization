package graph;

public class Edge {
    private Vertex start;
    private Vertex end;

    /**
     * Creates edge assigned to the two vertices
     *
     * @param start first vertex
     * @param end second vertex
     */
    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return vertex from the first end of the edge
     */
    public Vertex getStart() {
        return start;
    }

    /**
     * @return vertex from the second end of the edge
     */
    public Vertex getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Edge)) {
            return false;
        }

        Edge that = (Edge) other;

        return ((this.start.equals(that.start) && this.end.equals(that.end))
                || (this.start.equals(that.end) && this.end.equals(that.start)));
    }
}
