import java.util.*;
import java.io.*;
public class StudentLoginAndRegister 
{
    static void register() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("StudentFile.csv"));
        while(sc.hasNextLine())
        {
            String[] credentials = sc.nextLine().split(",");
            if(!credentials[2].endsWith("@pilani.bits-pilani.ac.in"))
            {
                System.out.println(credentials[0] + " will not be registered due to wrong bits emailId");
            }
            else
            {
                Student newCustomer = new Student(credentials[0],credentials[1],credentials[2],credentials[3]);
                Customer.registerStudent(credentials[1],newCustomer);
            }
           
        }
        sc.close();
    }
    
}
