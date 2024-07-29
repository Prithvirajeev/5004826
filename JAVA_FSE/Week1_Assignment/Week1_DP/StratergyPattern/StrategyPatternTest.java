package StratergyPattern;

public class StrategyPatternTest {

    public static void main(String[] args) {
        // Create a payment context
        PaymentContext paymentContext = new PaymentContext();

        // Set payment strategy to Credit Card and execute payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("John Doe", "1234-5678-9876-5432");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100.0);

        // Set payment strategy to PayPal and execute payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.0);
    }
}
