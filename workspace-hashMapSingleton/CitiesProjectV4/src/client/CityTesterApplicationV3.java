package client;
import java.io.IOException;
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

public class CityTesterApplicationV3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {		
		
		System.out.println("\n Tester 03 - Using a Singleton HashMap");		
		
		Scanner scan = new Scanner(System.in);
		City c1 =  new City("411" , "Laval" , 444.44);		
		City c2 =  new City("514" , "Montreal" , 222.22);		
		City c3 =  new City("418" , "Ottawa" , 777.77);
		
		SingletonHashMapCollection.getSingleInstance().add(c1); 
		SingletonHashMapCollection.getSingleInstance().add(c2); 
		SingletonHashMapCollection.getSingleInstance().add(c3);
		
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
		      
		   City foundCity = SingletonHashMapCollection.getSingleInstance().search(key);
	
		   if (foundCity == null)
		   {
			   System.out.println("City code " + key + "   not found" );
		   }
		   else 
		   {
			   System.out.println("City code " + key + " found" + " - "  + foundCity) ;
		   }
		   		
			scan.close();
			System.exit(0);
	}
	
}


