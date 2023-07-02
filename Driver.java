import java.io.*;
import java.util.*;
public class Driver 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        StudentLoginAndRegister.register();
        //Customer.showCustomers(); // This shows all the registered students with their name and Bits Id
        Inventory.config();
        Admin.getInstance().removeItem(); // Removes the item as specified by user
        Admin.getInstance().addItem(); // Removes the item as specified by user
        StudentActivities.takeOrders();
        StudentActivities.placeOrder();
        Customer.showOrderHistory(); // Generate OrderHistory.txt file
        Inventory.showRediInventory(); // Generates FinalInventory.txt
        Admin.getInstance().getInsights(); // Generate Insights.txt file
        Admin.getInstance().getRevenueSummary(); // Generate RevenueSummary.txt file
    }
    /*
     * Do not change the order of the code
     * You can uncomment the two lines as required for addItem and removeItem.
     * It is advisible that you run the code on VS Code
     * You can make changes in the .csv file to check the various edge cases and testcases.
     */
}