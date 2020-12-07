//Interface with this!
//Your fractals are so full of themselves!

import java.util.*;

public class FractalMonster extends SketchPad implements Fractal
{
  public static void main(String[] args)
  {
    FractalMonster monster = new FractalMonster();
    
    System.out.println("Testing Line");
    Curve line = new Line(0.1, 0.2, 0.3, 0.4);
    line.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(0.1, 0.2, 0.3, 0.4);
    monster.clear();
    System.out.println(" Passed Line");
    
    System.out.println("Testing Triangle");
    Curve tri = new Triangle(0.5, 0.6, 0.7, 0.8, 0.9, 0.0);
    tri.draw(monster);
    monster.testNumLines(3);
    monster.testHasLine(0.5, 0.6, 0.7, 0.8);
    monster.testHasLine(0.5, 0.6, 0.9, 0.0);
    monster.testHasLine(0.7, 0.8, 0.9, 0.0);
    monster.clear();
    System.out.println(" Passed Triangle");
    
    System.out.println("Testing CompositeCurve");
    CompositeCurve comp = new CompositeCurve();
    Curve c = comp;
    comp.add(line);
    comp.add(tri);
    comp.draw(monster);
    monster.testNumLines(4);
    monster.testHasLine(0.1, 0.2, 0.3, 0.4);
    monster.testHasLine(0.5, 0.6, 0.7, 0.8);
    monster.testHasLine(0.5, 0.6, 0.9, 0.0);
    monster.testHasLine(0.7, 0.8, 0.9, 0.0);
    monster.clear();
    System.out.println(" Passed CompositeCurve");
    
    System.out.println("Testing Line translate");
    line.translate(0.1, -0.1);
    line.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(0.2, 0.1, 0.4, 0.3);
    monster.clear();
    System.out.println(" Passed Line translate");
    
    System.out.println("Testing Line scale");
    line = new Line(0.1, 0.2, 0.3, 0.4);
    line.scale(2, 0.5);
    line.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(0.2, 0.1, 0.6, 0.2);
    monster.clear();
    System.out.println(" Passed Line scale");
    
    System.out.println("Testing Line rotate");
    line = new Line(0.1, 0.2, 0.3, 0.4);
    line.rotate(90);
    line.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(-.2, 0.1, -0.4, 0.3);
    monster.clear();
    line = new Line(0.1, 0.2, 0.3, 0.4);
    line.rotate(30);
    line.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(-0.013397459621556113, 0.22320508075688775, 0.05980762113533164, 0.4964101615137755);
    monster.clear();
    System.out.println(" Passed Line rotate");
    
    System.out.println("Testing CompositeCurve transform");
    comp = new CompositeCurve();
    comp.add(new Line(0.1, 0.2, 0.3, 0.4));
    comp.add(tri);
    comp.translate(-0.1, 0.2);
    comp.scale(0.25, 3);
    comp.rotate(-15);
    comp.draw(monster);
    monster.testNumLines(4);
    monster.testHasLine(0.31058285412302494, 1.1591109915468822, 0.5141705724989908, 1.7257255350651972);
    monster.testHasLine(0.7177582908749567, 2.2923400785835124, 0.9213460092509225, 2.8589546221018267);
    monster.testHasLine(0.9213460092509225, 2.8589546221018267, 0.34847659231932615, 0.527791686752937);
    monster.testHasLine(0.34847659231932615, 0.527791686752937, 0.7177582908749567, 2.2923400785835124);
    monster.clear();
    System.out.println(" Passed CompositeCurve transform");
   
    System.out.println("Testing Line copy");
    line = new Line(0.1, 0.2, 0.3, 0.4);
    Curve line2 = line.copy();
    if (line2 == line)
      throw new RuntimeException("same line instead of copy");
    line2.draw(monster);
    monster.testNumLines(1);
    monster.testLastLine(0.1, 0.2, 0.3, 0.4);
    monster.clear();
    System.out.println(" Passed Line copy");

    System.out.println("Testing CompositeCurve copy");
    comp = new CompositeCurve();
    line = new Line(0.1, 0.2, 0.3, 0.4);
    tri = new Triangle(0.5, 0.6, 0.7, 0.8, 0.9, 0.0);
    comp.add(line);
    comp.add(tri);
    Curve comp2 = comp.copy();
    comp.scale(2, 2);
    comp2.draw(monster);
    monster.testNumLines(4);
    monster.testHasLine(0.1, 0.2, 0.3, 0.4);
    monster.testHasLine(0.5, 0.6, 0.7, 0.8);
    monster.testHasLine(0.5, 0.6, 0.9, 0.0);
    monster.testHasLine(0.7, 0.8, 0.9, 0.0);
    monster.clear();
    System.out.println(" Passed CompositeCurve copy");
    
    System.out.println("Testing generateFractal");
    Lab.generateFractal(monster, 0).draw(monster);
    monster.testNumLines(1);
    monster.testHasLine(0, 0, 0, 1);
    monster.clear();
    Lab.generateFractal(monster, 1).draw(monster);
    monster.testNumLines(2);
    monster.testHasLine(0, 0, 0, 1);
    monster.testHasLine(0.5, 0, 0.5, 1);
    monster.clear();
    Lab.generateFractal(monster, 2).draw(monster);
    monster.testNumLines(4);
    monster.testHasLine(0, 0, 0, 1);
    monster.testHasLine(0.25, 0, 0.25, 1);
    monster.testHasLine(0.5, 0, 0.5, 1);
    monster.testHasLine(0.75, 0, 0.75, 1);
    monster.clear();
    Lab.generateFractal(monster, 3).draw(monster);
    monster.testNumLines(8);
    monster.testHasLine(0, 0, 0, 1);
    monster.testHasLine(0.125, 0, 0.125, 1);
    monster.testHasLine(0.25, 0, 0.25, 1);
    monster.testHasLine(0.375, 0, 0.375, 1);
    monster.testHasLine(0.5, 0, 0.5, 1);
    monster.testHasLine(0.625, 0, 0.625, 1);
    monster.testHasLine(0.75, 0, 0.75, 1);
    monster.testHasLine(0.875, 0, 0.875, 1);
    monster.clear();
    
    monster.completed();
    
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.println("Enter name of fractal class (e.g. Sierpinski)");
      String name = in.nextLine();
      if (name.equals(""))
        break;
      SketchPad pad = new SketchPad();
      try
      {
        Lab.generateFractal((Fractal)Class.forName(name).newInstance(), 5).draw(pad);
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  
  private ArrayList<double[]> lines;
  
  private FractalMonster()
  {
    lines = new ArrayList<double[]>();
    super.drawLine(0.25, 0.25, 0.5, 0.5);
    super.drawLine(0.5, 0.5, 0.75, 0.25);
    super.drawLine(0.25, 0.5, 0.25, 0.75);
    super.drawLine(0.75, 0.5, 0.75, 0.75);
  }
  
  public void drawLine(double x1, double y1, double x2, double y2)
  {
    lines.add(new double[]{x1, y1, x2, y2});
  }
  
  private void testNumLines(int num)
  {
    if (num != lines.size())
      throw new RuntimeException("drew " + lines.size() +
                                 " lines instead of " + num + " lines");
  }

  private void testLastLine(double x1, double y1, double x2, double y2)
  {
    double[] last = lines.get(lines.size() - 1);
    if (!near(x1, last[0]) ||
        !near(y1, last[1]) ||
        !near(x2, last[2]) ||
        !near(y2, last[3]))
      throw new RuntimeException("drew line from (" + last[0] + ", " + last[1] +
                                 ") to (" + last[2] + ", " + last[3] +
                                 ")\ninstead of from (" + x1 + ", " + y1 +
                                 ") to (" + x2 + ", " + y2 + ")");
  }
  
  private void testHasLine(double x1, double y1, double x2, double y2)
  {
    for (double[] line : lines)
    {
      if (near(x1, line[0]) &&
          near(y1, line[1]) &&
          near(x2, line[2]) &&
          near(y2, line[3]))
        return;
      if (near(x2, line[0]) &&
          near(y2, line[1]) &&
          near(x1, line[2]) &&
          near(y1, line[3]))
        return;
    }
    throw new RuntimeException("did not draw line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
  }
  
  private boolean near(double x, double y)
  {
    return Math.abs(x - y) < 0.001;
  }
  
  private void clear()
  {
    lines = new ArrayList<double[]>();
  }
  
  private void printLines()
  {
    for (double[] line : lines)
      System.out.println(Arrays.toString(line));
  }
  
  private void completed()
  {
    super.drawLine(0.25, 0.25, 0.25, 0.5);
    super.drawLine(0.75, 0.25, 0.75, 0.5);
    super.drawLine(0.8, 0.25, 0.8, 0.5);
    super.drawLine(0.85, 0.25, 0.85, 0.5);
    super.drawLine(0.95, 0.25, 0.95, 0.5);
    super.drawLine(0.85, 0.5, 0.95, 0.25);
  }
  
  public Curve step0()
  {
    return new Line(0, 0, 0, 1);
  }
  
  public Curve transform(Curve curve)
  {
    CompositeCurve next = new CompositeCurve();
    Curve c1 = curve.copy();
    c1.scale(0.5, 1);
    next.add(c1);
    Curve c2 = c1.copy();
    c2.translate(0.5, 0);
    next.add(c2);
    return next;
  }
}
