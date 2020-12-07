public class Koch implements Fractal
{
  Koch()
  {
  
  }
  
  public Curve step0()
  {
    return new Line(0,0.5,1,0.5);
  }
   
  public Curve transform(Curve curve)
  {
    CompositeCurve comp = new CompositeCurve();

    curve.translate(0,-0.5);
    curve.scale(1.0/3,1.0/3);

    Curve c1 = curve.copy();
    c1.translate(0,0.5);
    comp.add(c1);

    Curve c2 = c1.copy();
    c2.translate(2.0/3,0);
    comp.add(c2);

    Curve c3 = curve.copy();
    c3.rotate(60);
    c3.translate(1.0/3,0.5);
    comp.add(c3);

    Curve c4 = curve.copy();
    c4.rotate(-60);
    c4.translate(0.5,0.5 + Math.sqrt(3)/6);
    comp.add(c4);
   
    return comp;
  }
}