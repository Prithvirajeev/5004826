import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ECommerceSearch {

    public static class Product {
        private String productId;
        private String productName;
        private String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters and setters
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId='" + productId + '\'' +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    public static class SearchAlgorithms {

        public static Product linearSearch(Product[] products, String targetProductId) {
            for (Product product : products) {
                if (product.getProductId().equals(targetProductId)) {
                    return product;
                }
            }
            return null;
        }

        public static Product binarySearch(Product[] products, String targetProductId) {
            Arrays.sort(products, Comparator.comparing(Product::getProductId)); // Ensure the array is sorted
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].getProductId().compareTo(targetProductId);

                if (comparison == 0) {
                    return products[mid];
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Mouse", "Electronics"),
            new Product("103", "Keyboard", "Electronics"),
            new Product("104", "Monitor", "Electronics"),
            new Product("105", "Printer", "Electronics")
        };

        System.out.println("Choose search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Product ID to search: ");
        String targetProductId = scanner.nextLine();

        Product result = null;
        if (choice == 1) {
            result = SearchAlgorithms.linearSearch(products, targetProductId);
        } else if (choice == 2) {
            result = SearchAlgorithms.binarySearch(products, targetProductId);
        } else {
            System.out.println("Invalid choice!");
        }

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found!");
        }

        scanner.close();
    }
}

