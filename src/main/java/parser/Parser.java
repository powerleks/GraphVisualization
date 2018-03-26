package parser;

import graph.Graph;

import java.io.IOException;

public interface Parser {

    void findVertices();

    void findEdges();

    Graph parse(String input) throws IOException;
}
