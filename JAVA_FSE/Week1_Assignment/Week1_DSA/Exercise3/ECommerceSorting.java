import java.util.Scanner;

public class ECommerceSorting {

    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        // Getters and setters
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId='" + orderId + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    public static class BubbleSort {

        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        // Swap orders[j] and orders[j+1]
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static class QuickSort {

        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);

                quickSort(orders, low, pi - 1);  // Recursively sort elements before partition
                quickSort(orders, pi + 1, high); // Recursively sort elements after partition
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            Order pivot = orders[high];
            int i = (low - 1);  // Index of smaller element

            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() < pivot.getTotalPrice()) {
                    i++;

                    // Swap orders[i] and orders[j]
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }

            // Swap orders[i+1] and orders[high] (or pivot)
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;

            return i + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Order[] orders = {
            new Order("101", "Alice", 250.75),
            new Order("102", "Bob", 150.50),
            new Order("103", "Charlie", 300.00),
            new Order("104", "David", 100.25),
            new Order("105", "Eve", 200.10)
        };

        System.out.println("Choose sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            BubbleSort.bubbleSort(orders);
        } else if (choice == 2) {
            QuickSort.quickSort(orders, 0, orders.length - 1);
        } else {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }

        System.out.println("Sorted orders by totalPrice:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}

