import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithmsBinary {

    public static Product binarySearch(Product[] products, String targetProductId) {
        Arrays.sort(products, Comparator.comparing(Product::getProductId)); // Ensure the array is sorted
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetProductId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

