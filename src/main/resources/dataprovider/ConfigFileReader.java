package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.function.LongPredicate;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyfilepath = "configs//configuration.properties";
	
	public ConfigFileReader() {
		// TODO Auto-generated constructor stub
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyfilepath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException("Key Value Paire not found in configuration file");
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found Exception");
		}
		
	}
	
	public String getLoginUrl() {
		String loginURL = properties.getProperty("login_url");
		if (loginURL!= null) {
			return loginURL;
		} else {
			throw new RuntimeException("Given Key Value pair not found in Configuration File");
		}
	}
	public Long getImplicitWait() {
		String wait = properties.getProperty("implicitlywait");
		if (wait!=null) {
			return Long.parseLong(wait);
		}
		else
			throw new RuntimeException("Specified Key value pair not found in Configuration file");
	}
	public String getLogoutUrl() {
		String logoutURL = properties.getProperty("logout_url");
		if (logoutURL!= null) {
			return logoutURL;
		}
		else
			throw new RuntimeException("Logout URL is not found in Configuration file");
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driver_path");
		if (driverPath!=null) 
			return driverPath;
		else
			throw new RuntimeException("Driver path is not specified in the Configuration file");
		
	}
	public String getChrome() {
		String chrome = properties.getProperty("chrome");
		if (chrome!= null) {
			return chrome;
		} else {
			throw new RuntimeException("Given Key Value pair not found in Configuration File");
		}
	}
	public String getDataFilePath() {
		String chrome = properties.getProperty("data_file");
		if (chrome!= null) {
			return chrome;
		} else {
			throw new RuntimeException("Given Key Value pair not found in Configuration File");
		}
	}
	
	public String getExtentPath() {
		String strPath  = properties.getProperty("extent");
		if (strPath!=null) {
			return strPath;
		} else {
			throw new RuntimeException("Extent Report Path not Found");
		}
		
	}
	
	public String getExcelLocation() {
		String excelPath  = properties.getProperty("excel_location");
		if (excelPath!=null) {
			return excelPath;
		} else {
			throw new RuntimeException("Extent Report Path not Found");
		}
		
	}
	
}
