package com.qa.travel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {


	public static Properties properties;

	public ConfigDataProvider() 
	{
		//Read and load the file
		File configFile = new File("./Config/config.properties");
		try {

			FileInputStream configFileInput  = new FileInputStream(configFile);
			properties = new Properties();
			properties.load(configFileInput);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//fetch browser info from config file
	public String getBrowser() 
	{	
		return properties.getProperty("Browser");
	}
	//fetch url from config file
	public String getURL() 
	{	
		return properties.getProperty("qaURL");
	}

}
