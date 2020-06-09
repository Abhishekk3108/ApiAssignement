package Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private Properties properties;

	public PropertiesReader() {
		properties = new Properties();
		try {
			String propertiesFilePath = "Qa.properties";
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getHostUrl() {
		String environment = "Qa";
		if (environment == "Qa"){
		return properties.getProperty("QaHost");}
		else if(environment == "Staging"){
			return properties.getProperty("StagingHost");}
		else{
			return properties.getProperty("ProdHost");}
	}
	}

