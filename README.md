# Java-Knapsack-01-Backtracking-Algorithm
Java program that uses a backtracking algorithm to solve the knapsack-01 problem in the form of a business problem with mining trucks.


@author Joe Bofani
@since 12/10/2020
CS 324-3

BUSINESS PROBLEM: Mining trucks take a very long time to enter/exit mines.  Thus, when a truck exits a mine carrying mined materials, the truck needs to haul away the highest profit yielding cargo, without overloading the truck's weight limit.  If not, the mining company will lose money because of inefficiency.  The "user" can set the weight threshold of the trucks in various company mines across the world.  The program will use the backtracking approach of the 0-1 Knapsack problem to determine the highest profit exit haul each truck can make.  

DESCRIPTION: The program reads data (prices & weights) from a .txt file.  "JoeItem" objects are created from the read-in and stored in a ListADT.  The ListADT is sorted by price/weight ratios, and then passed through the  backtracking 0-1 Knapsack algorithm.  The optimal solution is delivered to the user via String manipulations. 

TO RUN CALL: Open "BofaniMiningTruckApp." Use the knapsack01() method to input the truck's cargo weight capacity (int), and the name of the mine location (String).
             Example:   knapsack01(int W, String "USA"); //Pseudo-code
             

EXAMPLE INPUT:   
   knapsack01(16, "BofaniMineTruckDataAustralia.txt");  //Executable code

EXAMPLE OUTPUT:
   MINE LOCATION: AUSTRALIA
   ITEMS:  Item1=$40/2wt   Item2=$30/5wt   Item3=$50/10wt   Item4=$10/5wt  //Sorted list of items.   

   INCLUDE:  Item1=Yes   Item2=No   Item3=Yes   Item4=No   Maxprofit: 90  //Optimal Solution (bestset and maxprofit).


FILES INCLUDED:
BofaniMineTruckDataAustralia.txt

BofaniMineTruckDataBotswana.txt

BofaniMineTruckDataBrazil.txt

BofaniMineTruckDataCanada.txt

BofaniMineTruckDataCongo.txt

BofaniMineTruckDataRussia.txt

BofaniMiningTruckApp.java  //Application class for Mining Truck Business Problem.

JoeCS324ListADT.java  //Reads .txt file to create objects of type "JoeItem." Then calls the 0-1 Knapsack algorithm.

JoeItem.java  //Creates objects of type "JoeItem" (e.g. any general "item" that can be described solely by a price and weight).

JoeKnapsackObject.java  //0-1 Knapsack Backtracking Algorithm w/ additional support methods.

README.md  //README file with description of the programs and how to run the application.
