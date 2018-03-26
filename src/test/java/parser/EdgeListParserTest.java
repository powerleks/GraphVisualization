package parser;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class EdgeListParserTest {
    Graph G;

    @Before
    public void setUp() throws Exception {
        String input = "./input/edgelist";
        EdgeListParser parser = new EdgeListParser();

        G = parser.parse(input);
    }

    @Test
    public void testEdgeListParser() {
        assertEquals(4, G.getVertices().size());
        assertEquals(4, G.getEdges().size());
    }

    @Test
    public void testGraphVertices() {
        int i = 1;
        ArrayList<String> vertices = G.getVertices();
        Collections.sort(vertices);
        for (String v : G.getVertices()) {
            assertEquals(Integer.toString(i), v);
            i += 1;
        }
    }
}