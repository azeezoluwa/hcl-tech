package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties prop;
	public static final String propertyPath="./ConfigFile/config.properties";



	public ConfigFileReader () 
	{
		try {
			prop=new Properties();
			BufferedReader reader=new BufferedReader(new FileReader(propertyPath));
			prop.load(reader);
			reader.close();
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at: "+propertyPath);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at: "+propertyPath);
		}
	}
}
