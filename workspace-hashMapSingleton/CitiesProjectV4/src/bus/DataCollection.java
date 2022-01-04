package bus;

import java.util.ArrayList;

import java.util.Collections;
public  class DataCollection {
	
    private static ArrayList<City> listOfCities = new ArrayList<City>();

	public static ArrayList<City> getListOfCities() {
		return listOfCities;
	}
	public static void setListOfCities(ArrayList<City> listOfCities) {
		
		DataCollection.listOfCities = listOfCities;
	}	
	public static void add(City newCity)	{
		
		listOfCities.add(newCity);	
	}	
	public static void remove(City newCity)	{
		
		listOfCities.remove(newCity);	
	}	
	public static void sortByCode()	{
		
		Collections.sort(listOfCities , new CodeComparator());
	}
	public static void sortByArea()	{
		
		Collections.sort(listOfCities , new AreaComparator());
	}	
	public static void sort(CodeComparator predict)	{
		
		Collections.sort(listOfCities , predict);
	}	
	public static void sort(AreaComparator predict)	{
		
		Collections.sort(listOfCities , predict);
	}	
    public static City  search(String key)	 {
    	
		 for( City element : listOfCities) {
			                            //if(element.getCode() == key)	 
			 if(element.getCode().equals(key) )	 {
				 return element ;				 
			 }
		 }		 
	   return null;	   
	 }
}

