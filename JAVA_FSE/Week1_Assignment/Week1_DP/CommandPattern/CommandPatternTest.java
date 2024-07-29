package CommandPattern;

public class CommandPatternTest {

    public static void main(String[] args) {
        // Create receiver
        Light light = new Light();

        // Create concrete commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

