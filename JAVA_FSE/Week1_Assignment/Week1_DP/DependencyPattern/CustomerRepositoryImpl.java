package DependencyPattern;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(String id) {
        // Simulate fetching customer from a database
        return new Customer(id, "John Doe");
    }
}

