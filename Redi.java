import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Redi 
{
    private String rediName;
    ArrayList<CustomPair> inventory;
    ArrayList<CustomPair> inventorySold;
    private int totalRevenue;
    Redi(String name)
    {
        this.rediName = name;
        this.inventory = new ArrayList<CustomPair>();
        this.inventorySold  = new ArrayList<CustomPair>();
        this.totalRevenue = 0;
    }
    public String getRediName()
    {
        return this.rediName;
    }
    public void addItem(Item item, int quantity)
    {
        inventory.add(new CustomPair(item,quantity));
        inventorySold.add(new CustomPair(item,0));
    }
    public void removeItem(String itemId)
    {
        CustomPair remove = null;
        for(CustomPair e : inventory)
        {
            
            if(e.getItemId().equalsIgnoreCase(itemId))
            {
                remove = e;
                break;
            }
        }
        if(remove == null)
        {
            System.out.println("Operation not Successful as item " + itemId + " does not exist in this redi");
        }
        else inventory.remove(remove);
        
    }
    public boolean placeOrder(Student obj, String itemId, int quantity) throws IOException
    {
        boolean flag = false;
        for(CustomPair e : inventory)
        {
            if(e.getItemId().equals(itemId))
            {
                flag = true;
                if(quantity <= e.getQuantity() )
                {
                    obj.updateItem(e.getItem(), quantity, getRediName());
                    e.setQuantity(e.getQuantity()-quantity);
                    totalRevenue += e.getPrice() * quantity;
                    for(CustomPair f : inventorySold)
                    {
                        if(f.getItemId().equals(itemId))
                        {
                            f.setQuantity(f.getQuantity() + quantity);
                            break;
                        }
                    }
                    try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
                    {
                        fw.write("Order Delivered \n");
                        fw.write("*********************************\n");
                    }
                    return true;
                }
                break;
            }
        }
        if(!flag)
        {
            try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
                {
                    fw.write("Order Unsuccessful as item with ItemId " + itemId + " does not exist\n");
                    fw.write("*********************************\n");
                }
        }
        else
        {
            try(FileWriter fw = new FileWriter("OrderLogs.txt",true))
                {
                    fw.write("Order Unsuccessful because of less inventory of the item\n");
                    fw.write("*********************************\n");
                }
        }
        return false;
        

    }
    public void showInventory() throws IOException
    {
        
        for(CustomPair e : inventory)
        {
            
            try(FileWriter fw = new FileWriter("FinalInventory.txt",true))
            {
                fw.write(e.getItem() + " " +  "Quantity : " + e.getQuantity() + "\n");
            }
           
        }
        
        try(FileWriter fw = new FileWriter("FinalInventory.txt",true))
        {
            fw.write("**********************************\n");
        }
    }
    public int getTotalRevenue()
    {
        return totalRevenue;
    }
    public CustomPair getMaxSoldItem()
    {
        Collections.sort(inventorySold);
        return  inventorySold.get(inventorySold.size()-1);
    }
}
