import java.io.*;
import java.util.*;
public class Student 
{
    private String name;
    private String bitsId;
    private String emailId;
    private String phoneNo;
    private int totalAmountSpent;
    private int monthlyExpense;
    private HashMap<String,ArrayList<CustomPair>> itemsBought;
    Student(String name, String bitsId, String emailId, String phoneNo)
    {
        this.name = name;
        this.bitsId = bitsId;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.totalAmountSpent = 0;
        this.monthlyExpense = 0;
        itemsBought = new HashMap<>();
        itemsBought.put("Shankar",new ArrayList<>());
        itemsBought.put("Meera",new ArrayList<>());
        itemsBought.put("CVR",new ArrayList<>());
        itemsBought.put("SR",new ArrayList<>());
    }
    public String getName()
    {
        return this.name;
    }
    public String getBitsId()
    {
        return this.bitsId;
    }
    public String getEmailId()
    {
        return this.emailId;
    }
    public String getPhoneNo()
    {
        return this.phoneNo;
    }
    public void generateOrderHistory() throws IOException
    {   
        try(FileWriter fw = new FileWriter("OrderHistory.txt",true))
        {
            
            fw.write("Order History for " + name + " Bits Id : " + bitsId + "\n");
            fw.write("Food Items Ordered\n");
            for(Map.Entry<String,ArrayList<CustomPair>> e : itemsBought.entrySet())
            {
                
                fw.write("Items ordered at Redi " + e.getKey() + "\n");
                if(e.getValue().size() == 0)
                {
                    fw.write("None\n");
                }
                for(CustomPair i : e.getValue())
                {
                    
                    fw.write("Description: " + i.getItem() + " Quantity: "  + i.getQuantity() + "\n");
                }
            
            }
            fw.write("Total Expenses :" + this.totalAmountSpent + "\n");
            fw.write("Monthly Expenses: "+ this.monthlyExpense + "\n");
            fw.write("*************************************\n");
        }
        
    }
    public void updateItem(Item item, int quantity, String rediName)
    {
        boolean flag = false;
        for(Map.Entry<String,ArrayList<CustomPair>> e : itemsBought.entrySet())
        {
            if (e.getKey().equals(rediName))
            {
                for(CustomPair i : e.getValue())
                {
                    if(i.getItem() == item )
                    {
                        i.setQuantity(i.getQuantity() + quantity);
                        flag = true;
                        break;
                    }
                }
            }
            
        }
        if(!flag)
        {
            itemsBought.get(rediName).add(new CustomPair(item,quantity));
        }
        totalAmountSpent += item.getItemPrice()* quantity;
        monthlyExpense += item.getItemPrice()* quantity;
    }
    public void resetMonthlyexp()
    {
        this.monthlyExpense = 0; 
    }
    
}
