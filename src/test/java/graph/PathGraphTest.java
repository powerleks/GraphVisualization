package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathGraphTest {
    PathGraph G;

    @Test
    public void testGraphSizes() {
        for (int i = 1; i < 10; i++) {
            G = new PathGraph(i);
            assertTrue(G.getVertices().size() == i);
            assertTrue(G.getEdges().size() == (i - 1));
        }
    }
}