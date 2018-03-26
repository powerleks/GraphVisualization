package parser;

import graph.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Parse Gragh contains in adjacency matrix
 */
public class AdjacencyMatrixParser implements Parser {
    private Graph G;
    private String content;

    public void findEdges() throws ArrayIndexOutOfBoundsException {
        String[] myData = content.split("\n");
        int len = myData.length > 0 ? myData[0].split(" ").length : 0;
        for (int i = 0; i < myData.length; i++) {
            if (len != myData[i].split(" ").length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            G.addVertex(i);
            String[] neighbors = myData[i].split(" ");
            for (int j = i ; j < neighbors.length; j++) {
                if (!neighbors[j].equals("0")) {
                    G.addEdge(i, j);
                }
            }
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
    public Graph parse(String input) throws IOException {
        Path file = Paths.get(input);
        content = new String(Files.readAllBytes(file));
        G = new Graph();
        findVertices();
        findEdges();
        return G;
    }
}
