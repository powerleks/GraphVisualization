import graph.*;
import parser.AdjacencyMatrixParser;
import parser.EdgeListParser;
import parser.GmlParser;
import parser.Parser;
import visualization.FDLayout;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static boolean checkParametrs(String input, String inputFormat, String outputFormat, String type, int n) {
        if (input.equals("undefined") && type.equals("undefined")) {
            System.out.println("Path to graph was not entered!");
            return false;
        }
        List<String> formatNames = Arrays.asList(ImageIO.getWriterFormatNames());
        if (!formatNames.contains(outputFormat)) {
            System.out.println("The output format is not supported!");
            return false;
        }
        List<String> inputFormats = Arrays.asList("gml", "edgelist", "adj");
        if (!inputFormats.contains(inputFormat)) {
            System.out.println("The input format is not supported!");
            return false;
        }
        List<String> types = Arrays.asList("star", "cycle", "path", "complete", "wheel");
        if (!type.equals("undefined") && !types.contains(type)) {
            System.out.println("Wrong type of a graph is entered!");
            return false;
        }
        if (!type.equals("undefined") && n <= 0) {
            System.out.println("The number of vertices of generated graph have to be positive!");
            return false;
        }
        return true;
    }

    private static void printHelpText() {
        String s = String.join("\n"
                , "Reading a graph:"
                , "  -i <path to graph file>"
                , "  -if <graph format. Valid options: \"gml\", \"edgeist\", \"adj\" (adjacency matrix). " +
                        "Optional parameter, default value: \"gml\">"
                , ""
                , "Generating a graph:"
                , "  -t <type of generated graph. Valid options: \"star\", \"path\", \"cycle\", " +
                        "\"wheel\", \"complete\">"
                , "  -n <number of vertices in generated graph>"
                , ""
                , "Saving a picture:"
                , "  -o <name of output image. The image is saved in the folder \"output\" " +
                        "(the folder is created if it does not exist).Optional parameter, default value: \"saved\">"
                , "  -of <format of saving image. Valid options: jpg, bmp, gif, png, wbmp, jpeg. " +
                        "Optional parameter, default value: \"png\">"
                , "  -h <height of saving image. Optional parameter, default value: 480>"
                , "  -w <width of saving image. Optional parameter, default value: 640>"
        );
        System.out.println(s);
    }

    public static void main(String[] args) {
        String input = "undefined";
        String inputFormat = "gml";
        String output = "saved";
        String outputFormat = "png";
        String prev_arg = "undefined";
        String type = "undefined";
        int numberOfVertices = -1;
        int height = 480;
        int width = 640;
        for (String arg : args) {
            if (arg.equals("-i") || arg.equals("-o") || arg.equals("-of") ||
                    arg.equals("-if") || arg.equals("-h") || arg.equals("-w") ||
                    arg.equals("-t") || arg.equals("-n")) {
                prev_arg = arg;
            } else if (arg.equals("--help")) {
                printHelpText();
                return;
            } else {
                switch (prev_arg) {
                    case "-i": input = arg;
                        break;
                    case "-if": inputFormat = arg;
                        break;
                    case "-o": output = arg;
                        break;
                    case "-of": outputFormat = arg;
                        break;
                    case "-h": height = Integer.parseInt(arg);
                        break;
                    case "-w": width = Integer.parseInt(arg);
                        break;
                    case "-t": type = arg;
                        break;
                    case "-n": numberOfVertices = Integer.parseInt(arg);
                        break;
                }
            }
        }
        if (!checkParametrs(input, inputFormat, outputFormat, type, numberOfVertices)) {
            return;
        }
        Parser parser;
        Graph G;
        if (!input.equals("undefined")) {
            switch (inputFormat) {
                case "gml":
                    parser = new GmlParser();
                    break;
                case "edgelist":
                    parser = new EdgeListParser();
                    break;
                case "adj":
                    parser = new AdjacencyMatrixParser();
                    break;
                default:
                    parser = new GmlParser();
                    break;
            }
            try {
                G = parser.parse(input);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error while parsing graph! The graph is written incorrectly.");
                return;
            } catch (IOException e) {
                System.err.println("Error while opening file! Please, check the path to the file!");
                return;
            }
        } else {
            switch (type) {
                case "star":
                    G = new StarGraph(numberOfVertices);
                    break;
                case "cycle":
                    G = new CycleGraph(numberOfVertices);
                    break;
                case "path":
                    G = new PathGraph(numberOfVertices);
                    break;
                case "complete":
                    G = new CompleteGraph(numberOfVertices);
                    break;
                case "wheel":
                    G = new WheelGraph(numberOfVertices);
                    break;
                default:
                    G = new Graph();
                    break;
            }
        }
        if (G.getVertices().size() == 0) {
            System.out.println("The graph is empty!");
            return;
        }
        FDLayout layout = new FDLayout(G, height, width);
        layout.simulation();
        layout.draw();
        try {
            layout.saveImage(output, outputFormat);
        } catch (IOException e) {
            System.err.println("Error while saving picture!");
            return;
        }
    }
}
