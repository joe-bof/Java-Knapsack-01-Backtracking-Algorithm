/* @Author Joe Bofani
 * @Since 12/10/2020
 * Creates objects of type "JoeItem."
 * "JoeItem" objects create a shell for "general item" objects.
 * I.e. "JoeItem" can be used for any item that is described solely by a weight and price.
 * */

import java.text.DecimalFormat;

public class JoeItem
{
  private int price;
  private int weight;
  
  DecimalFormat f0 = new DecimalFormat("0.##");
  
  public JoeItem()  //Constructors.
  {
    this.price = 0;
    this.weight = 0;
  }
  
  public JoeItem(int price, int weight)
  {
    this.price = price;
    this.weight = weight;
  }
  
  public int getWeight()  //Getters.
  {
    return(this.weight);
  }
  
   public int getPrice()
  {
    return(this.price);
  }
  
  public int PiWi()  //Returns price/weight ratio.
  {
    String piwi = f0.format(this.price / this.weight);
    return( Integer.parseInt(piwi) );
  }
  
  @Override
  public String toString()  //toString() method.
  {
    return("$" + this.price + "/" +
           this.weight + "wt");
  }
}