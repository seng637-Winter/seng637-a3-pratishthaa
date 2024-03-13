package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineTest {
	private Range exampleRange;
	@BeforeClass public static void setUpBeforeClass () throws Exception {
		
	}
	private static final double DELTA = 0.0000000001;
	@Before
	public void setUp() throws Exception { 
		exampleRange = new Range (0.0, 1.0);
	}
	
	//X------------------------TEST CASES FOR THE METHOD COMBINE()-------------------------X
	
	@Test
    public void testCombineWithOverlappingRanges() {
		// create two ranges with some overlap 
		Range r1 = new Range(Double.MAX_VALUE - 20.0, Double.MAX_VALUE);
        Range r2 = new Range(Double.MAX_VALUE -40, Double.MAX_VALUE -10.0);
        // combine the ranges
        Range combinedRange = Range.combine(r1,r2);
        assertEquals(Double.MAX_VALUE -40, combinedRange.getLowerBound(), DELTA);
	    assertEquals(Double.MAX_VALUE , combinedRange.getUpperBound(), DELTA);
    }

	 @Test
	 public void testCombineWithNoOverlapInRanges() {
	     // Create two ranges with no overlap
	     Range r1 = new Range(Double.MAX_VALUE - 10.0, Double.MAX_VALUE);
	     Range r2 = new Range(Double.MAX_VALUE -40, Double.MAX_VALUE -30.0);
	     Range combinedRange = Range.combine(r1, r2);
	     assertEquals(Double.MAX_VALUE -40, combinedRange.getLowerBound(), DELTA);
	     assertEquals(Double.MAX_VALUE , combinedRange.getUpperBound(), DELTA);
	 }

	 @Test
	 public void testCombineWithIdenticalRanges() {
	     Range r1 = new Range(1.0, 2.0);
	     Range r2 = new Range(1.0, 2.0);
	     Range combinedRange = Range.combine(r1, r2);
	     assertEquals("Combining identical ranges should return the same range", r1, combinedRange);
	 }
	 
	
    @Test
    public void testCombineWithRangeBoundsDoubleLimits() {
        Range r1 = new Range(Double.MAX_VALUE - 10.0, Double.MAX_VALUE);
        Range r2 = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE + 10.0);
        Range combinedRange = Range.combine(r1, r2);
        assertEquals(-Double.MAX_VALUE, combinedRange.getLowerBound(), DELTA);
    }


    @Test(timeout = 1000) // Timeout to make sure test completes within a reasonable time since we are considering very large ranges
    public void testCombineWithLargeRanges() {
        Range r1 = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        Range r2 = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        Range combinedRange = Range.combine(r1, r2);
        assertEquals(-Double.MAX_VALUE, combinedRange.getLowerBound(), DELTA);
        // Ensuring the method handles large ranges efficiently
        assertNotNull("Combining large ranges should not return null", combinedRange);
    }

    @Test
    public void testCombineWithNaNValues() {
        Range r1 = new Range(Double.NaN, 2.0);
        Range r2 = new Range(1.0, Double.NaN);
        Range combinedRange = Range.combine(r1, r2);
        // Ensuring the method handles NaN values correctly
       assertNotNull("Combining ranges with NaN values should not return null", combinedRange);
    }
    
    @Test
    public void testCombineWithNullRange() {
        Range r1 = new Range(1.0, 2.0);
        Range combinedRange = Range.combine(r1, null);
        assertEquals("Combining with null range should return the non-null range", r1, combinedRange);
    }

    @Test
    public void testCombineWithBothRangesNull() {
        Range combinedRange = Range.combine(null, null);
        assertNull("Combining with both ranges null should return null", combinedRange);
    }

	//X------------------------NEW TEST CASES FOR THE METHOD COMBINE()-ASSIGNMENT3-------------------------X

	 @Test
	 public void testCombineWithSingleElementRanges() {
	     Range r1 = new Range(2.0, 2.0);
	     Range r2 = new Range(2.0, 2.0);
	     Range combinedRange = Range.combine(r1, r2);
	     assertEquals("Combining such ranges should return the same range", r1, combinedRange);
	 }
	 
	 @Test
	 public void testCombineWithTouchInRanges() {
	     Range r1 = new Range(2.0, 6.0);
	     Range r2 = new Range(6.0, 10.0);
	     Range combinedRange = Range.combine(r1, r2);
	     assertEquals(2.0, combinedRange.getLowerBound(), DELTA);
	     assertEquals(10.0 , combinedRange.getUpperBound(), DELTA);
	 }
	 
	 @Test
	 public void testCombineWithOneRangeInAnother() {
	     Range r1 = new Range(1.0, 10.0);
	     Range r2 = new Range(3.0, 7.0);
	     Range combinedRange = Range.combine(r1, r2);
	     assertEquals(1.0, combinedRange.getLowerBound(), DELTA);
	     assertEquals(10.0 , combinedRange.getUpperBound(), DELTA);

	 }

   

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}


