import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class ShapeFinder implements ImageListener
{
    public static final boolean COLOR_SHAPES = true;
    public static final int SHAPE_COLOR = rgb(0, 255, 0);
    private ColorCriteria criteria;

    public ShapeFinder(ColorCriteria criteria)
    {
        this.criteria = criteria;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ImageListener#ImageRecieved(java.awt.Image)
     */
    @Override
    public void ImageRecieved(BufferedImage img)
    {
        boolean[][] visited = new boolean[img.getWidth(null)][img
                                                              .getHeight(null)];
        List<Shape> shapes = new ArrayList<Shape>();
        int maxSize = 0;
        for (int x = 0; x < img.getWidth(null); x++)
        {
            for (int y = 0; y < img.getHeight(null); y++)
            {
                if (!visited[x][y])
                {
                    if (criteria.fitsCriteria(img.getRGB(x, y)))
                    {
                        shapes.add(new Shape(floodFill(visited, img, criteria,
                                x, y)));
                        maxSize = Math.max(maxSize, shapes.get(shapes.size() - 1).getPointList().size());
                    }
                }
            }
        }
        System.out.println("Max: " + maxSize);
        // System.out.println(shapes.toString());
    }

    private static List<Point> floodFill(boolean[][] visited, BufferedImage img,
            ColorCriteria criteria, int x, int y)
            {
        //System.out.println("floodfill call");
        Stack<Point> toVisit = new Stack<Point>();
        List<Point> blob = new ArrayList<Point>();
        toVisit.add(new Point(x, y));
        while (!(toVisit.isEmpty()))
        {
            //System.out.println("not empty");
            Point p = toVisit.pop();
            if (p.getX() > 0 && p.getY() > 0 && p.getX() < visited.length
                    && p.getY() < visited[p.x].length)
            {
                //System.out.println("valid point");
                if (!visited[p.x][p.y])
                {
                    //System.out.println("not visited");
                    visited[p.x][p.y] = true;
                    if (criteria.fitsCriteria(img.getRGB(p.x, p.y)))
                    {
                        //System.out.println("Fits criteria");
                        blob.add(new Point(p.x, p.y));
                        if(COLOR_SHAPES){
                            img.setRGB(p.x, p.y, SHAPE_COLOR);
                        }
                        toVisit.push(new Point(p.x + 1, p.y));
                        toVisit.push(new Point(p.x - 1, p.y));
                        toVisit.push(new Point(p.x, p.y + 1));
                        toVisit.push(new Point(p.x, p.y - 1));
                    }
                }
            }
        }
        //System.out.println("Final size " + blob.size() + " should be " + size);
        return blob;
            }

    public static int rgb(int red, int green, int blue)
    {
        int rgb = red;
        rgb = (rgb << 8) + green;
        rgb = (rgb << 8) + blue;
        return rgb;
    }

    public static int[] rgb(int rgb)
    {
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return new int[]
                { red, green, blue };
    }
}
