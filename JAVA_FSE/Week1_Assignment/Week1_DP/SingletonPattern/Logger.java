public class Logger {

    // Step 2.1: Create a private static instance of the Logger class
    private static Logger instance;

    // Step 2.2: Make the constructor private
    private Logger() {
        // Private constructor to prevent instantiation
    }

    // Step 2.3: Provide a public static method to get the instance of the Logger class
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
