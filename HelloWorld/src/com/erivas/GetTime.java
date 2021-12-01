package com.erivas;

import java.time.LocalDateTime;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GetTime {

	
	
	static //final Logger LOG = Logger.getLogger("com.erivas");
	
	Logger logger = Logger.getLogger("com.erivas");
	
	

	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
       
		LocalDateTime.now().getHour();
		LocalDateTime.now().getMinute();
		System.out.println(LocalDateTime.now());
	
		
		FileHandler fh; 
		
		try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/temp/test/MyLogFile.log",true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info("My first log");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  

	    logger.info("Hi How r u?");  
		
		logger.log(Level.INFO, "logging: {0} ", "message1");
		
		get_email();
		

	}
	 public static String get_email()
	 {
		 
		 String email="erivas@gpconsultores.cl";
		  logger.warning("Esto es un warning");  
		
		 return email;
	 }
	
	
	 

	

}
