package AlgorithmModule;

import java.util.List;

/**
 * Interface for subarray analysis algorithms.
 * Defines the contract for analyzing numeric sequences and retrieving algorithm names.
 */
public interface ISubarrayAnalyzer {
    SubarrayResult analyze(List<Double> values); // core logic
    String getName(); // algorithm name
}