/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class Rectangle extends ObjectType
{
    private double heightOverWidth;
    private double percentFilled;
    
    
    /**
     * @param num
     * @param heightOverWidth
     * @param percentFilled
     */
    public Rectangle(int num, double heightOverWidth, double percentFilled)
    {
        super(num);
        this.heightOverWidth = heightOverWidth;
        this.percentFilled = percentFilled;
    }


    /* (non-Javadoc)
     * @see ObjectType#percentError(Shape)
     */
    @Override
    public double percentError(Shape shape)
    {
        double hWRatio = (double) shape.getPointArray()[0].length / shape.getPointArray().length;
        double percentErrorRatio = Math.abs(heightOverWidth - hWRatio)/heightOverWidth;
        double realFilled = (double) shape.getPointList().size();
        double percentErrorFilled = Math.abs(percentFilled - realFilled)/percentFilled;
        double meanError = (percentErrorRatio + percentErrorFilled)/2;
        return meanError;
    }

}
