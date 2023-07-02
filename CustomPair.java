public class CustomPair implements Comparable<CustomPair>
{
    private Item item;
    private int quantity;
    CustomPair(Item  item, int quantity)
    {
        this.item  = item;
        this.quantity = quantity;
    }
    public int compareTo(CustomPair obj)
    {
        return this.getQuantity() - obj.getQuantity();
    }
    public Item getItem()
    {
        return this.item; 
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public int getPrice()
    {
        return this.item.getItemPrice();
    }
    public String getItemId()
    {
        return item.getItemId();
    }
    public String getName()
    {
        return this.item.getItemName();
    }

}
