import java.util.ArrayList;

public class Customer extends Product
{
    public int CustomerID;
    public boolean DoesBuy;
    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }
    static Product product=new Product();
    int ProductID=product.getProductID();
    public static  void BuysProduct(){};


    public ArrayList<Integer> DoesBuy(int CustomerID, int ProductID)
    {
        ArrayList<Integer>detail=new ArrayList<>();
        detail.add(CustomerID);
        detail.add(ProductID);
        return detail;
    }

}
