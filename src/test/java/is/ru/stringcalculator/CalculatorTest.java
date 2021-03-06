package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) 
	{
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() 
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() 
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers()
    {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testMoreMultipleNumbers()
    {
    	assertEquals(28, Calculator.add("1,2,3,4,5,6,7"));
    }

    @Test
    public void testLinesBetweenTheNumbers()
    {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDelimiter()
    {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testDelimiter2()
    {
    	assertEquals(3, Calculator.add("//#\n1#2"));
    }

    @Test
    public void test1000()
    {
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test (expected = RuntimeException.class)
    public void testNegativeNumbers()
    {
        assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
    }

    @Test
    public void testDelimiterLength()
    {
    	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
    
    @Test
    public void testDelimiterLength2()
    {
    	assertEquals(8, Calculator.add("//[&&&&]\n2&&&&2&&&&4"));
    }

    @Test
    public void testMultipleDelimiters()
    {
    	assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleDelimitersOfAnyLength()
    {
        assertEquals(6, Calculator.add("//[***][%%%]\n1***2%%%3"));
    }
    
}



 
