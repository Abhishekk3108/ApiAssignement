package Properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesReader
{
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

	public String getHostUrl()
	{
		String environment = properties.getProperty("environment");
		String hostUrl = "";

		switch (environment)
		{
			case "Qa":
				hostUrl = properties.getProperty("QaHost");
				break;
			case "Staging":
				hostUrl = properties.getProperty("StagingHost");
				break;
			case "Production":
				hostUrl = properties.getProperty("ProdHost");
				break;
	    }
	    return  hostUrl;

	}
}

