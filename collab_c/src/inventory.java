import java.util.ArrayList;
import java.util.List;

public class inventory {
    private List<product> products;

    public inventory() {
        products = new ArrayList<>();
    }

    public void addproduct(product product) {
        products.add(product);
    }

    public List<product> getproducts() {
        return products;
    }

    public product getProductById(int productId) {
        for (product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void displayStockAndCustomers(List<customer> customers) {
        System.out.println("Stock Information:");
        for (product p : products) {
            System.out.println(p.getName() + " - Stock: " + p.getQuantity());
        }

        System.out.println("Customer List:");
        for (customer c : customers) {
            System.out.println("Username: " + c.getUsername());
        }
    }
}
