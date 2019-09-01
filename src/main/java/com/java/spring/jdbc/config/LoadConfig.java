package com.java.spring.jdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.java.spring.jdbc.constant.ConfigConstant;

public class LoadConfig {
	
	public static LoadConfig  loadConfig=null;
	
	public LoadConfig getInstance()
	{
		if(loadConfig!=null)
		return loadConfig;
		else
			loadConfig=new LoadConfig();
	  return loadConfig;
		
	}
	
	Properties properties=null;
	
	

	public LoadConfig() 
	
	{
        properties = new Properties();
    	
    	try (InputStream is = new FileInputStream(ConfigConstant.PROP_FILE_PATH+"/"+ConfigConstant.PROP_FILE))
    	{
    	  
    	  properties.load(is);
    	  
    	}
    	catch(IOException e)
    	{
    		System.out.println("application.propertiesFile Not Found");
    	}
    	
    	
    	
	}
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}


}
