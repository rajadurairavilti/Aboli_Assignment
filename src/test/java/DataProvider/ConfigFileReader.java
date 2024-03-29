package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= "Config//Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("path");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	public void initialiseDriver() {
		System.setProperty("webdriver.chrome.driver",getDriverPath());

		
	}
	public String getURL() {

		String url = properties.getProperty("URL");
		return url;

	}
//	
//	public long getImplicitlyWait() {		
//		String implicitlyWait = properties.getProperty("implicitlyWait");
//		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
//		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
//	}
//	
//	public String getApplicationUrl() {
//		String url = properties.getProperty("url");
//		if(url != null) return url;
//		else throw new RuntimeException("url not specified in the Configuration.properties file.");
//	}
}