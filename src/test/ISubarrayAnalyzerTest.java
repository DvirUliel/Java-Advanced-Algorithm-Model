package test;

import AlgorithmModule.ISubarrayAnalyzer;
import AlgorithmModule.KadaneAnalyzer;
import AlgorithmModule.PrefixSumAnalyzer;
import AlgorithmModule.SubarrayResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ISubarrayAnalyzerTest {

    // ─────────────── Kadane Tests ───────────────

    /**
     * Mixed values.
     * Expected: subarray with max sum is [3.0, -1.0, 4.0] → sum = 6.0
     */
    @Test
    public void testKadaneAnalyzer() {
        ISubarrayAnalyzer analyzer = new KadaneAnalyzer();
        List<Double> input = Arrays.asList(-2.0, 3.0, -1.0, 4.0, -5.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals("Kadane", analyzer.getName());
        assertEquals(1, result.getStartIndex());
        assertEquals(3, result.getEndIndex());
        assertEquals(6.0, result.getTotal(), 0.001);
    }

    /**
     * All numbers are negative.
     * Expected: the least negative number is selected as the max subarray.
     */
    @Test
    public void testKadaneAllNegative() {
        ISubarrayAnalyzer analyzer = new KadaneAnalyzer();
        List<Double> input = Arrays.asList(-5.0, -1.0, -8.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(1, result.getStartIndex());
        assertEquals(1, result.getEndIndex());
        assertEquals(-1.0, result.getTotal(), 0.001);
    }

    /**
     * Single positive element.
     * Expected: that single value is the result.
     */
    @Test
    public void testKadaneSingleElement() {
        ISubarrayAnalyzer analyzer = new KadaneAnalyzer();
        List<Double> input = List.of(7.5);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(0, result.getStartIndex());
        assertEquals(0, result.getEndIndex());
        assertEquals(7.5, result.getTotal(), 0.001);
    }

    /**
     * Max subarray is in the middle, not at start or end.
     * Expected: [4.0, -1.0, 2.0, 1.0] → sum = 6.0
     */
    @Test
    public void testKadaneMaxInMiddle() {
        ISubarrayAnalyzer analyzer = new KadaneAnalyzer();
        List<Double> input = Arrays.asList(-2.0, 1.0, -3.0, 4.0, -1.0, 2.0, 1.0, -5.0, 4.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(3, result.getStartIndex());
        assertEquals(6, result.getEndIndex());
        assertEquals(6.0, result.getTotal(), 0.001);
    }
    /**
     * Empty list and target 0.
     * Expected: return (-1, -1)
     */
    @Test
    public void testKadaneEmptyList() {
        ISubarrayAnalyzer analyzer = new KadaneAnalyzer();
        List<Double> input = Collections.emptyList();
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(-1, result.getStartIndex());
        assertEquals(-1, result.getEndIndex());
        assertEquals(0.0, result.getTotal(), 0.001);
    }

    // ─────────────── Prefix Sum Tests ───────────────

    /**
     * Sum equals to 0 across the entire array.
     * Expected: subarray from index 0 to 4 sums to 0
     */
    @Test
    public void testPrefixSumZeroTarget() {
        ISubarrayAnalyzer analyzer = new PrefixSumAnalyzer(0);
        List<Double> input = Arrays.asList(2.0, -2.0, 3.0, 1.0, -4.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals("PrefixSum", analyzer.getName());
        assertEquals(0, result.getStartIndex());
        assertEquals(4, result.getEndIndex());
        assertEquals(0.0, result.getTotal(), 0.001);
    }

    /**
     * All numbers are zero and target is 0.
     * Expected: longest subarray is full list
     */
    @Test
    public void testPrefixAllZeros() {
        ISubarrayAnalyzer analyzer = new PrefixSumAnalyzer(0);
        List<Double> input = Arrays.asList(0.0, 0.0, 0.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(0, result.getStartIndex());
        assertEquals(2, result.getEndIndex());
        assertEquals(0.0, result.getTotal(), 0.001);
    }

    /**
     * No subarray summing to target (0).
     * Expected: return (-1, -1) indicating no result found
     */
    @Test
    public void testPrefixNoZeroSum() {
        ISubarrayAnalyzer analyzer = new PrefixSumAnalyzer(0);
        List<Double> input = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(-1, result.getStartIndex());
        assertEquals(-1, result.getEndIndex());
        assertEquals(0.0, result.getTotal(), 0.001);
    }

    /**
     * Empty list and target 0.
     * Expected: return (-1, -1)
     */
    @Test
    public void testPrefixEmptyList() {
        ISubarrayAnalyzer analyzer = new PrefixSumAnalyzer(0);
        List<Double> input = Collections.emptyList();
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(-1, result.getStartIndex());
        assertEquals(-1, result.getEndIndex());
        assertEquals(0.0, result.getTotal(), 0.001);
    }

    /**
     * Target sum (5.0).
     * Expected: subarray [2.0, 3.0] or similar gives total = 5.0
     */
    @Test
    public void testPrefixCustomTarget() {
        ISubarrayAnalyzer analyzer = new PrefixSumAnalyzer(5.0);
        List<Double> input = Arrays.asList(1.0, 2.0, 2.0, 3.0);
        SubarrayResult result = analyzer.analyze(input);

        assertEquals(0, result.getStartIndex());
        assertEquals(2, result.getEndIndex());
        assertEquals(5.0, result.getTotal(), 0.001);
    }
}