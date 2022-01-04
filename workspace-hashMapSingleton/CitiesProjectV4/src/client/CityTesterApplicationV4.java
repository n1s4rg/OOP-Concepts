package client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.ArrayList;
					//import java.util.Collections;
import java.util.Scanner;


import bus.FileManager2;
import bus.NameComparator;
import bus.City;
import bus.CodeComparator;
import bus.DataCollection;
import bus.AreaComparator;
import bus.SingletonHashMapCollection;

public class CityTesterApplicationV4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {		
		
		System.out.println("\n Tester 04 - Using a Singleton HashMap");		
		
		Scanner scan = new Scanner(System.in);
		City c1 =  new City("411" , "Laval" , 444.44);		
		SingletonHashMapCollection.getSingleInstance().add(c1.getCode() , c1); 
		
		City c2 =  new City("514" , "Montreal" , 222.22);	
		SingletonHashMapCollection.getSingleInstance().add(c2.getCode() , c2);
		
		
		City c3 =  new City("418" , "Ottawa" , 111.11);	
		SingletonHashMapCollection.getSingleInstance().add( c3.getCode() , c3); 
		
	
		System.out.println("\n ---1--  List of cities from RAM");
		for(City aCity :  SingletonHashMapCollection.getSingleInstance().getListOfCities().values())
		{
			System.out.println(aCity);			
		}
		
			
		System.out.println("\n WRITE TO FILE");
		FileManager2.writeToSerializedFile(
				                  (HashMap<String, City>) (SingletonHashMapCollection.getSingleInstance().getListOfCities())
				                        );


		System.out.println("\n READ FROM FILE");	
		System.out.println("\n List of cities from Hard Drive");
		for(City aCity : FileManager2.readFromSerializedFile().values())
		{
			System.out.println(aCity);			
		}
		

		
		String key;
		System.out.print("Searching for a city: \n\t Enter the key(city code): ");
		  key = scan.nextLine();
		  
		           //System.out.println("\t" + SingletonCollection2.getSingleInstance().search(key));
		  
		   ArrayList<City> citiesList = SingletonHashMapCollection.getSingleInstance().search2(key);
		
		   if (citiesList == null)
		   {
			   System.out.println("City code " + key + "   not found" );
		   }
		   else 
		   {
			   for(City aCity : citiesList)
			   {
			   System.out.println("City code " + key + " found" + " - "  + aCity) ;
			   }
		   }

       ArrayList <City> sortingList = new ArrayList<City>(  SingletonHashMapCollection.getSingleInstance().getListOfCities().values()  );
  
        Collections.sort(sortingList, new AreaComparator() );
		System.out.println("\n List of cities sorted by city area");
		for(City aCity :  sortingList)
		{
		System.out.println(aCity);			
		}
		
		Collections.sort(sortingList, new CodeComparator() );
		System.out.println("\n List of cities sorted by city code");
		for(City aCity :  sortingList)
		{
		System.out.println(aCity);			
		}
				   
		   
	    scan.close();
	    System.exit(0);		
	}
}

/*

 Tester 03 - Using Singleton

 ---1--  List of cities from RAM
City [code=411, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=418, name=Ottawa, area=111.11]

 WRITE TO FILE

 READ FROM FILE

 List of cities from Hard Drive
City [code=411, name=Laval, area=444.44]
City [code=514, name=Montreal, area=222.22]
City [code=418, name=Ottawa, area=111.11]
Searching for a city: 
	 Enter the key(city code): 514
City code 514 found - City [code=514, name=Montreal, area=222.22]

 List of cities sorted by city area
City [code=418, name=Ottawa, area=111.11]
City [code=514, name=Montreal, area=222.22]
City [code=411, name=Laval, area=444.44]

 List of cities sorted by city code
City [code=411, name=Laval, area=444.44]
City [code=418, name=Ottawa, area=111.11]
City [code=514, name=Montreal, area=222.22]
***/






























/*
 * 
 * 
 * 		//-1-sorting by city code
		                 //Collections.sort( DataCollection.getListOfCities()   ,   new CodeComparator()  );	
		    SingletonCollection2.getSingleInstance().sort(new CodeComparator());
		     //or
		       //DataCollection.sortByCode();
	
		System.out.println("\n List of cities sorted by city code");
		for(City aCity :  SingletonCollection2.getSingleInstance().getListOfCities().values())
		{
			System.out.println(aCity);			
		}
		
		//-1-sorting by city area
		   //Collections.sort( DataCollection.getListOfCities()   ,   new AreaComparator()  );	
		      SingletonCollection2.getSingleInstance().sortByArea();
		   //or
		     // DataCollection.sort(new AreaComparator());
	
		System.out.println("\n List of cities sorted by city area");
		for(City aCity :  SingletonCollection2.getSingleInstance().getListOfCities().values())
		{
			System.out.println(aCity);			
		}
		
		
		*/
