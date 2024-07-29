package DependencyPattern;

public class DependencyInjectionTest {

    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService via constructor
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to get customer details
        Customer customer = customerService.getCustomer("12345");

        // Display customer details
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}
