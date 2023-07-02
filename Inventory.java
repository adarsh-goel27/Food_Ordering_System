import java.util.*;
import java.io.*;
public class Inventory 
{
    static ArrayList<Redi> rediInventory = new ArrayList<>();
    static int[] arr = new int[3];
    static void config() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("RediInventory.csv"));
        while(sc.hasNextLine())
        {
            String[] rediData = sc.nextLine().split(",");
            boolean flag = false;
            for(Redi e : rediInventory)
            {
                if(rediData[0].equalsIgnoreCase(e.getRediName()))
                {
                    if(rediData.length==4) e.addItem(new Item(rediData[2],Integer.parseInt(rediData[3]),rediData[1]), 2147483647);
                    else e.addItem(new Item(rediData[2],Integer.parseInt(rediData[3]),rediData[1]), Integer.parseInt(rediData[4]));
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                Redi e = new Redi(rediData[0]);
                if(rediData.length==4) e.addItem(new Item(rediData[2],Integer.parseInt(rediData[3]),rediData[1]), 2147483647);
                else e.addItem(new Item(rediData[2],Integer.parseInt(rediData[3]),rediData[1]), Integer.parseInt(rediData[4]));
                rediInventory.add(e);
            }

        }
    }
    synchronized static void placeOrderAtRedi(Student obj, String rediName, String itemId, int quantity, int timestamp) throws IOException
    {
        
        try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
        {
            fw.write("Order of item with item Id : " + itemId + " Quantity : " + quantity + " made by " + obj.getBitsId() + " at time " + Timestamp.unixTimeToHumanReadable(timestamp) + "\n");
        }
        for(Redi e : rediInventory)
        {
            if(e.getRediName().equals(rediName))
            {
                if(e.placeOrder(obj,itemId,quantity))
                {
                    int hours = Timestamp.getHHFromUnixTime(timestamp);
                    if(hours < 12) arr[0]++;
                    else if(hours < 16 ) arr[1]++;
                    else arr[2]++;
                }
                return;
            }
        }
        try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
        {
            fw.write("Order Unsuccessful due to Redi entered does not exist\n");
            fw.write("************************************\n");
        }
        
    }
    static void showRediInventory() throws IOException
    {
        File obj = new File("FinalInventory.txt");
        try
        {
            obj.createNewFile();
        }
        catch(Exception e)
        {
            System.out.println("Error Occurred");
        }
        try(FileWriter fw = new FileWriter("FinalInventory.txt")){};
        for(Redi e : rediInventory)
        {
            
            try(FileWriter fw = new FileWriter("FinalInventory.txt",true))
            {
                fw.write("Inventory at "+ e.getRediName() + " Redi\n");
                
            }
            e.showInventory();
        }


    }
    static Redi getRedi(String rediName)
    {
        for(Redi e : rediInventory)
        {
            if(e.getRediName().equals(rediName))
            {
                return e;
            }
        }
        return null;
    }
    static void getInsights() throws IOException
    {
        File f = new File("Insights.txt");
        f.createNewFile();
        try(FileWriter fw = new FileWriter(f))
        {
            if(arr[0]>=arr[1] && arr[0]>=arr[2])
            {
                fw.write("Items were ordered most frequently during Morning (12AM-12PM)\n");
            }
            else if(arr[1]>=arr[0] && arr[1]>=arr[2])
            {
                fw.write("Items were ordered most frequently during AfterNoon (12PM-4PM)\n");
            }
            else fw.write("Items were ordered most frequently sold during Evening (4PM-12AM)\n");
            fw.write("*********************************\n");
            fw.write("Following are the items that were sold most at respective Redi:\n");
            for(Redi e : rediInventory)
            {
                fw.write(e.getRediName() + " : " );
                if(e.getMaxSoldItem().getQuantity()!=0)
                {
                    fw.write(e.getMaxSoldItem().getItem().getItemName() + " @ " + e.getMaxSoldItem().getItem().getItemPrice() + "\n");
                }
                else fw.write("-\n");
            }
        }
    }
    static void getRevenueSummary() throws IOException
    {
        File f = new File("RevenueSummary.txt");
        f.createNewFile();
        try(FileWriter fw = new FileWriter(f))
        {
            fw.write("Following are the total revenue amount for each of the Redi \n");
            for(Redi e : rediInventory)
            {
                fw.write(e.getRediName()+" : " + e.getTotalRevenue() + "\n");
            }
        }
    }
        
}
