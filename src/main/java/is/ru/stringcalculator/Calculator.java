package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}

		else if(text.contains("//")){
			 return sum(anotherDelimiter(text));
		}

		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}

		else 
			return toInt(text);
		}


	private static String[] anotherDelimiter(String numbers){
    	String anotherDelimiter = numbers.substring(2,3);
    	numbers = numbers.substring(3);
    	numbers = numbers.replaceAll("\n","");
    	numbers = numbers.replaceAll(anotherDelimiter,","); 

    	return numbers.split(",");
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
    }

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) <= 1000)
        	{
        		total += toInt(number);
        	}
		   
		}
		return total;
    }   
}



    
