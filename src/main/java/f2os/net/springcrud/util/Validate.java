package f2os.net.springcrud.util;

public class Validate {
	
	public static String replaceQuotes(String in){
		String replaceQuotes = in;
		replaceQuotes = replaceQuotes.replace('\'', '-');
		replaceQuotes = replaceQuotes.replace('\"', '-');
		return replaceQuotes;
	}
	
	public static  String getOnlyNums(String str) {        
		if (str == null) {        
			return null;    
			}    
		StringBuffer strBuff = new StringBuffer();    
		char c;        
		for (int i = 0; i < str.length() ; i++) 
		{        
			c = str.charAt(i);                
			if (Character.isDigit(c)) 
			{            
				strBuff.append(c);        
			}    
			}   
		String returnString = strBuff.toString();
		if(returnString.equals(""))
			returnString = "0";
			if(returnString.length() != 10){
				System.out.println("must be 10 nums");
			}
		
		return returnString;
		}
	
	public static double remove$(String inS){
		String s = inS;
		double d = 0.0;
	  if(s.contains("$")){
			s = s.substring(1);
			 d = Double.parseDouble(s);
		}
	  else 
		  d = Double.parseDouble(s);
	  
		return d;
	}
	
	public static String putInDashes(String num){
		String returnString = "";
		try{
		if(num == null)
			return null;
		if(num.equals("") || num.isEmpty())
			return null;
		StringBuffer strBuff = new StringBuffer();  
		strBuff.append(num.substring(0, 3));
		strBuff.append("-");
		strBuff.append(num.substring(3,6));
		strBuff.append("-");
		strBuff.append(num.substring(6,10));
	    returnString = strBuff.toString();
		
		}
		catch(Exception ex){
			System.out.println("must be 10 nums" +ex.getMessage());	
		}
		return returnString;
	}
	
	public static boolean isInt(String i)
	{
	try
	{
	int in = Integer.parseInt(i);
	if(in > 0 && in < 55)
	return true;
	else
		return false;
	}
	
	
	catch(NumberFormatException nfe)
	{
	return false;
	}
	}
	
	public static boolean isDouble(String i) {
	try
	{
	double in = remove$(i);
	// in = Double.parseDouble(in);
	if(in > 0 )
	return true;
	else
		return false;
	}
	
	
	catch(NumberFormatException nfe)
	{
	return false;
	}
	}

}
