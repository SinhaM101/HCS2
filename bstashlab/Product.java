
public class Product implements Comparable<Product>
{
  private String model;
  private int version;
  
  public Product(String model, int version)
  {
    this.model = model;
    this.version = version;
  }
  
  public String getModel()
  {
    return model;
  }
  
  public int getVersion()
  {
    return version;
  }
  
  public String toString()
  {
    return model + " " + version;
  }
  
  public boolean equals(Object obj)
  {
    Product other = (Product)obj;
    return model.equals(other.getModel()) &&
      version == other.getVersion();
  }
  
  public int compareTo(Product other)
  {
    if (model.equals(other.getModel()))
    {
        if (version == other.getVersion())
          return 0;
        if (version < other.getVersion())
          return -1;
        else 
          return 1;
    }
    else
    {
      if (model.compareTo(other.getModel()) == 0)
        return 0;
      else if (model.compareTo(other.getModel()) < 0)
        return -1;
      else
        return 1;
    }
  }
  
  public int hashCode()
  {
    String total = "";
    total += version;
    total += Math.abs(model.hashCode());
     while(total.length() > 9)
     {
        total = total.substring(0,total.length()-2);
     }
    return (Integer.parseInt(total));
  }
}