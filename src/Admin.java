import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Customer
{
    public String CustomerEmail;
    public int CustomerID;
    public String CustomerPWD;
    public int ProductID;
    public int ProductQTY;
    public int ProductPrice;
    public boolean Delivered;
    static ArrayList<ArrayList<String>>arr= new ArrayList<>();
    static HashMap<Integer,ArrayList<Integer>>product=new HashMap<>();

    Customer customer=new Customer();


    public static void CustomerCreate(String CustomerEmail, int CustomerID, String CustomerPWD){
        CustomerEmail=CustomerEmail;
        CustomerID=CustomerID;
        CustomerPWD=CustomerPWD;
        ArrayList<String>curr=new ArrayList<>();
        curr.add(CustomerEmail);
        curr.add(Integer.toString(CustomerID));
        curr.add(CustomerPWD);
        arr.add(curr);
        System.out.println("User has successfully Created");
    }
    public static void CreateProduct(int ProductID,int ProductQTY, int ProductPrice)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("ProductID: ");
        ProductID=sc.nextInt();
        System.out.println("Product Quantity");
        ProductQTY=sc.nextInt();
        System.out.println("Produc Price: ");
        ProductPrice=sc.nextInt();
        ProductID=ProductID;
        ProductQTY=ProductQTY;
        ProductPrice=ProductPrice;
        ArrayList<Integer>details=new ArrayList<>();
        details.add(ProductQTY);
        details.add(ProductPrice);
        product.put(ProductID,details);
    }




    public static void LoggedinSuccess()
    {
        System.out.println("Logged IN");
    }
    public static void Error()
    {
        System.out.println("Error has occured!");
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        Product product = new Product();
        Customer customer= new Customer();

        int AdminID;
        int AdminPWD;
        System.out.println("-----------------------------------");
        System.out.println("Enter Admin ID: ");
        AdminID=sc.nextInt();
        System.out.println("Enter Admin Password: ");
        AdminPWD=sc.nextInt();

        if(AdminID==AdminPWD && AdminID==12345)
        {
            LoggedinSuccess();
            boolean created=false;

            while(!created)
            {
               String CustomerEmail;
               int CustomerID;
               String CustomerPWD;
               System.out.println("Enter Customer Email:");
               CustomerEmail=sc.next();
               System.out.println("Enter Customer ID:");
               CustomerID=sc.nextInt();
               System.out.println("Enter Customer Password:");
               CustomerPWD=sc.next();
               CustomerCreate(CustomerEmail,CustomerID,CustomerPWD);
               created=true;
            }

            while(true)
            {
                System.out.println("1: Create Product: ");
                System.out.println("2: View Product Details: ");
                System.out.println("3: Exit");

                int choice=sc.nextInt();
                if(choice==1)
                {
                    int ProductID = 0,ProductQTY=0,ProductPrice=0;

                    CreateProduct(ProductID,ProductQTY,ProductPrice);

                }
                else if(choice==2)
                {


                }
                else if(choice==3)
                {
                    break;
                }
                else{
                    Error();
                }
//                System.out.println(product);
            }

        }
        else {
            Error();
        }


    }
}
