import java.util.*;
public class CompositeCurve implements Curve
{
  private ArrayList <Curve> list;
  
  public CompositeCurve()
  {
    list = new ArrayList <Curve> ();
  }
  
  public void add(Curve line)
  {
    list.add(line);
  }
  
  public void draw(SketchPad pad)
  {
    for (int i = 0; i < list.size(); i += 1) 
      list.get(i).draw(pad);
  }
  
  public void translate(double tx, double ty)
  {
    for (int i = 0; i < list.size(); i += 1)
      list.get(i).translate(tx, ty);
  }
  
  public void scale(double sx, double sy)
  {
    for (int i = 0; i < list.size(); i += 1)
      list.get(i).scale(sx,sy);
  }
  
  public void rotate(double degrees)
  {
    for (int i = 0; i < list.size(); i += 1)
      list.get(i).rotate(degrees);
  }
  
  public CompositeCurve copy()
  {
    CompositeCurve co = new CompositeCurve ();
    for (int i = 0; i < list.size(); i += 1)
      co.add((list.get(i)).copy());
    return co;
  }
}