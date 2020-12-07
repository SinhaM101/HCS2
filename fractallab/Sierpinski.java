public class Sierpinski implements Fractal
{
  Sierpinski()
  {
  
  }
  
  public Curve step0()
  {
    return new Triangle (0,0,0.5,1,1,0);
  }
   
  public Curve transform(Curve curve)
  {
    CompositeCurve com = new CompositeCurve();
    Curve a = curve.copy();
    a.scale(.5,.5);
    
    Curve b = curve.copy();
    b.scale(.5,.5);
    b.translate(.5,0);
    
    Curve c = curve.copy();
    c.scale(.5,.5);
    c.translate(.25,.5);
    
    com.add(a);
    com.add(b);
    com.add(c);
    
    return com;
  }
}