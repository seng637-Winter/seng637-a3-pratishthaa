//package org.jfree.data.test;
package org.jfree.data;
import static org.junit.Assert.*;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.*;


public class DataUtilitiesCreateNumberArrayTest {
	
	private final Number[] expected = {1.0, 2.5, 3.7, 4.2}; // Expected output
	
	
	@Test
    public void testCreateNumberArrayWithBottomLimitBoundary() {
        double[] testData = {Double.MIN_VALUE}; // Smallest positive nonzero value
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }

	 @Test
    public void testCreateNumberArrayWithLowerBoundary() {
        double[] testData = {-1.0, 0.0, 1.0}; // Example low values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCreateNumberArrayWithAdjustedLowerBoundary() {
        double[] testData = {-10.5, -5.0, -1.0}; // Example negative values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    @Test
    public void testCreateNumberArrayWithSameValues() {
        // Input array containing repeated values
        double[] testData = {1.0, 1.0, 1.0, 1.0};
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }


    @Test
    public void testCreateNumberArrayWithUpperBoundary() {
        double[] testData = {Double.MAX_VALUE - 1.0, Double.MAX_VALUE}; // Example high values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCreateNumberArrayWithUpperLimitBoundary() {
        double[] testData = {Double.MAX_VALUE}; // Largest positive finite value
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCreateNumberArrayWithAdjustedUpperBoundary() {
        double[] testData = {1.0e100, 1.0e200}; // Example very large values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
	
    @Test
    public void testCreateNumberArrayValidInput() {
        double[] testData = {1.0, 2.5, 3.7, 4.2}; // similar input data
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    @Test
    public void testCreateNumberArrayWithNominalValues() {
        double[] testData = {10.0, 20.5, 30.7, 40.2}; // Typical values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    
     @Test
    public void testCreateNumberArrayEmptyInput() { //passed
        double[] testData = {}; // Empty array
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertEquals(0, result.length);
    }
    @Test
    public void testCreateNumberArrayWithMixedValues() {
        double[] testData = {-1.0, 2.5, 0.0, 4.2}; // Mixed positive and negative values
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCreateNumberArrayWithLargeInput() {
        // Large input array with repeated values
        double[] testData = new double[1000];
        Arrays.fill(testData, 1.0);
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(new Number[1000], result);
    }

    @Test
    public void testCreateNumberArrayWithZeroValues() {
        // Input array containing only zeros
        double[] testData = {0.0, 0.0, 0.0, 0.0};
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    @Test
    public void testCreateNumberArrayWithSingleElement() {
        // Input array with a single element
        double[] testData = {10.0};
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    @Test
    public void testCreateNumberArrayWithNaN() {
        // Input array containing NaN (Not-a-Number)
        double[] testData = {Double.NaN, 2.5, 3.7, 4.2};
        
        Number[] result = DataUtilities.createNumberArray(testData);
        
        assertArrayEquals(expected, result);
    }
    //my test cases has 100 % coverage before, No misses !!!!
    //some more test cases 
    @Test
    public void testCreateNumberArrayWithNonNumericValues() {
        double[] testData = {1.0, Double.POSITIVE_INFINITY, 3.7, Double.NEGATIVE_INFINITY};

        Number[] result = DataUtilities.createNumberArray(testData);

        assertEquals(1.0, result[0].doubleValue(), 0.001);
        assertEquals(Double.POSITIVE_INFINITY, result[1].doubleValue(), 0.001);
        assertEquals(3.7, result[2].doubleValue(), 0.001);
        assertEquals(Double.NEGATIVE_INFINITY, result[3].doubleValue(), 0.001);
    }

    @Test
    public void testCreateNumberArrayWithSingleNaN() {
        double[] testData = {Double.NaN};

        Number[] result = DataUtilities.createNumberArray(testData);

        assertTrue(Double.isNaN(result[0].doubleValue()));
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}

    

