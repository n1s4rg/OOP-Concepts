                     
							  -----------------------
							  - Database Application-    
							  -----------------------
					  

  Eclipse           <===========================================>      DBMS (Oracle) -BA3-
  NetBeans
  IntellijD

Java Application                    ojdbc API                         faculty database
                                 (ojdbc.jar driver)



Java API : https://docs.oracle.com/javase/8/docs/api/
---------

java.sql (package):	
 
 -1- interface:
    ----------
		1.1- Connection interface:
			static Connection  getConnection(String url)
				//Attempts to establish a connection to the given database URL.
					 
			static Connection  getConnection(String url, Properties info)
			  //Attempts to establish a connection to the given database URL.
			  
		   static Connection getConnection(String url, String user, String password)
			 //Attempts to establish a connection to the given database URL.
			 
	    -1.2-Statement interface				  
					
			
-2- Class:
		2.1- DriverManager class
		
		
3- Exception:
		3.1-   SQLException
     					
		
----------------------

Later, we will use more interfaces and classes 

Java API
         java.sql (package)
		 
            -1- interface:
			          Connection
					                   Statement					  
					  ResultSet
					  
					  DatabaseMetaData
					  
					  ParameterMetaData
					  
					  ResultSetMetaData					  
					  
					                   PreparedStatement
					  
			-2- Classe:
			            DriverManager
						
						
			3- Exception:
			             SQLException
     			