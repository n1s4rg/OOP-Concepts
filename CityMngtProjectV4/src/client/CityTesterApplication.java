package client;

import bus.City;

import bus.DataCollection;


// class tester application
public class CityTesterApplication {	

  // main function
	public static void main(String[] args) {
	
		System.out.println("\n ---Version 02 ------");	
		System.out.println("\n Adding cities into DataCollection");
		DataCollection.add( new City("418" , "Laval" , 444.44));
		DataCollection.add( new City("514" , "Montreal" , 222.22));
		DataCollection.add( new City("411" , "Brossard" , 777.77));
		
		//City newCity = new City();
	
		DataCollection.sortByArea();
		System.out.println("\n List of cities of the DataCollection BEFORE sorting by city area");
		for(City aCity : DataCollection.getListOfCities())
		{
			System.out.println(aCity.toString());			
		}
		
		//function call
		       DataCollection.sortByName();
		
		System.out.println("\n List of cities of the DataCollection AFTER  sorting by city Name");
		for(City aCity : DataCollection.getListOfCities())
		{
			System.out.println(aCity.toString());			
		}	
		
		
		DataCollection.sortByPop();
		System.out.println("\n List of cities of the DataCollection AFTER  sorting by city Population");
		for(City aCity : DataCollection.getListOfCities())
		{
			System.out.println(aCity.toString());			
		}	
	}

}
/* Console output:
 * 
 List of cities BEFORE sorting
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=411, name=Brossard, area=777.77]

 List of cities AFTER  sorting by city area
City [code=514, name=Montreal, area=222.22]
City [code=418, name=Laval, area=444.44]
City [code=411, name=Brossard, area=777.77]

 */






















/*//sort by city code
		public static void sort(ArrayList<City> listOfCities)	
		{
			for(int i = 0; i < listOfCities.size(); i++)
			{			
				for(int j = i+1; j < listOfCities.size(); j++)
				{									
					//sort by value in ascending order
					if(listOfCities.get(i).getCode().compareTo(listOfCities.get(j).getCode())  < 0)
					{					
						City temp = listOfCities.get(i);;
						listOfCities.set(i, listOfCities.get(j));
						listOfCities.set(j, temp);
					}
				}
			}
		}	
		
		sort(listOfCities);		
		System.out.println("\n List of cities AFTER  sorting by city code");
		for(City aCity : listOfCities)
		{
			System.out.println(aCity.toString());			
		}
		
		
		***/
