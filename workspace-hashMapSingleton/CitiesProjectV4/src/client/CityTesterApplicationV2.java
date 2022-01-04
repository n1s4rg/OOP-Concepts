package client;
import java.io.IOException;
					//import java.util.ArrayList;
					//import java.util.Collections;
import java.util.Scanner;
import bus.City;
import bus.CodeComparator;
import bus.DataCollection;
import bus.FileManager;
import bus.AreaComparator;

public class CityTesterApplicationV2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {		
		//ArrayList <City> citiesList = new ArrayList<City>(); ArrayList <City> citiesListFromFile = new ArrayList<City>();
		
		Scanner scan = new Scanner(System.in);
		City c1 =  new City("411" , "Laval" , 444.44);		
		City c2 =  new City("514" , "Montreal" , 222.22);		
		City c3 =  new City("418" , "Ottawa" , 777.77);
		DataCollection.add(c1); DataCollection.add(c2); DataCollection.add(c3);
		
		System.out.println("\n List of cities from RAM");
		for(City aCity : DataCollection.getListOfCities())
		{
			System.out.println(aCity);			
		}
		FileManager.writeToSerializedFile(DataCollection.getListOfCities());
		
		System.out.println("\n List of cities from Hard Drive");
		for(City aCity : FileManager.readFromSerializedFile())
		{
			System.out.println(aCity);			
		}
		
		//-1-sorting by city code
		                 //Collections.sort( DataCollection.getListOfCities()   ,   new CodeComparator()  );	
		     DataCollection.sort(new CodeComparator());
		     //or
		       //DataCollection.sortByCode();
	
		System.out.println("\n List of cities sorted by city code");
		for(City aCity :  DataCollection.getListOfCities())
		{
			System.out.println(aCity);			
		}
		
		//-1-sorting by city area
		   //Collections.sort( DataCollection.getListOfCities()   ,   new AreaComparator()  );	
		   DataCollection.sortByArea();
		   //or
		     // DataCollection.sort(new AreaComparator());
	
		System.out.println("\n List of cities sorted by city area");
		for(City aCity :  DataCollection.getListOfCities())
		{
			System.out.println(aCity);			
		}
		
		String key;
		System.out.print("Searching for a city: \n\t Enter the key(city code): ");
		  key = scan.nextLine();		
		           System.out.println("\t" + DataCollection.search(key));
		           
	    scan.close();
	    System.exit(0);		
	}
}
/****************

 List of cities from RAM
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=411, name=Brossard, area=777.77]

 List of cities from Hard Drive
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=411, name=Brossard, area=777.77]

 List of cities sorted by city code
City [code=411, name=Brossard, area=777.77]
City [code=418, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]

 List of cities sorted by city area
City [code=514, name=Montreal, area=222.22]
City [code=418, name=Laval, area=444.44]
City [code=411, name=Brossard, area=777.77]
Searching for a city: 
	 Enter the key(city code): 418
	City [code=418, name=Laval, area=444.44]

 
******************************************/
