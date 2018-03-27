# Graph Visualization

## Problem statement
The goal of the project is to create visualization system of graphs. Project supports simple undirected graphs without loops and self-edges. 
Graph can be readed from external text files or generated. Graphs in the text files can be written in one of the following formats: gml, edge list and adjacency matrix.
Possible types of generated graphs:

 - Star
 - Path
 - Cycle
 - Wheel
 - Complate

Positions os graph nodes are obtained by Force-Directed algorithm (Fruchterman-Reingold). The obtained graph saved in external image file.

## Building
The project can be compiled using maven:

```sh
$ mvn package
$ java -cp target/GraphVisualization-1.0-SNAPSHOT.jar Main -i ./input/FD-Sample2.gml
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
