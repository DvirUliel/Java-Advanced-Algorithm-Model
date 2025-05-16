package AlgorithmModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analyzes a list of numeric values using the prefix sum technique.
 * Finds the longest subarray whose elements sum to a given target.
 * Utilizes a HashMap to track prefix sums in linear time (O(n)).
 */
public class PrefixSumAnalyzer extends AbstractSubarrayAnalyzer {

    private final double target;

    public PrefixSumAnalyzer(double target) {
        super("PrefixSum");
        this.target = target;
    }

    @Override
    public SubarrayResult analyze(List<Double> values) {
        Map<Double, Integer> prefixMap = new HashMap<>();
        double sum = 0;
        int maxLength = 0;
        int start = 0, end = -1;

        prefixMap.put(0.0, -1); // Allow subarrays that start at index 0

        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);

            // When the map already has this sum, it means we found a bigger continuous portion for the algorithm
            if (prefixMap.containsKey(sum - target)) {
                int prevIndex = prefixMap.get(sum - target);
                if (i - prevIndex > maxLength) {
                    maxLength = i - prevIndex;
                    start = prevIndex + 1;
                    end = i;
                }
            }

            prefixMap.putIfAbsent(sum, i);
        }

        if (end == -1) return new SubarrayResult(-1, -1, 0);
        return new SubarrayResult(start, end, target);
    }
}