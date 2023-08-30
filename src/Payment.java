public class Payment
{
    private  int CustomerID;
    public int total;
    public int ProductID;
    public int ProductQTY;
    public int ProductPrice;

//    public Payment(int productIDbyCustomer, int productQTYbyCustomer, int productDefaultprice) {
//    }

    public   Payment(int ProductID,int ProductQTY, int ProductPrice)
    {

        this.CustomerID=CustomerID;
        this.ProductID=ProductID;
        this.ProductQTY=ProductQTY;
        this.ProductPrice=ProductPrice;

    }
    public void showBILL()
    {
        try
        {
            int total=ProductQTY*ProductPrice;
            System.out.println("The total amount to be Pay is: "+total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Total can't be zero if Product is bought");
        }
    }


}
