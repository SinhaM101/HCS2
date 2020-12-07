public class Lab
{

  public static Curve generateFractal(Fractal fractal, int step)
  {
    Curve fra = fractal.step0();
    for (int i = 0; i < step; i += 1)
      fra = fractal.transform(fra);
    return fra;
  }

  public static void main(String[] args)
   {
    SketchPad pad = new SketchPad();
  
    CompositeCurve comp = new CompositeCurve();

    Curve line = new Line(0,0.5,1,0.5);
    line.scale(1.0/4,1);
  line.translate(0, -.5);
    
    Curve c1 = line.copy();
    c1.rotate(45);
    c1.translate(0,1.0/2);
    comp.add(c1);

    Curve c2 = line.copy();
    c2.rotate(-45);
    c2.translate(1.0/5,1.0/2 + 1.0/5);
    comp.add(c2);

    comp.draw(pad);
  }

  
}