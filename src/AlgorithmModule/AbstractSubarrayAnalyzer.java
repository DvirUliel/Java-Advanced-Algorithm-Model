package AlgorithmModule;

import java.util.List;

/**
 * Abstract base class for subarray analyzers.
 * Storing the algorithm's name.
 * Implement the analyze method to define their specific logic.
 */
public abstract class AbstractSubarrayAnalyzer implements ISubarrayAnalyzer {
    protected String name;

    public AbstractSubarrayAnalyzer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract SubarrayResult analyze(List<Double> values);
}