package bus;

import java.util.Comparator;

public class NameComparator implements Comparator<City>{
	
	public int compare(City c1, City c2)
	{
		if(c1.getName().compareTo(c2.getName()) < 0)
			return -1;
		
		   else if(c1.getName().compareTo(c2.getName()) > 0) 
			  return 1;
		
		        else return 0;
		
	}
}
