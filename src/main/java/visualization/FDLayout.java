package visualization;

import javax.vecmath.Vector2d;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FDLayout extends Layout {

    private ArrayList<String> vertices;
    private ArrayList<Edge> edges;
    private Map<String, Vector2d> pos;
    private Map<String, Vector2d> disp;
    private int frameWidth;
    private int frameHeight;
    private double k;
    private double t;
    private int iterations;
    private double coolingRate;

    /**
     * Creates FDLayout object that can find optimal positions of the graphs' vertices
     * on the canvas (rectangle) using Force-Directed drawing algorithm.
     *
     * @param g Graph whose vertex positions are searched.
     * @param height desired height of the canvas
     * @param width desired width of the canvas
     */
    public FDLayout(Graph g, int height, int width) {
        super(height, width);
        pos = new HashMap();
        disp = new HashMap();
        vertices = g.getVertices();
        edges = g.getEdges();
        iterations = 100;
        frameWidth = width - 2 * super.getRadius();
        frameHeight = height - 2 * super.getRadius();
        int area = Math.min(frameWidth * frameWidth, frameHeight * frameHeight);
        k = Math.sqrt(area / vertices.size());
        t = frameWidth / 10;
        coolingRate = t / iterations;
    }

    /**
     * Initializes random positions of vertices on the canvas.
     */
    private void initializePositions() {
        for (String v : vertices) {
            double l = Math.random() * frameWidth;
            double r = Math.random() * frameHeight;
            pos.put(v, new Vector2d(l, r));
        }
    }

    /**
     * @return true, if the graph's image is stretched along one axis, and the canvas is stretched along the other.
     */
    private boolean isNeedRotated() {
        double minX = 0.0;
        double minY = 0.0;
        double maxX = 0.0;
        double maxY = 0.0;

        for (String v : vertices) {
            double x = pos.get(v).x;
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);

            double y = pos.get(v).y;
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        if (((maxX - minX) < (maxY - minY)) && (frameHeight < frameWidth)) {
            return true;
        } else if (((maxX - minX) > (maxY - minY)) && (frameHeight > frameWidth)) {
            return true;
        }
        return false;
    }

    /**
     * Swaps x- and y-coordinate of each vertex.
     */
    private void rotate() {
        for (String v : vertices) {
            double x = pos.get(v).x;
            double y = pos.get(v).y;
            pos.put(v, new Vector2d(y, x));
        }
    }

    /**
     * Checks whether vertices are outside the canvas. If so, it shifts so that the vertices fit on the canvas.
     */
    private void normalizePositions() {
        double maxDevX = 0.0;
        double maxDevY = 0.0;
        double maxNegX = 0.0;
        double maxNegY = 0.0;
        for (String v : vertices) {
            double x = pos.get(v).x;

            if (x < 0) {
                maxNegX = Math.min(maxNegX, x);
            } else if (x > frameWidth) {
                maxDevX = Math.max(maxDevX, x - frameWidth);
            }

            double y = pos.get(v).y;

            if (y < 0) {
                maxNegY = Math.min(maxNegY, y);
            } else if (y > frameHeight) {
                maxDevY = Math.max(maxDevY, y - frameHeight);
            }

        }

        for (String v : vertices) {
            pos.get(v).add(new Vector2d(-maxNegX, -maxNegY));
        }

        double scale;
        scale = Math.min((frameWidth / (frameWidth + maxDevX - maxNegX)),
                (frameHeight / (frameHeight + maxDevY - maxNegY)));

        for (String v : vertices) {
            pos.get(v).scale(scale);
        }
    }

    private double repulsiveForce(double d) {
        return k * k / d;
    }

    private double attractiveForce(double d) {
        return d * d / k;
    }

    /**
     * Finds optimal positions of nodes using Fruchterman-Reingold algorithm.
     */
    public void simulation() {
        initializePositions();
        for (int i = 0; i < iterations; ++i) {
            for (String v : vertices) {
                disp.put(v, new Vector2d());
                for (String u : vertices) {
                    if (!v.equals(u)) {
                        Vector2d deltaPos = new Vector2d();
                        deltaPos.sub(pos.get(v), pos.get(u));
                        double length = deltaPos.length();
                        deltaPos.normalize();

                        deltaPos.scale(this.repulsiveForce(length));
                        disp.get(v).add(deltaPos);
                    }
                }
            }

            for (Edge e : edges) {
                String v = e.getStart().getLabel();
                String u = e.getEnd().getLabel();

                Vector2d deltaPos = new Vector2d();
                deltaPos.sub(pos.get(v), pos.get(u));
                double length = deltaPos.length();
                deltaPos.normalize();

                deltaPos.scale(this.attractiveForce(length));

                disp.get(v).sub(deltaPos);
                disp.get(u).add(deltaPos);
            }

            for (String v : vertices) {

                Vector2d displacement = new Vector2d(disp.get(v));
                double length = displacement.length();

                displacement.normalize();
                displacement.scale(Math.min(length, t));
                pos.get(v).add(displacement);
            }
            t -= coolingRate;
        }
        if (isNeedRotated()) {
            rotate();
        }
        normalizePositions();
    }

    /**
     * Draws all vertices and edges on the canvas
     */
    public void draw() {
        for (Edge e : edges) {
            String start = e.getStart().getLabel();
            String end = e.getEnd().getLabel();
            Vector2d v = pos.get(start);
            Vector2d u = pos.get(end);
            super.drawLine(v.x, v.y, u.x, u.y);
        }

        for (Vector2d p : pos.values()) {
            super.drawCircle(p.x, p.y);
        }
    }
}
