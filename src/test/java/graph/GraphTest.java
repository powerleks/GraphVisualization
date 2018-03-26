package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

//        Vertex v1 = new Vertex("1");
//        Vertex v2 = new Vertex("2");
//        Vertex v3 = new Vertex("3");
//        Vertex v4 = new Vertex("4");
//        ArrayList<Edge> expected = new ArrayList<>(Arrays.asList(new Edge(v1, v2), new Edge(v2, v3), new Edge(v3, v4)));
//        ArrayList<Edge> actual = G.getEdges();
//        for (int i = 0; i < expected.size(); i++) {
//            System.out.printf("%s %s\n", expected.get(i).getStart().getLabel(), expected.get(i).getEnd().getLabel());
//            System.out.printf("%s %s\n", actual.get(i).getStart().getLabel(), actual.get(i).getEnd().getLabel());
//            assertTrue(expected.get(i) == actual.get(i));
//        }
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