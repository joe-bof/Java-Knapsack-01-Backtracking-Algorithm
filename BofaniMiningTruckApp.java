/* @Author Joe Bofani
 * @Since 12/10/2020
 * Application class for Mining Truck Business Problem.
 * */

public class BofaniMiningTruckApp extends JoeCS324ListADT
{
  public static void main(String[] args)
  {
    System.out.println("MINE LOCATION: AUSTRALIA");
    knapsack01(16, "BofaniMineTruckDataAustralia.txt"); //Textbook page 237 example.
    
    System.out.println("MINE LOCATION: BOTSWANA");
    knapsack01(9, "BofaniMineTruckDataBotswana.txt");   //Textbook page 247 HW problem.
    
    System.out.println("MINE LOCATION: BRAZIL");
    knapsack01(22, "BofaniMineTruckDataBrazil.txt");    //Quiz 12 problem.
    
    System.out.println("MINE LOCATION: CANADA");
    knapsack01(1000, "BofaniMineTruckDataCanada.txt");  //Made-up theoretical problem.
    
    System.out.println("MINE LOCATION: CONGO");
    knapsack01(1200, "BofaniMineTruckDataCongo.txt");   //Made-up theoretical problem.
    
    System.out.println("MINE LOCATION: RUSSIA");
    knapsack01(75000, "BofaniMineTruckDataRussia.txt"); //Made-up theoretical problem.
  }
}