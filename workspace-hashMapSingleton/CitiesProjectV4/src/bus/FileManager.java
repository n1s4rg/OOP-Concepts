package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {	
	
	private static String filePath = "src//data//cities-file.ser" ;
	
	//creating the public static methods: write/read	
	public static void writeToSerializedFile(ArrayList<City> listOfCities) throws IOException
	{		
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		//write the list of cities(listOfCities) into the physical file(cities.ser)
		  oos.writeObject(listOfCities);
		  fos.close();		
	}	

	public static ArrayList <City>  readFromSerializedFile() throws IOException, ClassNotFoundException
	{
		ArrayList<City> listOfCitiesFromFile = new ArrayList<City>();
		  FileInputStream fis = new FileInputStream(filePath);
		  ObjectInputStream ois = new ObjectInputStream(fis);		  
		  listOfCitiesFromFile  =   (ArrayList<City>) ois.readObject();		  
		  fis.close();			  
		  return listOfCitiesFromFile;	
	} 	


}
