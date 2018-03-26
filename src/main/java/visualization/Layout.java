package visualization;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Creates Layout object that can paint white rectangle with specified height and width,
 * draw lines and red circles with radius equals to 7.
 */
public class Layout {
    private BufferedImage img;
    private Graphics2D g2;
    private int radius;

    /**
     * Create class object that contains white rectangle with specified height and width.
     *
     * @param height desired height of a rectangle
     * @param width desired width of a rectangle
     */
    public Layout(int height, int width) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = img.createGraphics();
        g2.setPaint (new Color (255, 255, 255));
        g2.fillRect (0, 0, img.getWidth(), img.getHeight());
        radius = 7;
    }

    /**
     * @param name desired name of the saved image
     * @param format desired image's format
     * @throws IOException
     */
    public void saveImage(String name, String format) throws IOException {
        Files.createDirectories(Paths.get("./output"));
        String outputName = "./output/" + name + "." + format;
        System.out.printf("Graph picture is saved at the path:\n%s\n", outputName);
        File outfile = new File(outputName);
        ImageIO.write(img, format, outfile);
    }

    /**
     * Draw red circle on the rectangle in the square whose lower left angle located in (x, y)
     *
     * @param x
     * @param y
     */
    public void drawCircle(int x, int y){
        g2.setColor(Color.RED);
        g2.fillOval(x,y,14,14);
    }

    public void drawCircle(double x, double y){
        drawCircle((int) x, (int) y);
    }

    /**
     * Draw black segment whose ends are in (x1, y1) and (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void drawLine(int x1, int y1, int x2, int y2){
        g2.setColor(Color.BLACK);
        g2.drawLine(x1+radius, y1+radius, x2+radius, y2+radius);
    }

    public void drawLine(double x1, double y1, double x2, double y2){
        drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    public int getRadius() {
        return this.radius;
    }
}