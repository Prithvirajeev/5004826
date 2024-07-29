package BuilderPattern;

public class BuilderPatternTest {

    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        
        // Basic configuration
        Computer basicComputer = new Computer.Builder("Intel i5", 8)
            .build();

        // Computer with all optional attributes
        Computer advancedComputer = new Computer.Builder("AMD Ryzen 7", 16)
            .setStorage(512)
            .setGraphicsCardIncluded(true)
            .setBluetoothEnabled(true)
            .build();

        // Print out the configurations
        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Advanced Computer: " + advancedComputer);
    }
}

