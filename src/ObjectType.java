/**
 * 
 */

/**
 * @author joelmanning
 *
 */
public abstract class ObjectType
{
    private int numOfType;
    
    public abstract double percentError(Shape shape);
    
    public ObjectType(int num){
        numOfType = num;
    }

    /**
     * @return the numOfType
     */
    public int getNumOfType()
    {
        return numOfType;
    }

    /**
     * @param numOfType the numOfType to set
     */
    public void setNumOfType(int numOfType)
    {
        this.numOfType = numOfType;
    }
    
}
