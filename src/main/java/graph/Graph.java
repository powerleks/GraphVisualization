package graph;

import java.util.*;

/**
 * Creates graph
 */
public class Graph {
    private Map<String, Vertex> nodes;

    public Graph() {
        nodes = new HashMap();
    }

    /**
     * @param v String label of the vertex
     * @return vertex of the graph by the label
     */
    private Vertex getVertex(String v) {
        if (!this.nodes.containsKey(v)) {
            addVertex(v);
        }
        return this.nodes.get(v);
    }

    /**
     * Add edge to graph
     *
     * @param from String label of end of the edge
     * @param to String label of another end of the edge
     */
    public void addEdge(String from, String to) {
        Vertex start = getVertex(from);
        Vertex end = getVertex(to);
        Edge e = new Edge(start, end);
        addEdgeToAdjacentVertices(start, end, e);
    }

    /**
     * Adds edge to graph
     *
     * @param start Integer label of end of the edge
     * @param end Integer label of another end of the edge
     */
    public void addEdge(int start, int end) {
        addEdge(Integer.toString(start), Integer.toString(end));
    }

    /**
     * Adds edge to its adjacent vertices
     *
     * @param start one of the adjacent vertices
     * @param end other of the adjacent vertices
     * @param e added edge
     */
    private void addEdgeToAdjacentVertices(Vertex start, Vertex end, Edge e) {
        if (start == end) {
            return;
        }
        if (!start.getConnections().contains(e)) {
            start.addConnections(e);
        }
        if (!end.getConnections().contains(e)) {
            end.addConnections(e);
        }
    }

    /**
     * Adds vertex to the graph with String label
     *
     * @param label String label of the added vertex
     */
    public void addVertex(String label) {
        Vertex v = new Vertex();
        v.setLabel(label);
        nodes.put(label, v);
    }

    /**
     * Adds vertex to the graph with Integer label
     *
     * @param label Integer label of the added vertex
     */
    public void addVertex(int label) {
        addVertex(Integer.toString(label));
    }

    /**
     * @return list of String labels of the graph
     */
    public ArrayList<String> getVertices() {
        ArrayList<String> keyList = new ArrayList(nodes.keySet());
        return keyList;
    }

    /**
     * @return list of edges
     */
    public ArrayList<Edge> getEdges() {
        Set<Edge> edges = new HashSet<>();
        for(Vertex v: nodes.values()) {
            for (Edge incidentEdge : v.getConnections()) {
                edges.add(incidentEdge);
            }
        }
        return new ArrayList<Edge>(edges);
    }
}
