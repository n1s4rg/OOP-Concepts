package bus;



import java.util.Comparator;

public class AreaComparator  implements Comparator<City>{

	
	public int compare(City c1, City c2)
	{
		if(c1.getArea().compareTo(c2.getArea()) < 0)
			return -1;
		else
			if(c1.getArea().compareTo(c2.getArea()) >0)
				return +1;
			else 
				return 0;
	}
}
