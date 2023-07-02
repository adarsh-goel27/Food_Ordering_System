import java.io.*;
import java.util.*;
public class Customer 
{
    static HashMap<String,Student> customers = new HashMap<String, Student>();
    static void registerStudent(String  bitsId, Student newCustomer)
    {
        customers.put(bitsId,newCustomer);
    }
    static void showCustomers()
    {
        for(Map.Entry<String,Student> e : customers.entrySet())
        {
            System.out.println(e.getKey() + " " + e.getValue().getName());
        }
    }
    static boolean checkPresent(String bitsId)
    {
        if(customers.containsKey(bitsId))
            return true;
        else
            return false;
    }
    static void showOrderHistory() throws IOException
    {
        File obj = new File("OrderHistory.txt");
        obj.createNewFile();
        try(FileWriter fw = new FileWriter(obj)){}
        for(Map.Entry<String,Student> e : customers.entrySet())
        {
            e.getValue().generateOrderHistory();
        }
    }
}
