public class Line implements Curve
{
  public double x;
  public double y;
  public double z;
  public double w;
  
  public Line(double x1, double y1, double x2, double y2)
  {
    x = x1;
    y = y1;
    z = x2;
    w = y2;
  }
  
  public void draw(SketchPad pad)
  {
    pad.drawLine(x,y,z,w);
  }
  
  public void translate(double tx, double ty)
  {
    x += tx; 
    y += ty;
    z += tx;
    w += ty;
  }
  
  public void scale(double sx, double sy)
  {
    x *= sx;
    y *= sy;
    z *= sx;
    w *= sy;
  }
  
  public void rotate(double degrees)
  {
    double cx = x;
    double cy = y;
    double cz = z;
    double cw = w;

      x = cx*Math.cos(Math.toRadians(degrees)) - cy*Math.sin(Math.toRadians(degrees));
      y = cx*Math.sin(Math.toRadians(degrees)) + cy*Math.cos(Math.toRadians(degrees));
      z = cz*Math.cos(Math.toRadians(degrees)) - cw*Math.sin(Math.toRadians(degrees));
      w = cz*Math.sin(Math.toRadians(degrees)) + cw*Math.cos(Math.toRadians(degrees));
  }
  
  public Line copy()
  {
    return new Line (x,y,z,w);
  }
  
}