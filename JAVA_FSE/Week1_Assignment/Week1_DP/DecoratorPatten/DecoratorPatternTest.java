package DecoratorPatten;

public class DecoratorPatternTest {

    public static void main(String[] args) {
        // Create a basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the EmailNotifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate the EmailNotifier with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        // Test sending notifications
        System.out.println("Basic Email Notification:");
        emailNotifier.send("Hello World!");

        System.out.println("\nEmail + SMS Notification:");
        smsNotifier.send("Hello World!");

        System.out.println("\nEmail + Slack Notification:");
        slackNotifier.send("Hello World!");
    }
}

