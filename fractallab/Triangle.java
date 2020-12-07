public class Triangle implements Curve
{
  private double x;
  private double y;
  private double z;
  private double a;
  private double b;
  private double c;
  
  public Triangle (double x1, double y1, double x2, double y2, double x3, double y3)
  {
    x = x1;
    y = y1;
    z = x2;
    a = y2;
    b = x3;
    c = y3;
  }
  
  public void draw(SketchPad pad)
  {
    pad.drawLine(x,y,z,a);
    pad.drawLine(z,a,b,c);
    pad.drawLine(b,c,x,y);
  }
  
  public void translate(double tx, double ty)
  {
    x += tx; 
    y += ty;
    z += tx;
    a += ty;
    b += tx;
    c += ty;
  }
  
  public void scale(double sx, double sy)
  {
    x *= sx;
    y *= sy;
    z *= sx;
    a *= sy;
    b *= sx;
    c *= sy;
  }
  
  public void rotate(double degrees)
  {
    double cx = x;
    double cy = y;
    double cz = z;
    double ca = a;
    double cb = b;
    double cc = c;

      x = cx*Math.cos(Math.toRadians(degrees)) - cy*Math.sin(Math.toRadians(degrees));
      y = cx*Math.sin(Math.toRadians(degrees)) + cy*Math.cos(Math.toRadians(degrees));
      z = cz*Math.cos(Math.toRadians(degrees)) - ca*Math.sin(Math.toRadians(degrees));
      a = cz*Math.sin(Math.toRadians(degrees)) + ca*Math.cos(Math.toRadians(degrees));
      b = cb*Math.cos(Math.toRadians(degrees)) - cc*Math.sin(Math.toRadians(degrees));
      c = cb*Math.sin(Math.toRadians(degrees)) + cc*Math.cos(Math.toRadians(degrees));
  }
  
  public Triangle copy()
  {
    return new Triangle (x,y,z,a,b,c);
  }
}