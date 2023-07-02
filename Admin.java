public class Admin extends AdminActivities
{
    private static Admin obj = new Admin();
    private String name ;
    private Admin()
    {
        name = "Adarsh";
    }
    
    public static Admin getInstance()
    {
        return Admin.obj;
    } 
    
}
