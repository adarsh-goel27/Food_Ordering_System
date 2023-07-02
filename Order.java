import java.io.*;
import java.util.*;
public class Order implements Comparable<Order>,Runnable
{
    int timestamp;
    String bitsId;
    String rediName;
    String itemId;
    int quantity;
    Thread t;
    Order(int timestamp,String bitsId, String rediName,String itemId,int quantity)
    {
        this.timestamp = timestamp;
        this.bitsId = bitsId;
        this.itemId = itemId;
        this.rediName = rediName;
        this.quantity = quantity;
        t = new Thread(this);
    }
    public int compareTo(Order obj)
    {
        return this.timestamp - obj.timestamp;
    }
    public String toString()
    {
        return timestamp + " " + bitsId;
    }
    public void run()
    {
        try
        {
            if(Customer.checkPresent(bitsId))
            {
                Student obj = Customer.customers.get(bitsId);
                Inventory.placeOrderAtRedi(obj,rediName,itemId,quantity,timestamp);
            }
            else
            {
                try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
                {
                    fw.write("Order of item with item Id : " + itemId + " Quantity : " + quantity + " made by " + bitsId + " at time " + Timestamp.unixTimeToHumanReadable(timestamp) + "\n");
                    fw.write("Order Unsuccessful as Student is not registered or Entered wrong Bits Id\n");
                    fw.write("*************************************\n");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error Occurred");
        }
    }
}
