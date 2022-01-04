package bus;
import java.util.Comparator;

public class PopComparator implements Comparator <City> {
	
	public int compare(City c1, City c2)
	{
		if (c1.getPop().compareTo(c2.getPop()) < 0)
			return -1;
		else if (c1.getPop().compareTo(c2.getPop()) <0)
			return +1;
		else
			return 0;
		
	}

}
