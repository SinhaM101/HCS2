public class Coastline implements Fractal
{   
    Coastline()
    {

    }

    public Curve step0()
    {
        return new Line(1,0,0.5,1);
    }

    public Curve transform(Curve curve)
    {
        CompositeCurve Coast = new CompositeCurve();
        Curve a = curve.copy();
        Curve b,c,d;
        a.translate(0,-0.5);
        a.scale(Math.sqrt(2)/4, Math.sqrt(2)/4);
        a.rotate(45);
        b=a.copy();
        b.rotate(-90);
        c = b.copy();
        d = a.copy();
        a.translate(0,0.5);
        b.translate(0.25,0.75);
        c.translate(0.5,0.5);
        d.translate(0.75,0.25);
        Coast.add(a);
        Coast.add(b);
        Coast.add(c);
        Coast.add(d);
        return Coast;
    }
}