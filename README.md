# Graph Visualization

## Building
The project can be compiled using maven:

```sh
$ mvn compile
```

## Usage
You can work with the project with the help of the Main class, submitting command-line arguments to the input.

Reading a graph:
  - **-i** \<path to graph file>
  - **-if** <graph format. *Valid options*: "gml" , "edgeist", "adj" (adjacency matrix). Optional parameter, default value: "gml">

Generating a graph:
  - **-t** <type of generated graph. *Valid options*: "star", "path", "cycle", "wheel", "complete">
  - **-n** \<number of vertices in generated graph>

Saving a picture:
  - **-o** \<name of output image. The image is saved in the folder "output" (the folder is created if it does not exist). Optional parameter, default value: "saved">
  - **-of** \<format of saving image. *Valid options*: jpg, bmp, gif, png, wbmp, jpeg. Optional parameter, default value: "png">
  - **-h** \<height of saving image. Optional parameter, default value: 480>
  - **-w** \<width of saving image. Optional parameter, default value: 640>

The simultaneous use of graph reading and graph generation parameters is unacceptable. If you simultaneously enter the parameters for reading and generating the graph, only the graph reading options will be executed.

## Examples
You can see examples of graphs visualization in the folder "output". In the folder "input" there are several examples of graphs data in different formats (gml, edge list and adjacency matrix).