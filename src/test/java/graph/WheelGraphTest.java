package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class WheelGraphTest {
    WheelGraph G;

    @Test
    public void testGraphSizes() {
        for (int i = 1; i < 10; i++) {
            G = new WheelGraph(i);
            assertTrue(G.getVertices().size() == i);
            if (i == 2) {
                assertTrue(G.getEdges().size() == 1);
            } else if (i == 3) {
                assertTrue(G.getEdges().size() == 3);
            } else {
                assertTrue(G.getEdges().size() == (i - 1) * 2);
            }
        }
    }

//    @Test
//    public void testVertexDegree() {
//        G = new WheelGraph(5);
//        for (int i = 1; i < 5; i++) {
//            assertTrue(G.get);
//        }
//    }
}