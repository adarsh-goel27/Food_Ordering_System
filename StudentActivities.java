import java.io.*;
import java.util.*;
public class StudentActivities 
{
    static PriorityQueue<Order> pq = new PriorityQueue<>();
    static void takeOrders()throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("Order.csv"));
        while(sc.hasNextLine())
        {
            String[] s  = sc.nextLine().split(",");
            Order newOrder  = new Order(Integer.parseInt(s[0]),s[1],s[2],s[3],Integer.parseInt(s[4]));
            pq.add(newOrder);
        }
    }
    static void showOrder()
    {
        for(Order e : pq)
        {
            System.out.println(e);
        }
    }
    static void placeOrder() throws InterruptedException, IOException
    {
        File f = new File("OrderLogs.txt");
        f.createNewFile();
        try(FileWriter fw = new FileWriter("OrderLogs.txt")){}
        int month=0;
        while(!pq.isEmpty())
        {
            
            int time = pq.peek().timestamp;
            if(month!=Timestamp.getMonthFromUnixTime(time))
            {
                month = Timestamp.getMonthFromUnixTime(time);
                resetMonthlyExpenditure();
            }
            ArrayList<Order> al = new ArrayList<>();
            int count = 0;
            for(Order e : pq)
            {
                if(time == e.timestamp)
                {
                    al.add(e);
                    count++;
                }
                else break;
            }
            for(int i = 1; i <= count;++i)pq.poll();
            
            for(Order e : al)
            {
                e.t.start();
            }
            for(Order e : al)
            {
                e.t.join();
            }
        }
    }
    static void resetMonthlyExpenditure()
    {
        for(Map.Entry<String,Student> e : Customer.customers.entrySet())
        {
            e.getValue().resetMonthlyexp();
        }
    }
}
