package AlgorithmModule;

/**
 * Represents the result of analyzing a subarray,
 * which is a continuous portion of an array without gaps.
 */
public class SubarrayResult {
    private int startIndex; // the index where the subarray starts (inclusive)
    private int endIndex; // the index where the subarray ends (inclusive)
    private double total; //  the total sum of values in the subarray

    public SubarrayResult(int startIndex, int endIndex, double total) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.total = total;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "StartIndex: " + startIndex + ", EndIndex: " + endIndex + ", Total: " + total;
    }
}