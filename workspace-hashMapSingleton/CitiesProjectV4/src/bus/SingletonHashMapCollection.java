package bus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SingletonHashMapCollection {
	
	private static  SingletonHashMapCollection   singleInstance = null;
	//From Java API:
	        // The implementation provides constant-time performance for the basic operations (get and put)
	
	private HashMap<String, City> listOfCities = null  ;
	
	// private HashMap<String, City> listOfCities  ;
	
	private SingletonHashMapCollection()
	 {
		 listOfCities = new HashMap<String, City> () ;
	 }
	
	public static SingletonHashMapCollection getSingleInstance() {
		 if(singleInstance == null)
		 {
			 singleInstance = new SingletonHashMapCollection();
		 }		 
		return singleInstance;
	}	
	
	public void setListOfCities(HashMap<String, City> listOfCities) {
	  this.listOfCities = listOfCities;
	}
	public HashMap<String, City>  getListOfCities() {
		return singleInstance.listOfCities;
	}	
    public  void add(City newCity)	{		
		singleInstance.listOfCities.put(newCity.getCode(), newCity);	
	}	
    
    public  void add(String key, City newCity)	{	
    	 
		singleInstance.listOfCities.put(key, newCity);	
	}	
    
    public void add(ArrayList<City> cities){
    	
        for(City aCity : cities) {
        	
            singleInstance.listOfCities.put(aCity.getCode(), aCity);
        }
    }

    public void clear(){
    	singleInstance.listOfCities.clear();
    }
    
	public  void remove(City newCity)	{
		
		singleInstance.listOfCities.remove(newCity.getCode());	
	}

	//1st way
	 public City search(String  key){
		 City element = null;
	        if (singleInstance.listOfCities.containsKey(key)){
	        	
	          element = singleInstance.listOfCities.get(key);
	        }       
	        
	        return element;
	    }
	 
	 public ArrayList<City> search2(String  key){
		 ArrayList<City> citiesList = new ArrayList<>();
	        if (singleInstance.listOfCities.containsKey(key)){
	        	
	          citiesList.add(singleInstance.listOfCities.get(key));
	        }       
	        
	        return citiesList;
	    }
	

}