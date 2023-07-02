import java.io.*;
import java.util.*;
public class AdminActivities 
{
   
    public  void addItem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin requesting to add an item");
        System.out.println("Enter Redi Name");
        String rediName = sc.nextLine();
        System.out.println("Enter Item Id");
        String itemId = sc.nextLine();
        System.out.println("Enter Item name");
        String itemName = sc.nextLine();
        System.out.println("Enter Price");
        int price = sc.nextInt();
        System.out.println("Enter Quantity");
        int quantity = sc.nextInt();
        Item item = new Item(itemName, price, itemId);
        Redi obj = Inventory.getRedi(rediName);
        if(obj == null)
        {
            System.out.println("Operation not successful as Redi entered does not exist");
        }
        else obj.addItem(item,quantity);
    }
    public void removeItem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin requesting to remove an item");
        System.out.println("Enter Redi Name");
        String rediName = sc.nextLine();
        System.out.println("Enter Item Id");
        String itemId = sc.nextLine();
        Redi obj = Inventory.getRedi(rediName);
        if(obj == null)
        {
            System.out.println("Operation not successful as Redi entered does not exist");
        }
        else obj.removeItem(itemId);
    }
    public  void getInsights() throws IOException
    {
        Inventory.getInsights();
    }
    public  void getRevenueSummary() throws IOException
    {
        Inventory.getRevenueSummary();
    }
}
