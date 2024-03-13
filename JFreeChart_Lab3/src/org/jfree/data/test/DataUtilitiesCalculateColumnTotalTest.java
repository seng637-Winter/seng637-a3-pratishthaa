


package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Result;



 public class DataUtilitiesCalculateColumnTotalTest extends DataUtilities {
@BeforeClass	 public static void setUpBeforeClass()
	 throws Exception {}
@Test
	public void calculateColumnTotalForTwoValues() {
// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class); mockingContext.checking(new Expectations() {
		{
		one(values).getRowCount(); 
		will(returnValue(2));
		one(values).getColumnCount();
		will(returnValue(2));
		one(values).getValue(0, 0); 
		will(returnValue(7.5)); 
		one(values).getValue(1, 0);
		will(returnValue(2.5));
		}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
// tear-down: NONE in this test method
	}

@Test
	public void testCalculateColumnTotal_nullDataObjectPassed() {
		boolean testPassed = false;
		
		try {
			DataUtilities.calculateColumnTotal(null, 1);
		} catch (InvalidParameterException e) {
			testPassed = true;
		} finally {
			assertEquals("Method should throw exception.", true, testPassed);
		}
	}
	

@Test
public void testCalculateColumnTotal_invalidDataPassed() {
    Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {{
        oneOf(values).getRowCount(); will(returnValue(2));
        // These should return Numbers, not Booleans
        oneOf(values).getValue(0, 0); will(returnValue(true)); // Use a valid numeric value or throw an exception
        oneOf(values).getValue(1, 0); will(returnValue(false)); // Same here
    }});
    double result = DataUtilities.calculateColumnTotal(values, 0);
    // Adjust assertion according to the correct handling of invalid data
    assertEquals("Result should reflect handling of invalid data", 3, result, 0.000000001d);
}


@Test
	public void testCalculateColumnTotal_columnIsLastColumnInTable() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 2); 
			    will(returnValue(2.4)); 
			    one(values).getValue(1, 2); 
			    will(returnValue(1.6));
			    one(values).getValue(2, 2); 
			    will(returnValue(3.4));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals(7.4, result, 0.000000001d);
	}
	
@Test
	public void testCalculateColumnTotal_columnIsFirstInTable() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0); 
			    will(returnValue(1.4)); 
			    one(values).getValue(1, 0); 
			    will(returnValue(1.6));
			    one(values).getValue(2, 0); 
			    will(returnValue(3.4));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(6.4, result, 0.000000001d);
	}
	
@Test
	public void testCalculateColumnTotal_columnIsNegativeOne() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals(0, result, 0.000000001d);
	}
	
@Test
public void testCalculateColumnTotal_columnIsOneMoreThanMax() {
    Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {{
    	oneOf(values).getRowCount(); will(returnValue(3));
        oneOf(values).getColumnCount(); will(returnValue(3));
        // Do not set expectations for getValue for the out-of-bounds column index
    }});
    double result = DataUtilities.calculateColumnTotal(values, 5); // Assuming 3 is out of bounds
    assertEquals("Expected total of 0 for out-of-bounds column index", 0.0, result, 0.000000001d);
}

	
@Test
public void testCalculateColumnTotal_columnIsCentralInTable() {
	Mockery mockingContext = new Mockery();
	final Values2D values = mockingContext.mock(Values2D.class);
	mockingContext.checking(new Expectations() {
		{
			one(values).getRowCount();
			will(returnValue(3));
			one(values).getValue(0, 1); 
		    will(returnValue(1.4)); 
		    one(values).getValue(1, 1); 
		    will(returnValue(1.6));
		    one(values).getValue(2, 1); 
		    will(returnValue(3.4));
		}
	});
	double result = DataUtilities.calculateColumnTotal(values, 1);
	assertEquals(6.4, result, 0.000000001d);
}
@Test
public void calculateColumnTotalWithNullValues() {
	Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {{
        oneOf(values).getRowCount(); will(returnValue(3));
        oneOf(values).getValue(0, 0); will(returnValue(5));
        oneOf(values).getValue(1, 0); will(returnValue(null));
        oneOf(values).getValue(2, 0); will(returnValue(10));
    }});

    double result = DataUtilities.calculateColumnTotal(values, 0);
    assertEquals(15.0, result, 0.0000001d);
}

@Test
public void calculateColumnTotalForEmptyDataSet() {
	Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {{
        oneOf(values).getRowCount(); will(returnValue(0));
    }});

    double result = DataUtilities.calculateColumnTotal(values, 0);
    assertEquals(0.0, result, 0.0000001d);
}

@Test(expected = IndexOutOfBoundsException.class)
public void calculateColumnTotalForInvalidColumnIndex() {
	Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {{
        oneOf(values).getRowCount(); will(returnValue(3));
    }});

    // Assuming the method throws an exception for invalid column index.

    DataUtilities.calculateColumnTotal(values, -1);
}
}

