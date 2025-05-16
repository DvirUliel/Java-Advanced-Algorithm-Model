package AlgorithmModule;

import java.util.List;

/**
 * Analyzes a list of numeric values using Kadane's algorithm.
 * Finds the subarray (continuous segment) with the maximum possible sum.
 * This implementation runs in linear time (O(n)).
 */
public class KadaneAnalyzer extends AbstractSubarrayAnalyzer {

    public KadaneAnalyzer() {
        super("Kadane");
    }

    @Override
    public SubarrayResult analyze(List<Double> values) {
        if (values == null || values.isEmpty()) {
            return new SubarrayResult(-1, -1, 0.0);
        }

        double maxSum = Double.NEGATIVE_INFINITY;
        double currentSum = 0;
        int start = 0; // Start index
        int tempStart = 0; // Keep the index when we reset currentSum and change the value of "start"
        int end = 0; // End index

        for (int i = 0; i < values.size(); i++) {
            currentSum += values.get(i);

            // Always update the maxSum to be the max sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            // Reset when currentSum isn't positive
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        return new SubarrayResult(start, end, maxSum);
    }
}