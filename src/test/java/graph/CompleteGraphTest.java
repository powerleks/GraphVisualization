package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompleteGraphTest {
    CompleteGraph G;

    @Test
    public void testGraphSizes() {
        for (int i = 1; i < 10; i++) {
            G = new CompleteGraph(i);
            assertEquals(i, G.getVertices().size());
            if (i < 3) {
                assertEquals(i - 1, G.getEdges().size());
            } else {
                assertEquals(i * (i - 1) / 2, G.getEdges().size());
            }
        }
    }
}