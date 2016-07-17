
public class FalseCriteria implements ColorCriteria
{

    @Override
    public boolean fitsCriteria(int rgb)
    {
        return false;
    }

}
