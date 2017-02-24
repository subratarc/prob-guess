import static org.junit.Assert.*;

import org.junit.Test;

public class NumberGuessTest {
	
	NumberGuess soln = new NumberGuess(); // This class is tested

	@Test
	public void testGetExact() {
		
        // assert that actual logic does what it is meant to do
		try {			
	        assertEquals("Should spit out 2", 2, soln.getExact(1234, 1203));	        
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		try {
	        assertEquals("Should spit out 0", 0, soln.getExact(1234, 5678));			
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		try {
	        assertEquals("Should spit out 0", 0, soln.getExact(1234, 2000));
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		/*
		try {
	        assertEquals("Should spit out 4", 4, soln.getExact(0000, 0000));
		} catch (Exception e) {
		      // expected
		}*/
		 
	}

	@Test
	public void testGetAlmost() {
		
        // assert that actual logic does what it is meant to do
		try {			
	        assertEquals("Should spit out 1", 1, soln.getAlmost(1234, 1203));	        
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		try {
	        assertEquals("Should spit out 0", 0, soln.getAlmost(1234, 5678));			
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		try {
	        assertEquals("Should spit out 1", 1, soln.getAlmost(1234, 2000));
		} catch (Exception e) {
		      // expected
		}
		
        // assert that actual logic does what it is meant to do
		/*
		try {
	        assertEquals("Should spit out 0", 0, soln.getAlmost(0000, 0000));
		} catch (Exception e) {
		      // expected
		}*/
		
	}
	
	@Test
	public void testNegativeInput() {
		
		  // Negative input1		  
		  try {
		      soln.getExact(-123, 1203);
		      fail("Fail! Method was expected to throw an exception because negative numbers are not supported.");
		  } catch (Exception e) {
		      // expected
		  }
		  
		  // Negative input2
		  try {
		      soln.getExact(1234, -120);
		      fail("Fail! Method was expected to throw an exception because negative numbers are not supported.");
		  } catch (Exception e) {
		      // expected
		  }
		 
	}
	
	@Test
	public void testUnqualInputLength() {
		
		// Unequal length inputs: scenario 1		  
		  try {
		      soln.getExact(1234, 123);
		      fail("Fail! Method was expected to throw an exception because actual and predicted numbers should be of equal number of digits.");
		  } catch (Exception e) {
		     // expected
		  }
		  
		  // Unequal length inputs: scenario 2		  
		  try {
		      soln.getExact(123, 1234);
		      fail("Fail! Method was expected to throw an exception because actual and predicted numbers should be of equal number of digits.");
		  } catch (Exception e) {
		      // expected
		  }
		 
	}

}
