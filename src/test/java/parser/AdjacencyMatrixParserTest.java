package parser;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class AdjacencyMatrixParserTest {
    Graph G;

    @Before
    public void setUp() throws Exception {
        String input = "./input/adjgraph";
        AdjacencyMatrixParser parser = new AdjacencyMatrixParser();

        G = parser.parse(input);
    }

    @Test
    public void testAdjancyMatrixParser() {
        assertEquals(3, G.getVertices().size());
        assertEquals(3, G.getEdges().size());
    }

    @Test
    public void testGraphVertices() {
        int i = 0;
        ArrayList<String> vertices = G.getVertices();
        Collections.sort(vertices);
        for (String v : G.getVertices()) {
            assertEquals(Integer.toString(i), v);
            i += 1;
        }
    }
}