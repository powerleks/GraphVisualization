package parser;

import graph.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Parse Gragh contains in edge list.
 */
public class EdgeListParser implements Parser {
    private Graph G;
    private String content;

    public void findEdges() throws ArrayIndexOutOfBoundsException {
        String[] myData = content.split("\n");
        for (String s: myData) {
            String[] edge = s.split(" ");
            G.addEdge(edge[0], edge[1]);
        }
    }

    public void findVertices() {};

    /**
     * Reads text file, parses it and then creates and returns Graph object.
     *
     * @param input path to graph
     * @return parsed graph
     * @throws IOException
     */
    public Graph parse(String input) throws IOException  {
        Path file = Paths.get(input);
        content = new String(Files.readAllBytes(file));
        G = new Graph();
        findVertices();
        findEdges();
        return G;
    }
}
