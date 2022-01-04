package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FileManager2 {	
	
	private static String filePath = "src//data//cities-file.ser" ;
	
	public static void writeToSerializedFile(HashMap<String, City>  collection) throws IOException
	{		 
		ArrayList<City> arrayList = new ArrayList <> (     ((HashMap<String, City>) collection).values()    );
		
		FileOutputStream fos = new FileOutputStream(filePath);		
		ObjectOutputStream oos = new ObjectOutputStream(fos);	
		
		  oos.writeObject(arrayList);		  
		  fos.close();		
	}	

	public static HashMap<String, City>  readFromSerializedFile() throws IOException, ClassNotFoundException
	{
		HashMap<String, City> citiesHashMap = new HashMap<String, City>();		
		ArrayList< City> citiesArrayList    = new ArrayList< City>();
		
		  FileInputStream fis = new FileInputStream(filePath);		  
		  ObjectInputStream ois = new ObjectInputStream(fis);		  
		  
		  citiesArrayList  =   (ArrayList<City>) ois.readObject();
		  
		  for(City aCity :  citiesArrayList)  {
			  
			  citiesHashMap.put(aCity.getCode(), aCity);
		  }		  
		  fis.close();			  
		  return citiesHashMap;	
	} 	


}
