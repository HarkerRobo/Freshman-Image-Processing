import java.awt.Point;
import java.util.Set;

/**
 * @author joelmanning
 *
 */
public class Shape
{
    private boolean[][] pointArray;
    private Set<Point> pointSet;

    public Shape(Set<Point> points)
    {
        pointSet = points;
        pointArray = fromSet(points);
    }

    private boolean[][] fromSet(Set<Point> s)
    {
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        for (Point p : s)
        {
            minx = Math.min(minx, p.x);
            miny = Math.min(miny, p.y);
            maxx = Math.max(maxx, p.x);
            maxy = Math.max(maxy, p.y);
        }
        boolean[][] a = new boolean[maxx - minx][maxy - miny];
        for (Point p : s)
        {
            a[p.x - minx][p.y - miny] = true;
        }
        return a;
    }

    /**
     * @return the pointArray
     */
    public boolean[][] getPointArray()
    {
        return pointArray;
    }

    /**
     * @param pointArray
     *            the pointArray to set
     */
    public void setPointArray(boolean[][] pointArray)
    {
        this.pointArray = pointArray;
    }

    /**
     * @return the pointSet
     */
    public Set<Point> getPointSet()
    {
        return pointSet;
    }

    /**
     * @param pointSet
     *            the pointSet to set
     */
    public void setPointSet(Set<Point> pointSet)
    {
        this.pointSet = pointSet;
    }

}
