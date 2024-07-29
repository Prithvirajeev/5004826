package Exercise4;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[--count];
                employees[count] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee("E001", "Alice", "Manager", 70000));
        ems.addEmployee(new Employee("E002", "Bob", "Developer", 50000));
        ems.addEmployee(new Employee("E003", "Charlie", "Designer", 60000));

        System.out.println("All employees:");
        ems.traverseEmployees();

        System.out.println("Search for employee E002:");
        System.out.println(ems.searchEmployee("E002"));

        System.out.println("Delete employee E002:");
        ems.deleteEmployee("E002");

        System.out.println("All employees after deletion:");
        ems.traverseEmployees();
    }
}

