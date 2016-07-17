import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        boolean[][] visited = new boolean[img.getWidth(null)][img.getHeight(null)];
        Stack<Point> toVisit = new Stack<Point>();
        List<Shape> shapes = new ArrayList<Shape>();
        for (int x = 0; x < img.getWidth(null); x++)
        {
            for (int y = 0; y < img.getHeight(null); y++)
            {
                if (!visited[x][y])
                {
                    if (criteria.fitsCriteria(img.getRGB(x, y)))
                    {
                        shapes.add(new Shape(floodFill(visited, img, criteria, x, y)));
                    }
                }
            }
        }
    }

    private static Set<Point> floodFill(boolean[][] visited, BufferedImage img,
            ColorCriteria criteria, int x, int y)
    {
        Stack<Point> toVisit = new Stack<Point>();
        // FloodBlob blob = new FloodBlob();
        HashSet<Point> blob = new HashSet<Point>();
        toVisit.add(new Point(x, y));
        while (!(toVisit.isEmpty()))
        {
            Point p = toVisit.pop();
            if (!(visited[p.x][p.y]))
            {
                visited[p.x][p.y] = true;
                if (criteria.fitsCriteria(img.getRGB(p.x, p.y)))
                {
                    blob.add(new Point(x, y));
                    toVisit.push(new Point(x + 1, y));
                    toVisit.push(new Point(x - 1, y));
                    toVisit.push(new Point(x, y + 1));
                    toVisit.push(new Point(x, y - 1));
                }
            }
        }
        return blob;
    }
}
