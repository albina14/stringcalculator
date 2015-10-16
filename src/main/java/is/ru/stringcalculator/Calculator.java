package is.ru.stringcalculator;

public class Calculator 
{

	public static int add(String text)
	{
		if(text.equals(""))
		{
			return 0;
		}

		else if(text.contains("//"))
		{
			 return sum(anotherDelimiter(text));
		}

		else if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}

		else 
			return toInt(text);
	}
	

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
		if(numbers.contains("-"))
		{
			return checkForNegatives(numbers.split(",|\n"));
		}

	    	return numbers.split(",|\n");
    }

    private static String[] anotherDelimiter(String numbers)
    {
    	String anotherDelimiter = numbers.substring(2,3);

	    	numbers = numbers.substring(3);   
	    	numbers = numbers.replace("\n","");
	    	numbers = numbers.replace(anotherDelimiter,","); 

    	return splitNumbers(numbers);
	}

	private static String[] checkForNegatives(String[] numbers)
	{
    	String allNegatives = "";

        for(String number : numbers)
        {
        	if((toInt(number)) < 0)
        	{
        		allNegatives +=  (number + ",");
        		
        	}
		}

		allNegatives = ("Negatives not allowed: " + allNegatives);

		throw new IllegalArgumentException(allNegatives);

    }

    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers)
        {
        	if(toInt(number) <= 1000)
        	{
        		total += toInt(number);
        	}
		   
		}
		return total;
    }   
}



    
