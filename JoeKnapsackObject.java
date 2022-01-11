/* @Author Joe Bofani
 * @Since 12/10/2020
 * 0-1 Knapsack Backtracking Algorithm w/ additional support methods.
 * Creates objects of type "JoeKnapsackObject" to help the passing of data b/w methods.
 * */

import java.util.ArrayList;

public class JoeKnapsackObject
{
  String str = "";
  int i;
  int profit;
  int weight;
  int numbest;
  int W;
  int maxprofit;
  String[] bestset;
  String[] include;
  ArrayList<JoeItem> array;
  
  public JoeKnapsackObject(int i, int profit, int weight, ArrayList<JoeItem> array, int W, 
                           int maxprofit, String[] bestset, String[] include, int numbest)  //constructor
  {
    this.i = i;
    this.profit = profit;
    this.weight = weight;
    this.numbest = numbest;
    this.W = W;
    this.maxprofit = maxprofit;
    this.bestset = bestset;
    this.include = include;
    this.array = array;
  }
  
  public void executeKnapsack() //This method runs the 01Knapsack Algorithm given an object of type "JoeKnapsackObject."
  {
    knapsack(this.i, this.profit, this.weight, this.array, this.W, 
             this.maxprofit, this.bestset, this.include, this.numbest);
  }
  
  public void knapsack(int i, int profit, int weight, ArrayList<JoeItem> array, int W, 
                       int maxprofit, String[] bestset, String[] include, int numbest)  //01Knapsack Algorithm.
  {
    if(profit == maxprofit)  //Puts all bestsets w/ their respective maxprofits into a String.
    {
      for(int t=0; t < array.size(); t++)
      {
        str += ("Item" + (t+1) + "=" + bestset[t] + "   ");
      }
      str += ("Maxprofit: " + Integer.toString(maxprofit) + ",");
    }
    
    if(weight <= W && profit > maxprofit)
    {
      maxprofit = profit;
      numbest = i;
      bestset = include;
    }
    
    if(promising(i, weight, profit, maxprofit, W, array))
    {
      include[i+1] = "Yes";
      knapsack(i+1, profit + array.get(i+1).getPrice(), weight + array.get(i+1).getWeight(), 
               array, W, maxprofit, bestset, include, numbest);
      include[i+1] = "No";
      knapsack(i+1, profit, weight, array, W, maxprofit, bestset, include, numbest);
    }
  }
  
  public boolean promising(int i, int weight, int profit, int maxprofit, int W, ArrayList<JoeItem> array) //Promising.
  { 
    int j, k;
    int totweight;
    float bound;
    
    if(weight >= W)
      return(false);
    
    else
    {
      j = i+1;
      bound = profit;
      totweight = weight;
      
      while( (j < array.size()) && (totweight + array.get(j).getWeight() <= W))
      {
        totweight = (totweight + array.get(j).getWeight());
        bound = (bound + array.get(j).getPrice());
        j++;
      }
      
      k = j;
      
      if(k < array.size())
        bound = (bound + ((W - totweight)*(array.get(k).PiWi())));
      
      if( bound > maxprofit)
        return (true);
      return(false);
    }
  }
  
  public String getString()  //Retrieves str, which is a concatenated String w/ all bestsets and maxprofits determined
  {                          // by the 01Knapsack Algorithm.  str seperates sets by via a comma.
    return (this.str);
  }
  
  public void output(String str)  //This method determines and prints the optimal solution.
  {
    String optimalSolution = "";
    int j;
    int largest = 0;
    String[] newString = str.split(",");

    for(j=0; j < newString.length; j++)  //Determines the highest maxprofit value within str.
    {
      String[] newString2 = newString[j].split("Maxprofit: ");
      
      if (Integer.parseInt(newString2[1]) > largest)
        largest = Integer.parseInt(newString2[1]);
    }
    
    for(j=0; j < newString.length; j++)  //Updates the optimal solution.
    {
      String[] newString2 = newString[j].split("Maxprofit: ");
  
        if (Integer.parseInt(newString2[1]) == largest)
        {
            optimalSolution = newString[j];
        }
      }
    
    optimalSolution = optimalSolution.replaceAll("null", "No");
    System.out.println("INCLUDE:  " + optimalSolution + "\n\n\n\n");  //Prints the optimal solution (bestset and maxprofit).
    }
}