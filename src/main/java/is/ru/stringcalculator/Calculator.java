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
    	int length = 0;
    	int countDelimiters = numbers.split("]").length - 1;
    	int indexOfBracketEndBracket = 0;	
    
    	if (anotherDelimiter.equals("["))
    	{
    		numbers = numbers.replace("*","\\*");
    		length = numbers.indexOf("]");
    		anotherDelimiter = numbers.substring (3,length);
    		numbers = numbers.substring(length + 1);
    		numbers = numbers.replace(anotherDelimiter , ","); 	

    		if(countDelimiters > 1)
    		{
	    		for(int i = 1; i < countDelimiters; i++)
				{			
					//System.out.println("\n Kemst eg hingad? \n");
					indexOfBracketEndBracket = numbers.indexOf("]");
				    anotherDelimiter = numbers.substring (1, indexOfBracketEndBracket);
				    numbers = numbers.substring(indexOfBracketEndBracket + 1);
				    numbers = numbers.replace(anotherDelimiter , ","); 	

				}	

			}

			//System.out.println("\n What r this: " + numbers + " \n");
    	}

    	else
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

		throw new RuntimeException("Negatives not allowed: " + allNegatives);

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



    
