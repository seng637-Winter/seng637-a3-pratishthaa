package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangegetCentralValueTest {

	private static final double EPSILON = 0.0001;

    @Test
    public void testGetCentralValueEvenLength() {
        // Test case for even length range
        Range range = new Range(1.0, 10.0);

        // Central value for even length range is the average of start and end
        double expectedCentralValue = (1.0 + 10.0) / 2.0;

        // Verify the central value
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueOddLength() {
        // Test case for odd length range
        Range range = new Range(1.0, 9.0);

        // Central value for odd length range is the middle value
        double expectedCentralValue = 5.0;

        // Verify the central value
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueSingleValue() {
        // Test case for single value range
        Range range = new Range(5.0, 5.0);

        // Central value for a single value range is the value itself
        double expectedCentralValue = 5.0;

        // Verify the central value
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueNegativeRange() {
        // Test case for negative range
        Range range = new Range(-5.0, 5.0);

        // Central value for negative range
        double expectedCentralValue = 0.0;

        // Verify the central value
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }
    
    @Test
    public void testGetCentralValueNegativeOddLength() {
        // Test case for negative odd length range
        Range range = new Range(-9.0, -1.0);
        double expectedCentralValue = -5.0;
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueZeroRange() {
        // Test case for zero range
        Range range = new Range(0.0, 0.0);
        double expectedCentralValue = 0.0;
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueLargeRange() {
        // Test case for large range
        Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        double expectedCentralValue = Double.MAX_VALUE / 2.0;
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }

    @Test
    public void testGetCentralValueSymmetricRange() {
        Range range = new Range(-2.5, 2.5);
        double expectedCentralValue = 0.0;
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }
    @Test
    public void testGetCentralValueWithNaN() {
        // Test case for a range involving NaN
        Range range = new Range(Double.NaN, 10.0);
        // Central value involving NaN should result in NaN
        double expectedCentralValue = Double.NaN;
        assertEquals(expectedCentralValue, range.getCentralValue(), EPSILON);
    }
   

   
}
    


