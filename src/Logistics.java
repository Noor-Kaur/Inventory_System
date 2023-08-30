import java.util.ArrayList;

public class Logistics extends Customer
{
    public int ProductID;
    public int CustomerID;
    public boolean Dispatch;
    public boolean Delivered;
    public int DeliveryID;

    public ArrayList<Integer> LogisticStatus(int CustomerID)
    {
        ArrayList<Integer>arr=new ArrayList<>();

        return arr;
    }
    public Logistics(int CustomerID)
    {
        this.CustomerID=CustomerID;
    }
   public  Logistics (int CustomerID, int ProductID)
   {
       this.CustomerID=CustomerID;
       this.ProductID=ProductID;
   }
   public  void ShowLogistics()
   {
       System.out.println("The customer with ID: "+CustomerID+" bought the Product with ID+ "+ProductID);
   }
}
