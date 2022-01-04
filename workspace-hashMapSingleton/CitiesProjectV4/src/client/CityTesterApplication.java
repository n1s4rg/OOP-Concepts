package client;
import java.util.ArrayList;
import java.util.Collections;

import bus.City;
import bus.CodeComparator;
import bus.AreaComparator;

public class CityTesterApplication {

	public static void main(String[] args) {
		
		ArrayList <City> citiesList = new ArrayList<City>();
		
		City c1 =  new City("411" , "Laval" , 444.44);		
		City c2 =  new City("514" , "Montreal" , 222.22);		
		City c3 =  new City("418" , "Ottawa" , 777.77);
		citiesList.add(c1); citiesList.add(c2); citiesList.add(c3);
		
		System.out.println("\n List of cities BEFORE sorting");
		for(City aCity : citiesList)
		{
			System.out.println(aCity);			
		}
		
		//-1-sorting by city code
		 Collections.sort(citiesList   ,   new CodeComparator()  );
		
	
		System.out.println("\n List of cities AFTER sorting by city code");
		for(City aCity : citiesList)
		{
			System.out.println(aCity);			
		}
		
		//-1-sorting by city area
		 Collections.sort(citiesList   ,   new AreaComparator()  );
		
	
		System.out.println("\n List of cities AFTER sorting by city area");
		for(City aCity : citiesList)
		{
			System.out.println(aCity);			
		}
	}
}
/*
 List of cities BEFORE sorting
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=411, name=Brossard, area=777.77]

 List of cities AFTER sorting by city code
City [code=411, name=Brossard, area=777.77]
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]

 List of cities AFTER sorting by city area
City [code=514, name=Montreal, area=222.22]
City [code=418, name=Laval, area=444.44]
City [code=411, name=Brossard, area=777.77]
********/
