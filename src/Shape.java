import java.awt.Point;
import java.util.Arrays;
import java.util.List;

/**
 * @author joelmanning
 *
 */
public class Shape
{
    private boolean[][] pointArray;
    private List<Point> pointList;
    private int minX;
    private int minY;

    public Shape(List<Point> points)
    {
        pointList = points;
        pointArray = fromList(points);
    }

    private boolean[][] fromList(List<Point> s)
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
        boolean[][] a = new boolean[maxx - minx + 1][maxy - miny + 1];
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
     * @return the pointList
     */
    public List<Point> getPointList()
    {
        return pointList;
    }

    /**
     * @param pointList
     *            the pointList to set
     */
    public void setPointList(List<Point> pointList)
    {
        this.pointList = pointList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Shape [" + pointList.toString() + Arrays.deepToString(pointArray) + "]";
    }

    /**
     * @return the minX
     */
    public int getMinX()
    {
        return minX;
    }

    /**
     * @param minX the minX to set
     */
    public void setMinX(int minX)
    {
        this.minX = minX;
    }

    /**
     * @return the minY
     */
    public int getMinY()
    {
        return minY;
    }

    /**
     * @param minY the minY to set
     */
    public void setMinY(int minY)
    {
        this.minY = minY;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + minX;
        result = prime * result + minY;
        result = prime * result + Arrays.hashCode(pointArray);
        result = prime * result
                + ((pointList == null) ? 0 : pointList.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shape other = (Shape) obj;
        if (minX != other.minX)
            return false;
        if (minY != other.minY)
            return false;
        if (!Arrays.deepEquals(pointArray, other.pointArray))
            return false;
        if (pointList == null)
        {
            if (other.pointList != null)
                return false;
        }
        else if (!pointList.equals(other.pointList))
            return false;
        return true;
    }
    
    

}
