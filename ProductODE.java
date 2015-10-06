/**
 * Created by Zachary on 10/6/2015.
 */
public class ProductODE implements ODE
{
    private double a;
    private double b;

    public ProductODE(double a, double b) // in form y' = axy + b
    {
        this.a=a;
        this.b=b;
    }

    public double getA() {return a;}
    public double getB() {return b;}

    @Override
    public String getEquation()
    {
        String output = "y' = "+a+"xy ";
        if(b!=0)
            output+="+ "+b;

        return output;
    }
}
