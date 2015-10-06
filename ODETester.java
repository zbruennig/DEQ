import java.awt.geom.Point2D;

/**
 * Created by Zachary on 10/6/2015.
 */
public class ODETester
{
    public static void main(String[] args)
    {
        SimpleODE example = new SimpleODE(3,-2,0);
        System.out.println(example.getEquation());
        Point2D.Double[] simpleEx = EulersMethod.simpleODE(0, 0, 0.1, 10, example);
        System.out.println(EulersMethod.pointString(simpleEx));

        System.out.println("\n\nNEW EXAMPLE\n\n");

        ProductODE example2 = new ProductODE(-4,1);
        System.out.println(example2.getEquation());
        Point2D.Double[] productEx = EulersMethod.productODE(0, 0, 0.1, 10, example2);
        System.out.println(EulersMethod.pointString(productEx));
    }
}
