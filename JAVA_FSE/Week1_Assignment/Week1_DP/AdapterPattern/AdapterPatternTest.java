package AdapterPattern;

public class AdapterPatternTest {

    public static void main(String[] args) {
        // Create instances of third-party payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();

        // Create adapters for the payment processors
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Test the adapters
        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }

    private static class Stripe {

        public Stripe() {
        }
    }
}

