package parser;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class GmlParserTest {
    Graph G;

    @Before
    public void setUp() throws Exception {
        String input = "./input/FD-Sample3.gml";
        GmlParser parser = new GmlParser();

        G = parser.parse(input);
    }

    @Test
    public void testAdjancyMatrixParser() {
        assertEquals(9, G.getVertices().size());
        assertEquals(9, G.getEdges().size());
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