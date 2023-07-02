import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price;
    }
}

class ProductManagementSystem {
    private List<Product> products;
    boolean loggedIn;

    public ProductManagementSystem() {
        products = new ArrayList<>();
        loggedIn = false;
    }

    public void login() {
        loggedIn = true;
        System.out.println("Logged in successfully!");
    }

    public void logout() {
        loggedIn = false;
        System.out.println("Logged out successfully!");
    }

    public void addProduct(Product product) {
        if (loggedIn) {
            products.add(product);
            System.out.println("Product added successfully!");
        } else {
            System.out.println("You must be logged in to add a product.");
        }
    }

    public void editProduct(String productName, String newName, double newPrice) {
        if (loggedIn) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    product.setName(newName);
                    product.setPrice(newPrice);
                    System.out.println("Product edited successfully!");
                    return;
                }
            }
            System.out.println("Product not found.");
        } else {
            System.out.println("You must be logged in to edit a product.");
        }
    }

    public void deleteProduct(String productName) {
        if (loggedIn) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    products.remove(product);
                    System.out.println("Product deleted successfully!");
                    return;
                }
            }
            System.out.println("Product not found.");
        } else {
            System.out.println("You must be logged in to delete a product.");
        }
    }

    public void searchProduct(String productName) {
        if (loggedIn) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    System.out.println("Product found: " + product);
                    return;
                }
            }
            System.out.println("Product not found.");
        } else {
            System.out.println("You must be logged in to search for a product.");
        }
    }

    public void displayProducts() {
        if (loggedIn) {
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("You must be logged in to display the product list.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ProductManagementSystem pms = new ProductManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Product Management System");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Add Product");
            System.out.println("4. Edit Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Search Product");
            System.out.println("7. Display Products");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    pms.login();
                    break;
                case "2":
                    pms.logout();
                    break;
                case "3":
                    if (pms.loggedIn) {
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        Product product = new Product(name, price);
                        pms.addProduct(product);
                    } else {
                        System.out.println("You must be logged in to add a product.");
                    }
                    break;
                case "4":
                    if (pms.loggedIn) {
                        System.out.print("Enter product name to edit: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter new product name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new product price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        pms.editProduct(productName, newName, newPrice);
                    } else {
                        System.out.println("You must be logged in to edit a product.");
                    }
                    break;
                case "5":
                    if (pms.loggedIn) {
                        System.out.print("Enter product name to delete: ");
                        String productName = scanner.nextLine();
                        pms.deleteProduct(productName);
                    } else {
                        System.out.println("You must be logged in to delete a product.");
                    }
                    break;
                case "6":
                    if (pms.loggedIn) {
                        System.out.print("Enter product name to search: ");
                        String productName = scanner.nextLine();
                        pms.searchProduct(productName);
                    } else {
                        System.out.println("You must be logged in to search for a product.");
                    }
                    break;
                case "7":
                    pms.displayProducts();
                    break;
                case "8":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (!choice.equals("8"));

        scanner.close();
    }
}