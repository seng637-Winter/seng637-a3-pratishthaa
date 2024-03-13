package org.jfree.data;
//package org.jfree.data.test;
import static org.junit.Assert.*;
import org.jfree.data.Range; 
import org.junit.*;

public class RangeIntersectsTest {
    private Range exampleRange;
    private Range originRange;
    

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.exampleRange = new Range(-10, 10);
        this.originRange = new Range(0.0, 0.0);
    }

    // test cases for intersects(double, double) ------------------------------
    @Test
    public void intersectsWithInputBLBAndLB() {
        assertTrue(this.exampleRange.intersects(-10.00001, -10));
    }

    @Test
    public void intersectsWithInputBLBAndALB() {
        assertTrue(this.exampleRange.intersects(-10.00001, -9.99999));
    }

    @Test
    public void intersectsWithInputBLBAndAUB() {
        assertTrue(this.exampleRange.intersects(-10.00001, 10.00001));
    }

    @Test
    public void intersectsWithInputLBAndALB() {
        assertTrue(this.exampleRange.intersects(-10, -9.99999));
    }

    @Test
    public void intersectsWithInputLBAndUB() {
        assertTrue(this.exampleRange.intersects(-10, 10));
    }

    @Test
    public void intersectsWithInputNOMAndNOM() {
        assertTrue(this.exampleRange.intersects(-1, 1)); //passed, intersection
    }

    @Test
    public void intersectsWithInputBUBAndUB() {
        assertTrue(this.exampleRange.intersects(9.99999, 10)); //failed, no intersection
    }

    @Test
    public void intersectsWithInputUBAndAUB() {
        assertTrue(this.exampleRange.intersects(10, 10.00001)); //failed
    }

    @Test
    public void intersectsWithInputMINAndAUB() {
        assertTrue(this.exampleRange.intersects(Double.MIN_VALUE, 10.00001));//passed
    }

    @Test
    public void intersectsWithInputBLBAndMAX() {
        assertTrue(this.exampleRange.intersects(-10.00001, Double.MAX_VALUE));
    }

    @Test
    public void intersectsWithInput0And0() {
        assertTrue(this.exampleRange.intersects(0, 0));
    }

    @Test
    public void intersectsWithInputNaNAnd1() {
        assertTrue(this.exampleRange.intersects(Double.NaN, 1)); //failed
    }
    
    //Test cases added for coverage testing
    //Here, B0 is bigger than B1 ..from Range class
    @Test
    public void intersectsWithReverse() {
        assertTrue(this.exampleRange.intersects(-6,-9)); 
    }
    
   
    // ------------------------------------------------------------------------

  
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}



