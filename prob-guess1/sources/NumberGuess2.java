import java.util.HashMap;
import java.util.ArrayList;

public class NumberGuess2 {
	
	int getExact (int actual, int predicted) throws Exception
	{
		//System.out.println("ActualInput int: " + actual + " PredictedInput int: " + predicted);
		if (actual < 0 || predicted < 0)  
			throw new IllegalArgumentException("Negative number inputs not allowed");
		return computeExact(Integer.toString(actual), Integer.toString(predicted));	
		
	}
	
	int getAlmost (int actual, int predicted) throws Exception
	{
		if (actual < 0 || predicted < 0)  
			throw new IllegalArgumentException("Negative number inputs not allowed");
	    //System.out.println("ActualInput int: " + actual + " PredictedInput int: " + predicted);
		return computeAlmost(Integer.toString(actual), Integer.toString(predicted));

	}
	
	public int computeExact(String actualNumber, String predictedNumber) {
		
		if (actualNumber.length() != predictedNumber.length()) {
		    throw new IllegalArgumentException("Unequal number of digits in input");
		}
		
	    int numDigitAndPosition=0;
	    ArrayList myList = compute(actualNumber, predictedNumber);
	    numDigitAndPosition=(int) myList.get(0);
		    
	    System.out.println("Actual: " + actualNumber + " Predicted: " + predictedNumber + " Exact: " + numDigitAndPosition);

	    return numDigitAndPosition;
	   
	}
	
	public int computeAlmost(String actualNumber, String predictedNumber) {
		
		if (actualNumber.length() != predictedNumber.length()) {
		    throw new IllegalArgumentException("Unequal number of digits in input");
		}
		
	    int numOnlyDigit=0;
	    
	    // Create a map of characters and number of their exact matches
	    ArrayList myList = compute(actualNumber, predictedNumber);
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
	    map=(HashMap<Character, Integer>) myList.get(1);
	 
	    // 'ALMOST' check
	    for(int i=0; i<actualNumber.length(); i++){
	        char c1 = actualNumber.charAt(i);
	        char c2 = predictedNumber.charAt(i);
	 
	        if(c1!=c2){
	            if(map.containsKey(c2)){
	            	numOnlyDigit++;
	                if(map.get(c2)==1){
	                    map.remove(c2);
	                }else{
	                    int freq = map.get(c2);
	                    freq--;
	                    map.put(c2, freq);
	                }
	            }
	        } 
	    }
	    System.out.println("Actual: " + actualNumber + " Predicted: " + predictedNumber + " Almost: " + numOnlyDigit);
	    return numOnlyDigit;
	   
	}
	
	public ArrayList compute (String actualNumber, String predictedNumber){
		
	    int numDigitAndPosition=0;
   	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    // 'EXACT' check
	    for(int i=0; i<actualNumber.length(); i++){
	        char c1 = actualNumber.charAt(i);
	        char c2 = predictedNumber.charAt(i);
	 
	        if(c1==c2){
	        	numDigitAndPosition++;
	        }else{
	            if(map.containsKey(c1)){
	                int frequency = map.get(c1);
	                frequency++;
	                map.put(c1, frequency);
	            }else{
	                map.put(c1, 1);
	            }
	        }
	    }
	    
	    ArrayList returnList = new ArrayList();
	    returnList.add(0, numDigitAndPosition);
	    returnList.add(1, map);
	    	    
	    return returnList;
		
	}
	

}
