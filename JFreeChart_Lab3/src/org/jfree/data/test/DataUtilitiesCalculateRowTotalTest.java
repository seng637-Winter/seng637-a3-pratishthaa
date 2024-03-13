package org.jfree.data.test;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;



public class DataUtilitiesCalculateRowTotalTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}
	
	private static final double DELTA = 0.0000000001;

	@Test
	public void calculateRowTotalMaxValueBoundary() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);

	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3)); // Suppose we have 3 columns
	            one(values).getValue(0, 0);
	            will(returnValue(Double.MAX_VALUE));
	            one(values).getValue(0, 1);
	            will(returnValue(Double.MAX_VALUE));
	            one(values).getValue(0, 2);
	            will(returnValue(Double.MAX_VALUE));
	        }
	    });

	    double resultm = DataUtilities.calculateRowTotal(values, 0);
	   // System.out.println("Actual Result: " + resultm);
	    assertEquals("The row total is adding up to 2e10", 3 * Double.MAX_VALUE, resultm, DELTA);
	}

	@Test
	public void calculateRowTotalMinValBoundary() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);

	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3)); // Suppose we have 1 row
	            one(values).getValue(0, 0);
	            will(returnValue(-Double.MAX_VALUE));
	            one(values).getValue(0, 1);
	            will(returnValue(-Double.MAX_VALUE));
	            one(values).getValue(0, 2);
	            will(returnValue(Double.MAX_VALUE));
	        }
	    });

	    double resultm = DataUtilities.calculateRowTotal(values, 0);
	    double expectedres = -2 * Double.MAX_VALUE + Double.MAX_VALUE;
	    assertEquals("The row total is adding up to Double.MIN_VALUE", expectedres, resultm, DELTA);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalWithNullData() {
	    // Attempt to calculate row total with null data object
	    double rowTotal = DataUtilities.calculateRowTotal(null, 0);
	    
	    // The test should fail if no exception is thrown
	    // No need to assert anything here
	}

	
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateRowTotalInvalidIndex() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);

	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2)); 

	            // Expecting an InvalidParameterException when accessing negative row index
	            one(values).getValue(with(any(int.class)), with(equal(0)));
	            will(throwException(new IndexOutOfBoundsException()));
	        }
	    });

	    // Attempt to calculate row total with negative index
	    double result = DataUtilities.calculateRowTotal(values, -10);

	    // If an InvalidParameterException is thrown, the test passes
	}

	    
	    @Test
	    public void calculateRowTotalValidRow() {
	    	Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(7.5));
	                one(values).getValue(0, 1);
	                will(returnValue(2.0));
	                one(values).getValue(0, 2);
	                will(returnValue(9.0));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);
	 	  // System.out.println("Actual Result: " + result);
	        assertEquals(18.5, result, DELTA);
	    }
	    // X----------------------------------NEW TEST CASES FOR CALCULATEROWTOTAL()-ASSIGNMENT-3-------------------------------------------X
	    @Test
	    public void testCalculateRowWithSomeMissingValues() {
	    	Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	            	one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(1.0));
	                one(values).getValue(0, 1);
	                will(returnValue(null));
	                one(values).getValue(0, 2);
	                will(returnValue(2.0));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("Total of the row with some missing values should be the rest values", 3.0, result, 0);
	    }
	    
	    @Test
	    public void testCalculateRowWithSingleColumnValue() {
	    	Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {
	            {
	            	one(values).getColumnCount();
	                will(returnValue(1));
	                one(values).getValue(0, 0);
	                will(returnValue(10.0));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("Total of the row with single value should be the value", 10.0, result, 0);
	    }
	    
	    @Test
	    public void testCalculateRowTotalWithNegativeValues() {
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);

	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(-5.0));
	                one(values).getValue(0, 1);
	                will(returnValue(-3.0));
	                one(values).getValue(0, 2);
	                will(returnValue(-2.0));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("Total of row with negative values", -10.0, result, DELTA);
	    }

	    @Test
	    public void testCalculateRowTotalWithEmptyValues2D() {
	        Mockery mockery = new Mockery();
	        final Values2D values = mockery.mock(Values2D.class);

	        mockery.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(0)); // Suppose we have no columns
	            }
	        });

	        double result = DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("Row total should be 0.0 for empty Values2D", 0.0, result, DELTA);
	    }
	    
	    
	    @Test
	    public void testCalculateRowTotalWhenSumOfARowIsZero() {
	        Mockery mockery = new Mockery();
	        final Values2D values = mockery.mock(Values2D.class);

	        mockery.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(3)); // Suppose we have no columns
	                one(values).getValue(0, 0);
	                will(returnValue(7.5));
	                one(values).getValue(0, 1);
	                will(returnValue(2.5));
	                one(values).getValue(0, 2);
	                will(returnValue(-10));
	            }
	        });

	        double result = DataUtilities.calculateRowTotal(values, 0);
	        assertEquals("Should return 0.0", 0, result, .000000001d);
	    }
	    
	    @After
		public void tearDown() throws Exception {
			
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			
		}
	
	

}


