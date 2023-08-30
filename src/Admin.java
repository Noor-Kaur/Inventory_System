import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Customer {
    public String CustomerEmail;
    public int CustomerID;
    public String CustomerPWD;
    public int ProductID;
    public int ProductQTY;
    public int ProductPrice;
    public boolean Delivered;
    public static boolean customersuccess = false;
    public static boolean boughtproduct = false;
    public int globalCustomer=0;
    static ArrayList<ArrayList<String>> arr = new ArrayList<>();
    //customers
    static HashMap<Integer, ArrayList<Integer>> productdetials = new HashMap<>();
    //products, hashmap of  int of arraylist
    // int-> productid
    // arraylist -> 1: productqty, 2: prodcutprice

    Customer customer = new Customer();
    //inheritance


    public static void CustomerCreate(String CustomerEmail, int CustomerID, String CustomerPWD) {
        CustomerEmail = CustomerEmail;
        CustomerID = CustomerID;
        CustomerPWD = CustomerPWD;
        ArrayList<String> curr = new ArrayList<>();
        curr.add(CustomerEmail);
        curr.add(Integer.toString(CustomerID));
        curr.add(CustomerPWD);
        arr.add(curr);
        System.out.println("User has successfully Created");
    }

    public static void CreateProduct(int ProductID, int ProductQTY, int ProductPrice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ProductID: ");
        ProductID = sc.nextInt();
        System.out.println("Product Quantity");
        ProductQTY = sc.nextInt();
        System.out.println("Product Price: ");
        ProductPrice = sc.nextInt();
        ProductID = ProductID;
        ProductQTY = ProductQTY;
        ProductPrice = ProductPrice;
        ArrayList<Integer> details = new ArrayList<>();
        details.add(ProductQTY);
        details.add(ProductPrice);
        productdetials.put(ProductID, details);
        boughtproduct = true;
    }

    public static void WelcomeCustomer() {
        Scanner sc = new Scanner(System.in);
        String CustomerEmail = "";
        int CustomerID = 0;
        String CustomerPWD = "";
        System.out.println("Enter your Customer Login Details");
        System.out.println("Customer ID: ");
        CustomerID = sc.nextInt();
        System.out.println("Customer Password: ");
        CustomerPWD = sc.next();
        CustomerAuthLogin(CustomerID, CustomerPWD);
    }

    public static boolean CustomerAuthLogin(int CustomerID, String CustomerPWD) {
        for (ArrayList<String> ent : arr) {


            if (Integer.parseInt(ent.get(1)) == (CustomerID) && ent.get(2).equals(CustomerPWD)) {
                System.out.println("Customer " + ent.get(1) + " Logged in");
                customersuccess = true;
                return true;
            }
            else
            {
                System.out.println("Wrong credentials");
            }
        }
        return false;
    }

    public static void WanttoBuy() {
        Scanner sc = new Scanner(System.in);
        int ProductIDbyCustomer = 0, ProductQTYbyCustomer = 0;
        System.out.println("Enter ProductID: ");
        ProductIDbyCustomer = sc.nextInt();
        System.out.println("Enter Product Quantity");
        ProductQTYbyCustomer = sc.nextInt();
        int ProductDefaultprice=0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : productdetials.entrySet()) {
            int ProductID = entry.getKey();
            if (ProductID == ProductIDbyCustomer) {
                ArrayList<Integer> values = entry.getValue();
                //                         200-50=150
                int ProductQTYupdate = values.get(0) - ProductQTYbyCustomer;
                if (ProductQTYupdate < 0) {
                    System.out.println("Not Sufficient Quantity");
                    return;
                }
                int ProductPrice = values.get(1);
                ProductDefaultprice=ProductPrice;
                values.clear();
                values.add(ProductQTYupdate);
                values.add(ProductPrice);
                productdetials.put(ProductID, values);
                boughtproduct = true;
//                showPrice(ProductID,ProductQTYbyCustomer,ProductPrice);
                Payment paymeny= new Payment(ProductIDbyCustomer,ProductQTYbyCustomer,ProductDefaultprice);
                paymeny.showBILL();

                return;
            } else {
                System.out.println("No Such Product is available");
            }
        }
    }

    public static void ShowProductLIST() {
        System.out.println("ProductID \t Product Quantity \t  Product Price");
        for (Map.Entry<Integer, ArrayList<Integer>> entry : productdetials.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer> values = entry.getValue();

            System.out.print(key + "\t              " + values.get(0) + "\t                  " + values.get(1));

            System.out.println();
        }
    }

    public static void showPrice(int ProductID,int ProductQTYbyCustomer,int ProductPrice) {
        int total = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : productdetials.entrySet()) {
            {
                int currproduct = entry.getKey();
                if (currproduct == ProductID) {
                    total = ProductQTYbyCustomer * ProductPrice;
                    System.out.println("Your Total is: "+total);
                    System.out.println();
                    return;
                }
            }
        }
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


        int runone=1;
        int AdminID = 0;
        int AdminPWD=0;
        System.out.println("-----------------------------------");
//        System.out.println("Enter Admin ID: ");
//        AdminID=sc.nextInt();
//        System.out.println("Enter Admin Password: ");
//        AdminPWD=sc.nextInt();

       try
       {
           System.out.println("Enter Admin ID: ");
           AdminID=sc.nextInt();
           System.out.println("Enter Admin Password: ");
           AdminPWD=sc.nextInt();
       }
       catch (Exception e)
       {
           System.out.println("Admin ID and Admin Password has to be Integer");
           return;
       }





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

               Logistics logistics =new Logistics(CustomerID);
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
                    System.out.println("ProductID \t Product Qunaity \t  Product Price");
                    for (Map.Entry<Integer, ArrayList<Integer>> entry : productdetials.entrySet()) {
                        Integer key = entry.getKey();
                        ArrayList<Integer> values = entry.getValue();

                        System.out.print(key+"\t              "+values.get(0)+"\t                   "+values.get(1) );

                        System.out.println();
                    }

                }
                else if(choice==3)
                {
                    break;
                }
                else{
                    Error();
                }

            }

        }
        else {
            Error();
        }

        WelcomeCustomer();
        if(customersuccess)
        {

            System.out.println("ProductID \t Product Quantity \t  Product Price");
            for (Map.Entry<Integer, ArrayList<Integer>> entry : productdetials.entrySet()) {
                Integer key = entry.getKey();
                ArrayList<Integer> values = entry.getValue();

                System.out.print(key+"\t              "+values.get(0)+"\t                  "+values.get(1) );

                System.out.println();
            }
            System.out.println("Want to buy some Products 1 or 2 EXIT ");
            int choice=0;
            while(true)
            {
                choice=sc.nextInt();
                if(choice==1)
                {
                    System.out.println("started");
                    WanttoBuy();
                    if(boughtproduct)
                    {
                        ShowProductLIST();

                    }
                }
                else
                {
                    break;
                }
            }
        }



    }
}
