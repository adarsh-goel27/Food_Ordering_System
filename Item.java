public class Item 
{
    private String itemName;
    private int itemPrice;
    private String itemId;
    Item(String name, int price, String itemId)
    {
        this.itemName = name;
        this.itemPrice = price;
        this.itemId = itemId;
    }
    public String getItemName()
    {
        return this.itemName;
    }
    public int getItemPrice()
    {
        return this.itemPrice;
    }
    public String getItemId()
    {
        return this.itemId;
    }
    public String toString()
    {
        return this.itemName + " @ " + "Rs. " + this.itemPrice;
    }
    
}
