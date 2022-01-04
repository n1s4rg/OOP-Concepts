package bus;

import java.util.Comparator;

public class CodeComparator implements Comparator<City>{	
	
	public int compare(City c1, City c2)
	{
		if(c1.getCode().compareTo(c2.getCode())   < 0) 
			  return -1;
		
		  else if(c1.getCode().compareTo(c2.getCode())   > 0)
			      return 1;
		
		       else return 0;
		
	}

}
