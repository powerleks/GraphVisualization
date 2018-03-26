package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates vertex. It contains string label and list of incidents edges.
 */
public class Vertex {
    private String label;
    private List<Edge> connections;

    public Vertex() {
        connections = new ArrayList<>();
    }

    /**
     * @return label of the vertex
     */
    public String getLabel() {
        return label;
    }

    /**
     * Assign label of the vertex
     *
     * @param label new desired label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return list of incident edges
     */
    public List<Edge> getConnections() {
        return connections;
    }

    /**
     * add new incident edge to the vertex
     *
     * @param e new edge
     */
    public void addConnections(Edge e) {
        this.connections.add(e);
    }
}
