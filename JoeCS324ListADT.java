/* @Author Joe Bofani
 * @Since 12/10/2020
 * Reads text file to create objects of type "JoeItem."
 * Then calls the 0-1 Knapsack algorithm.
 * Contains application class method knapsack01() w/ I/O:
 *    INPUT: text file name & W value (knapsack weight limit).
 *    OUTPUT: Maxprofit value & the set required to obtain maxprofit.
 * */

import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.ArrayList;

public class JoeCS324ListADT
{
  public static ArrayList<JoeItem> readFile(String fileName)  //This method reads in and sorts data from a .txt file.
  {
    ArrayList <JoeItem> array = new ArrayList<JoeItem>();
    String[] bestset = new String[array.size()];
    String[] include = new String[array.size()];
    int numbest = 0;
    
    try
    {
      Scanner fScanner = new Scanner (new File(fileName));
      
      while (fScanner.hasNextLine())
      {
        String description = fScanner.nextLine();          //Skips over 1st line in .txt file.
        
        int price = fScanner.nextInt();
        int weight = fScanner.nextInt();
        JoeItem tempItem = new JoeItem (price, weight);   //Creates new objects of type "JoeItem" from .txt file.
        array.add(tempItem);                              //All "JoeItem" objects stored in ArrayList.
      }
      
      for(int i=0; i < array.size(); i++)                 //Decreasingly sorts array by JoeItems' Price/Weight value.
      {
        for(int j=i+1; j < array.size(); j++)
        {
          if( array.get(i).PiWi() < array.get(j).PiWi()) 
          {
            JoeItem itemI = array.get(i);
            JoeItem itemJ = array.get(j);
            
            array.set(j, itemI);
            array.set(i, itemJ);
          }
        }
      }
    }
    
    catch (FileNotFoundException fnf)
    {
      System.out.println("File not found! " + fnf);
    }
    
    return(array);                                      //Returns a sorted array of "JoeItems" from .txt file.
  }
  
  public static void knapsack01(int W, String fileName) //This method plugs-in both the array created by the readFile()
  {                                                     //method above, and user generated W into the knapsack algorithm.
    ArrayList<JoeItem> array = readFile(fileName);
    String[] bestset = new String[array.size()];
    String[] include = new String[array.size()];
    int numbest = 0;
    
    JoeKnapsackObject knapObj = new JoeKnapsackObject(-1, 0, 0, array, W, 0, bestset, include, numbest);
    knapObj.executeKnapsack();
    System.out.print("ITEMS:  ");
    
    for(int i=0; i < readFile(fileName).size(); i++)                  //Prints out array of "JoeItems."
      System.out.print("Item" + (i+1) + "=" + readFile(fileName).get(i) + "   ");
    
    System.out.println("\n");
    knapObj.output(knapObj.getString());                              //Prints out the optimal solution.
  }
}