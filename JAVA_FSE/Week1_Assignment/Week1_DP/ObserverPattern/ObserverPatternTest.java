package ObserverPattern;

public class ObserverPatternTest {

    public static void main(String[] args) {
        // Create stock market and observers
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        stockMarket.setStockPrice(120.50);
        stockMarket.setStockPrice(125.75);
    }
}
