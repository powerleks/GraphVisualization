package parser;

import graph.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse Gragh contains in a file the gml format.
 */
public class GmlParser implements Parser {
    private Graph G;
    private String content;

    public void findVertices() {
        String pattern = "node\\s+\\[\\s+\\w+\\s+(\\d+)\\s+\\w+\\s+\"(\\w*)\"\\s+\\]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        while(m.find()) {
            int id = Integer.parseInt(m.group(1));
            String label = m.group(2);
            if (label.equals("")) {
                label = Integer.toString(id);
            }
            G.addVertex(label);
        }
    }

    public void findEdges() {
        String pattern = "edge\\s+\\[\\s+\\w+\\s+(\\d+)\\s+\\w+\\s+(\\d*)\\s+\\]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        while(m.find()) {
            int source = Integer.parseInt(m.group(1));
            int target = Integer.parseInt(m.group(2));

            G.addEdge(source, target);
        }
    }

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
