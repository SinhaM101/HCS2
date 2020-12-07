public class Coastline implements Fractal
{
    Coastline ()
    {

    }

    public Curve step0()
    {
        return new Line(0,0.5,1,0.5);
        
    }
   
    public Curve transform(Curve curve)
    {
        CompositeCurve comp = new CompositeCurve();

        curve.translate(0, -.5);
        curve.scale(.25,.25);


        return null;
    }
}
