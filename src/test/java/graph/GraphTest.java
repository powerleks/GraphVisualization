package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    Graph G;

    @Before
    public void setUp() throws Exception {
        G = new Graph();
    }

    @Test
    public void addEdge() {
        G.addEdge("1", "2");
        G.addEdge("2", "1");
        assertTrue(G.getEdges().size() == 1);


        G.addEdge("2", "3");
        G.addEdge("3", "4");
        assertTrue(G.getEdges().size() == 3);
    }

    @Test
    public void addEdgeInt() {
        G.addEdge("1", "2");
        G.addEdge(1, 2);
        assertTrue(G.getEdges().size() == 1);
    }

    @Test
    public void addVertex() {
        G.addVertex("1");
        G.addVertex("2");
        G.addVertex("3");
        assertTrue(G.getVertices().size() == 3);
    }

    @Test
    public void addVertexInt() {
        G.addVertex(1);
        G.addVertex(2);
        G.addVertex(3);
        assertTrue(G.getVertices().size() == 3);
    }
}