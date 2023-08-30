import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample products
        product product1 = new product(1, "Product 1", 10.99, 20);
        product product2 = new product(2, "Product 2", 20.49, 15);

        // Add products to inventory
        inventory inventory = new inventory();
        inventory.addproduct(product1);
        inventory.addproduct(product2);

        System.out.println("Welcome to the Inventory Management System!");
        System.out.println("Are you an admin or a customer? (admin/customer): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("admin")) {
            System.out.println("Admin Dashboard");
            List<customer> customers = new ArrayList<>();
            customers.add(new customer("avi", "password123"));
            customers.add(new customer("jatin", "secret456"));
            inventory.displayStockAndCustomers(customers);
        } else if (userType.equalsIgnoreCase("customer")) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            customer customer = new customer(username, password);

            // Display available products
            List<product> products = inventory.getproducts();
            System.out.println("Available Products:");
            for (product p : products) {
                System.out.println(p.getId() + ". " + p.getName() + " - Rs" + p.getPrice() + " (Stock: " + p.getQuantity() + ")");
            }

            // Customer selects a product
            System.out.println("Enter the ID of the product you want to buy: ");
            int productId = scanner.nextInt();
            product selectedProduct = inventory.getProductById(productId);

            if (selectedProduct != null) {
                System.out.println("You have selected: " + selectedProduct.getName());

                // Customer selects quantity
                System.out.println("Enter the quantity you want to buy: ");
                int quantityToBuy = scanner.nextInt();

                if (quantityToBuy > 0 && quantityToBuy <= selectedProduct.getQuantity()) {
                    // Update stock and display confirmation
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - quantityToBuy);
                    System.out.println("Purchase successful! Remaining stock: " + selectedProduct.getQuantity());


                    inventory.displayStockAndCustomers(new ArrayList<>());
                } else {
                    System.out.println("Invalid quantity or insufficient stock.");
                }
            } else {
                System.out.println("Invalid product ID.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
