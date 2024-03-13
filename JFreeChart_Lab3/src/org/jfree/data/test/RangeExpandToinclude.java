package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeExpandToinclude {
    private Range exampleRange;
  
   /* @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }*/
    @Test
    public void expandToIncludeWithInputBLB() {
        assertEquals("Testing expanding range to include value BLB", new Range(-10.00001, 10),
                Range.expandToInclude(this.exampleRange, -10.00001));
    }

    @Test
    public void expandToIncludeWithInputLB() {
        assertEquals("Testing expanding range to include value at LB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, -10));
    }

   // @Test
   /* public void expandToIncludeWithInputALB() {
    	assertEquals("Testing expanding range to include value ALB (range shouldn't change)", new Range(-10, 10),
    			Range.expandToInclude(this.exampleRange, -9.99999));
    	}*/
    @Test
    public void expandToIncludeWithInputUpperBoundSlightlyBelowUB() {
        assertEquals("Testing expanding range to include value just below UB", new Range(-10, 10.00001),
                Range.expandToInclude(new Range(-10, 10), 10.00001));
    }
    /*@Test
    public void expandToIncludeWithInputBUB() {
        assertEquals("Testing expanding range to include value BUB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, 9.99999));
        }*/
    @Test
    public void expandToIncludeWithInputUpperBound() {
        assertEquals("Testing expanding range to include value at UB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(new Range(-10, 10), 10));
    }
    /*@Test
    public void expandToIncludeWithInputUB() {
        assertEquals("Testing expanding range to include value at UB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, 10));
        }

    @Test
    public void expandToIncludeWithInputAUB() {
        assertEquals("Testing expanding range to include value AUB ", new Range(-10, 10.00001),
                Range.expandToInclude(this.exampleRange, 10.00001));
    }

    @Test
    public void expandToIncludeWithInputPositive() {
        assertEquals("Testing expanding range to include value at LB (range shouldn't change)", new Range(-10, 25),
                Range.expandToInclude(this.exampleRange, 25));
        }*/
    @Test
    public void expandToIncludeWithInputUB() {
        assertEquals("Testing expanding range to include value at UB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(new Range(-10, 10), 10));
    }
    @Test
    public void expandToIncludeWithInputAUB() {
        assertEquals("Testing expanding range to include value just above UB", new Range(-10, 10.00001),
                Range.expandToInclude(new Range(-10, 10), 10.00001));
    }
    @Test
    public void expandToIncludeWithInputPositive() {
        assertEquals("Testing expanding range to include value greater than UB", new Range(-10, 25),
                Range.expandToInclude(new Range(-10, 25), 30));
    }
        

    @Test
    public void expandToIncludeWithInputNegative() {
        assertEquals("Testing epanding range to include value at LB (range shouldn't change)", new Range(-25, 10),
                Range.expandToInclude(this.exampleRange, -25));
        }

    /*@Test
    public void expandToIncludeWithInputDoubleMax() {
        assertEquals("Testing expanding range to include max double", new Range(-10, Double.MAX_VALUE),
                Range.expandToInclude(this.exampleRange, Double.MAX_VALUE));
        }
    @Test
    public void expandToIncludeWithInputWithinRange() {
        assertEquals("Testing expanding range to include a value within the range", new Range(-1, 1),
                Range.expandToInclude(this.exampleRange, 0.5));
        }*/
    @Test
    public void expandToIncludeWithInputGreaterThanUpperBound() {
        assertEquals("Testing expanding range to include value greater than UB", new Range(-10, Double.MAX_VALUE),
                Range.expandToInclude(new Range(-10, 10), Double.MAX_VALUE));
    }

    @Test
    public void expandToIncludeWithInputLessThanLowerBound() {
        assertEquals("Testing expanding range to include value less than LB", new Range(-10, 10),
                Range.expandToInclude(new Range(-10, 10), -Double.MAX_VALUE));
    }
    @Test
    public void expandToIncludeWithInputNegativeDoubleMax() {
        assertEquals("Testing epanding range to include negative max double", new Range(-Double.MAX_VALUE, 10),
                Range.expandToInclude(this.exampleRange, -Double.MAX_VALUE));
        }
    // new test cases ---------------------------------------------------------
    @Test
    public void expandToIncludeWithNullRange() {
        assertEquals("Testing expanding range to include Null Range", new Range(10, 10),
                Range.expandToInclude(null, 10));
        }
    
  
    
}