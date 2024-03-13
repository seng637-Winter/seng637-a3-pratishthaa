package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class RangeContainsMethodTest{

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("These tests are related to the Contains method of the Range class.");
    }

    @Before
    public void setUp() throws Exception {}

    @Test
    public void testContains_PositiveRange_ReturnsCorrectValue() {
        Range range = new Range(1.0, 10.0);
        boolean result = range.contains(5.0);
        assertTrue(result);
    }

    @Test
    public void testContains_PositiveRange_ReturnsFalseForValueLessThanMin() {
        Range range = new Range(1.0, 10.0);
        boolean result = range.contains(0.0);
        assertFalse(result);
    }

    @Test
    public void testContains_PositiveRange_ReturnsFalseForValueGreaterThanMax() {
        Range range = new Range(1.0, 10.0);
        boolean result = range.contains(11.0);
        assertFalse(result);
    }

    @Test
    public void testContains_NegativeRange_ReturnsCorrectValue() {
        Range range = new Range(-10.0, -1.0);
        boolean result = range.contains(-5.0);
        assertTrue(result);
    }

    @Test
    public void testContains_NegativeRange_ReturnsFalseForValueLessThanMin() {
        Range range = new Range(-10.0, -1.0);
        boolean result = range.contains(-11.0);
        assertFalse(result);
    }

    @Test
    public void testContains_NegativeRange_ReturnsFalseForValueGreaterThanMax() {
        Range range = new Range(-10.0, -1.0);
        boolean result = range.contains(0.0);
        assertFalse(result);
    }

    @Test
    public void testContains_ZeroRange_ReturnsCorrectValue() {
        Range range = new Range(0.0, 0.0);
        boolean result = range.contains(0.0);
        assertTrue(result);
    }

    @Test
    public void testContains_ZeroRange_ReturnsFalseForNonZeroValue() {
        Range range = new Range(0.0, 0.0);
        boolean result = range.contains(1.0);
        assertFalse(result);
    }
// New
    
    @Test
    public void testContains_BoundaryValueLower_ReturnsTrue() {
        Range range = new Range(1.0, 10.0);
        assertTrue("Boundary lower value should be contained", range.contains(1.0));
    }

    @Test
    public void testContains_BoundaryValueUpper_ReturnsTrue() {
        Range range = new Range(1.0, 10.0);
        assertTrue("Boundary upper value should be contained", range.contains(10.0));
    }

    // Test for contains method with NaN values
    @Test
    public void testContains_NaNValue() {
        Range range = new Range(1.0, 10.0);
        assertFalse("NaN should not be contained", range.contains(Double.NaN));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}