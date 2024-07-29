package BuilderPattern;

public class Computer {
    // Required attributes
    private final String CPU;
    private final int RAM;

    // Optional attributes
    private final int storage;
    private final boolean isGraphicsCardIncluded;
    private final boolean isBluetoothEnabled;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGraphicsCardIncluded = builder.isGraphicsCardIncluded;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", isGraphicsCardIncluded=" + isGraphicsCardIncluded +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final int RAM;

        // Optional attributes
        private int storage = 0; // default value
        private boolean isGraphicsCardIncluded = false; // default value
        private boolean isBluetoothEnabled = false; // default value

        // Builder constructor
        public Builder(String CPU, int RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Setter methods for optional attributes
        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCardIncluded(boolean isGraphicsCardIncluded) {
            this.isGraphicsCardIncluded = isGraphicsCardIncluded;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method
        public Computer build() {
            return new Computer(this);
        }
    }
}
