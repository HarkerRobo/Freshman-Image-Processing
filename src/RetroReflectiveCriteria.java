/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public class RetroReflectiveCriteria implements ColorCriteria
{

    /*
     * (non-Javadoc)
     * 
     * @see ColorCriteria#fitsCriteria(int)
     */
    @Override
    public boolean fitsCriteria(int rgb)
    {
        int[] rgbArray = getRGBFromPixel(rgb);
        // random criteria from earlier program serving as a placeholder
        // TODO update this criteria
        return rgbArray[1] > 249;
    }

    /**
     * returns an array {r, g, b} from the integer value
     */
    public static int[] getRGBFromPixel(int pixel)
    {
        int b = pixel & 0xFF;
        int g = (pixel >> 8) & 0xFF;
        int r = (pixel >> 16) & 0xFF;
        return new int[]
        { r, g, b };
    }
}
