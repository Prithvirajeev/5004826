package Exercise7;
import java.util.HashMap;
import java.util.Map;

public class FinancialForecastingOptimized {

    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value with memoization
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        // Base case: if years is 0, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Check if result is already computed and stored in the map
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        // Recursive case: calculate the future value for one less year and apply growth rate
        double result = calculateFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
        // Store the result in the map before returning
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Current value
        double annualGrowthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years to predict

        double futureValue = calculateFutureValue(currentValue, annualGrowthRate, years);
        System.out.println("The future value after " + years + " years is: " + futureValue);
    }
}

