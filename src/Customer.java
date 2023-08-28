
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
    public static  void BuysProduct(int CustomerID,int ProductID){};
    public static  void main2()
    {
        System.out.println(product.ProductID);
    }

}
