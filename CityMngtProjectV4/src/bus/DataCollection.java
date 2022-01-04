package bus;

import java.util.ArrayList;
import java.util.Collections;
import bus.AreaComparator;

public class DataCollection {	
	
	private static ArrayList<City> listOfCities = new ArrayList<City>();
	
	
	public static ArrayList<City> getListOfCities() {
		return listOfCities;
	}

	public static void setListOfCities(ArrayList<City> listOfCities) {
		DataCollection.listOfCities = listOfCities;
	}

	public static void add(City aCity)
	{
		listOfCities.add(aCity);		
	}
	
	
	public static void  sortByName()
	{
	//	NameComparator areaComparator = new NameComparator();
		Collections.sort(listOfCities, new NameComparator());
		
		
//	for(int i = 0; i < listOfCities.size(); i++)
//		for(int j = i+1; j < listOfCities.size(); j++)
//			{									
//		//sort by value in ascending order
//				if(listOfCities.get(i).getName() > listOfCities.get(j).getName())
//				{	
//				//swapping---- interchanging
//					City temp= listOfCities.get(i);
//					listOfCities.set(i, listOfCities.get(j));
//				
//			listOfCities.set(j, temp);
//			}
//			}
		}	
	
		
	//sort by city area
		public static void sortByArea()
		{
			AreaComparator areaComparator = new AreaComparator();
			Collections.sort(listOfCities, new AreaComparator());
			
			
//		for(int i = 0; i < listOfCities.size(); i++)
//			for(int j = i+1; j < listOfCities.size(); j++)
//				{									
//			//sort by value in ascending order
//					if(listOfCities.get(i).getArea() > listOfCities.get(j).getArea())
//					{	
//					//swapping---- interchanging
//						City temp= listOfCities.get(i);
//						listOfCities.set(i, listOfCities.get(j));
//					
//				listOfCities.set(j, temp);
//				}
//				}
//			}		
		}
	
		
		public static void  sortByPop() {
			
			Collections.sort(listOfCities, new PopComparator());
		}

}
