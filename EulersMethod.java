import java.awt.geom.Point2D;

/**
 * Created by Zachary on 10/6/2015.
 */
public class EulersMethod
{
    public static Point2D.Double[] simpleODE(double x0, double y0, double dx, int iterations, SimpleODE equation)
            //x0 and y0 are initial value conditions, dx is the change in x(step), iterations is the number of times to loop
    {
        Point2D.Double initial = new Point2D.Double(x0,y0);
        return simpleODE(initial, dx, iterations, equation);
    }

    public static Point2D.Double[] simpleODE(Point2D.Double initial, double dx, int iterations, SimpleODE equation)
    {
        Point2D.Double[] points = new Point2D.Double[iterations+1];
        points[0] = initial;

        double yPrev = initial.getY();
        double xPrev = initial.getX();

        for(int i=1; i<=iterations; i++)
        {
            double slope = equation.getA()*xPrev + equation.getB()*yPrev + equation.getC(); // solves for y'
            double dy = slope*dx; // change in y = slope*distance

            yPrev+=dy;
            xPrev+=dx;
            points[i] = new Point2D.Double(xPrev,yPrev);
        }

        return points;
    }

    public static Point2D.Double[] productODE(double x0, double y0, double dx, int iterations, ProductODE equation)
    //x0 and y0 are initial value conditions, step is the change in x (step), iterations is the number of times to loop
    {
        Point2D.Double initial = new Point2D.Double(x0,y0);
        return productODE(initial, dx, iterations, equation);
    }

    public static Point2D.Double[] productODE(Point2D.Double initial, double dx, int iterations, ProductODE equation)
    {
        Point2D.Double[] points = new Point2D.Double[iterations+1];
        points[0] = initial;

        double yPrev = initial.getY();
        double xPrev = initial.getX();

        for(int i=1; i<=iterations; i++)
        {
            double slope = equation.getA()*xPrev*yPrev + equation.getB(); // solves for y'
            double dy = slope*dx; // change in y = slope*distance

            yPrev+=dy;
            xPrev+=dx;
            points[i] = new Point2D.Double(xPrev,yPrev);
        }

        return points;
    }

    public static String pointString(Point2D.Double[] points) // makes a Point2D.Double array readable
    {
        String output = "";
        for(int i=0; i<points.length; i++)
        {
            String xRounded = String.format("%.2g",points[i].getX());
            String yRounded = String.format("%.6g",points[i].getY());
            output+="("+xRounded+", "+yRounded+")\n";
            //NON-ROUNDING APPROACH:
            //output+="("+points[i].getX()+", "+points[i].getY()+")\n";
        }
        return output;
    }
}
