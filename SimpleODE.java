/**
 * Created by Zachary on 10/6/2015.
 */
public class SimpleODE implements ODE
{
    private double a;
    private double b;
    private double c;

    public SimpleODE(double a, double b, double c) // in form of y' = ax + by + c
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public String getEquation()
    {
        String output = "y' = ";
        if(a!=0)
            output+=a+"x + ";
        if(b!=0)
            output+=b+"y + ";
        if(c!=0)
            output+=c;
        else
            output=output.substring(0,output.length()-2);

        return output;
    }

    public double getA() {return a;}

    public double getB() {return b;}

    public double getC() {return c;}
}
